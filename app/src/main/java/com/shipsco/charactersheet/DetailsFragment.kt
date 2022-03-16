package com.shipsco.charactersheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.databinding.FragmentDetailsBinding
import com.shipsco.charactersheet.utils.toJsonString
import com.shipsco.charactersheet.views.AttackSpellsAdapter


class DetailsFragment : Fragment(), ManualEditListener {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var characterName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val factory = CharacterViewModelFactory(requireActivity().application)
//        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]
        characterViewModel = requireActivity().viewModels<CharacterViewModel>().value
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        binding.viewModel = characterViewModel
        currentCharacter = characterViewModel.currentCharacter.value!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        initRecyclerView()
        println("----------------------- IN DETAILS")
    }

    override fun onPause() {
        super.onPause()
        characterViewModel.saveCurrentCharacter()
    }

    private fun initMenuOptions() {
        val lockButton = binding.toolbar.menu[0]
        if (currentCharacter.editingIsLocked) {
            lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock)
        } else {
            lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock_open)
        }
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.lockButton -> {
                    currentCharacter.editingIsLocked = !currentCharacter.editingIsLocked
                    characterViewModel.saveCurrentCharacter()
                    binding.invalidateAll()
                    if (currentCharacter.editingIsLocked) {
                        lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock)
                        Toast.makeText(context, "Editing locked. Tap and hold a text field to edit.", Toast.LENGTH_SHORT).show()
                    } else {
                        lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock_open)
                        Toast.makeText(context, "Editing unlocked. Tap a text field to edit.", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                R.id.saveButton -> {
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        characterViewModel.saveCharacter(currentCharacter)
                    }
                    true
                }
                R.id.exportButton -> {
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        val json = currentCharacter.toJsonString()

                        // Add a custom intent to handle the "copy to clipboard" option.

                        // Add a custom intent to handle the "copy to clipboard" option.
//                        val copyToClipboard = Intent(requireContext(), CopyToClipboardService::class.java)
//
//                        val labeledCopyToClipboard =
//                            LabeledIntent(copyToClipboard, "R", "Copy", R.drawable.ic_copy)
//                        labeledCopyToClipboard.action = Intent.EXTRA_INITIAL_INTENTS
////                        val clipboard = requireContext().getSystemService(Service.CLIPBOARD_SERVICE) as ClipboardManager
////                        val clip = ClipData.newPlainText("characterData", json)
////                        clipboard.setPrimaryClip(clip)
////                        Toast.makeText(context, "${currentCharacter.characterName}'s data has been copied to your clipboard", Toast.LENGTH_SHORT).show()
//                        val shareIntent = Intent().apply {
//                            this.action = Intent.ACTION_SEND
//                            this.type = "plain/text"
//                            this.putExtra(Intent.EXTRA_TEXT, json)
                        val share = Intent(Intent.ACTION_SEND)
                        share.type = "text/plain"
                        share.putExtra(Intent.EXTRA_TEXT, json)
                        val shareIntent = Intent.createChooser(share, "Export Character Data")
                        if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
                            startActivity(shareIntent)
                        }
                    }
                    true
                }
                else -> {true}
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.attackSpellsRecyclerView
        val adapter = AttackSpellsAdapter(currentCharacter.attackSpells, characterViewModel)
        recyclerView.adapter = adapter
    }

    override fun manualEditCompleted() {
        characterViewModel.saveCurrentCharacter()
    }
}