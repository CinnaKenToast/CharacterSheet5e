package com.example.charactersheet.data

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.charactersheet.CharacterViewModel
import com.example.charactersheet.CharacterViewModelFactory
import com.example.charactersheet.R
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.databinding.FragmentCharacterSelectBinding
import com.example.charactersheet.utils.fromJsonString
import com.example.charactersheet.utils.toJsonString
import com.example.charactersheet.views.CharacterSelectAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

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

        subscribeToViewModel()

        characterViewModel.getCharacters()
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
                    createDeleteDialog(selectedCharacter, adapter)
                }
                true
            }
            R.id.exportButton -> {
                val selectedCharacter = adapter.getSelectedCharacter()
                selectedCharacter?.let {
                    val json = selectedCharacter.toJsonString()
                    val clipboard = requireContext().getSystemService(Service.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("characterData", json)
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(context, "${selectedCharacter.characterName}'s data has been copied to your clipboard", Toast.LENGTH_SHORT).show()
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
            initRecyclerView(characters)
            if (characters.isEmpty()) {
                binding.addCharacterPrompt.visibility = View.VISIBLE
            } else {
                binding.characterSelectRecycler.visibility = View.VISIBLE
            }
        }
    }

    private fun initRecyclerView(characters: List<Character>) {
        val recyclerView = binding.characterSelectRecycler
        val adapter = CharacterSelectAdapter(characters = characters, findNavController())
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
        editText.hint = "Insert character data"
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Import Character")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Import") { dialog, which ->
                val characterData = editText.text.toString()
                if (characterData.isNotEmpty()) {
                    val newCharacter = characterData.fromJsonString<Character>()
                    characterViewModel.saveCharacter(newCharacter)
                    dialog.dismiss()
                } else {
                    Toast.makeText(requireContext(), "Character data cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setView(editText)
            .show()
    }

    private fun createDeleteDialog(selectedCharacter: Character, adapter: CharacterSelectAdapter) {
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