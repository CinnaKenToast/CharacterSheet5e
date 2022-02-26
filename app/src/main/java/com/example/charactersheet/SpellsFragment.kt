package com.example.charactersheet

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.data.character.blankCharacter
import com.example.charactersheet.databinding.FragmentSpellsBinding
import com.example.charactersheet.utils.toJsonString
import kotlinx.coroutines.runBlocking

class SpellsFragment : Fragment() {

    private lateinit var binding: FragmentSpellsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var characterName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = CharacterViewModelFactory(requireActivity().application)
        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]

        runBlocking {
            arguments?.let {
                val isNewCharacter = it.getBoolean("creatingCharacter")
                if (!isNewCharacter) {
                    characterName = it.getString("characterName")!!
                    currentCharacter = characterViewModel.getCharacter(characterName)
                } else {
                    currentCharacter = blankCharacter.copy()
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        if (this::currentCharacter.isInitialized) {
            initializeFields()
        }
    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.saveButton -> {
//                    updateCharacter()
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        characterViewModel.saveCharacter(currentCharacter)
                    }
                    true
                }
                R.id.exportButton -> {
//                    updateCharacter()
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        val json = currentCharacter.toJsonString()
                        val clipboard = requireContext().getSystemService(Service.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("characterSpellsData", json)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "${currentCharacter.characterName}'s data has been copied to your clipboard", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                else -> {true}
            }
        }
    }

    private fun initializeFields() {
        binding.spellcastingClass.text = currentCharacter.spellCastingClass
        binding.spellcastingAbility.text = currentCharacter.spellCastingAbility
        binding.spellSaveDC.text = currentCharacter.spellSaveDC
        binding.spellBonus.text = currentCharacter.spellAttackBonus
        binding.cantrip1.setText(currentCharacter.cantrips[0])
        binding.cantrip2.setText(currentCharacter.cantrips[1])
        binding.cantrip3.setText(currentCharacter.cantrips[2])
        binding.cantrip4.setText(currentCharacter.cantrips[3])
        binding.cantrip5.setText(currentCharacter.cantrips[4])
        binding.cantrip6.setText(currentCharacter.cantrips[5])
        binding.cantrip7.setText(currentCharacter.cantrips[6])
        binding.cantrip8.setText(currentCharacter.cantrips[7])

        binding.level1SlotsTotal.setText(currentCharacter.level1Spells.totalSpellSlots)
        binding.level1SlotsExpended.setText(currentCharacter.level1Spells.spellSlotsExpended)
        binding.level1Spell1.setChecked(currentCharacter.level1Spells.spellChecked[0])
        binding.level1Spell1.setText(currentCharacter.level1Spells.spellName[0])
        binding.level1Spell2.setChecked(currentCharacter.level1Spells.spellChecked[1])
        binding.level1Spell2.setText(currentCharacter.level1Spells.spellName[1])
        binding.level1Spell3.setChecked(currentCharacter.level1Spells.spellChecked[2])
        binding.level1Spell3.setText(currentCharacter.level1Spells.spellName[2])
        binding.level1Spell4.setChecked(currentCharacter.level1Spells.spellChecked[3])
        binding.level1Spell4.setText(currentCharacter.level1Spells.spellName[3])
        binding.level1Spell5.setChecked(currentCharacter.level1Spells.spellChecked[4])
        binding.level1Spell5.setText(currentCharacter.level1Spells.spellName[4])
        binding.level1Spell6.setChecked(currentCharacter.level1Spells.spellChecked[5])
        binding.level1Spell6.setText(currentCharacter.level1Spells.spellName[5])
        binding.level1Spell7.setChecked(currentCharacter.level1Spells.spellChecked[6])
        binding.level1Spell7.setText(currentCharacter.level1Spells.spellName[6])
        binding.level1Spell8.setChecked(currentCharacter.level1Spells.spellChecked[7])
        binding.level1Spell8.setText(currentCharacter.level1Spells.spellName[7])
        binding.level1Spell9.setChecked(currentCharacter.level1Spells.spellChecked[8])
        binding.level1Spell9.setText(currentCharacter.level1Spells.spellName[8])
        binding.level1Spell10.setChecked(currentCharacter.level1Spells.spellChecked[9])
        binding.level1Spell10.setText(currentCharacter.level1Spells.spellName[9])
        binding.level1Spell11.setChecked(currentCharacter.level1Spells.spellChecked[10])
        binding.level1Spell11.setText(currentCharacter.level1Spells.spellName[10])
        binding.level1Spell12.setChecked(currentCharacter.level1Spells.spellChecked[11])
        binding.level1Spell12.setText(currentCharacter.level1Spells.spellName[11])
        binding.level1Spell13.setChecked(currentCharacter.level1Spells.spellChecked[12])
        binding.level1Spell13.setText(currentCharacter.level1Spells.spellName[12])

        binding.level2SlotsTotal.setText(currentCharacter.level2Spells.totalSpellSlots)
        binding.level2SlotsExpended.setText(currentCharacter.level2Spells.spellSlotsExpended)
        binding.level2Spell1.setChecked(currentCharacter.level2Spells.spellChecked[0])
        binding.level2Spell1.setText(currentCharacter.level2Spells.spellName[0])
        binding.level2Spell2.setChecked(currentCharacter.level2Spells.spellChecked[1])
        binding.level2Spell2.setText(currentCharacter.level2Spells.spellName[1])
        binding.level2Spell3.setChecked(currentCharacter.level2Spells.spellChecked[2])
        binding.level2Spell3.setText(currentCharacter.level2Spells.spellName[2])
        binding.level2Spell4.setChecked(currentCharacter.level2Spells.spellChecked[3])
        binding.level2Spell4.setText(currentCharacter.level2Spells.spellName[3])
        binding.level2Spell5.setChecked(currentCharacter.level2Spells.spellChecked[4])
        binding.level2Spell5.setText(currentCharacter.level2Spells.spellName[4])
        binding.level2Spell6.setChecked(currentCharacter.level2Spells.spellChecked[5])
        binding.level2Spell6.setText(currentCharacter.level2Spells.spellName[5])
        binding.level2Spell7.setChecked(currentCharacter.level2Spells.spellChecked[6])
        binding.level2Spell7.setText(currentCharacter.level2Spells.spellName[6])
        binding.level2Spell8.setChecked(currentCharacter.level2Spells.spellChecked[7])
        binding.level2Spell8.setText(currentCharacter.level2Spells.spellName[7])
        binding.level2Spell9.setChecked(currentCharacter.level2Spells.spellChecked[8])
        binding.level2Spell9.setText(currentCharacter.level2Spells.spellName[8])
        binding.level2Spell10.setChecked(currentCharacter.level2Spells.spellChecked[9])
        binding.level2Spell10.setText(currentCharacter.level2Spells.spellName[9])
        binding.level2Spell11.setChecked(currentCharacter.level2Spells.spellChecked[10])
        binding.level2Spell11.setText(currentCharacter.level2Spells.spellName[10])
        binding.level2Spell12.setChecked(currentCharacter.level2Spells.spellChecked[11])
        binding.level2Spell12.setText(currentCharacter.level2Spells.spellName[11])
        binding.level2Spell13.setChecked(currentCharacter.level2Spells.spellChecked[12])
        binding.level2Spell13.setText(currentCharacter.level2Spells.spellName[12])

        binding.level3SlotsTotal.setText(currentCharacter.level3Spells.totalSpellSlots)
        binding.level3SlotsExpended.setText(currentCharacter.level3Spells.spellSlotsExpended)
        binding.level3Spell1.setChecked(currentCharacter.level3Spells.spellChecked[0])
        binding.level3Spell1.setText(currentCharacter.level3Spells.spellName[0])
        binding.level3Spell2.setChecked(currentCharacter.level3Spells.spellChecked[1])
        binding.level3Spell2.setText(currentCharacter.level3Spells.spellName[1])
        binding.level3Spell3.setChecked(currentCharacter.level3Spells.spellChecked[2])
        binding.level3Spell3.setText(currentCharacter.level3Spells.spellName[2])
        binding.level3Spell4.setChecked(currentCharacter.level3Spells.spellChecked[3])
        binding.level3Spell4.setText(currentCharacter.level3Spells.spellName[3])
        binding.level3Spell5.setChecked(currentCharacter.level3Spells.spellChecked[4])
        binding.level3Spell5.setText(currentCharacter.level3Spells.spellName[4])
        binding.level3Spell6.setChecked(currentCharacter.level3Spells.spellChecked[5])
        binding.level3Spell6.setText(currentCharacter.level3Spells.spellName[5])
        binding.level3Spell7.setChecked(currentCharacter.level3Spells.spellChecked[6])
        binding.level3Spell7.setText(currentCharacter.level3Spells.spellName[6])
        binding.level3Spell8.setChecked(currentCharacter.level3Spells.spellChecked[7])
        binding.level3Spell8.setText(currentCharacter.level3Spells.spellName[7])
        binding.level3Spell9.setChecked(currentCharacter.level3Spells.spellChecked[8])
        binding.level3Spell9.setText(currentCharacter.level3Spells.spellName[8])
        binding.level3Spell10.setChecked(currentCharacter.level3Spells.spellChecked[9])
        binding.level3Spell10.setText(currentCharacter.level3Spells.spellName[9])
        binding.level3Spell11.setChecked(currentCharacter.level3Spells.spellChecked[10])
        binding.level3Spell11.setText(currentCharacter.level3Spells.spellName[10])
        binding.level3Spell12.setChecked(currentCharacter.level3Spells.spellChecked[11])
        binding.level3Spell12.setText(currentCharacter.level3Spells.spellName[11])
        binding.level3Spell13.setChecked(currentCharacter.level3Spells.spellChecked[12])
        binding.level3Spell13.setText(currentCharacter.level3Spells.spellName[12])

        binding.level4SlotsTotal.setText(currentCharacter.level4Spells.totalSpellSlots)
        binding.level4SlotsExpended.setText(currentCharacter.level4Spells.spellSlotsExpended)
        binding.level4Spell1.setChecked(currentCharacter.level4Spells.spellChecked[0])
        binding.level4Spell1.setText(currentCharacter.level4Spells.spellName[0])
        binding.level4Spell2.setChecked(currentCharacter.level4Spells.spellChecked[1])
        binding.level4Spell2.setText(currentCharacter.level4Spells.spellName[1])
        binding.level4Spell3.setChecked(currentCharacter.level4Spells.spellChecked[2])
        binding.level4Spell3.setText(currentCharacter.level4Spells.spellName[2])
        binding.level4Spell4.setChecked(currentCharacter.level4Spells.spellChecked[3])
        binding.level4Spell4.setText(currentCharacter.level4Spells.spellName[3])
        binding.level4Spell5.setChecked(currentCharacter.level4Spells.spellChecked[4])
        binding.level4Spell5.setText(currentCharacter.level4Spells.spellName[4])
        binding.level4Spell6.setChecked(currentCharacter.level4Spells.spellChecked[5])
        binding.level4Spell6.setText(currentCharacter.level4Spells.spellName[5])
        binding.level4Spell7.setChecked(currentCharacter.level4Spells.spellChecked[6])
        binding.level4Spell7.setText(currentCharacter.level4Spells.spellName[6])
        binding.level4Spell8.setChecked(currentCharacter.level4Spells.spellChecked[7])
        binding.level4Spell8.setText(currentCharacter.level4Spells.spellName[7])
        binding.level4Spell9.setChecked(currentCharacter.level4Spells.spellChecked[8])
        binding.level4Spell9.setText(currentCharacter.level4Spells.spellName[8])
        binding.level4Spell10.setChecked(currentCharacter.level4Spells.spellChecked[9])
        binding.level4Spell10.setText(currentCharacter.level4Spells.spellName[9])
        binding.level4Spell11.setChecked(currentCharacter.level4Spells.spellChecked[10])
        binding.level4Spell11.setText(currentCharacter.level4Spells.spellName[10])
        binding.level4Spell12.setChecked(currentCharacter.level4Spells.spellChecked[11])
        binding.level4Spell12.setText(currentCharacter.level4Spells.spellName[11])
        binding.level4Spell13.setChecked(currentCharacter.level4Spells.spellChecked[12])
        binding.level4Spell13.setText(currentCharacter.level4Spells.spellName[12])
        
        binding.level5SlotsTotal.setText(currentCharacter.level5Spells.totalSpellSlots)
        binding.level5SlotsExpended.setText(currentCharacter.level5Spells.spellSlotsExpended)
        binding.level5Spell1.setChecked(currentCharacter.level5Spells.spellChecked[0])
        binding.level5Spell1.setText(currentCharacter.level5Spells.spellName[0])
        binding.level5Spell2.setChecked(currentCharacter.level5Spells.spellChecked[1])
        binding.level5Spell2.setText(currentCharacter.level5Spells.spellName[1])
        binding.level5Spell3.setChecked(currentCharacter.level5Spells.spellChecked[2])
        binding.level5Spell3.setText(currentCharacter.level5Spells.spellName[2])
        binding.level5Spell4.setChecked(currentCharacter.level5Spells.spellChecked[3])
        binding.level5Spell4.setText(currentCharacter.level5Spells.spellName[3])
        binding.level5Spell5.setChecked(currentCharacter.level5Spells.spellChecked[4])
        binding.level5Spell5.setText(currentCharacter.level5Spells.spellName[4])
        binding.level5Spell6.setChecked(currentCharacter.level5Spells.spellChecked[5])
        binding.level5Spell6.setText(currentCharacter.level5Spells.spellName[5])
        binding.level5Spell7.setChecked(currentCharacter.level5Spells.spellChecked[6])
        binding.level5Spell7.setText(currentCharacter.level5Spells.spellName[6])
        binding.level5Spell8.setChecked(currentCharacter.level5Spells.spellChecked[7])
        binding.level5Spell8.setText(currentCharacter.level5Spells.spellName[7])
        binding.level5Spell9.setChecked(currentCharacter.level5Spells.spellChecked[8])
        binding.level5Spell9.setText(currentCharacter.level5Spells.spellName[8])
        binding.level5Spell10.setChecked(currentCharacter.level5Spells.spellChecked[9])
        binding.level5Spell10.setText(currentCharacter.level5Spells.spellName[9])
        binding.level5Spell11.setChecked(currentCharacter.level5Spells.spellChecked[10])
        binding.level5Spell11.setText(currentCharacter.level5Spells.spellName[10])

        binding.level6SlotsTotal.setText(currentCharacter.level6Spells.totalSpellSlots)
        binding.level6SlotsExpended.setText(currentCharacter.level6Spells.spellSlotsExpended)
        binding.level6Spell1.setChecked(currentCharacter.level6Spells.spellChecked[0])
        binding.level6Spell1.setText(currentCharacter.level6Spells.spellName[0])
        binding.level6Spell2.setChecked(currentCharacter.level6Spells.spellChecked[1])
        binding.level6Spell2.setText(currentCharacter.level6Spells.spellName[1])
        binding.level6Spell3.setChecked(currentCharacter.level6Spells.spellChecked[2])
        binding.level6Spell3.setText(currentCharacter.level6Spells.spellName[2])
        binding.level6Spell4.setChecked(currentCharacter.level6Spells.spellChecked[3])
        binding.level6Spell4.setText(currentCharacter.level6Spells.spellName[3])
        binding.level6Spell5.setChecked(currentCharacter.level6Spells.spellChecked[4])
        binding.level6Spell5.setText(currentCharacter.level6Spells.spellName[4])
        binding.level6Spell6.setChecked(currentCharacter.level6Spells.spellChecked[5])
        binding.level6Spell6.setText(currentCharacter.level6Spells.spellName[5])
        binding.level6Spell7.setChecked(currentCharacter.level6Spells.spellChecked[6])
        binding.level6Spell7.setText(currentCharacter.level6Spells.spellName[6])
        binding.level6Spell8.setChecked(currentCharacter.level6Spells.spellChecked[7])
        binding.level6Spell8.setText(currentCharacter.level6Spells.spellName[7])
        binding.level6Spell9.setChecked(currentCharacter.level6Spells.spellChecked[8])
        binding.level6Spell9.setText(currentCharacter.level6Spells.spellName[8])
        binding.level6Spell10.setChecked(currentCharacter.level6Spells.spellChecked[9])
        binding.level6Spell10.setText(currentCharacter.level6Spells.spellName[9])
        binding.level6Spell11.setChecked(currentCharacter.level6Spells.spellChecked[10])
        binding.level6Spell11.setText(currentCharacter.level6Spells.spellName[10])

        binding.level7SlotsTotal.setText(currentCharacter.level7Spells.totalSpellSlots)
        binding.level7SlotsExpended.setText(currentCharacter.level7Spells.spellSlotsExpended)
        binding.level7Spell1.setChecked(currentCharacter.level7Spells.spellChecked[0])
        binding.level7Spell1.setText(currentCharacter.level7Spells.spellName[0])
        binding.level7Spell2.setChecked(currentCharacter.level7Spells.spellChecked[1])
        binding.level7Spell2.setText(currentCharacter.level7Spells.spellName[1])
        binding.level7Spell3.setChecked(currentCharacter.level7Spells.spellChecked[2])
        binding.level7Spell3.setText(currentCharacter.level7Spells.spellName[2])
        binding.level7Spell4.setChecked(currentCharacter.level7Spells.spellChecked[3])
        binding.level7Spell4.setText(currentCharacter.level7Spells.spellName[3])
        binding.level7Spell5.setChecked(currentCharacter.level7Spells.spellChecked[4])
        binding.level7Spell5.setText(currentCharacter.level7Spells.spellName[4])
        binding.level7Spell6.setChecked(currentCharacter.level7Spells.spellChecked[5])
        binding.level7Spell6.setText(currentCharacter.level7Spells.spellName[5])
        binding.level7Spell7.setChecked(currentCharacter.level7Spells.spellChecked[6])
        binding.level7Spell7.setText(currentCharacter.level7Spells.spellName[6])
        binding.level7Spell8.setChecked(currentCharacter.level7Spells.spellChecked[7])
        binding.level7Spell8.setText(currentCharacter.level7Spells.spellName[7])
        binding.level7Spell9.setChecked(currentCharacter.level7Spells.spellChecked[8])
        binding.level7Spell9.setText(currentCharacter.level7Spells.spellName[8])
        binding.level7Spell10.setChecked(currentCharacter.level7Spells.spellChecked[9])
        binding.level7Spell10.setText(currentCharacter.level7Spells.spellName[9])
        binding.level7Spell11.setChecked(currentCharacter.level7Spells.spellChecked[10])
        binding.level7Spell11.setText(currentCharacter.level7Spells.spellName[10])

        binding.level8SlotsTotal.setText(currentCharacter.level8Spells.totalSpellSlots)
        binding.level8SlotsExpended.setText(currentCharacter.level8Spells.spellSlotsExpended)
        binding.level8Spell1.setChecked(currentCharacter.level8Spells.spellChecked[0])
        binding.level8Spell1.setText(currentCharacter.level8Spells.spellName[0])
        binding.level8Spell2.setChecked(currentCharacter.level8Spells.spellChecked[1])
        binding.level8Spell2.setText(currentCharacter.level8Spells.spellName[1])
        binding.level8Spell3.setChecked(currentCharacter.level8Spells.spellChecked[2])
        binding.level8Spell3.setText(currentCharacter.level8Spells.spellName[2])
        binding.level8Spell4.setChecked(currentCharacter.level8Spells.spellChecked[3])
        binding.level8Spell4.setText(currentCharacter.level8Spells.spellName[3])
        binding.level8Spell5.setChecked(currentCharacter.level8Spells.spellChecked[4])
        binding.level8Spell5.setText(currentCharacter.level8Spells.spellName[4])
        binding.level8Spell6.setChecked(currentCharacter.level8Spells.spellChecked[5])
        binding.level8Spell6.setText(currentCharacter.level8Spells.spellName[5])
        binding.level8Spell7.setChecked(currentCharacter.level8Spells.spellChecked[6])
        binding.level8Spell7.setText(currentCharacter.level8Spells.spellName[6])
        binding.level8Spell8.setChecked(currentCharacter.level8Spells.spellChecked[7])
        binding.level8Spell8.setText(currentCharacter.level8Spells.spellName[7])
        binding.level8Spell9.setChecked(currentCharacter.level8Spells.spellChecked[8])
        binding.level8Spell9.setText(currentCharacter.level8Spells.spellName[8])
        
        binding.level9SlotsTotal.setText(currentCharacter.level9Spells.totalSpellSlots)
        binding.level9SlotsExpended.setText(currentCharacter.level9Spells.spellSlotsExpended)
        binding.level9Spell1.setChecked(currentCharacter.level9Spells.spellChecked[0])
        binding.level9Spell1.setText(currentCharacter.level9Spells.spellName[0])
        binding.level9Spell2.setChecked(currentCharacter.level9Spells.spellChecked[1])
        binding.level9Spell2.setText(currentCharacter.level9Spells.spellName[1])
        binding.level9Spell3.setChecked(currentCharacter.level9Spells.spellChecked[2])
        binding.level9Spell3.setText(currentCharacter.level9Spells.spellName[2])
        binding.level9Spell4.setChecked(currentCharacter.level9Spells.spellChecked[3])
        binding.level9Spell4.setText(currentCharacter.level9Spells.spellName[3])
        binding.level9Spell5.setChecked(currentCharacter.level9Spells.spellChecked[4])
        binding.level9Spell5.setText(currentCharacter.level9Spells.spellName[4])
        binding.level9Spell6.setChecked(currentCharacter.level9Spells.spellChecked[5])
        binding.level9Spell6.setText(currentCharacter.level9Spells.spellName[5])
        binding.level9Spell7.setChecked(currentCharacter.level9Spells.spellChecked[6])
        binding.level9Spell7.setText(currentCharacter.level9Spells.spellName[6])
        binding.level9Spell8.setChecked(currentCharacter.level9Spells.spellChecked[7])
        binding.level9Spell8.setText(currentCharacter.level9Spells.spellName[7])
        binding.level9Spell9.setChecked(currentCharacter.level9Spells.spellChecked[8])
        binding.level9Spell9.setText(currentCharacter.level9Spells.spellName[8])
    }

    companion object {
        fun createInstance(creatingCharacter: Boolean, characterName: String) = SpellsFragment().apply {
                arguments = bundleOf(
                    Pair("creatingCharacter", creatingCharacter),
                    Pair("characterName", characterName)
                )
            }
    }
}