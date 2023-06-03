package com.shipsco.charactersheet

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.data.character.blankCharacter
import com.shipsco.charactersheet.databinding.FragmentMiscBinding
import com.shipsco.charactersheet.utils.toJsonString
import com.shipsco.charactersheet.views.*


class MiscFragment : Fragment() {

    private lateinit var binding: FragmentMiscBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var longTextMap: MutableMap<CSTextViewLong, String>

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
        binding = FragmentMiscBinding.inflate(layoutInflater)
        currentCharacter = characterViewModel.currentCharacter.value ?: blankCharacter.copy()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        setMappings()
        setBindings()
        println("----------------------- IN NOTES")
        subscribeToVM()
    }

    override fun onResume() {
        super.onResume()
        initMenuOptions()
        setMappings()
        setBindings()
    }

    private fun subscribeToVM() {
        characterViewModel.currentCharacter.observe(viewLifecycleOwner) {
            currentCharacter = it
        }
    }

    private fun initMenuOptions() {
        val lockButton = binding.toolbar.menu[1]
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
                    setBindings()
                    if (currentCharacter.editingIsLocked) {
                        lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock)
                    } else {
                        lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock_open)
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
                        val share = Intent(Intent.ACTION_SEND)
                        share.type = "text/json"
                        share.putExtra(Intent.EXTRA_TEXT, json)
                        val shareIntent = Intent.createChooser(share, "Export Character Data")
                        if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
                            startActivity(shareIntent)
                        }
                    }
                    true
                }
                R.id.longRestButton -> {
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "You have been healed\nAll spell slots are reset", Toast.LENGTH_SHORT).show()
                        currentCharacter.currentHitPoints = currentCharacter.hitPointMax
                        if (currentCharacter.spells[0].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[0].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[1].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[1].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[2].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[2].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[3].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[3].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[4].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[4].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[5].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[5].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[6].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[6].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[7].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[7].spellSlotsExpended = "0"
                        }
                        if (currentCharacter.spells[8].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[8].spellSlotsExpended = "0"
                        }
                        characterViewModel.saveCurrentCharacter()
                    }
                    true
                }
                else -> {true}
            }
        }
    }

    private fun setBindings() {
        longTextMap.forEach { (theBinding, theString) ->
            theBinding.text = theString
            theBinding.isLocked = currentCharacter.editingIsLocked
            theBinding.eventListener = characterViewModel
        }

        binding.notesCategory.text = "${currentCharacter.selectedNote} ▼"

        binding.notesCategory.setOnClickListener {
            println("------------- I AM TOTALLY DOING SOMETHING HERE")
            characterViewModel.saveCurrentCharacter()
            showNoteOptions()
        }
    }

    private fun setMappings() {
        val index = currentCharacter.notesMisc.indexOfFirst {
            it[0] == currentCharacter.selectedNote
        }
        longTextMap = mutableMapOf<CSTextViewLong, String>(
            Pair(binding.notesMisc, currentCharacter.notesMisc[index][1]),
        )
    }

    private fun showNoteOptions() {
        val categories: MutableList<String> = mutableListOf()
        for (category in currentCharacter.notesMisc) {
            categories.add(category[0])
        }
        var checkedItem = categories.indexOf(currentCharacter.selectedNote)
        var selectedItem = currentCharacter.selectedNote

        val deleteDialog = MaterialAlertDialogBuilder(requireContext())
            .setPositiveButton("Yes") { dialog, which ->
                currentCharacter.notesMisc.removeAt(checkedItem)
                if (selectedItem == currentCharacter.selectedNote) {
                    selectedItem = categories[0]
                    checkedItem = 0
                    currentCharacter.selectedNote = selectedItem
                }
                setMappings()
                setBindings()
            }
            .setNegativeButton("No") { dialog, which ->

            }

        val editText = TextInputEditText(requireContext())
        editText.id = R.id.importDialog
        editText.hint = "Insert Category Name"
        editText.inputType = InputType.TYPE_CLASS_TEXT
        editText.imeOptions = EditorInfo.IME_ACTION_DONE
        editText.requestFocus()

        val addDialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Enter Note Category")
            .setPositiveButton("Add") { dialog, which ->
                currentCharacter.notesMisc.add(mutableListOf(editText.text.toString(), ""))
                currentCharacter.selectedNote = editText.text.toString()
                setMappings()
                setBindings()
            }
            .setNegativeButton("Cancel") { dialog, which ->

            }
            .setView(editText)

        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle("Select Note Category")
            .setNegativeButton("Add") { dialog, which ->
                println("Need to add a category")
                val shownDialog = addDialog.show()

                val window = shownDialog.window
                window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
                window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
                editText.setOnEditorActionListener { textView, actionId, keyEvent ->
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        currentCharacter.notesMisc.add(mutableListOf(editText.text.toString(), ""))
                        currentCharacter.selectedNote = editText.text.toString()
                        setMappings()
                        setBindings()
                        shownDialog.dismiss()
                    }
                    true
                }
            }
            .setNeutralButton("Delete") { dialog, which ->
                println("Need to delete a category")
                deleteDialog.setTitle("Are you sure you want to delete ${selectedItem}?")
                deleteDialog.show()
            }
            .setPositiveButton("Select") { dialog, which ->
                println("Need to select a category")
                currentCharacter.selectedNote = selectedItem
                setMappings()
                setBindings()
            }
        dialog.setSingleChoiceItems(categories.toTypedArray(), checkedItem) { dialog, which ->
            selectedItem = categories[which]
            checkedItem = which
        }
        dialog.show()
    }
}