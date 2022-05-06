package com.shipsco.charactersheet

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
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.data.character.blankCharacter
import com.shipsco.charactersheet.databinding.FragmentSpellsBinding
import com.shipsco.charactersheet.utils.toJsonString

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
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellsBinding.inflate(layoutInflater)
        currentCharacter = characterViewModel.currentCharacter.value ?: blankCharacter.copy()
//        initCantripSpellVariables()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        println("----------------------- IN SPELLS")
    }

    override fun onPause() {
        super.onPause()
        characterViewModel.saveCurrentCharacter()
    }
    
//    private fun initCantripSpellVariables() {
//        binding.cantrip1.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  0
//        binding.cantrip2.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  1
//        binding.cantrip3.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  2
//        binding.cantrip4.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  3
//        binding.cantrip5.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  4
//        binding.cantrip6.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  5
//        binding.cantrip7.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  6
//        binding.cantrip8.binding.viewModel = characterViewModel
//        binding.cantrip1.binding.position =  7
//
//        binding.level1Spell1.binding.viewModel = characterViewModel
//        binding.level1Spell1.binding.spellLevel = 0
//        binding.level1Spell1.binding.spellPosition = 0
//        binding.level1Spell2.binding.viewModel = characterViewModel
//        binding.level1Spell2.binding.spellLevel = 0
//        binding.level1Spell2.binding.spellPosition = 1
//        binding.level1Spell3.binding.viewModel = characterViewModel
//        binding.level1Spell3.binding.spellLevel = 0
//        binding.level1Spell3.binding.spellPosition = 2
//        binding.level1Spell4.binding.viewModel = characterViewModel
//        binding.level1Spell4.binding.spellLevel = 0
//        binding.level1Spell4.binding.spellPosition = 3
//        binding.level1Spell5.binding.viewModel = characterViewModel
//        binding.level1Spell5.binding.spellLevel = 0
//        binding.level1Spell5.binding.spellPosition = 4
//        binding.level1Spell6.binding.viewModel = characterViewModel
//        binding.level1Spell6.binding.spellLevel = 0
//        binding.level1Spell6.binding.spellPosition = 5
//        binding.level1Spell7.binding.viewModel = characterViewModel
//        binding.level1Spell7.binding.spellLevel = 0
//        binding.level1Spell7.binding.spellPosition = 6
//        binding.level1Spell8.binding.viewModel = characterViewModel
//        binding.level1Spell8.binding.spellLevel = 0
//        binding.level1Spell8.binding.spellPosition = 7
//        binding.level1Spell9.binding.viewModel = characterViewModel
//        binding.level1Spell9.binding.spellLevel = 0
//        binding.level1Spell9.binding.spellPosition = 8
//        binding.level1Spell10.binding.viewModel = characterViewModel
//        binding.level1Spell10.binding.spellLevel = 0
//        binding.level1Spell10.binding.spellPosition = 9
//        binding.level1Spell11.binding.viewModel = characterViewModel
//        binding.level1Spell11.binding.spellLevel = 0
//        binding.level1Spell11.binding.spellPosition = 10
//        binding.level1Spell12.binding.viewModel = characterViewModel
//        binding.level1Spell12.binding.spellLevel = 0
//        binding.level1Spell12.binding.spellPosition = 11
//        binding.level1Spell13.binding.viewModel = characterViewModel
//        binding.level1Spell13.binding.spellLevel = 0
//        binding.level1Spell13.binding.spellPosition = 12
//
//        binding.level2Spell1.binding.viewModel = characterViewModel
//        binding.level2Spell1.binding.spellLevel = 1
//        binding.level2Spell1.binding.spellPosition = 0
//        binding.level2Spell2.binding.viewModel = characterViewModel
//        binding.level2Spell2.binding.spellLevel = 1
//        binding.level2Spell2.binding.spellPosition = 1
//        binding.level2Spell3.binding.viewModel = characterViewModel
//        binding.level2Spell3.binding.spellLevel = 1
//        binding.level2Spell3.binding.spellPosition = 2
//        binding.level2Spell4.binding.viewModel = characterViewModel
//        binding.level2Spell4.binding.spellLevel = 1
//        binding.level2Spell4.binding.spellPosition = 3
//        binding.level2Spell5.binding.viewModel = characterViewModel
//        binding.level2Spell5.binding.spellLevel = 1
//        binding.level2Spell5.binding.spellPosition = 4
//        binding.level2Spell6.binding.viewModel = characterViewModel
//        binding.level2Spell6.binding.spellLevel = 1
//        binding.level2Spell6.binding.spellPosition = 5
//        binding.level2Spell7.binding.viewModel = characterViewModel
//        binding.level2Spell7.binding.spellLevel = 1
//        binding.level2Spell7.binding.spellPosition = 6
//        binding.level2Spell8.binding.viewModel = characterViewModel
//        binding.level2Spell8.binding.spellLevel = 1
//        binding.level2Spell8.binding.spellPosition = 7
//        binding.level2Spell9.binding.viewModel = characterViewModel
//        binding.level2Spell9.binding.spellLevel = 1
//        binding.level2Spell9.binding.spellPosition = 8
//        binding.level2Spell10.binding.viewModel = characterViewModel
//        binding.level2Spell10.binding.spellLevel = 1
//        binding.level2Spell10.binding.spellPosition = 9
//        binding.level2Spell11.binding.viewModel = characterViewModel
//        binding.level2Spell11.binding.spellLevel = 1
//        binding.level2Spell11.binding.spellPosition = 10
//        binding.level2Spell12.binding.viewModel = characterViewModel
//        binding.level2Spell12.binding.spellLevel = 1
//        binding.level2Spell12.binding.spellPosition = 11
//        binding.level2Spell13.binding.viewModel = characterViewModel
//        binding.level2Spell13.binding.spellLevel = 1
//        binding.level2Spell13.binding.spellPosition = 12
//
//        binding.level3Spell1.binding.viewModel = characterViewModel
//        binding.level3Spell1.binding.spellLevel = 2
//        binding.level3Spell1.binding.spellPosition = 0
//        binding.level3Spell2.binding.viewModel = characterViewModel
//        binding.level3Spell2.binding.spellLevel = 2
//        binding.level3Spell2.binding.spellPosition = 1
//        binding.level3Spell3.binding.viewModel = characterViewModel
//        binding.level3Spell3.binding.spellLevel = 2
//        binding.level3Spell3.binding.spellPosition = 2
//        binding.level3Spell4.binding.viewModel = characterViewModel
//        binding.level3Spell4.binding.spellLevel = 2
//        binding.level3Spell4.binding.spellPosition = 3
//        binding.level3Spell5.binding.viewModel = characterViewModel
//        binding.level3Spell5.binding.spellLevel = 2
//        binding.level3Spell5.binding.spellPosition = 4
//        binding.level3Spell6.binding.viewModel = characterViewModel
//        binding.level3Spell6.binding.spellLevel = 2
//        binding.level3Spell6.binding.spellPosition = 5
//        binding.level3Spell7.binding.viewModel = characterViewModel
//        binding.level3Spell7.binding.spellLevel = 2
//        binding.level3Spell7.binding.spellPosition = 6
//        binding.level3Spell8.binding.viewModel = characterViewModel
//        binding.level3Spell8.binding.spellLevel = 2
//        binding.level3Spell8.binding.spellPosition = 7
//        binding.level3Spell9.binding.viewModel = characterViewModel
//        binding.level3Spell9.binding.spellLevel = 2
//        binding.level3Spell9.binding.spellPosition = 8
//        binding.level3Spell10.binding.viewModel = characterViewModel
//        binding.level3Spell10.binding.spellLevel = 2
//        binding.level3Spell10.binding.spellPosition = 9
//        binding.level3Spell11.binding.viewModel = characterViewModel
//        binding.level3Spell11.binding.spellLevel = 2
//        binding.level3Spell11.binding.spellPosition = 10
//        binding.level3Spell12.binding.viewModel = characterViewModel
//        binding.level3Spell12.binding.spellLevel = 2
//        binding.level3Spell12.binding.spellPosition = 11
//        binding.level3Spell13.binding.viewModel = characterViewModel
//        binding.level3Spell13.binding.spellLevel = 2
//        binding.level3Spell13.binding.spellPosition = 12
//
//        binding.level4Spell1.binding.viewModel = characterViewModel
//        binding.level4Spell1.binding.spellLevel = 3
//        binding.level4Spell1.binding.spellPosition = 0
//        binding.level4Spell2.binding.viewModel = characterViewModel
//        binding.level4Spell2.binding.spellLevel = 3
//        binding.level4Spell2.binding.spellPosition = 1
//        binding.level4Spell3.binding.viewModel = characterViewModel
//        binding.level4Spell3.binding.spellLevel = 3
//        binding.level4Spell3.binding.spellPosition = 2
//        binding.level4Spell4.binding.viewModel = characterViewModel
//        binding.level4Spell4.binding.spellLevel = 3
//        binding.level4Spell4.binding.spellPosition = 3
//        binding.level4Spell5.binding.viewModel = characterViewModel
//        binding.level4Spell5.binding.spellLevel = 3
//        binding.level4Spell5.binding.spellPosition = 4
//        binding.level4Spell6.binding.viewModel = characterViewModel
//        binding.level4Spell6.binding.spellLevel = 3
//        binding.level4Spell6.binding.spellPosition = 5
//        binding.level4Spell7.binding.viewModel = characterViewModel
//        binding.level4Spell7.binding.spellLevel = 3
//        binding.level4Spell7.binding.spellPosition = 6
//        binding.level4Spell8.binding.viewModel = characterViewModel
//        binding.level4Spell8.binding.spellLevel = 3
//        binding.level4Spell8.binding.spellPosition = 7
//        binding.level4Spell9.binding.viewModel = characterViewModel
//        binding.level4Spell9.binding.spellLevel = 3
//        binding.level4Spell9.binding.spellPosition = 8
//        binding.level4Spell10.binding.viewModel = characterViewModel
//        binding.level4Spell10.binding.spellLevel = 3
//        binding.level4Spell10.binding.spellPosition = 9
//        binding.level4Spell11.binding.viewModel = characterViewModel
//        binding.level4Spell11.binding.spellLevel = 3
//        binding.level4Spell11.binding.spellPosition = 10
//        binding.level4Spell12.binding.viewModel = characterViewModel
//        binding.level4Spell12.binding.spellLevel = 2
//        binding.level4Spell12.binding.spellPosition = 11
//        binding.level4Spell13.binding.viewModel = characterViewModel
//        binding.level4Spell13.binding.spellLevel = 2
//        binding.level4Spell13.binding.spellPosition = 12
//
//        binding.level5Spell1.binding.viewModel = characterViewModel
//        binding.level5Spell1.binding.spellLevel = 4
//        binding.level5Spell1.binding.spellPosition = 0
//        binding.level5Spell2.binding.viewModel = characterViewModel
//        binding.level5Spell2.binding.spellLevel = 4
//        binding.level5Spell2.binding.spellPosition = 1
//        binding.level5Spell3.binding.viewModel = characterViewModel
//        binding.level5Spell3.binding.spellLevel = 4
//        binding.level5Spell3.binding.spellPosition = 2
//        binding.level5Spell4.binding.viewModel = characterViewModel
//        binding.level5Spell4.binding.spellLevel = 4
//        binding.level5Spell4.binding.spellPosition = 3
//        binding.level5Spell5.binding.viewModel = characterViewModel
//        binding.level5Spell5.binding.spellLevel = 4
//        binding.level5Spell5.binding.spellPosition = 4
//        binding.level5Spell6.binding.viewModel = characterViewModel
//        binding.level5Spell6.binding.spellLevel = 4
//        binding.level5Spell6.binding.spellPosition = 5
//        binding.level5Spell7.binding.viewModel = characterViewModel
//        binding.level5Spell7.binding.spellLevel = 4
//        binding.level5Spell7.binding.spellPosition = 6
//        binding.level5Spell8.binding.viewModel = characterViewModel
//        binding.level5Spell8.binding.spellLevel = 4
//        binding.level5Spell8.binding.spellPosition = 7
//        binding.level5Spell9.binding.viewModel = characterViewModel
//        binding.level5Spell9.binding.spellLevel = 4
//        binding.level5Spell9.binding.spellPosition = 8
//        binding.level5Spell10.binding.viewModel = characterViewModel
//        binding.level5Spell10.binding.spellLevel = 4
//        binding.level5Spell10.binding.spellPosition = 9
//        binding.level5Spell11.binding.viewModel = characterViewModel
//        binding.level5Spell11.binding.spellLevel = 4
//        binding.level5Spell11.binding.spellPosition = 10
//
//        binding.level6Spell1.binding.viewModel = characterViewModel
//        binding.level6Spell1.binding.spellLevel = 5
//        binding.level6Spell1.binding.spellPosition = 0
//        binding.level6Spell2.binding.viewModel = characterViewModel
//        binding.level6Spell2.binding.spellLevel = 5
//        binding.level6Spell2.binding.spellPosition = 1
//        binding.level6Spell3.binding.viewModel = characterViewModel
//        binding.level6Spell3.binding.spellLevel = 5
//        binding.level6Spell3.binding.spellPosition = 2
//        binding.level6Spell4.binding.viewModel = characterViewModel
//        binding.level6Spell4.binding.spellLevel = 5
//        binding.level6Spell4.binding.spellPosition = 3
//        binding.level6Spell5.binding.viewModel = characterViewModel
//        binding.level6Spell5.binding.spellLevel = 5
//        binding.level6Spell5.binding.spellPosition = 4
//        binding.level6Spell6.binding.viewModel = characterViewModel
//        binding.level6Spell6.binding.spellLevel = 5
//        binding.level6Spell6.binding.spellPosition = 5
//        binding.level6Spell7.binding.viewModel = characterViewModel
//        binding.level6Spell7.binding.spellLevel = 5
//        binding.level6Spell7.binding.spellPosition = 6
//        binding.level6Spell8.binding.viewModel = characterViewModel
//        binding.level6Spell8.binding.spellLevel = 5
//        binding.level6Spell8.binding.spellPosition = 7
//        binding.level6Spell9.binding.viewModel = characterViewModel
//        binding.level6Spell9.binding.spellLevel = 5
//        binding.level6Spell9.binding.spellPosition = 8
//        binding.level6Spell10.binding.viewModel = characterViewModel
//        binding.level6Spell10.binding.spellLevel = 5
//        binding.level6Spell10.binding.spellPosition = 9
//        binding.level6Spell11.binding.viewModel = characterViewModel
//        binding.level6Spell11.binding.spellLevel = 5
//        binding.level6Spell11.binding.spellPosition = 10
//
//        binding.level7Spell1.binding.viewModel = characterViewModel
//        binding.level7Spell1.binding.spellLevel = 6
//        binding.level7Spell1.binding.spellPosition = 0
//        binding.level7Spell2.binding.viewModel = characterViewModel
//        binding.level7Spell2.binding.spellLevel = 6
//        binding.level7Spell2.binding.spellPosition = 1
//        binding.level7Spell3.binding.viewModel = characterViewModel
//        binding.level7Spell3.binding.spellLevel = 6
//        binding.level7Spell3.binding.spellPosition = 2
//        binding.level7Spell4.binding.viewModel = characterViewModel
//        binding.level7Spell4.binding.spellLevel = 6
//        binding.level7Spell4.binding.spellPosition = 3
//        binding.level7Spell5.binding.viewModel = characterViewModel
//        binding.level7Spell5.binding.spellLevel = 6
//        binding.level7Spell5.binding.spellPosition = 4
//        binding.level7Spell6.binding.viewModel = characterViewModel
//        binding.level7Spell6.binding.spellLevel = 6
//        binding.level7Spell6.binding.spellPosition = 5
//        binding.level7Spell7.binding.viewModel = characterViewModel
//        binding.level7Spell7.binding.spellLevel = 6
//        binding.level7Spell7.binding.spellPosition = 6
//        binding.level7Spell8.binding.viewModel = characterViewModel
//        binding.level7Spell8.binding.spellLevel = 6
//        binding.level7Spell8.binding.spellPosition = 7
//        binding.level7Spell9.binding.viewModel = characterViewModel
//        binding.level7Spell9.binding.spellLevel = 6
//        binding.level7Spell9.binding.spellPosition = 8
//        binding.level7Spell10.binding.viewModel = characterViewModel
//        binding.level7Spell10.binding.spellLevel = 6
//        binding.level7Spell10.binding.spellPosition = 9
//        binding.level7Spell11.binding.viewModel = characterViewModel
//        binding.level7Spell11.binding.spellLevel = 6
//        binding.level7Spell11.binding.spellPosition = 10
//
//        binding.level8Spell1.binding.viewModel = characterViewModel
//        binding.level8Spell1.binding.spellLevel = 7
//        binding.level8Spell1.binding.spellPosition = 0
//        binding.level8Spell2.binding.viewModel = characterViewModel
//        binding.level8Spell2.binding.spellLevel = 7
//        binding.level8Spell2.binding.spellPosition = 1
//        binding.level8Spell3.binding.viewModel = characterViewModel
//        binding.level8Spell3.binding.spellLevel = 7
//        binding.level8Spell3.binding.spellPosition = 2
//        binding.level8Spell4.binding.viewModel = characterViewModel
//        binding.level8Spell4.binding.spellLevel = 7
//        binding.level8Spell4.binding.spellPosition = 3
//        binding.level8Spell5.binding.viewModel = characterViewModel
//        binding.level8Spell5.binding.spellLevel = 7
//        binding.level8Spell5.binding.spellPosition = 4
//        binding.level8Spell6.binding.viewModel = characterViewModel
//        binding.level8Spell6.binding.spellLevel = 7
//        binding.level8Spell6.binding.spellPosition = 5
//        binding.level8Spell7.binding.viewModel = characterViewModel
//        binding.level8Spell7.binding.spellLevel = 7
//        binding.level8Spell7.binding.spellPosition = 6
//        binding.level8Spell8.binding.viewModel = characterViewModel
//        binding.level8Spell8.binding.spellLevel = 7
//        binding.level8Spell8.binding.spellPosition = 7
//        binding.level8Spell9.binding.viewModel = characterViewModel
//        binding.level8Spell9.binding.spellLevel = 7
//        binding.level8Spell9.binding.spellPosition = 8
//
//        binding.level9Spell1.binding.viewModel = characterViewModel
//        binding.level9Spell1.binding.spellLevel = 8
//        binding.level9Spell1.binding.spellPosition = 0
//        binding.level9Spell2.binding.viewModel = characterViewModel
//        binding.level9Spell2.binding.spellLevel = 8
//        binding.level9Spell2.binding.spellPosition = 1
//        binding.level9Spell3.binding.viewModel = characterViewModel
//        binding.level9Spell3.binding.spellLevel = 8
//        binding.level9Spell3.binding.spellPosition = 2
//        binding.level9Spell4.binding.viewModel = characterViewModel
//        binding.level9Spell4.binding.spellLevel = 8
//        binding.level9Spell4.binding.spellPosition = 3
//        binding.level9Spell5.binding.viewModel = characterViewModel
//        binding.level9Spell5.binding.spellLevel = 8
//        binding.level9Spell5.binding.spellPosition = 4
//        binding.level9Spell6.binding.viewModel = characterViewModel
//        binding.level9Spell6.binding.spellLevel = 8
//        binding.level9Spell6.binding.spellPosition = 5
//        binding.level9Spell7.binding.viewModel = characterViewModel
//        binding.level9Spell7.binding.spellLevel = 8
//        binding.level9Spell7.binding.spellPosition = 6
//        binding.level9Spell8.binding.viewModel = characterViewModel
//        binding.level9Spell8.binding.spellLevel = 8
//        binding.level9Spell8.binding.spellPosition = 7
//        binding.level9Spell9.binding.viewModel = characterViewModel
//        binding.level9Spell9.binding.spellLevel = 8
//        binding.level9Spell9.binding.spellPosition = 8
//    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
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
}