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
import com.shipsco.charactersheet.data.character.blankCharacter
import com.shipsco.charactersheet.databinding.FragmentDetailsBinding
import com.shipsco.charactersheet.utils.toJsonString
import com.shipsco.charactersheet.views.*


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var textMap: MutableMap<CSTextView, String>
    private lateinit var longTextMap: MutableMap<CSTextViewLong, String>
    private lateinit var checkboxMap: MutableMap<CSCheckbox, Boolean>
    private lateinit var inspirationCheckboxMap: MutableMap<CSInspirationCheckbox, Boolean>

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
        currentCharacter = characterViewModel.currentCharacter.value ?: blankCharacter.copy()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        initRecyclerView()
        setMappings()
        setBindings()
        println("----------------------- IN DETAILS")
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
        characterViewModel.strengthBonus.observe(viewLifecycleOwner) { strengthBonus ->
            binding.strengthBonus.text = strengthBonus
            binding.strengthSave.text = strengthBonus
            binding.athletics.text = strengthBonus
        }
        characterViewModel.dexterityBonus.observe(viewLifecycleOwner) { dexterityBonus ->
            binding.dexterityBonus.text = dexterityBonus
            binding.initiative.text = dexterityBonus
            binding.dexteritySave.text = dexterityBonus
            binding.acrobatics.text = dexterityBonus
            binding.sleightOfHand.text = dexterityBonus
            binding.stealth.text = dexterityBonus
        }
        characterViewModel.constitutionBonus.observe(viewLifecycleOwner) { constitutionBonus ->
            binding.constitutionBonus.text = constitutionBonus
            binding.constitutionSave.text = constitutionBonus
        }
        characterViewModel.intelligenceBonus.observe(viewLifecycleOwner) { intelligenceBonus ->
            binding.intelligenceBonus.text = intelligenceBonus
            binding.intelligenceSave.text = intelligenceBonus
            binding.arcana.text = intelligenceBonus
            binding.history.text = intelligenceBonus
            binding.investigation.text = intelligenceBonus
            binding.nature.text = intelligenceBonus
            binding.religion.text = intelligenceBonus
        }
        characterViewModel.wisdomBonus.observe(viewLifecycleOwner) { wisdomBonus ->
            binding.wisdomBonus.text = wisdomBonus
            binding.wisdomSave.text = wisdomBonus
            binding.animalHandling.text = wisdomBonus
            binding.insight.text = wisdomBonus
            binding.medicine.text = wisdomBonus
            binding.perception.text = wisdomBonus
            binding.survival.text = wisdomBonus
        }
        characterViewModel.charismaBonus.observe(viewLifecycleOwner) { charismaBonus ->
            binding.charismaBonus.text = charismaBonus
            binding.charismaSave.text = charismaBonus
            binding.deception.text = charismaBonus
            binding.intimidation.text = charismaBonus
            binding.performance.text = charismaBonus
            binding.persuasion.text = charismaBonus
        }
        characterViewModel.proficiencyBonus.observe(viewLifecycleOwner) { proficiencyBonus ->
            binding.proficiencyBonus.text = proficiencyBonus
        }
        characterViewModel.currentHitPoints.observe(viewLifecycleOwner) { currentHitPoints ->
            binding.currentHitPoints.text = currentHitPoints
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
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        currentCharacter.editingIsLocked = !currentCharacter.editingIsLocked
                        characterViewModel.saveCurrentCharacter()
                        setBindings()
                        if (currentCharacter.editingIsLocked) {
                            lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock)
                            Toast.makeText(context, "Editing locked. Tap and hold a text field to edit.", Toast.LENGTH_SHORT).show()
                        } else {
                            lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock_open)
                            Toast.makeText(context, "Editing unlocked. Tap a text field to edit.", Toast.LENGTH_SHORT).show()
                        }
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
                        share.type = "text/plain"
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
                        currentCharacter.currentHitPoints = currentCharacter.hitPointMax
                        if (currentCharacter.spells[0].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[0].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[1].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[1].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[2].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[2].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[3].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[3].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[4].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[4].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[5].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[5].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[6].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[6].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[7].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[7].spellSlotsExpended = ""
                        }
                        if (currentCharacter.spells[8].spellSlotsExpended.isNotEmpty()) {
                            currentCharacter.spells[8].spellSlotsExpended = ""
                        }
                        characterViewModel.saveCurrentCharacter()
                        setMappings()
                        setBindings()
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

    private fun setBindings() {
        textMap.forEach { (theBinding, theString) ->
            theBinding.text = theString
            theBinding.isLocked = currentCharacter.editingIsLocked
            theBinding.eventListener = characterViewModel
        }

        longTextMap.forEach { (theBinding, theString) ->
            theBinding.text = theString
            theBinding.isLocked = currentCharacter.editingIsLocked
            theBinding.eventListener = characterViewModel
        }

        checkboxMap.forEach { (theBinding, theBool) ->
            theBinding.isChecked = theBool
            theBinding.eventListener = characterViewModel
        }

        inspirationCheckboxMap.forEach { (theBinding, theBool) ->
            theBinding.isChecked = theBool
            theBinding.eventListener = characterViewModel
        }
    }

    private fun setMappings() {
        textMap = mutableMapOf<CSTextView, String>(
            Pair(binding.characterName, currentCharacter.characterName),
            Pair(binding.classLevel, currentCharacter.classLevel),
            Pair(binding.characterBackground, currentCharacter.background),
            Pair(binding.playerName, currentCharacter.playerName),
            Pair(binding.characterRace, currentCharacter.race),
            Pair(binding.characterAlignment, currentCharacter.alignmentType),
            Pair(binding.experiencePoints, currentCharacter.experiencePoints),
            Pair(binding.totalLevel, currentCharacter.totalLevel),
            Pair(binding.armorClass, currentCharacter.armorClass),
            Pair(binding.initiative, currentCharacter.initiative),
            Pair(binding.speed, currentCharacter.speed),
            Pair(binding.hitPointMax, currentCharacter.hitPointMax),
            Pair(binding.currentHitPoints, currentCharacter.currentHitPoints),
            Pair(binding.tempHitPoints, currentCharacter.temporaryHitPoints),
            Pair(binding.totalHitDice, currentCharacter.totalHitDice),
            Pair(binding.hitDice, currentCharacter.hitDice),
            Pair(binding.proficiencyBonus, currentCharacter.proficiencyBonus),
            Pair(binding.strength, currentCharacter.strength),
            Pair(binding.strengthBonus, currentCharacter.strengthBonus),
            Pair(binding.dexterity, currentCharacter.dexterity),
            Pair(binding.dexterityBonus, currentCharacter.dexterityBonus),
            Pair(binding.constitution, currentCharacter.constitution),
            Pair(binding.constitutionBonus, currentCharacter.constitutionBonus),
            Pair(binding.intelligence, currentCharacter.intelligence),
            Pair(binding.intelligenceBonus, currentCharacter.intelligenceBonus),
            Pair(binding.wisdom, currentCharacter.wisdom),
            Pair(binding.wisdomBonus, currentCharacter.wisdomBonus),
            Pair(binding.charisma, currentCharacter.charisma),
            Pair(binding.charismaBonus, currentCharacter.charismaBonus),
            Pair(binding.strengthSave, currentCharacter.strengthSave),
            Pair(binding.dexteritySave, currentCharacter.dexteritySave),
            Pair(binding.constitutionSave, currentCharacter.constitutionSave),
            Pair(binding.intelligenceSave, currentCharacter.intelligenceSave),
            Pair(binding.wisdomSave, currentCharacter.wisdomSave),
            Pair(binding.charismaSave, currentCharacter.charismaSave),
            Pair(binding.acrobatics, currentCharacter.acrobatics),
            Pair(binding.animalHandling, currentCharacter.animalHandling),
            Pair(binding.arcana, currentCharacter.arcana),
            Pair(binding.athletics, currentCharacter.athletics),
            Pair(binding.deception, currentCharacter.deception),
            Pair(binding.history, currentCharacter.history),
            Pair(binding.insight, currentCharacter.insight),
            Pair(binding.intimidation, currentCharacter.intimidation),
            Pair(binding.investigation, currentCharacter.investigation),
            Pair(binding.medicine, currentCharacter.medicine),
            Pair(binding.nature, currentCharacter.nature),
            Pair(binding.perception, currentCharacter.perception),
            Pair(binding.performance, currentCharacter.performance),
            Pair(binding.persuasion, currentCharacter.persuasion),
            Pair(binding.religion, currentCharacter.religion),
            Pair(binding.sleightOfHand, currentCharacter.sleightOfHand),
            Pair(binding.stealth, currentCharacter.stealth),
            Pair(binding.survival, currentCharacter.survival),
            // attacks and spells
            Pair(binding.copperPieces, currentCharacter.copper),
            Pair(binding.silverPieces, currentCharacter.silver),
            Pair(binding.electrumPieces, currentCharacter.electrum),
            Pair(binding.goldPieces, currentCharacter.gold),
            Pair(binding.platinumPieces, currentCharacter.platinum),
        )

        longTextMap = mutableMapOf<CSTextViewLong, String>(
            Pair(binding.equipment, currentCharacter.equipment),
            Pair(binding.proficienciesLanguages, currentCharacter.proficiencyLanguages),
            Pair(binding.personalityTraits, currentCharacter.personalityTraits),
            Pair(binding.ideals, currentCharacter.ideals),
            Pair(binding.bonds, currentCharacter.bonds),
            Pair(binding.flaws, currentCharacter.flaws),
        )

        checkboxMap = mutableMapOf<CSCheckbox, Boolean>(
            Pair(binding.successSaveButton1, currentCharacter.successDeathSave1),
            Pair(binding.successSaveButton2, currentCharacter.successDeathSave2),
            Pair(binding.successSaveButton3, currentCharacter.successDeathSave3),
            Pair(binding.failSaveButton1, currentCharacter.failDeathSave1),
            Pair(binding.failSaveButton2, currentCharacter.failDeathSave2),
            Pair(binding.failSaveButton3, currentCharacter.failDeathSave3),
            Pair(binding.strengthSaveButton, currentCharacter.strengthSaveChecked),
            Pair(binding.dexteritySaveButton, currentCharacter.dexteritySaveChecked),
            Pair(binding.constitutionSaveButton, currentCharacter.constitutionSaveChecked),
            Pair(binding.intelligenceSaveButton, currentCharacter.intelligenceSaveChecked),
            Pair(binding.wisdomSaveButton, currentCharacter.wisdomSaveChecked),
            Pair(binding.charismaSaveButton, currentCharacter.charismaSaveChecked),
            Pair(binding.acrobaticsButton, currentCharacter.acrobaticsChecked),
            Pair(binding.animalHandlingButton, currentCharacter.animalHandlingChecked),
            Pair(binding.arcanaButton, currentCharacter.arcanaChecked),
            Pair(binding.athleticsButton, currentCharacter.athleticsChecked),
            Pair(binding.deceptionButton, currentCharacter.deceptionChecked),
            Pair(binding.historyButton, currentCharacter.historyChecked),
            Pair(binding.insightButton, currentCharacter.insightChecked),
            Pair(binding.intimidationButton, currentCharacter.intimidationChecked),
            Pair(binding.investigationButton, currentCharacter.investigationChecked),
            Pair(binding.medicineButton, currentCharacter.medicineChecked),
            Pair(binding.natureButton, currentCharacter.natureChecked),
            Pair(binding.perceptionButton, currentCharacter.perceptionChecked),
            Pair(binding.performanceButton, currentCharacter.performanceChecked),
            Pair(binding.persuasionButton, currentCharacter.persuasionChecked),
            Pair(binding.religionButton, currentCharacter.religionChecked),
            Pair(binding.sleightOfHandButton, currentCharacter.sleightOfHandChecked),
            Pair(binding.stealthButton, currentCharacter.stealthChecked),
            Pair(binding.survivalButton, currentCharacter.survivalChecked),
        )

        inspirationCheckboxMap = mutableMapOf<CSInspirationCheckbox, Boolean>(
            Pair(binding.inspirationChecked, currentCharacter.inspiration),
        )
    }
}

