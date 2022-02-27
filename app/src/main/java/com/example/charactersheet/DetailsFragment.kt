package com.example.charactersheet

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactersheet.data.character.AttackSpell
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.data.character.blankCharacter
import com.example.charactersheet.data.character.testCharacter
import com.example.charactersheet.databinding.FragmentDetailsBinding
import com.example.charactersheet.utils.toJsonString
import com.example.charactersheet.views.AttackSpellsAdapter
import kotlinx.coroutines.runBlocking

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var characterName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val factory = CharacterViewModelFactory(requireActivity().application)
//        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]
        characterViewModel = requireActivity().viewModels<CharacterViewModel>().value

        runBlocking {
            arguments?.let {
                val isNewCharacter = it.getBoolean("creatingCharacter")
                if (!isNewCharacter) {
                    characterName = it.getString("characterName")!!
                    currentCharacter = characterViewModel.getCharacter(characterName)
                } else {
                    currentCharacter = blankCharacter.copy()
                    characterViewModel.setCharacter(currentCharacter)
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        binding.viewModel = characterViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        initRecyclerView()
        println("----------------------- IN DETAILS")
    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.saveButton -> {
                    updateCharacter()
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        characterViewModel.saveCharacter(currentCharacter)
                    }
                    true
                }
                R.id.exportButton -> {
                    updateCharacter()
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        val json = currentCharacter.toJsonString()
                        val clipboard = requireContext().getSystemService(Service.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("characterData", json)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "${currentCharacter.characterName}'s data has been copied to your clipboard", Toast.LENGTH_SHORT).show()
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

    private fun getAttackSpells(): List<AttackSpell> {
        val list = mutableListOf<AttackSpell>()

        val recyclerView = binding.attackSpellsRecyclerView
        for (i in 0 until recyclerView.childCount) {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(i)!! as AttackSpellsAdapter.ViewHolder
            list.add(
                viewHolder.getAttackSpell()
            )
        }
        return list
    }

    private fun updateCharacter() {
        currentCharacter.characterName = binding.characterName.text.toString()
        currentCharacter.classLevel = binding.classLevel.text.toString()
        currentCharacter.background = binding.characterBackground.text.toString()
        currentCharacter.playerName = binding.playerName.text.toString()
        currentCharacter.race = binding.characterRace.text.toString()
        currentCharacter.alignmentType = binding.characterAlignment.text.toString()
        currentCharacter.experiencePoints = binding.experiencePoints.text.toString()
        currentCharacter.armorClass = binding.armorClass.text.toString()
        currentCharacter.initiative = binding.initiative.text.toString()
        currentCharacter.speed = binding.speed.text.toString()
        currentCharacter.hitPointMax = binding.hitPointMax.text.toString()
        currentCharacter.currentHitPoints = binding.currentHitPoints.text.toString()
        currentCharacter.temporaryHitPoints = binding.tempHitPoints.text.toString()
        currentCharacter.totalHitDice = binding.totalHitDice.text.toString()
        currentCharacter.successDeathSave1 = binding.successSaveButton1.isChecked
        currentCharacter.successDeathSave2 = binding.successSaveButton2.isChecked
        currentCharacter.successDeathSave3 = binding.successSaveButton3.isChecked
        currentCharacter.failDeathSave1 = binding.failSaveButton1.isChecked
        currentCharacter.failDeathSave2 = binding.failSaveButton2.isChecked
        currentCharacter.failDeathSave3 = binding.failSaveButton3.isChecked
        currentCharacter.inspiration = binding.inspiration.text.toString()
        currentCharacter.proficiencyBonus = binding.proficiencyBonus.text.toString()
        currentCharacter.strength = binding.strength.text.toString()
        currentCharacter.strengthBonus = binding.strengthBonus.text.toString()
        currentCharacter.dexterityBonus = binding.dexterityBonus.text.toString()
        currentCharacter.constitution = binding.constitution.text.toString()
        currentCharacter.constitutionBonus = binding.constitutionBonus.text.toString()
        currentCharacter.intelligence = binding.intelligence.text.toString()
        currentCharacter.intelligenceBonus = binding.intelligenceBonus.text.toString()
        currentCharacter.wisdom = binding.wisdom.text.toString()
        currentCharacter.wisdomBonus = binding.wisdomBonus.text.toString()
        currentCharacter.charisma = binding.charisma.text.toString()
        currentCharacter.strengthSaveChecked = binding.strengthSaveButton.isChecked
        currentCharacter.strengthSave = binding.strengthSave.text.toString()
        currentCharacter.dexteritySaveChecked = binding.dexteritySaveButton.isChecked
        currentCharacter.dexteritySave = binding.dexteritySave.text.toString()
        currentCharacter.constitutionSaveChecked = binding.constitutionSaveButton.isChecked
        currentCharacter.constitutionSave = binding.constitutionSave.text.toString()
        currentCharacter.intelligenceSaveChecked = binding.intelligenceSaveButton.isChecked
        currentCharacter.intelligenceSave = binding.intelligenceSave.text.toString()
        currentCharacter.wisdomSaveChecked = binding.wisdomSaveButton.isChecked
        currentCharacter.wisdomSave = binding.wisdomSave.text.toString()
        currentCharacter.charismaSaveChecked = binding.charismaSaveButton.isChecked
        currentCharacter.charismaSave = binding.charismaSave.text.toString()
        currentCharacter.acrobaticsChecked = binding.acrobaticsButton.isChecked
        currentCharacter.acrobatics = binding.acrobatics.text.toString()
        currentCharacter.animalHandlingChecked = binding.animalHandlingButton.isChecked
        currentCharacter.animalHandling = binding.animalHandling.text.toString()
        currentCharacter.arcanaChecked = binding.arcanaButton.isChecked
        currentCharacter.arcana = binding.arcana.text.toString()
        currentCharacter.athleticsChecked = binding.athleticsButton.isChecked
        currentCharacter.athletics = binding.athletics.text.toString()
        currentCharacter.deceptionChecked = binding.deceptionButton.isChecked
        currentCharacter.deception = binding.deception.text.toString()
        currentCharacter.historyChecked = binding.historyButton.isChecked
        currentCharacter.history = binding.history.text.toString()
        currentCharacter.insightChecked = binding.insightButton.isChecked
        currentCharacter.insight = binding.insight.text.toString()
        currentCharacter.intimidationChecked = binding.intimidationButton.isChecked
        currentCharacter.intimidation = binding.intimidation.text.toString()
        currentCharacter.investigationChecked = binding.investigationButton.isChecked
        currentCharacter.investigation = binding.investigation.text.toString()
        currentCharacter.medicineChecked = binding.medicineButton.isChecked
        currentCharacter.medicine = binding.medicine.text.toString()
        currentCharacter.natureChecked = binding.natureButton.isChecked
        currentCharacter.nature = binding.nature.text.toString()
        currentCharacter.perceptionChecked = binding.perceptionButton.isChecked
        currentCharacter.perception = binding.perception.text.toString()
        currentCharacter.performanceChecked = binding.performanceButton.isChecked
        currentCharacter.performance = binding.performance.text.toString()
        currentCharacter.persuasionChecked = binding.persuasionButton.isChecked
        currentCharacter.persuasion = binding.persuasion.text.toString()
        currentCharacter.religionChecked = binding.religionButton.isChecked
        currentCharacter.religion = binding.religion.text.toString()
        currentCharacter.sleightOfHandChecked = binding.sleightOfHandButton.isChecked
        currentCharacter.sleightOfHand = binding.sleightOfHand.text.toString()
        currentCharacter.stealthChecked = binding.stealthButton.isChecked
        currentCharacter.stealth = binding.stealth.text.toString()
        currentCharacter.survivalChecked = binding.survivalButton.isChecked
        currentCharacter.attackSpells = getAttackSpells().toMutableList()
        currentCharacter.copper = binding.copperPieces.text.toString()
        currentCharacter.silver = binding.silverPieces.text.toString()
        currentCharacter.electrum = binding.electrumPieces.text.toString()
        currentCharacter.gold = binding.goldPieces.text.toString()
        currentCharacter.platinum = binding.platinumPieces.text.toString()
        currentCharacter.equipment = binding.equipment.text.toString()
        currentCharacter.proficiencyLanguages = binding.proficienciesLanguages.text.toString()
        currentCharacter.personalityTraits = binding.personalityTraits.text.toString()
        currentCharacter.ideals = binding.ideals.text.toString()
        currentCharacter.bonds = binding.bonds.text.toString()
        currentCharacter.flaws = binding.flaws.text.toString()
    }

    companion object {
        fun createInstance(creatingCharacter: Boolean, characterName: String) = DetailsFragment().apply {
            arguments = bundleOf(
                Pair("creatingCharacter", creatingCharacter),
                Pair("characterName", characterName)
            )
        }
    }
}