package com.shipsco.charactersheet

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.FileProvider.getUriForFile
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.databinding.FragmentCharacterSelectBinding
import com.shipsco.charactersheet.utils.fromJsonString
import com.shipsco.charactersheet.views.CharacterSelectAdapter


class CharacterSelectFragment : Fragment() {

    private lateinit var binding: FragmentCharacterSelectBinding
    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = CharacterViewModelFactory(requireActivity().application)
        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterSelectBinding.inflate(layoutInflater)
        registerForContextMenu(binding.characterSelectRecycler)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()

        binding.fab.setOnClickListener {
            val bundle = bundleOf(
                Pair("creatingCharacter", true),
                Pair("characterName", "")
            )
            findNavController().navigate(R.id.action_characterSelectFragment_to_viewPagerFragment, bundle)
        }

        characterViewModel.getCharacters()
        subscribeToViewModel()

        binding.swipeRefreshLayout.setOnRefreshListener {
            characterViewModel.getCharacters()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = requireActivity().menuInflater
        inflater.inflate(R.menu.character_long_press_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val adapter = binding.characterSelectRecycler.adapter as CharacterSelectAdapter
        return when (item.itemId) {
            R.id.deleteButton -> {
                val selectedCharacter = adapter.getSelectedCharacter()
                selectedCharacter?.let {
                    createDeleteDialog(selectedCharacter)
                }
                true
            }
            R.id.exportButton -> {
                val selectedCharacter = adapter.getSelectedCharacter()
                selectedCharacter?.let {
//                    val json = selectedCharacter.toJsonString()
//                    val share = Intent(Intent.ACTION_SEND)
//                    share.type = "text/plain"
//                    share.putExtra(Intent.EXTRA_TEXT, json)
//                    val shareIntent = Intent.createChooser(share, "Export Character Data")
//                    if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
//                        startActivity(shareIntent)
//                    }
                    val file = characterViewModel.getCharacterFile(selectedCharacter)
                    file?.let {
                        val contentUri = getUriForFile(requireContext(), "com.shipsco.charactersheet.fileprovider", file)
                        val share = Intent(Intent.ACTION_SEND)
                        share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        share.type = "text/plain"
                        share.putExtra(Intent.EXTRA_STREAM, contentUri)

                        val resInfoList: List<ResolveInfo> =
                            requireContext().packageManager.queryIntentActivities(
                                share,
                                PackageManager.MATCH_DEFAULT_ONLY
                            )
                        for (resolveInfo in resInfoList) {
                            val packageName = resolveInfo.activityInfo.packageName
                            requireContext().grantUriPermission(
                                packageName,
                                contentUri,
                                Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
                            )
                        }

                        val shareIntent = Intent.createChooser(share, "Export Character File")
                        if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
                            startActivity(shareIntent)
                        }
                    }
                }
                true
            }
            else -> {
                super.onContextItemSelected(item)
            }
        }
    }

    private fun subscribeToViewModel() {
        characterViewModel.allCharacters.observe(viewLifecycleOwner) { characters ->
            initRecyclerView()
            if (characters.isEmpty()) {
                binding.addCharacterPrompt.visibility = View.VISIBLE
            } else {
                binding.characterSelectRecycler.visibility = View.VISIBLE
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.characterSelectRecycler
        val adapter = CharacterSelectAdapter(characters = characterViewModel.allCharacters.value!!, findNavController())
        recyclerView.adapter = adapter
    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.importButton -> {
                    createImportDialog()
                    true
                }
                else -> {true}
            }
        }
    }

    private fun createImportDialog() {
        val editText = TextInputEditText(requireContext())
        editText.id = R.id.importDialog
        editText.hint = "Insert Character Data"
        editText.maxLines = 15
        editText.requestFocus()
       val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Import Character")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Import") { dialog, which ->
                val characterData = editText.text.toString()
                if (characterData.isNotEmpty()) {
                    try {
                        val newCharacter = characterData.fromJsonString<Character>()
                        characterViewModel.saveCharacter(newCharacter)
                        dialog.dismiss()
                    } catch (e: Exception) {
                        Toast.makeText(requireContext(), "Invalid character data", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }

                } else {
                    Toast.makeText(requireContext(), "Character data cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setView(editText)
            .show()

        val window = dialog.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        editText.setOnEditorActionListener { textView, actionId, keyEvent ->
            val characterData = editText.text.toString()
            if (characterData.isNotEmpty()) {
                val newCharacter = characterData.fromJsonString<Character>()
                characterViewModel.saveCharacter(newCharacter)
                dialog.dismiss()
            } else {
                Toast.makeText(requireContext(), "Character data cannot be empty", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    private fun createDeleteDialog(selectedCharacter: Character) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Are you sure?")
            .setMessage("Your character will be gone forever!")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("DELETE") { dialog, which ->
                characterViewModel.deleteCharacter(selectedCharacter)
                Toast.makeText(requireContext(), "${selectedCharacter.characterName} has been deleted", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .show()
    }
}