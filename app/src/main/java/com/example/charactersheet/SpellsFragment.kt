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

//        val factory = CharacterViewModelFactory(requireActivity().application)
//        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]
        characterViewModel = requireActivity().viewModels<CharacterViewModel>().value
        runBlocking {
            arguments?.let {
                val isNewCharacter = it.getBoolean("creatingCharacter")
                if (!isNewCharacter) {
                    characterName = it.getString("characterName")!!
                    currentCharacter = characterViewModel.currentCharacter.value!!
                } else {
                    currentCharacter = characterViewModel.currentCharacter.value!!
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellsBinding.inflate(layoutInflater)
        binding.viewModel = characterViewModel
        initCantripSpellVariables()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        println("----------------------- IN SPELLS")
    }
    
    private fun initCantripSpellVariables() {
        binding.cantrip1.binding.viewModel = characterViewModel
        binding.cantrip1.binding.spellName = currentCharacter.cantrips[0]
        binding.cantrip2.binding.viewModel = characterViewModel
        binding.cantrip2.binding.spellName = currentCharacter.cantrips[1]
        binding.cantrip3.binding.viewModel = characterViewModel
        binding.cantrip3.binding.spellName = currentCharacter.cantrips[2]
        binding.cantrip4.binding.viewModel = characterViewModel
        binding.cantrip4.binding.spellName = currentCharacter.cantrips[3]
        binding.cantrip5.binding.viewModel = characterViewModel
        binding.cantrip5.binding.spellName = currentCharacter.cantrips[4]
        binding.cantrip6.binding.viewModel = characterViewModel
        binding.cantrip6.binding.spellName = currentCharacter.cantrips[5]
        binding.cantrip7.binding.viewModel = characterViewModel
        binding.cantrip7.binding.spellName = currentCharacter.cantrips[6]
        binding.cantrip8.binding.viewModel = characterViewModel
        binding.cantrip8.binding.spellName = currentCharacter.cantrips[7]

        binding.level1Spell1.binding.viewModel = characterViewModel
        binding.level1Spell1.binding.spell = currentCharacter.level1Spells.spellName[0]
        binding.level1Spell1.binding.isChecked = currentCharacter.level1Spells.spellChecked[0]
        binding.level1Spell2.binding.viewModel = characterViewModel
        binding.level1Spell2.binding.spell = currentCharacter.level1Spells.spellName[1]
        binding.level1Spell2.binding.isChecked = currentCharacter.level1Spells.spellChecked[1]
        binding.level1Spell3.binding.viewModel = characterViewModel
        binding.level1Spell3.binding.spell = currentCharacter.level1Spells.spellName[2]
        binding.level1Spell3.binding.isChecked = currentCharacter.level1Spells.spellChecked[2]
        binding.level1Spell4.binding.viewModel = characterViewModel
        binding.level1Spell4.binding.spell = currentCharacter.level1Spells.spellName[3]
        binding.level1Spell4.binding.isChecked = currentCharacter.level1Spells.spellChecked[3]
        binding.level1Spell5.binding.viewModel = characterViewModel
        binding.level1Spell5.binding.spell = currentCharacter.level1Spells.spellName[4]
        binding.level1Spell5.binding.isChecked = currentCharacter.level1Spells.spellChecked[4]
        binding.level1Spell6.binding.viewModel = characterViewModel
        binding.level1Spell6.binding.spell = currentCharacter.level1Spells.spellName[5]
        binding.level1Spell6.binding.isChecked = currentCharacter.level1Spells.spellChecked[5]
        binding.level1Spell7.binding.viewModel = characterViewModel
        binding.level1Spell7.binding.spell = currentCharacter.level1Spells.spellName[6]
        binding.level1Spell7.binding.isChecked = currentCharacter.level1Spells.spellChecked[6]
        binding.level1Spell8.binding.viewModel = characterViewModel
        binding.level1Spell8.binding.spell = currentCharacter.level1Spells.spellName[7]
        binding.level1Spell8.binding.isChecked = currentCharacter.level1Spells.spellChecked[7]
        binding.level1Spell9.binding.viewModel = characterViewModel
        binding.level1Spell9.binding.spell = currentCharacter.level1Spells.spellName[8]
        binding.level1Spell9.binding.isChecked = currentCharacter.level1Spells.spellChecked[8]
        binding.level1Spell10.binding.viewModel = characterViewModel
        binding.level1Spell10.binding.spell = currentCharacter.level1Spells.spellName[9]
        binding.level1Spell10.binding.isChecked = currentCharacter.level1Spells.spellChecked[9]
        binding.level1Spell11.binding.viewModel = characterViewModel
        binding.level1Spell11.binding.spell = currentCharacter.level1Spells.spellName[10]
        binding.level1Spell11.binding.isChecked = currentCharacter.level1Spells.spellChecked[10]
        binding.level1Spell12.binding.viewModel = characterViewModel
        binding.level1Spell12.binding.spell = currentCharacter.level1Spells.spellName[11]
        binding.level1Spell12.binding.isChecked = currentCharacter.level1Spells.spellChecked[11]
        binding.level1Spell13.binding.viewModel = characterViewModel
        binding.level1Spell13.binding.spell = currentCharacter.level1Spells.spellName[12]
        binding.level1Spell13.binding.isChecked = currentCharacter.level1Spells.spellChecked[12]

        binding.level2Spell1.binding.viewModel = characterViewModel
        binding.level2Spell1.binding.spell = currentCharacter.level2Spells.spellName[0]
        binding.level2Spell1.binding.isChecked = currentCharacter.level2Spells.spellChecked[0]
        binding.level2Spell2.binding.viewModel = characterViewModel
        binding.level2Spell2.binding.spell = currentCharacter.level2Spells.spellName[1]
        binding.level2Spell2.binding.isChecked = currentCharacter.level2Spells.spellChecked[1]
        binding.level2Spell3.binding.viewModel = characterViewModel
        binding.level2Spell3.binding.spell = currentCharacter.level2Spells.spellName[2]
        binding.level2Spell3.binding.isChecked = currentCharacter.level2Spells.spellChecked[2]
        binding.level2Spell4.binding.viewModel = characterViewModel
        binding.level2Spell4.binding.spell = currentCharacter.level2Spells.spellName[3]
        binding.level2Spell4.binding.isChecked = currentCharacter.level2Spells.spellChecked[3]
        binding.level2Spell5.binding.viewModel = characterViewModel
        binding.level2Spell5.binding.spell = currentCharacter.level2Spells.spellName[4]
        binding.level2Spell5.binding.isChecked = currentCharacter.level2Spells.spellChecked[4]
        binding.level2Spell6.binding.viewModel = characterViewModel
        binding.level2Spell6.binding.spell = currentCharacter.level2Spells.spellName[5]
        binding.level2Spell6.binding.isChecked = currentCharacter.level2Spells.spellChecked[5]
        binding.level2Spell7.binding.viewModel = characterViewModel
        binding.level2Spell7.binding.spell = currentCharacter.level2Spells.spellName[6]
        binding.level2Spell7.binding.isChecked = currentCharacter.level2Spells.spellChecked[6]
        binding.level2Spell8.binding.viewModel = characterViewModel
        binding.level2Spell8.binding.spell = currentCharacter.level2Spells.spellName[7]
        binding.level2Spell8.binding.isChecked = currentCharacter.level2Spells.spellChecked[7]
        binding.level2Spell9.binding.viewModel = characterViewModel
        binding.level2Spell9.binding.spell = currentCharacter.level2Spells.spellName[8]
        binding.level2Spell9.binding.isChecked = currentCharacter.level2Spells.spellChecked[8]
        binding.level2Spell10.binding.viewModel = characterViewModel
        binding.level2Spell10.binding.spell = currentCharacter.level2Spells.spellName[9]
        binding.level2Spell10.binding.isChecked = currentCharacter.level2Spells.spellChecked[9]
        binding.level2Spell11.binding.viewModel = characterViewModel
        binding.level2Spell11.binding.spell = currentCharacter.level2Spells.spellName[10]
        binding.level2Spell11.binding.isChecked = currentCharacter.level2Spells.spellChecked[10]
        binding.level2Spell12.binding.viewModel = characterViewModel
        binding.level2Spell12.binding.spell = currentCharacter.level2Spells.spellName[11]
        binding.level2Spell12.binding.isChecked = currentCharacter.level2Spells.spellChecked[11]
        binding.level2Spell13.binding.viewModel = characterViewModel
        binding.level2Spell13.binding.spell = currentCharacter.level2Spells.spellName[12]
        binding.level2Spell13.binding.isChecked = currentCharacter.level2Spells.spellChecked[12]

        binding.level3Spell1.binding.viewModel = characterViewModel
        binding.level3Spell1.binding.spell = currentCharacter.level3Spells.spellName[0]
        binding.level3Spell1.binding.isChecked = currentCharacter.level3Spells.spellChecked[0]
        binding.level3Spell2.binding.viewModel = characterViewModel
        binding.level3Spell2.binding.spell = currentCharacter.level3Spells.spellName[1]
        binding.level3Spell2.binding.isChecked = currentCharacter.level3Spells.spellChecked[1]
        binding.level3Spell3.binding.viewModel = characterViewModel
        binding.level3Spell3.binding.spell = currentCharacter.level3Spells.spellName[2]
        binding.level3Spell3.binding.isChecked = currentCharacter.level3Spells.spellChecked[2]
        binding.level3Spell4.binding.viewModel = characterViewModel
        binding.level3Spell4.binding.spell = currentCharacter.level3Spells.spellName[3]
        binding.level3Spell4.binding.isChecked = currentCharacter.level3Spells.spellChecked[3]
        binding.level3Spell5.binding.viewModel = characterViewModel
        binding.level3Spell5.binding.spell = currentCharacter.level3Spells.spellName[4]
        binding.level3Spell5.binding.isChecked = currentCharacter.level3Spells.spellChecked[4]
        binding.level3Spell6.binding.viewModel = characterViewModel
        binding.level3Spell6.binding.spell = currentCharacter.level3Spells.spellName[5]
        binding.level3Spell6.binding.isChecked = currentCharacter.level3Spells.spellChecked[5]
        binding.level3Spell7.binding.viewModel = characterViewModel
        binding.level3Spell7.binding.spell = currentCharacter.level3Spells.spellName[6]
        binding.level3Spell7.binding.isChecked = currentCharacter.level3Spells.spellChecked[6]
        binding.level3Spell8.binding.viewModel = characterViewModel
        binding.level3Spell8.binding.spell = currentCharacter.level3Spells.spellName[7]
        binding.level3Spell8.binding.isChecked = currentCharacter.level3Spells.spellChecked[7]
        binding.level3Spell9.binding.viewModel = characterViewModel
        binding.level3Spell9.binding.spell = currentCharacter.level3Spells.spellName[8]
        binding.level3Spell9.binding.isChecked = currentCharacter.level3Spells.spellChecked[8]
        binding.level3Spell10.binding.viewModel = characterViewModel
        binding.level3Spell10.binding.spell = currentCharacter.level3Spells.spellName[9]
        binding.level3Spell10.binding.isChecked = currentCharacter.level3Spells.spellChecked[9]
        binding.level3Spell11.binding.viewModel = characterViewModel
        binding.level3Spell11.binding.spell = currentCharacter.level3Spells.spellName[10]
        binding.level3Spell11.binding.isChecked = currentCharacter.level3Spells.spellChecked[10]
        binding.level3Spell12.binding.viewModel = characterViewModel
        binding.level3Spell12.binding.spell = currentCharacter.level3Spells.spellName[11]
        binding.level3Spell12.binding.isChecked = currentCharacter.level3Spells.spellChecked[11]
        binding.level3Spell13.binding.viewModel = characterViewModel
        binding.level3Spell13.binding.spell = currentCharacter.level3Spells.spellName[12]
        binding.level3Spell13.binding.isChecked = currentCharacter.level3Spells.spellChecked[12]

        binding.level4Spell1.binding.viewModel = characterViewModel
        binding.level4Spell1.binding.spell = currentCharacter.level4Spells.spellName[0]
        binding.level4Spell1.binding.isChecked = currentCharacter.level4Spells.spellChecked[0]
        binding.level4Spell2.binding.viewModel = characterViewModel
        binding.level4Spell2.binding.spell = currentCharacter.level4Spells.spellName[1]
        binding.level4Spell2.binding.isChecked = currentCharacter.level4Spells.spellChecked[1]
        binding.level4Spell3.binding.viewModel = characterViewModel
        binding.level4Spell3.binding.spell = currentCharacter.level4Spells.spellName[2]
        binding.level4Spell3.binding.isChecked = currentCharacter.level4Spells.spellChecked[2]
        binding.level4Spell4.binding.viewModel = characterViewModel
        binding.level4Spell4.binding.spell = currentCharacter.level4Spells.spellName[3]
        binding.level4Spell4.binding.isChecked = currentCharacter.level4Spells.spellChecked[3]
        binding.level4Spell5.binding.viewModel = characterViewModel
        binding.level4Spell5.binding.spell = currentCharacter.level4Spells.spellName[4]
        binding.level4Spell5.binding.isChecked = currentCharacter.level4Spells.spellChecked[4]
        binding.level4Spell6.binding.viewModel = characterViewModel
        binding.level4Spell6.binding.spell = currentCharacter.level4Spells.spellName[5]
        binding.level4Spell6.binding.isChecked = currentCharacter.level4Spells.spellChecked[5]
        binding.level4Spell7.binding.viewModel = characterViewModel
        binding.level4Spell7.binding.spell = currentCharacter.level4Spells.spellName[6]
        binding.level4Spell7.binding.isChecked = currentCharacter.level4Spells.spellChecked[6]
        binding.level4Spell8.binding.viewModel = characterViewModel
        binding.level4Spell8.binding.spell = currentCharacter.level4Spells.spellName[7]
        binding.level4Spell8.binding.isChecked = currentCharacter.level4Spells.spellChecked[7]
        binding.level4Spell9.binding.viewModel = characterViewModel
        binding.level4Spell9.binding.spell = currentCharacter.level4Spells.spellName[8]
        binding.level4Spell9.binding.isChecked = currentCharacter.level4Spells.spellChecked[8]
        binding.level4Spell10.binding.viewModel = characterViewModel
        binding.level4Spell10.binding.spell = currentCharacter.level4Spells.spellName[9]
        binding.level4Spell10.binding.isChecked = currentCharacter.level4Spells.spellChecked[9]
        binding.level4Spell11.binding.viewModel = characterViewModel
        binding.level4Spell11.binding.spell = currentCharacter.level4Spells.spellName[10]
        binding.level4Spell11.binding.isChecked = currentCharacter.level4Spells.spellChecked[10]
        binding.level4Spell12.binding.viewModel = characterViewModel
        binding.level4Spell12.binding.spell = currentCharacter.level4Spells.spellName[11]
        binding.level4Spell12.binding.isChecked = currentCharacter.level4Spells.spellChecked[11]
        binding.level4Spell13.binding.viewModel = characterViewModel
        binding.level4Spell13.binding.spell = currentCharacter.level4Spells.spellName[12]
        binding.level4Spell13.binding.isChecked = currentCharacter.level4Spells.spellChecked[12]

        binding.level5Spell1.binding.viewModel = characterViewModel
        binding.level5Spell1.binding.spell = currentCharacter.level5Spells.spellName[0]
        binding.level5Spell1.binding.isChecked = currentCharacter.level5Spells.spellChecked[0]
        binding.level5Spell2.binding.viewModel = characterViewModel
        binding.level5Spell2.binding.spell = currentCharacter.level5Spells.spellName[1]
        binding.level5Spell2.binding.isChecked = currentCharacter.level5Spells.spellChecked[1]
        binding.level5Spell3.binding.viewModel = characterViewModel
        binding.level5Spell3.binding.spell = currentCharacter.level5Spells.spellName[2]
        binding.level5Spell3.binding.isChecked = currentCharacter.level5Spells.spellChecked[2]
        binding.level5Spell4.binding.viewModel = characterViewModel
        binding.level5Spell4.binding.spell = currentCharacter.level5Spells.spellName[3]
        binding.level5Spell4.binding.isChecked = currentCharacter.level5Spells.spellChecked[3]
        binding.level5Spell5.binding.viewModel = characterViewModel
        binding.level5Spell5.binding.spell = currentCharacter.level5Spells.spellName[4]
        binding.level5Spell5.binding.isChecked = currentCharacter.level5Spells.spellChecked[4]
        binding.level5Spell6.binding.viewModel = characterViewModel
        binding.level5Spell6.binding.spell = currentCharacter.level5Spells.spellName[5]
        binding.level5Spell6.binding.isChecked = currentCharacter.level5Spells.spellChecked[5]
        binding.level5Spell7.binding.viewModel = characterViewModel
        binding.level5Spell7.binding.spell = currentCharacter.level5Spells.spellName[6]
        binding.level5Spell7.binding.isChecked = currentCharacter.level5Spells.spellChecked[6]
        binding.level5Spell8.binding.viewModel = characterViewModel
        binding.level5Spell8.binding.spell = currentCharacter.level5Spells.spellName[7]
        binding.level5Spell8.binding.isChecked = currentCharacter.level5Spells.spellChecked[7]
        binding.level5Spell9.binding.viewModel = characterViewModel
        binding.level5Spell9.binding.spell = currentCharacter.level5Spells.spellName[8]
        binding.level5Spell9.binding.isChecked = currentCharacter.level5Spells.spellChecked[8]
        binding.level5Spell10.binding.viewModel = characterViewModel
        binding.level5Spell10.binding.spell = currentCharacter.level5Spells.spellName[9]
        binding.level5Spell10.binding.isChecked = currentCharacter.level5Spells.spellChecked[9]
        binding.level5Spell11.binding.viewModel = characterViewModel
        binding.level5Spell11.binding.spell = currentCharacter.level5Spells.spellName[10]
        binding.level5Spell11.binding.isChecked = currentCharacter.level5Spells.spellChecked[10]

        binding.level6Spell1.binding.viewModel = characterViewModel
        binding.level6Spell1.binding.spell = currentCharacter.level6Spells.spellName[0]
        binding.level6Spell1.binding.isChecked = currentCharacter.level6Spells.spellChecked[0]
        binding.level6Spell2.binding.viewModel = characterViewModel
        binding.level6Spell2.binding.spell = currentCharacter.level6Spells.spellName[1]
        binding.level6Spell2.binding.isChecked = currentCharacter.level6Spells.spellChecked[1]
        binding.level6Spell3.binding.viewModel = characterViewModel
        binding.level6Spell3.binding.spell = currentCharacter.level6Spells.spellName[2]
        binding.level6Spell3.binding.isChecked = currentCharacter.level6Spells.spellChecked[2]
        binding.level6Spell4.binding.viewModel = characterViewModel
        binding.level6Spell4.binding.spell = currentCharacter.level6Spells.spellName[3]
        binding.level6Spell4.binding.isChecked = currentCharacter.level6Spells.spellChecked[3]
        binding.level6Spell5.binding.viewModel = characterViewModel
        binding.level6Spell5.binding.spell = currentCharacter.level6Spells.spellName[4]
        binding.level6Spell5.binding.isChecked = currentCharacter.level6Spells.spellChecked[4]
        binding.level6Spell6.binding.viewModel = characterViewModel
        binding.level6Spell6.binding.spell = currentCharacter.level6Spells.spellName[5]
        binding.level6Spell6.binding.isChecked = currentCharacter.level6Spells.spellChecked[5]
        binding.level6Spell7.binding.viewModel = characterViewModel
        binding.level6Spell7.binding.spell = currentCharacter.level6Spells.spellName[6]
        binding.level6Spell7.binding.isChecked = currentCharacter.level6Spells.spellChecked[6]
        binding.level6Spell8.binding.viewModel = characterViewModel
        binding.level6Spell8.binding.spell = currentCharacter.level6Spells.spellName[7]
        binding.level6Spell8.binding.isChecked = currentCharacter.level6Spells.spellChecked[7]
        binding.level6Spell9.binding.viewModel = characterViewModel
        binding.level6Spell9.binding.spell = currentCharacter.level6Spells.spellName[8]
        binding.level6Spell9.binding.isChecked = currentCharacter.level6Spells.spellChecked[8]
        binding.level6Spell10.binding.viewModel = characterViewModel
        binding.level6Spell10.binding.spell = currentCharacter.level6Spells.spellName[9]
        binding.level6Spell10.binding.isChecked = currentCharacter.level6Spells.spellChecked[9]
        binding.level6Spell11.binding.viewModel = characterViewModel
        binding.level6Spell11.binding.spell = currentCharacter.level6Spells.spellName[10]
        binding.level6Spell11.binding.isChecked = currentCharacter.level6Spells.spellChecked[10]

        binding.level7Spell1.binding.viewModel = characterViewModel
        binding.level7Spell1.binding.spell = currentCharacter.level7Spells.spellName[0]
        binding.level7Spell1.binding.isChecked = currentCharacter.level7Spells.spellChecked[0]
        binding.level7Spell2.binding.viewModel = characterViewModel
        binding.level7Spell2.binding.spell = currentCharacter.level7Spells.spellName[1]
        binding.level7Spell2.binding.isChecked = currentCharacter.level7Spells.spellChecked[1]
        binding.level7Spell3.binding.viewModel = characterViewModel
        binding.level7Spell3.binding.spell = currentCharacter.level7Spells.spellName[2]
        binding.level7Spell3.binding.isChecked = currentCharacter.level7Spells.spellChecked[2]
        binding.level7Spell4.binding.viewModel = characterViewModel
        binding.level7Spell4.binding.spell = currentCharacter.level7Spells.spellName[3]
        binding.level7Spell4.binding.isChecked = currentCharacter.level7Spells.spellChecked[3]
        binding.level7Spell5.binding.viewModel = characterViewModel
        binding.level7Spell5.binding.spell = currentCharacter.level7Spells.spellName[4]
        binding.level7Spell5.binding.isChecked = currentCharacter.level7Spells.spellChecked[4]
        binding.level7Spell6.binding.viewModel = characterViewModel
        binding.level7Spell6.binding.spell = currentCharacter.level7Spells.spellName[5]
        binding.level7Spell6.binding.isChecked = currentCharacter.level7Spells.spellChecked[5]
        binding.level7Spell7.binding.viewModel = characterViewModel
        binding.level7Spell7.binding.spell = currentCharacter.level7Spells.spellName[6]
        binding.level7Spell7.binding.isChecked = currentCharacter.level7Spells.spellChecked[6]
        binding.level7Spell8.binding.viewModel = characterViewModel
        binding.level7Spell8.binding.spell = currentCharacter.level7Spells.spellName[7]
        binding.level7Spell8.binding.isChecked = currentCharacter.level7Spells.spellChecked[7]
        binding.level7Spell9.binding.viewModel = characterViewModel
        binding.level7Spell9.binding.spell = currentCharacter.level7Spells.spellName[8]
        binding.level7Spell9.binding.isChecked = currentCharacter.level7Spells.spellChecked[8]
        binding.level7Spell10.binding.viewModel = characterViewModel
        binding.level7Spell10.binding.spell = currentCharacter.level7Spells.spellName[9]
        binding.level7Spell10.binding.isChecked = currentCharacter.level7Spells.spellChecked[9]
        binding.level7Spell11.binding.viewModel = characterViewModel
        binding.level7Spell11.binding.spell = currentCharacter.level7Spells.spellName[10]
        binding.level7Spell11.binding.isChecked = currentCharacter.level7Spells.spellChecked[10]

        binding.level8Spell1.binding.viewModel = characterViewModel
        binding.level8Spell1.binding.spell = currentCharacter.level8Spells.spellName[0]
        binding.level8Spell1.binding.isChecked = currentCharacter.level8Spells.spellChecked[0]
        binding.level8Spell2.binding.viewModel = characterViewModel
        binding.level8Spell2.binding.spell = currentCharacter.level8Spells.spellName[1]
        binding.level8Spell2.binding.isChecked = currentCharacter.level8Spells.spellChecked[1]
        binding.level8Spell3.binding.viewModel = characterViewModel
        binding.level8Spell3.binding.spell = currentCharacter.level8Spells.spellName[2]
        binding.level8Spell3.binding.isChecked = currentCharacter.level8Spells.spellChecked[2]
        binding.level8Spell4.binding.viewModel = characterViewModel
        binding.level8Spell4.binding.spell = currentCharacter.level8Spells.spellName[3]
        binding.level8Spell4.binding.isChecked = currentCharacter.level8Spells.spellChecked[3]
        binding.level8Spell5.binding.viewModel = characterViewModel
        binding.level8Spell5.binding.spell = currentCharacter.level8Spells.spellName[4]
        binding.level8Spell5.binding.isChecked = currentCharacter.level8Spells.spellChecked[4]
        binding.level8Spell6.binding.viewModel = characterViewModel
        binding.level8Spell6.binding.spell = currentCharacter.level8Spells.spellName[5]
        binding.level8Spell6.binding.isChecked = currentCharacter.level8Spells.spellChecked[5]
        binding.level8Spell7.binding.viewModel = characterViewModel
        binding.level8Spell7.binding.spell = currentCharacter.level8Spells.spellName[6]
        binding.level8Spell7.binding.isChecked = currentCharacter.level8Spells.spellChecked[6]
        binding.level8Spell8.binding.viewModel = characterViewModel
        binding.level8Spell8.binding.spell = currentCharacter.level8Spells.spellName[7]
        binding.level8Spell8.binding.isChecked = currentCharacter.level8Spells.spellChecked[7]
        binding.level8Spell9.binding.viewModel = characterViewModel
        binding.level8Spell9.binding.spell = currentCharacter.level8Spells.spellName[8]
        binding.level8Spell9.binding.isChecked = currentCharacter.level8Spells.spellChecked[8]

        binding.level9Spell1.binding.viewModel = characterViewModel
        binding.level9Spell1.binding.spell = currentCharacter.level9Spells.spellName[0]
        binding.level9Spell1.binding.isChecked = currentCharacter.level9Spells.spellChecked[0]
        binding.level9Spell2.binding.viewModel = characterViewModel
        binding.level9Spell2.binding.spell = currentCharacter.level9Spells.spellName[1]
        binding.level9Spell2.binding.isChecked = currentCharacter.level9Spells.spellChecked[1]
        binding.level9Spell3.binding.viewModel = characterViewModel
        binding.level9Spell3.binding.spell = currentCharacter.level9Spells.spellName[2]
        binding.level9Spell3.binding.isChecked = currentCharacter.level9Spells.spellChecked[2]
        binding.level9Spell4.binding.viewModel = characterViewModel
        binding.level9Spell4.binding.spell = currentCharacter.level9Spells.spellName[3]
        binding.level9Spell4.binding.isChecked = currentCharacter.level9Spells.spellChecked[3]
        binding.level9Spell5.binding.viewModel = characterViewModel
        binding.level9Spell5.binding.spell = currentCharacter.level9Spells.spellName[4]
        binding.level9Spell5.binding.isChecked = currentCharacter.level9Spells.spellChecked[4]
        binding.level9Spell6.binding.viewModel = characterViewModel
        binding.level9Spell6.binding.spell = currentCharacter.level9Spells.spellName[5]
        binding.level9Spell6.binding.isChecked = currentCharacter.level9Spells.spellChecked[5]
        binding.level9Spell7.binding.viewModel = characterViewModel
        binding.level9Spell7.binding.spell = currentCharacter.level9Spells.spellName[6]
        binding.level9Spell7.binding.isChecked = currentCharacter.level9Spells.spellChecked[6]
        binding.level9Spell8.binding.viewModel = characterViewModel
        binding.level9Spell8.binding.spell = currentCharacter.level9Spells.spellName[7]
        binding.level9Spell8.binding.isChecked = currentCharacter.level9Spells.spellChecked[7]
        binding.level9Spell9.binding.viewModel = characterViewModel
        binding.level9Spell9.binding.spell = currentCharacter.level9Spells.spellName[8]
        binding.level9Spell9.binding.isChecked = currentCharacter.level9Spells.spellChecked[8]
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

    companion object {
        fun createInstance(creatingCharacter: Boolean, characterName: String) = SpellsFragment().apply {
                arguments = bundleOf(
                    Pair("creatingCharacter", creatingCharacter),
                    Pair("characterName", characterName)
                )
            }
    }
}