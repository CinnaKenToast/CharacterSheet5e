package com.example.charactersheet

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactersheet.data.Character
import com.example.charactersheet.data.blankCharacter
import com.example.charactersheet.databinding.FragmentDetailsBinding
import com.example.charactersheet.views.AttackSpellsAdapter
import kotlinx.coroutines.runBlocking

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var characterName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        characterViewModel = activity?.let {
            ViewModelProvider(it)[CharacterViewModel::class.java]
        } ?: throw Exception("Activity is null")

        runBlocking {
            arguments?.let {
                val isNewCharacter = it.getBoolean("creatingCharacter")
                if (!isNewCharacter) {
                    characterName = it.getString("characterName")!!
                    currentCharacter = characterViewModel.characterDao.getCharacter(characterName)
                } else {
                    currentCharacter = blankCharacter
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        currentCharacter = blankCharacter
        if (this::currentCharacter.isInitialized) {
            initializeFields()
        }
    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.saveButton -> {
                    Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.exportButton -> {
                    Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {true}
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.attackSpellsRecyclerView
        val adapter = AttackSpellsAdapter(currentCharacter.attackSpells)
        recyclerView.adapter = adapter
    }

    private fun initializeFields() {
        binding.characterName.setText(currentCharacter.characterName)
        binding.classLevel.setText(currentCharacter.classLevel)
        binding.characterBackground.setText(currentCharacter.background)
        binding.playerName.setText(currentCharacter.playerName)
        binding.characterRace.setText(currentCharacter.race)
        binding.characterAlignment.setText(currentCharacter.alignmentType)
        binding.experiencePoints.setText(currentCharacter.experiencePoints)
        binding.armorClass.setText(currentCharacter.armorClass)
        binding.initiative.setText(currentCharacter.initiative)
        binding.speed.setText(currentCharacter.speed)
        binding.hitPointMax.setText(currentCharacter.hitPointMax)
        binding.currentHitPoints.setText(currentCharacter.currentHitPoints)
        binding.tempHitPoints.setText(currentCharacter.temporaryHitPoints)
        binding.totalHitDice.setText(currentCharacter.totalHitDice)
        binding.hitDice.setText(currentCharacter.hitDice)
        binding.successSaveButton1.setChecked(currentCharacter.successDeathSave1)
        binding.successSaveButton2.setChecked(currentCharacter.successDeathSave2)
        binding.successSaveButton3.setChecked(currentCharacter.successDeathSave3)
        binding.failSaveButton1.setChecked(currentCharacter.failDeathSave1)
        binding.failSaveButton2.setChecked(currentCharacter.failDeathSave2)
        binding.failSaveButton3.setChecked(currentCharacter.failDeathSave3)
        binding.inspiration.setText(currentCharacter.inspiration)
        binding.proficiencyBonus.setText(currentCharacter.proficiencyBonus)
        binding.strength.setText(currentCharacter.strength)
        binding.strengthBonus.setText(currentCharacter.strengthBonus)
        binding.dexterity.setText(currentCharacter.dexterity)
        binding.dexterityBonus.setText(currentCharacter.dexterityBonus)
        binding.constitution.setText(currentCharacter.constitution)
        binding.constitutionBonus.setText(currentCharacter.constitutionBonus)
        binding.intelligence.setText(currentCharacter.intelligence)
        binding.intelligenceBonus.setText(currentCharacter.intelligenceBonus)
        binding.wisdom.setText(currentCharacter.wisdom)
        binding.wisdomBonus.setText(currentCharacter.wisdomBonus)
        binding.charisma.setText(currentCharacter.charisma)
        binding.charismaBonus.setText(currentCharacter.charismaBonus)
        binding.strengthSaveButton.setChecked(currentCharacter.strengthSaveChecked)
        binding.strengthSave.setText(currentCharacter.strengthSave)
        binding.dexteritySaveButton.setChecked(currentCharacter.strengthSaveChecked)
        binding.dexteritySave.setText(currentCharacter.dexteritySave)
        binding.constitutionSaveButton.setChecked(currentCharacter.constitutionSaveChecked)
        binding.constitutionSave.setText(currentCharacter.constitutionSave)
        binding.intelligenceSaveButton.setChecked(currentCharacter.intelligenceSaveChecked)
        binding.intelligenceSave.setText(currentCharacter.intelligenceSave)
        binding.wisdomSaveButton.setChecked(currentCharacter.wisdomSaveChecked)
        binding.wisdomSave.setText(currentCharacter.wisdomSave)
        binding.charismaSaveButton.setChecked(currentCharacter.charismaSaveChecked)
        binding.charismaSave.setText(currentCharacter.charismaSave)
        binding.acrobaticsButton.setChecked(currentCharacter.acrobaticsChecked)
        binding.acrobatics.setText(currentCharacter.acrobatics)
        binding.animalHandlingButton.setChecked(currentCharacter.animalHandlingChecked)
        binding.animalHandling.setText(currentCharacter.animalHandling)
        binding.arcanaButton.setChecked(currentCharacter.arcanaChecked)
        binding.arcana.setText(currentCharacter.arcana)
        binding.athleticsButton.setChecked(currentCharacter.athleticsChecked)
        binding.athletics.setText(currentCharacter.athletics)
        binding.deceptionButton.setChecked(currentCharacter.deceptionChecked)
        binding.deception.setText(currentCharacter.deception)
        binding.historyButton.setChecked(currentCharacter.historyChecked)
        binding.history.setText(currentCharacter.history)
        binding.insightButton.setChecked(currentCharacter.insightChecked)
        binding.insight.setText(currentCharacter.insight)
        binding.intimidationButton.setChecked(currentCharacter.intimidationChecked)
        binding.intimidation.setText(currentCharacter.intimidation)
        binding.investigationButton.setChecked(currentCharacter.investigationChecked)
        binding.investigation.setText(currentCharacter.investigation)
        binding.medicineButton.setChecked(currentCharacter.medicineChecked)
        binding.medicine.setText(currentCharacter.medicine)
        binding.natureButton.setChecked(currentCharacter.natureChecked)
        binding.nature.setText(currentCharacter.nature)
        binding.perceptionButton.setChecked(currentCharacter.perceptionChecked)
        binding.perception.setText(currentCharacter.perception)
        binding.performanceButton.setChecked(currentCharacter.performanceChecked)
        binding.performance.setText(currentCharacter.performance)
        binding.persuasionButton.setChecked(currentCharacter.persuasionChecked)
        binding.persuasion.setText(currentCharacter.persuasion)
        binding.religionButton.setChecked(currentCharacter.religionChecked)
        binding.religion.setText(currentCharacter.religion)
        binding.sleightOfHandButton.setChecked(currentCharacter.sleightOfHandChecked)
        binding.sleightOfHand.setText(currentCharacter.sleightOfHand)
        binding.stealthButton.setChecked(currentCharacter.stealthChecked)
        binding.stealth.setText(currentCharacter.stealth)
        binding.survivalButton.setChecked(currentCharacter.survivalChecked)
        binding.survival.setText(currentCharacter.survival)
        initRecyclerView()
        binding.copperPieces.setText(currentCharacter.copper)
        binding.silverPieces.setText(currentCharacter.silver)
        binding.electrumPieces.setText(currentCharacter.electrum)
        binding.goldPieces.setText(currentCharacter.gold)
        binding.platinumPieces.setText(currentCharacter.platinum)
        binding.equipment.setText(currentCharacter.equipment)
        binding.proficienciesLanguages.setText(currentCharacter.proficiencyLanguages)
        binding.personalityTraits.setText(currentCharacter.personalityTraits)
        binding.ideals.setText(currentCharacter.ideals)
        binding.bonds.setText(currentCharacter.bonds)
        binding.flaws.setText(currentCharacter.flaws)
    }
}