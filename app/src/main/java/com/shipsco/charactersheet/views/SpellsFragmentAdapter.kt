package com.shipsco.charactersheet.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shipsco.charactersheet.CharacterViewModel
import com.shipsco.charactersheet.ManualEditListener
import com.shipsco.charactersheet.databinding.*

class SpellsFragmentAdapter(val viewModel: CharacterViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    ManualEditListener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_SPELL_CLASS -> {
                val binding = LayoutSpellsClassTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.viewModel = viewModel
                return SpellClassViewHolder(binding)
            }
            TYPE_CLASS_INFO -> {
                val binding = LayoutSpellsClassInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.viewModel = viewModel
                return ClassInfoViewHolder(binding)
            }
            TYPE_CANTRIPS -> {
                val binding = LayoutSpellsCantripsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.cantrip1.binding.viewModel = viewModel
//                binding.cantrip1.binding.position =  0
//                binding.cantrip2.binding.viewModel = viewModel
//                binding.cantrip2.binding.position =  1
//                binding.cantrip3.binding.viewModel = viewModel
//                binding.cantrip3.binding.position =  2
//                binding.cantrip4.binding.viewModel = viewModel
//                binding.cantrip4.binding.position =  3
//                binding.cantrip5.binding.viewModel = viewModel
//                binding.cantrip5.binding.position =  4
//                binding.cantrip6.binding.viewModel = viewModel
//                binding.cantrip6.binding.position =  5
//                binding.cantrip7.binding.viewModel = viewModel
//                binding.cantrip7.binding.position =  6
//                binding.cantrip8.binding.viewModel = viewModel
//                binding.cantrip8.binding.position =  7
                return CantripsViewHolder(binding)
            }
            TYPE_LEVEL_ONE -> {
                val binding = LayoutSpellsLevelOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level1Spell1.binding.viewModel = viewModel
//                binding.level1Spell1.binding.spellLevel = 0
//                binding.level1Spell1.binding.spellPosition = 0
//                binding.level1Spell2.binding.viewModel = viewModel
//                binding.level1Spell2.binding.spellLevel = 0
//                binding.level1Spell2.binding.spellPosition = 1
//                binding.level1Spell3.binding.viewModel = viewModel
//                binding.level1Spell3.binding.spellLevel = 0
//                binding.level1Spell3.binding.spellPosition = 2
//                binding.level1Spell4.binding.viewModel = viewModel
//                binding.level1Spell4.binding.spellLevel = 0
//                binding.level1Spell4.binding.spellPosition = 3
//                binding.level1Spell5.binding.viewModel = viewModel
//                binding.level1Spell5.binding.spellLevel = 0
//                binding.level1Spell5.binding.spellPosition = 4
//                binding.level1Spell6.binding.viewModel = viewModel
//                binding.level1Spell6.binding.spellLevel = 0
//                binding.level1Spell6.binding.spellPosition = 5
//                binding.level1Spell7.binding.viewModel = viewModel
//                binding.level1Spell7.binding.spellLevel = 0
//                binding.level1Spell7.binding.spellPosition = 6
//                binding.level1Spell8.binding.viewModel = viewModel
//                binding.level1Spell8.binding.spellLevel = 0
//                binding.level1Spell8.binding.spellPosition = 7
//                binding.level1Spell9.binding.viewModel = viewModel
//                binding.level1Spell9.binding.spellLevel = 0
//                binding.level1Spell9.binding.spellPosition = 8
//                binding.level1Spell10.binding.viewModel = viewModel
//                binding.level1Spell10.binding.spellLevel = 0
//                binding.level1Spell10.binding.spellPosition = 9
//                binding.level1Spell11.binding.viewModel = viewModel
//                binding.level1Spell11.binding.spellLevel = 0
//                binding.level1Spell11.binding.spellPosition = 10
//                binding.level1Spell12.binding.viewModel = viewModel
//                binding.level1Spell12.binding.spellLevel = 0
//                binding.level1Spell12.binding.spellPosition = 11
//                binding.level1Spell13.binding.viewModel = viewModel
//                binding.level1Spell13.binding.spellLevel = 0
//                binding.level1Spell13.binding.spellPosition = 12
                return LevelOneSpellsViewHolder(binding)
            }
            TYPE_LEVEL_TWO -> {
                val binding = LayoutSpellsLevelTwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level2Spell1.binding.viewModel = viewModel
//                binding.level2Spell1.binding.spellLevel = 1
//                binding.level2Spell1.binding.spellPosition = 0
//                binding.level2Spell2.binding.viewModel = viewModel
//                binding.level2Spell2.binding.spellLevel = 1
//                binding.level2Spell2.binding.spellPosition = 1
//                binding.level2Spell3.binding.viewModel = viewModel
//                binding.level2Spell3.binding.spellLevel = 1
//                binding.level2Spell3.binding.spellPosition = 2
//                binding.level2Spell4.binding.viewModel = viewModel
//                binding.level2Spell4.binding.spellLevel = 1
//                binding.level2Spell4.binding.spellPosition = 3
//                binding.level2Spell5.binding.viewModel = viewModel
//                binding.level2Spell5.binding.spellLevel = 1
//                binding.level2Spell5.binding.spellPosition = 4
//                binding.level2Spell6.binding.viewModel = viewModel
//                binding.level2Spell6.binding.spellLevel = 1
//                binding.level2Spell6.binding.spellPosition = 5
//                binding.level2Spell7.binding.viewModel = viewModel
//                binding.level2Spell7.binding.spellLevel = 1
//                binding.level2Spell7.binding.spellPosition = 6
//                binding.level2Spell8.binding.viewModel = viewModel
//                binding.level2Spell8.binding.spellLevel = 1
//                binding.level2Spell8.binding.spellPosition = 7
//                binding.level2Spell9.binding.viewModel = viewModel
//                binding.level2Spell9.binding.spellLevel = 1
//                binding.level2Spell9.binding.spellPosition = 8
//                binding.level2Spell10.binding.viewModel = viewModel
//                binding.level2Spell10.binding.spellLevel = 1
//                binding.level2Spell10.binding.spellPosition = 9
//                binding.level2Spell11.binding.viewModel = viewModel
//                binding.level2Spell11.binding.spellLevel = 1
//                binding.level2Spell11.binding.spellPosition = 10
//                binding.level2Spell12.binding.viewModel = viewModel
//                binding.level2Spell12.binding.spellLevel = 1
//                binding.level2Spell12.binding.spellPosition = 11
//                binding.level2Spell13.binding.viewModel = viewModel
//                binding.level2Spell13.binding.spellLevel = 1
//                binding.level2Spell13.binding.spellPosition = 12
                return LevelTwoSpellsViewHolder(binding)
            }
            TYPE_LEVEL_THREE -> {
                val binding = LayoutSpellsLevelThreeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level3Spell1.binding.viewModel = viewModel
//                binding.level3Spell1.binding.spellLevel = 2
//                binding.level3Spell1.binding.spellPosition = 0
//                binding.level3Spell2.binding.viewModel = viewModel
//                binding.level3Spell2.binding.spellLevel = 2
//                binding.level3Spell2.binding.spellPosition = 1
//                binding.level3Spell3.binding.viewModel = viewModel
//                binding.level3Spell3.binding.spellLevel = 2
//                binding.level3Spell3.binding.spellPosition = 2
//                binding.level3Spell4.binding.viewModel = viewModel
//                binding.level3Spell4.binding.spellLevel = 2
//                binding.level3Spell4.binding.spellPosition = 3
//                binding.level3Spell5.binding.viewModel = viewModel
//                binding.level3Spell5.binding.spellLevel = 2
//                binding.level3Spell5.binding.spellPosition = 4
//                binding.level3Spell6.binding.viewModel = viewModel
//                binding.level3Spell6.binding.spellLevel = 2
//                binding.level3Spell6.binding.spellPosition = 5
//                binding.level3Spell7.binding.viewModel = viewModel
//                binding.level3Spell7.binding.spellLevel = 2
//                binding.level3Spell7.binding.spellPosition = 6
//                binding.level3Spell8.binding.viewModel = viewModel
//                binding.level3Spell8.binding.spellLevel = 2
//                binding.level3Spell8.binding.spellPosition = 7
//                binding.level3Spell9.binding.viewModel = viewModel
//                binding.level3Spell9.binding.spellLevel = 2
//                binding.level3Spell9.binding.spellPosition = 8
//                binding.level3Spell10.binding.viewModel = viewModel
//                binding.level3Spell10.binding.spellLevel = 2
//                binding.level3Spell10.binding.spellPosition = 9
//                binding.level3Spell11.binding.viewModel = viewModel
//                binding.level3Spell11.binding.spellLevel = 2
//                binding.level3Spell11.binding.spellPosition = 10
//                binding.level3Spell12.binding.viewModel = viewModel
//                binding.level3Spell12.binding.spellLevel = 2
//                binding.level3Spell12.binding.spellPosition = 11
//                binding.level3Spell13.binding.viewModel = viewModel
//                binding.level3Spell13.binding.spellLevel = 2
//                binding.level3Spell13.binding.spellPosition = 12
                return LevelThreeSpellsViewHolder(binding)
            }
            TYPE_LEVEL_FOUR -> {
                val binding = LayoutSpellsLevelFourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level4Spell1.binding.viewModel = viewModel
//                binding.level4Spell1.binding.spellLevel = 3
//                binding.level4Spell1.binding.spellPosition = 0
//                binding.level4Spell2.binding.viewModel = viewModel
//                binding.level4Spell2.binding.spellLevel = 3
//                binding.level4Spell2.binding.spellPosition = 1
//                binding.level4Spell3.binding.viewModel = viewModel
//                binding.level4Spell3.binding.spellLevel = 3
//                binding.level4Spell3.binding.spellPosition = 2
//                binding.level4Spell4.binding.viewModel = viewModel
//                binding.level4Spell4.binding.spellLevel = 3
//                binding.level4Spell4.binding.spellPosition = 3
//                binding.level4Spell5.binding.viewModel = viewModel
//                binding.level4Spell5.binding.spellLevel = 3
//                binding.level4Spell5.binding.spellPosition = 4
//                binding.level4Spell6.binding.viewModel = viewModel
//                binding.level4Spell6.binding.spellLevel = 3
//                binding.level4Spell6.binding.spellPosition = 5
//                binding.level4Spell7.binding.viewModel = viewModel
//                binding.level4Spell7.binding.spellLevel = 3
//                binding.level4Spell7.binding.spellPosition = 6
//                binding.level4Spell8.binding.viewModel = viewModel
//                binding.level4Spell8.binding.spellLevel = 3
//                binding.level4Spell8.binding.spellPosition = 7
//                binding.level4Spell9.binding.viewModel = viewModel
//                binding.level4Spell9.binding.spellLevel = 3
//                binding.level4Spell9.binding.spellPosition = 8
//                binding.level4Spell10.binding.viewModel = viewModel
//                binding.level4Spell10.binding.spellLevel = 3
//                binding.level4Spell10.binding.spellPosition = 9
//                binding.level4Spell11.binding.viewModel = viewModel
//                binding.level4Spell11.binding.spellLevel = 3
//                binding.level4Spell11.binding.spellPosition = 10
//                binding.level4Spell12.binding.viewModel = viewModel
//                binding.level4Spell12.binding.spellLevel = 2
//                binding.level4Spell12.binding.spellPosition = 11
//                binding.level4Spell13.binding.viewModel = viewModel
//                binding.level4Spell13.binding.spellLevel = 2
//                binding.level4Spell13.binding.spellPosition = 12
                return LevelFourSpellsViewHolder(binding)
            }
            TYPE_LEVEL_FIVE -> {
                val binding = LayoutSpellsLevelFiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level5Spell1.binding.viewModel = viewModel
//                binding.level5Spell1.binding.spellLevel = 4
//                binding.level5Spell1.binding.spellPosition = 0
//                binding.level5Spell2.binding.viewModel = viewModel
//                binding.level5Spell2.binding.spellLevel = 4
//                binding.level5Spell2.binding.spellPosition = 1
//                binding.level5Spell3.binding.viewModel = viewModel
//                binding.level5Spell3.binding.spellLevel = 4
//                binding.level5Spell3.binding.spellPosition = 2
//                binding.level5Spell4.binding.viewModel = viewModel
//                binding.level5Spell4.binding.spellLevel = 4
//                binding.level5Spell4.binding.spellPosition = 3
//                binding.level5Spell5.binding.viewModel = viewModel
//                binding.level5Spell5.binding.spellLevel = 4
//                binding.level5Spell5.binding.spellPosition = 4
//                binding.level5Spell6.binding.viewModel = viewModel
//                binding.level5Spell6.binding.spellLevel = 4
//                binding.level5Spell6.binding.spellPosition = 5
//                binding.level5Spell7.binding.viewModel = viewModel
//                binding.level5Spell7.binding.spellLevel = 4
//                binding.level5Spell7.binding.spellPosition = 6
//                binding.level5Spell8.binding.viewModel = viewModel
//                binding.level5Spell8.binding.spellLevel = 4
//                binding.level5Spell8.binding.spellPosition = 7
//                binding.level5Spell9.binding.viewModel = viewModel
//                binding.level5Spell9.binding.spellLevel = 4
//                binding.level5Spell9.binding.spellPosition = 8
//                binding.level5Spell10.binding.viewModel = viewModel
//                binding.level5Spell10.binding.spellLevel = 4
//                binding.level5Spell10.binding.spellPosition = 9
//                binding.level5Spell11.binding.viewModel = viewModel
//                binding.level5Spell11.binding.spellLevel = 4
//                binding.level5Spell11.binding.spellPosition = 10
                return LevelFiveSpellsViewHolder(binding)
            }
            TYPE_LEVEL_SIX -> {
                val binding = LayoutSpellsLevelSixBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level6Spell1.binding.viewModel = viewModel
//                binding.level6Spell1.binding.spellLevel = 5
//                binding.level6Spell1.binding.spellPosition = 0
//                binding.level6Spell2.binding.viewModel = viewModel
//                binding.level6Spell2.binding.spellLevel = 5
//                binding.level6Spell2.binding.spellPosition = 1
//                binding.level6Spell3.binding.viewModel = viewModel
//                binding.level6Spell3.binding.spellLevel = 5
//                binding.level6Spell3.binding.spellPosition = 2
//                binding.level6Spell4.binding.viewModel = viewModel
//                binding.level6Spell4.binding.spellLevel = 5
//                binding.level6Spell4.binding.spellPosition = 3
//                binding.level6Spell5.binding.viewModel = viewModel
//                binding.level6Spell5.binding.spellLevel = 5
//                binding.level6Spell5.binding.spellPosition = 4
//                binding.level6Spell6.binding.viewModel = viewModel
//                binding.level6Spell6.binding.spellLevel = 5
//                binding.level6Spell6.binding.spellPosition = 5
//                binding.level6Spell7.binding.viewModel = viewModel
//                binding.level6Spell7.binding.spellLevel = 5
//                binding.level6Spell7.binding.spellPosition = 6
//                binding.level6Spell8.binding.viewModel = viewModel
//                binding.level6Spell8.binding.spellLevel = 5
//                binding.level6Spell8.binding.spellPosition = 7
//                binding.level6Spell9.binding.viewModel = viewModel
//                binding.level6Spell9.binding.spellLevel = 5
//                binding.level6Spell9.binding.spellPosition = 8
//                binding.level6Spell10.binding.viewModel = viewModel
//                binding.level6Spell10.binding.spellLevel = 5
//                binding.level6Spell10.binding.spellPosition = 9
//                binding.level6Spell11.binding.viewModel = viewModel
//                binding.level6Spell11.binding.spellLevel = 5
//                binding.level6Spell11.binding.spellPosition = 10
                return LevelSixSpellsViewHolder(binding)
            }
            TYPE_LEVEL_SEVEN -> {
                val binding = LayoutSpellsLevelSevenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level7Spell1.binding.viewModel = viewModel
//                binding.level7Spell1.binding.spellLevel = 6
//                binding.level7Spell1.binding.spellPosition = 0
//                binding.level7Spell2.binding.viewModel = viewModel
//                binding.level7Spell2.binding.spellLevel = 6
//                binding.level7Spell2.binding.spellPosition = 1
//                binding.level7Spell3.binding.viewModel = viewModel
//                binding.level7Spell3.binding.spellLevel = 6
//                binding.level7Spell3.binding.spellPosition = 2
//                binding.level7Spell4.binding.viewModel = viewModel
//                binding.level7Spell4.binding.spellLevel = 6
//                binding.level7Spell4.binding.spellPosition = 3
//                binding.level7Spell5.binding.viewModel = viewModel
//                binding.level7Spell5.binding.spellLevel = 6
//                binding.level7Spell5.binding.spellPosition = 4
//                binding.level7Spell6.binding.viewModel = viewModel
//                binding.level7Spell6.binding.spellLevel = 6
//                binding.level7Spell6.binding.spellPosition = 5
//                binding.level7Spell7.binding.viewModel = viewModel
//                binding.level7Spell7.binding.spellLevel = 6
//                binding.level7Spell7.binding.spellPosition = 6
//                binding.level7Spell8.binding.viewModel = viewModel
//                binding.level7Spell8.binding.spellLevel = 6
//                binding.level7Spell8.binding.spellPosition = 7
//                binding.level7Spell9.binding.viewModel = viewModel
//                binding.level7Spell9.binding.spellLevel = 6
//                binding.level7Spell9.binding.spellPosition = 8
//                binding.level7Spell10.binding.viewModel = viewModel
//                binding.level7Spell10.binding.spellLevel = 6
//                binding.level7Spell10.binding.spellPosition = 9
//                binding.level7Spell11.binding.viewModel = viewModel
//                binding.level7Spell11.binding.spellLevel = 6
//                binding.level7Spell11.binding.spellPosition = 10
                return LevelSevenSpellsViewHolder(binding)
            }
            TYPE_LEVEL_EIGHT -> {
                val binding = LayoutSpellsLevelEightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level8Spell1.binding.viewModel = viewModel
//                binding.level8Spell1.binding.spellLevel = 7
//                binding.level8Spell1.binding.spellPosition = 0
//                binding.level8Spell2.binding.viewModel = viewModel
//                binding.level8Spell2.binding.spellLevel = 7
//                binding.level8Spell2.binding.spellPosition = 1
//                binding.level8Spell3.binding.viewModel = viewModel
//                binding.level8Spell3.binding.spellLevel = 7
//                binding.level8Spell3.binding.spellPosition = 2
//                binding.level8Spell4.binding.viewModel = viewModel
//                binding.level8Spell4.binding.spellLevel = 7
//                binding.level8Spell4.binding.spellPosition = 3
//                binding.level8Spell5.binding.viewModel = viewModel
//                binding.level8Spell5.binding.spellLevel = 7
//                binding.level8Spell5.binding.spellPosition = 4
//                binding.level8Spell6.binding.viewModel = viewModel
//                binding.level8Spell6.binding.spellLevel = 7
//                binding.level8Spell6.binding.spellPosition = 5
//                binding.level8Spell7.binding.viewModel = viewModel
//                binding.level8Spell7.binding.spellLevel = 7
//                binding.level8Spell7.binding.spellPosition = 6
//                binding.level8Spell8.binding.viewModel = viewModel
//                binding.level8Spell8.binding.spellLevel = 7
//                binding.level8Spell8.binding.spellPosition = 7
//                binding.level8Spell9.binding.viewModel = viewModel
//                binding.level8Spell9.binding.spellLevel = 7
//                binding.level8Spell9.binding.spellPosition = 8
                return LevelEightSpellsViewHolder(binding)
            }
            else -> {
                val binding = LayoutSpellsLevelNineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.level9Spell1.binding.viewModel = viewModel
//                binding.level9Spell1.binding.spellLevel = 8
//                binding.level9Spell1.binding.spellPosition = 0
//                binding.level9Spell2.binding.viewModel = viewModel
//                binding.level9Spell2.binding.spellLevel = 8
//                binding.level9Spell2.binding.spellPosition = 1
//                binding.level9Spell3.binding.viewModel = viewModel
//                binding.level9Spell3.binding.spellLevel = 8
//                binding.level9Spell3.binding.spellPosition = 2
//                binding.level9Spell4.binding.viewModel = viewModel
//                binding.level9Spell4.binding.spellLevel = 8
//                binding.level9Spell4.binding.spellPosition = 3
//                binding.level9Spell5.binding.viewModel = viewModel
//                binding.level9Spell5.binding.spellLevel = 8
//                binding.level9Spell5.binding.spellPosition = 4
//                binding.level9Spell6.binding.viewModel = viewModel
//                binding.level9Spell6.binding.spellLevel = 8
//                binding.level9Spell6.binding.spellPosition = 5
//                binding.level9Spell7.binding.viewModel = viewModel
//                binding.level9Spell7.binding.spellLevel = 8
//                binding.level9Spell7.binding.spellPosition = 6
//                binding.level9Spell8.binding.viewModel = viewModel
//                binding.level9Spell8.binding.spellLevel = 8
//                binding.level9Spell8.binding.spellPosition = 7
//                binding.level9Spell9.binding.viewModel = viewModel
//                binding.level9Spell9.binding.spellLevel = 8
//                binding.level9Spell9.binding.spellPosition = 8
                return LevelNineSpellsViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_SPELL_CLASS -> {
                (holder as SpellClassViewHolder).bind(viewModel)
            }
            TYPE_CLASS_INFO -> {
                (holder as ClassInfoViewHolder).bind(viewModel)
            }
            TYPE_CANTRIPS -> {
                (holder as CantripsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_ONE -> {
                (holder as LevelOneSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_TWO -> {
                (holder as LevelTwoSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_THREE -> {
                (holder as LevelThreeSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_FOUR -> {
                (holder as LevelFourSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_FIVE -> {
                (holder as LevelFiveSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_SIX -> {
                (holder as LevelSixSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_SEVEN -> {
                (holder as LevelSevenSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_EIGHT -> {
                (holder as LevelEightSpellsViewHolder).bind(viewModel)
            }
            TYPE_LEVEL_NINE -> {
                (holder as LevelNineSpellsViewHolder).bind(viewModel)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position + 1
    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun manualEditCompleted(view: View) {
        viewModel.saveCurrentCharacter()
    }

    companion object {
        const val TYPE_SPELL_CLASS = 1
        const val TYPE_CLASS_INFO = 2
        const val TYPE_CANTRIPS = 3
        const val TYPE_LEVEL_ONE = 4
        const val TYPE_LEVEL_TWO = 5
        const val TYPE_LEVEL_THREE = 6
        const val TYPE_LEVEL_FOUR = 7
        const val TYPE_LEVEL_FIVE = 8
        const val TYPE_LEVEL_SIX = 9
        const val TYPE_LEVEL_SEVEN = 10
        const val TYPE_LEVEL_EIGHT = 11
        const val TYPE_LEVEL_NINE = 12
    }
}

class SpellClassViewHolder(val binding: LayoutSpellsClassTypeBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.spellcastingClass.text = viewModel.currentCharacter.value?.spellCastingClass
        binding.spellcastingClass.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.spellcastingClass.eventListener = viewModel
    }
}

class ClassInfoViewHolder(val binding: LayoutSpellsClassInfoBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.spellcastingAbility.text = viewModel.currentCharacter.value?.spellCastingAbility
        binding.spellcastingAbility.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.spellcastingAbility.eventListener = viewModel
        binding.spellBonus.text = viewModel.currentCharacter.value?.spellAttackBonus
        binding.spellBonus.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.spellBonus.eventListener = viewModel
        binding.spellSaveDC.text = viewModel.currentCharacter.value?.spellSaveDC
        binding.spellSaveDC.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.spellSaveDC.eventListener = viewModel
    }
}

class CantripsViewHolder(val binding: LayoutSpellsCantripsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.cantrip1.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(0) ?: ""
        binding.cantrip1.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip1.binding.cantripName.eventListener = viewModel
        binding.cantrip1.binding.cantripName.tag = "Cantrip1"
        binding.cantrip2.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(1) ?: ""
        binding.cantrip2.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip2.binding.cantripName.eventListener = viewModel
        binding.cantrip2.binding.cantripName.tag = "Cantrip2"
        binding.cantrip3.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(2) ?: ""
        binding.cantrip3.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip3.binding.cantripName.eventListener = viewModel
        binding.cantrip3.binding.cantripName.tag = "Cantrip3"
        binding.cantrip4.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(3) ?: ""
        binding.cantrip4.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip4.binding.cantripName.eventListener = viewModel
        binding.cantrip4.binding.cantripName.tag = "Cantrip4"
        binding.cantrip5.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(4) ?: ""
        binding.cantrip5.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip5.binding.cantripName.eventListener = viewModel
        binding.cantrip5.binding.cantripName.tag = "Cantrip5"
        binding.cantrip6.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(5) ?: ""
        binding.cantrip6.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip6.binding.cantripName.eventListener = viewModel
        binding.cantrip6.binding.cantripName.tag = "Cantrip6"
        binding.cantrip7.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(6) ?: ""
        binding.cantrip7.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip7.binding.cantripName.eventListener = viewModel
        binding.cantrip7.binding.cantripName.tag = "Cantrip7"
        binding.cantrip8.binding.cantripName.text =
            viewModel.currentCharacter.value?.cantrips?.get(7) ?: ""
        binding.cantrip8.binding.cantripName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.cantrip8.binding.cantripName.eventListener = viewModel
        binding.cantrip8.binding.cantripName.tag = "Cantrip8"
    }
}

class LevelOneSpellsViewHolder(val binding: LayoutSpellsLevelOneBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level1SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.totalSpellSlots ?: ""
        binding.level1SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1SlotsTotal.eventListener = viewModel
        binding.level1SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellSlotsExpended ?: ""
        binding.level1SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1SlotsExpended.eventListener = viewModel
        binding.level1Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(0) ?: ""
        binding.level1Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell1.binding.spellName.eventListener = viewModel
        binding.level1Spell1.binding.spellName.tag = "SpellName1-1"
        binding.level1Spell1.binding.spellButton.isChecked = 
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell1.binding.spellButton.eventListener = viewModel
        binding.level1Spell1.binding.spellButton.tag = "SpellButton1-1"
        binding.level1Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(1) ?: ""
        binding.level1Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell2.binding.spellName.eventListener = viewModel
        binding.level1Spell2.binding.spellName.tag = "SpellName1-2"
        binding.level1Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell2.binding.spellButton.eventListener = viewModel
        binding.level1Spell2.binding.spellButton.tag = "SpellButton1-2"
        binding.level1Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(2) ?: ""
        binding.level1Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell3.binding.spellName.eventListener = viewModel
        binding.level1Spell3.binding.spellName.tag = "SpellName1-3"
        binding.level1Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell3.binding.spellButton.eventListener = viewModel
        binding.level1Spell3.binding.spellButton.tag = "SpellButton1-3"
        binding.level1Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(3) ?: ""
        binding.level1Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell4.binding.spellName.eventListener = viewModel
        binding.level1Spell4.binding.spellName.tag = "SpellName1-4"
        binding.level1Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell4.binding.spellButton.eventListener = viewModel
        binding.level1Spell4.binding.spellButton.tag = "SpellButton1-4"
        binding.level1Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(4) ?: ""
        binding.level1Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell5.binding.spellName.eventListener = viewModel
        binding.level1Spell5.binding.spellName.tag = "SpellName1-5"
        binding.level1Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell5.binding.spellButton.eventListener = viewModel
        binding.level1Spell5.binding.spellButton.tag = "SpellButton1-5"
        binding.level1Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(5) ?: ""
        binding.level1Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell6.binding.spellName.eventListener = viewModel
        binding.level1Spell6.binding.spellName.tag = "SpellName1-6"
        binding.level1Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell6.binding.spellButton.eventListener = viewModel
        binding.level1Spell6.binding.spellButton.tag = "SpellButton1-6"
        binding.level1Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(6) ?: ""
        binding.level1Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell7.binding.spellName.eventListener = viewModel
        binding.level1Spell7.binding.spellName.tag = "SpellName1-7"
        binding.level1Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell7.binding.spellButton.eventListener = viewModel
        binding.level1Spell7.binding.spellButton.tag = "SpellButton1-7"
        binding.level1Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(7) ?: ""
        binding.level1Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell8.binding.spellName.eventListener = viewModel
        binding.level1Spell8.binding.spellName.tag = "SpellName1-8"
        binding.level1Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell8.binding.spellButton.eventListener = viewModel
        binding.level1Spell8.binding.spellButton.tag = "SpellButton1-8"
        binding.level1Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(8) ?: ""
        binding.level1Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell9.binding.spellName.eventListener = viewModel
        binding.level1Spell9.binding.spellName.tag = "SpellName1-9"
        binding.level1Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell9.binding.spellButton.eventListener = viewModel
        binding.level1Spell9.binding.spellButton.tag = "SpellButton1-9"
        binding.level1Spell10.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(9) ?: ""
        binding.level1Spell10.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell10.binding.spellName.eventListener = viewModel
        binding.level1Spell10.binding.spellName.tag = "SpellName1-10"
        binding.level1Spell10.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell10.binding.spellButton.eventListener = viewModel
        binding.level1Spell10.binding.spellButton.tag = "SpellButton1-10"
        binding.level1Spell11.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(10) ?: ""
        binding.level1Spell11.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell11.binding.spellName.eventListener = viewModel
        binding.level1Spell11.binding.spellName.tag = "SpellName1-11"
        binding.level1Spell11.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell11.binding.spellButton.eventListener = viewModel
        binding.level1Spell11.binding.spellButton.tag = "SpellButton1-11"
        binding.level1Spell12.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(11) ?: ""
        binding.level1Spell12.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell12.binding.spellName.eventListener = viewModel
        binding.level1Spell12.binding.spellName.tag = "SpellName1-12"
        binding.level1Spell12.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell12.binding.spellButton.eventListener = viewModel
        binding.level1Spell12.binding.spellButton.tag = "SpellButton1-12"
        binding.level1Spell13.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellName?.get(12) ?: ""
        binding.level1Spell13.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level1Spell13.binding.spellName.eventListener = viewModel
        binding.level1Spell13.binding.spellName.tag = "SpellName1-13"
        binding.level1Spell13.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(0)?.spellChecked?.get(0) ?: false
        binding.level1Spell13.binding.spellButton.eventListener = viewModel
        binding.level1Spell13.binding.spellButton.tag = "SpellButton1-13"
    }
}

class LevelTwoSpellsViewHolder(val binding: LayoutSpellsLevelTwoBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level2SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.totalSpellSlots ?: ""
        binding.level2SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2SlotsTotal.eventListener = viewModel
        binding.level2SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellSlotsExpended ?: ""
        binding.level2SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2SlotsExpended.eventListener = viewModel
        binding.level2Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(0) ?: ""
        binding.level2Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell1.binding.spellName.eventListener = viewModel
        binding.level2Spell1.binding.spellName.tag = "SpellName2-1"
        binding.level2Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell1.binding.spellButton.eventListener = viewModel
        binding.level2Spell1.binding.spellButton.tag = "SpellButton2-1"
        binding.level2Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(1) ?: ""
        binding.level2Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell2.binding.spellName.eventListener = viewModel
        binding.level2Spell2.binding.spellName.tag = "SpellName2-2"
        binding.level2Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell2.binding.spellButton.eventListener = viewModel
        binding.level2Spell2.binding.spellButton.tag = "SpellButton2-2"
        binding.level2Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(2) ?: ""
        binding.level2Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell3.binding.spellName.eventListener = viewModel
        binding.level2Spell3.binding.spellName.tag = "SpellName2-3"
        binding.level2Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell3.binding.spellButton.eventListener = viewModel
        binding.level2Spell3.binding.spellButton.tag = "SpellButton2-3"
        binding.level2Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(3) ?: ""
        binding.level2Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell4.binding.spellName.eventListener = viewModel
        binding.level2Spell4.binding.spellName.tag = "SpellName2-4"
        binding.level2Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell4.binding.spellButton.eventListener = viewModel
        binding.level2Spell4.binding.spellButton.tag = "SpellButton2-4"
        binding.level2Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(4) ?: ""
        binding.level2Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell5.binding.spellName.eventListener = viewModel
        binding.level2Spell5.binding.spellName.tag = "SpellName2-5"
        binding.level2Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell5.binding.spellButton.eventListener = viewModel
        binding.level2Spell5.binding.spellButton.tag = "SpellButton2-5"
        binding.level2Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(5) ?: ""
        binding.level2Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell6.binding.spellName.eventListener = viewModel
        binding.level2Spell6.binding.spellName.tag = "SpellName2-6"
        binding.level2Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell6.binding.spellButton.eventListener = viewModel
        binding.level2Spell6.binding.spellButton.tag = "SpellButton2-6"
        binding.level2Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(6) ?: ""
        binding.level2Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell7.binding.spellName.eventListener = viewModel
        binding.level2Spell7.binding.spellName.tag = "SpellName2-7"
        binding.level2Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell7.binding.spellButton.eventListener = viewModel
        binding.level2Spell7.binding.spellButton.tag = "SpellButton2-7"
        binding.level2Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(7) ?: ""
        binding.level2Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell8.binding.spellName.eventListener = viewModel
        binding.level2Spell8.binding.spellName.tag = "SpellName2-8"
        binding.level2Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell8.binding.spellButton.eventListener = viewModel
        binding.level2Spell8.binding.spellButton.tag = "SpellButton2-8"
        binding.level2Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(8) ?: ""
        binding.level2Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell9.binding.spellName.eventListener = viewModel
        binding.level2Spell9.binding.spellName.tag = "SpellName2-9"
        binding.level2Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell9.binding.spellButton.eventListener = viewModel
        binding.level2Spell9.binding.spellButton.tag = "SpellButton2-9"
        binding.level2Spell10.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(9) ?: ""
        binding.level2Spell10.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell10.binding.spellName.eventListener = viewModel
        binding.level2Spell10.binding.spellName.tag = "SpellName2-10"
        binding.level2Spell10.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell10.binding.spellButton.eventListener = viewModel
        binding.level2Spell10.binding.spellButton.tag = "SpellButton2-10"
        binding.level2Spell11.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(10) ?: ""
        binding.level2Spell11.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell11.binding.spellName.eventListener = viewModel
        binding.level2Spell11.binding.spellName.tag = "SpellName2-11"
        binding.level2Spell11.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell11.binding.spellButton.eventListener = viewModel
        binding.level2Spell12.binding.spellButton.tag = "SpellButton2-11"
        binding.level2Spell12.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(11) ?: ""
        binding.level2Spell12.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell12.binding.spellName.eventListener = viewModel
        binding.level2Spell12.binding.spellName.tag = "SpellName2-12"
        binding.level2Spell12.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell12.binding.spellButton.eventListener = viewModel
        binding.level2Spell12.binding.spellButton.tag = "SpellButton2-12"
        binding.level2Spell13.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellName?.get(12) ?: ""
        binding.level2Spell13.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level2Spell13.binding.spellName.eventListener = viewModel
        binding.level2Spell13.binding.spellName.tag = "SpellName2-13"
        binding.level2Spell13.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(1)?.spellChecked?.get(0) ?: false
        binding.level2Spell13.binding.spellButton.eventListener = viewModel
        binding.level2Spell13.binding.spellButton.tag = "SpellButton2-13"
    }
}

class LevelThreeSpellsViewHolder(val binding: LayoutSpellsLevelThreeBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level3SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.totalSpellSlots ?: ""
        binding.level3SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3SlotsTotal.eventListener = viewModel
        binding.level3SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellSlotsExpended ?: ""
        binding.level3SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3SlotsExpended.eventListener = viewModel
        binding.level3Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(0) ?: ""
        binding.level3Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell1.binding.spellName.eventListener = viewModel
        binding.level3Spell1.binding.spellName.tag = "SpellName3-1"
        binding.level3Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell1.binding.spellButton.eventListener = viewModel
        binding.level3Spell1.binding.spellButton.tag = "SpellButton3-1"
        binding.level3Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(1) ?: ""
        binding.level3Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell2.binding.spellName.eventListener = viewModel
        binding.level3Spell2.binding.spellName.tag = "SpellName3-2"
        binding.level3Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell2.binding.spellButton.eventListener = viewModel
        binding.level3Spell2.binding.spellButton.tag = "SpellButton3-2"
        binding.level3Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(2) ?: ""
        binding.level3Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell3.binding.spellName.eventListener = viewModel
        binding.level3Spell3.binding.spellName.tag = "SpellName3-3"
        binding.level3Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell3.binding.spellButton.eventListener = viewModel
        binding.level3Spell3.binding.spellButton.tag = "SpellButton3-3"
        binding.level3Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(3) ?: ""
        binding.level3Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell4.binding.spellName.eventListener = viewModel
        binding.level3Spell4.binding.spellName.tag = "SpellName3-4"
        binding.level3Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell4.binding.spellButton.eventListener = viewModel
        binding.level3Spell4.binding.spellButton.tag = "SpellButton3-4"
        binding.level3Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(4) ?: ""
        binding.level3Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell5.binding.spellName.eventListener = viewModel
        binding.level3Spell5.binding.spellName.tag = "SpellName3-5"
        binding.level3Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell5.binding.spellButton.eventListener = viewModel
        binding.level3Spell5.binding.spellButton.tag = "SpellButton3-5"
        binding.level3Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(5) ?: ""
        binding.level3Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell6.binding.spellName.eventListener = viewModel
        binding.level3Spell6.binding.spellName.tag = "SpellName3-6"
        binding.level3Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell6.binding.spellButton.eventListener = viewModel
        binding.level3Spell6.binding.spellButton.tag = "SpellButton3-6"
        binding.level3Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(6) ?: ""
        binding.level3Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell7.binding.spellName.eventListener = viewModel
        binding.level3Spell7.binding.spellName.tag = "SpellName3-7"
        binding.level3Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell7.binding.spellButton.eventListener = viewModel
        binding.level3Spell7.binding.spellButton.tag = "SpellButton3-7"
        binding.level3Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(7) ?: ""
        binding.level3Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell8.binding.spellName.eventListener = viewModel
        binding.level3Spell8.binding.spellName.tag = "SpellName3-8"
        binding.level3Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell8.binding.spellButton.eventListener = viewModel
        binding.level3Spell8.binding.spellButton.tag = "SpellButton3-8"
        binding.level3Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(8) ?: ""
        binding.level3Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell9.binding.spellName.eventListener = viewModel
        binding.level3Spell9.binding.spellName.tag = "SpellName3-9"
        binding.level3Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell9.binding.spellButton.eventListener = viewModel
        binding.level3Spell9.binding.spellButton.tag = "SpellButton3-9"
        binding.level3Spell10.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(9) ?: ""
        binding.level3Spell10.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell10.binding.spellName.eventListener = viewModel
        binding.level3Spell10.binding.spellName.tag = "SpellName3-10"
        binding.level3Spell10.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell10.binding.spellButton.eventListener = viewModel
        binding.level3Spell10.binding.spellButton.tag = "SpellButton3-10"
        binding.level3Spell11.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(10) ?: ""
        binding.level3Spell11.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell11.binding.spellName.eventListener = viewModel
        binding.level3Spell11.binding.spellName.tag = "SpellName3-11"
        binding.level3Spell11.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell11.binding.spellButton.eventListener = viewModel
        binding.level3Spell12.binding.spellButton.tag = "SpellButton3-11"
        binding.level3Spell12.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(11) ?: ""
        binding.level3Spell12.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell12.binding.spellName.eventListener = viewModel
        binding.level3Spell12.binding.spellName.tag = "SpellName3-12"
        binding.level3Spell12.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell12.binding.spellButton.eventListener = viewModel
        binding.level3Spell12.binding.spellButton.tag = "SpellButton3-12"
        binding.level3Spell13.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellName?.get(12) ?: ""
        binding.level3Spell13.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level3Spell13.binding.spellName.eventListener = viewModel
        binding.level3Spell13.binding.spellName.tag = "SpellName3-13"
        binding.level3Spell13.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(2)?.spellChecked?.get(0) ?: false
        binding.level3Spell13.binding.spellButton.eventListener = viewModel
        binding.level3Spell13.binding.spellButton.tag = "SpellButton3-13"
    }
}

class LevelFourSpellsViewHolder(val binding: LayoutSpellsLevelFourBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level4SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.totalSpellSlots ?: ""
        binding.level4SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4SlotsTotal.eventListener = viewModel
        binding.level4SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellSlotsExpended ?: ""
        binding.level4SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4SlotsExpended.eventListener = viewModel
        binding.level4Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(0) ?: ""
        binding.level4Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell1.binding.spellName.eventListener = viewModel
        binding.level4Spell1.binding.spellName.tag = "SpellName4-1"
        binding.level4Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell1.binding.spellButton.eventListener = viewModel
        binding.level4Spell1.binding.spellButton.tag = "SpellButton4-1"
        binding.level4Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(1) ?: ""
        binding.level4Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell2.binding.spellName.eventListener = viewModel
        binding.level4Spell2.binding.spellName.tag = "SpellName4-2"
        binding.level4Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell2.binding.spellButton.eventListener = viewModel
        binding.level4Spell2.binding.spellButton.tag = "SpellButton4-2"
        binding.level4Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(2) ?: ""
        binding.level4Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell3.binding.spellName.eventListener = viewModel
        binding.level4Spell3.binding.spellName.tag = "SpellName4-3"
        binding.level4Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell3.binding.spellButton.eventListener = viewModel
        binding.level4Spell3.binding.spellButton.tag = "SpellButton4-3"
        binding.level4Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(3) ?: ""
        binding.level4Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell4.binding.spellName.eventListener = viewModel
        binding.level4Spell4.binding.spellName.tag = "SpellName4-4"
        binding.level4Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell4.binding.spellButton.eventListener = viewModel
        binding.level4Spell4.binding.spellButton.tag = "SpellButton4-4"
        binding.level4Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(4) ?: ""
        binding.level4Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell5.binding.spellName.eventListener = viewModel
        binding.level4Spell5.binding.spellName.tag = "SpellName4-5"
        binding.level4Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell5.binding.spellButton.eventListener = viewModel
        binding.level4Spell5.binding.spellButton.tag = "SpellButton4-5"
        binding.level4Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(5) ?: ""
        binding.level4Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell6.binding.spellName.eventListener = viewModel
        binding.level4Spell6.binding.spellName.tag = "SpellName4-6"
        binding.level4Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell6.binding.spellButton.eventListener = viewModel
        binding.level4Spell6.binding.spellButton.tag = "SpellButton4-6"
        binding.level4Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(6) ?: ""
        binding.level4Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell7.binding.spellName.eventListener = viewModel
        binding.level4Spell7.binding.spellName.tag = "SpellName4-7"
        binding.level4Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell7.binding.spellButton.eventListener = viewModel
        binding.level4Spell7.binding.spellButton.tag = "SpellButton4-7"
        binding.level4Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(7) ?: ""
        binding.level4Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell8.binding.spellName.eventListener = viewModel
        binding.level4Spell8.binding.spellName.tag = "SpellName4-8"
        binding.level4Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell8.binding.spellButton.eventListener = viewModel
        binding.level4Spell8.binding.spellButton.tag = "SpellButton4-8"
        binding.level4Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(8) ?: ""
        binding.level4Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell9.binding.spellName.eventListener = viewModel
        binding.level4Spell9.binding.spellName.tag = "SpellName4-9"
        binding.level4Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell9.binding.spellButton.eventListener = viewModel
        binding.level4Spell9.binding.spellButton.tag = "SpellButton4-9"
        binding.level4Spell10.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(9) ?: ""
        binding.level4Spell10.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell10.binding.spellName.eventListener = viewModel
        binding.level4Spell10.binding.spellName.tag = "SpellName4-10"
        binding.level4Spell10.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell10.binding.spellButton.eventListener = viewModel
        binding.level4Spell10.binding.spellButton.tag = "SpellButton4-10"
        binding.level4Spell11.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(10) ?: ""
        binding.level4Spell11.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell11.binding.spellName.eventListener = viewModel
        binding.level4Spell11.binding.spellName.tag = "SpellName4-11"
        binding.level4Spell11.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell11.binding.spellButton.eventListener = viewModel
        binding.level4Spell12.binding.spellButton.tag = "SpellButton4-11"
        binding.level4Spell12.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(11) ?: ""
        binding.level4Spell12.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell12.binding.spellName.eventListener = viewModel
        binding.level4Spell12.binding.spellName.tag = "SpellName4-12"
        binding.level4Spell12.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell12.binding.spellButton.eventListener = viewModel
        binding.level4Spell12.binding.spellButton.tag = "SpellButton4-12"
        binding.level4Spell13.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellName?.get(12) ?: ""
        binding.level4Spell13.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level4Spell13.binding.spellName.eventListener = viewModel
        binding.level4Spell13.binding.spellName.tag = "SpellName4-13"
        binding.level4Spell13.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(3)?.spellChecked?.get(0) ?: false
        binding.level4Spell13.binding.spellButton.eventListener = viewModel
        binding.level4Spell13.binding.spellButton.tag = "SpellButton4-13"
    }
}

class LevelFiveSpellsViewHolder(val binding: LayoutSpellsLevelFiveBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level5SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.totalSpellSlots ?: ""
        binding.level5SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5SlotsTotal.eventListener = viewModel
        binding.level5SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellSlotsExpended ?: ""
        binding.level5SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5SlotsExpended.eventListener = viewModel
        binding.level5Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(0) ?: ""
        binding.level5Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell1.binding.spellName.eventListener = viewModel
        binding.level5Spell1.binding.spellName.tag = "SpellName5-1"
        binding.level5Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell1.binding.spellButton.eventListener = viewModel
        binding.level5Spell1.binding.spellButton.tag = "SpellButton5-1"
        binding.level5Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(1) ?: ""
        binding.level5Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell2.binding.spellName.eventListener = viewModel
        binding.level5Spell2.binding.spellName.tag = "SpellName5-2"
        binding.level5Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell2.binding.spellButton.eventListener = viewModel
        binding.level5Spell2.binding.spellButton.tag = "SpellButton5-2"
        binding.level5Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(2) ?: ""
        binding.level5Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell3.binding.spellName.eventListener = viewModel
        binding.level5Spell3.binding.spellName.tag = "SpellName5-3"
        binding.level5Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell3.binding.spellButton.eventListener = viewModel
        binding.level5Spell3.binding.spellButton.tag = "SpellButton5-3"
        binding.level5Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(3) ?: ""
        binding.level5Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell4.binding.spellName.eventListener = viewModel
        binding.level5Spell4.binding.spellName.tag = "SpellName5-4"
        binding.level5Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell4.binding.spellButton.eventListener = viewModel
        binding.level5Spell4.binding.spellButton.tag = "SpellButton5-4"
        binding.level5Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(4) ?: ""
        binding.level5Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell5.binding.spellName.eventListener = viewModel
        binding.level5Spell5.binding.spellName.tag = "SpellName5-5"
        binding.level5Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell5.binding.spellButton.eventListener = viewModel
        binding.level5Spell5.binding.spellButton.tag = "SpellButton5-5"
        binding.level5Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(5) ?: ""
        binding.level5Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell6.binding.spellName.eventListener = viewModel
        binding.level5Spell6.binding.spellName.tag = "SpellName5-6"
        binding.level5Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell6.binding.spellButton.eventListener = viewModel
        binding.level5Spell6.binding.spellButton.tag = "SpellButton5-6"
        binding.level5Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(6) ?: ""
        binding.level5Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell7.binding.spellName.eventListener = viewModel
        binding.level5Spell7.binding.spellName.tag = "SpellName5-7"
        binding.level5Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell7.binding.spellButton.eventListener = viewModel
        binding.level5Spell7.binding.spellButton.tag = "SpellButton5-7"
        binding.level5Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(7) ?: ""
        binding.level5Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell8.binding.spellName.eventListener = viewModel
        binding.level5Spell8.binding.spellName.tag = "SpellName5-8"
        binding.level5Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell8.binding.spellButton.eventListener = viewModel
        binding.level5Spell8.binding.spellButton.tag = "SpellButton5-8"
        binding.level5Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(8) ?: ""
        binding.level5Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell9.binding.spellName.eventListener = viewModel
        binding.level5Spell9.binding.spellName.tag = "SpellName5-9"
        binding.level5Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell9.binding.spellButton.eventListener = viewModel
        binding.level5Spell9.binding.spellButton.tag = "SpellButton5-9"
        binding.level5Spell10.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(9) ?: ""
        binding.level5Spell10.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell10.binding.spellName.eventListener = viewModel
        binding.level5Spell10.binding.spellName.tag = "SpellName5-10"
        binding.level5Spell10.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell10.binding.spellButton.eventListener = viewModel
        binding.level5Spell10.binding.spellButton.tag = "SpellButton5-10"
        binding.level5Spell11.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellName?.get(10) ?: ""
        binding.level5Spell11.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level5Spell11.binding.spellName.eventListener = viewModel
        binding.level5Spell11.binding.spellName.tag = "SpellName5-11"
        binding.level5Spell11.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(4)?.spellChecked?.get(0) ?: false
        binding.level5Spell11.binding.spellButton.eventListener = viewModel
    }
}

class LevelSixSpellsViewHolder(val binding: LayoutSpellsLevelSixBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level6SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.totalSpellSlots ?: ""
        binding.level6SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6SlotsTotal.eventListener = viewModel
        binding.level6SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellSlotsExpended ?: ""
        binding.level6SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6SlotsExpended.eventListener = viewModel
        binding.level6Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(0) ?: ""
        binding.level6Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell1.binding.spellName.eventListener = viewModel
        binding.level6Spell1.binding.spellName.tag = "SpellName6-1"
        binding.level6Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell1.binding.spellButton.eventListener = viewModel
        binding.level6Spell1.binding.spellButton.tag = "SpellButton6-1"
        binding.level6Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(1) ?: ""
        binding.level6Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell2.binding.spellName.eventListener = viewModel
        binding.level6Spell2.binding.spellName.tag = "SpellName6-2"
        binding.level6Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell2.binding.spellButton.eventListener = viewModel
        binding.level6Spell2.binding.spellButton.tag = "SpellButton6-2"
        binding.level6Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(2) ?: ""
        binding.level6Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell3.binding.spellName.eventListener = viewModel
        binding.level6Spell3.binding.spellName.tag = "SpellName6-3"
        binding.level6Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell3.binding.spellButton.eventListener = viewModel
        binding.level6Spell3.binding.spellButton.tag = "SpellButton6-3"
        binding.level6Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(3) ?: ""
        binding.level6Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell4.binding.spellName.eventListener = viewModel
        binding.level6Spell4.binding.spellName.tag = "SpellName6-4"
        binding.level6Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell4.binding.spellButton.eventListener = viewModel
        binding.level6Spell4.binding.spellButton.tag = "SpellButton6-4"
        binding.level6Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(4) ?: ""
        binding.level6Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell5.binding.spellName.eventListener = viewModel
        binding.level6Spell5.binding.spellName.tag = "SpellName6-5"
        binding.level6Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell5.binding.spellButton.eventListener = viewModel
        binding.level6Spell5.binding.spellButton.tag = "SpellButton6-5"
        binding.level6Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(5) ?: ""
        binding.level6Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell6.binding.spellName.eventListener = viewModel
        binding.level6Spell6.binding.spellName.tag = "SpellName6-6"
        binding.level6Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell6.binding.spellButton.eventListener = viewModel
        binding.level6Spell6.binding.spellButton.tag = "SpellButton6-6"
        binding.level6Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(6) ?: ""
        binding.level6Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell7.binding.spellName.eventListener = viewModel
        binding.level6Spell7.binding.spellName.tag = "SpellName6-7"
        binding.level6Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell7.binding.spellButton.eventListener = viewModel
        binding.level6Spell7.binding.spellButton.tag = "SpellButton6-7"
        binding.level6Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(7) ?: ""
        binding.level6Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell8.binding.spellName.eventListener = viewModel
        binding.level6Spell8.binding.spellName.tag = "SpellName6-8"
        binding.level6Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell8.binding.spellButton.eventListener = viewModel
        binding.level6Spell8.binding.spellButton.tag = "SpellButton6-8"
        binding.level6Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(8) ?: ""
        binding.level6Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell9.binding.spellName.eventListener = viewModel
        binding.level6Spell9.binding.spellName.tag = "SpellName6-9"
        binding.level6Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell9.binding.spellButton.eventListener = viewModel
        binding.level6Spell9.binding.spellButton.tag = "SpellButton6-9"
        binding.level6Spell10.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(9) ?: ""
        binding.level6Spell10.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell10.binding.spellName.eventListener = viewModel
        binding.level6Spell10.binding.spellName.tag = "SpellName6-10"
        binding.level6Spell10.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell10.binding.spellButton.eventListener = viewModel
        binding.level6Spell10.binding.spellButton.tag = "SpellButton6-10"
        binding.level6Spell11.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellName?.get(10) ?: ""
        binding.level6Spell11.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level6Spell11.binding.spellName.eventListener = viewModel
        binding.level6Spell11.binding.spellName.tag = "SpellName6-11"
        binding.level6Spell11.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(5)?.spellChecked?.get(0) ?: false
        binding.level6Spell11.binding.spellButton.eventListener = viewModel
    }
}

class LevelSevenSpellsViewHolder(val binding: LayoutSpellsLevelSevenBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level7SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.totalSpellSlots ?: ""
        binding.level7SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7SlotsTotal.eventListener = viewModel
        binding.level7SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellSlotsExpended ?: ""
        binding.level7SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7SlotsExpended.eventListener = viewModel
        binding.level7Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(0) ?: ""
        binding.level7Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell1.binding.spellName.eventListener = viewModel
        binding.level7Spell1.binding.spellName.tag = "SpellName7-1"
        binding.level7Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell1.binding.spellButton.eventListener = viewModel
        binding.level7Spell1.binding.spellButton.tag = "SpellButton7-1"
        binding.level7Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(1) ?: ""
        binding.level7Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell2.binding.spellName.eventListener = viewModel
        binding.level7Spell2.binding.spellName.tag = "SpellName7-2"
        binding.level7Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell2.binding.spellButton.eventListener = viewModel
        binding.level7Spell2.binding.spellButton.tag = "SpellButton7-2"
        binding.level7Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(2) ?: ""
        binding.level7Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell3.binding.spellName.eventListener = viewModel
        binding.level7Spell3.binding.spellName.tag = "SpellName7-3"
        binding.level7Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell3.binding.spellButton.eventListener = viewModel
        binding.level7Spell3.binding.spellButton.tag = "SpellButton7-3"
        binding.level7Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(3) ?: ""
        binding.level7Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell4.binding.spellName.eventListener = viewModel
        binding.level7Spell4.binding.spellName.tag = "SpellName7-4"
        binding.level7Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell4.binding.spellButton.eventListener = viewModel
        binding.level7Spell4.binding.spellButton.tag = "SpellButton7-4"
        binding.level7Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(4) ?: ""
        binding.level7Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell5.binding.spellName.eventListener = viewModel
        binding.level7Spell5.binding.spellName.tag = "SpellName7-5"
        binding.level7Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell5.binding.spellButton.eventListener = viewModel
        binding.level7Spell5.binding.spellButton.tag = "SpellButton7-5"
        binding.level7Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(5) ?: ""
        binding.level7Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell6.binding.spellName.eventListener = viewModel
        binding.level7Spell6.binding.spellName.tag = "SpellName7-6"
        binding.level7Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell6.binding.spellButton.eventListener = viewModel
        binding.level7Spell6.binding.spellButton.tag = "SpellButton7-6"
        binding.level7Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(6) ?: ""
        binding.level7Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell7.binding.spellName.eventListener = viewModel
        binding.level7Spell7.binding.spellName.tag = "SpellName7-7"
        binding.level7Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell7.binding.spellButton.eventListener = viewModel
        binding.level7Spell7.binding.spellButton.tag = "SpellButton7-7"
        binding.level7Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(7) ?: ""
        binding.level7Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell8.binding.spellName.eventListener = viewModel
        binding.level7Spell8.binding.spellName.tag = "SpellName7-8"
        binding.level7Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell8.binding.spellButton.eventListener = viewModel
        binding.level7Spell8.binding.spellButton.tag = "SpellButton7-8"
        binding.level7Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(8) ?: ""
        binding.level7Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell9.binding.spellName.eventListener = viewModel
        binding.level7Spell9.binding.spellName.tag = "SpellName7-9"
        binding.level7Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell9.binding.spellButton.eventListener = viewModel
        binding.level7Spell9.binding.spellButton.tag = "SpellButton7-9"
        binding.level7Spell10.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(9) ?: ""
        binding.level7Spell10.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell10.binding.spellName.eventListener = viewModel
        binding.level7Spell10.binding.spellName.tag = "SpellName7-10"
        binding.level7Spell10.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell10.binding.spellButton.eventListener = viewModel
        binding.level7Spell10.binding.spellButton.tag = "SpellButton7-10"
        binding.level7Spell11.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellName?.get(10) ?: ""
        binding.level7Spell11.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level7Spell11.binding.spellName.eventListener = viewModel
        binding.level7Spell11.binding.spellName.tag = "SpellName7-11"
        binding.level7Spell11.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(6)?.spellChecked?.get(0) ?: false
        binding.level7Spell11.binding.spellButton.eventListener = viewModel
    }
}

class LevelEightSpellsViewHolder(val binding: LayoutSpellsLevelEightBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level8SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.totalSpellSlots ?: ""
        binding.level8SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8SlotsTotal.eventListener = viewModel
        binding.level8SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellSlotsExpended ?: ""
        binding.level8SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8SlotsExpended.eventListener = viewModel
        binding.level8Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(0) ?: ""
        binding.level8Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell1.binding.spellName.eventListener = viewModel
        binding.level8Spell1.binding.spellName.tag = "SpellName8-1"
        binding.level8Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell1.binding.spellButton.eventListener = viewModel
        binding.level8Spell1.binding.spellButton.tag = "SpellButton8-1"
        binding.level8Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(1) ?: ""
        binding.level8Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell2.binding.spellName.eventListener = viewModel
        binding.level8Spell2.binding.spellName.tag = "SpellName8-2"
        binding.level8Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell2.binding.spellButton.eventListener = viewModel
        binding.level8Spell2.binding.spellButton.tag = "SpellButton8-2"
        binding.level8Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(2) ?: ""
        binding.level8Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell3.binding.spellName.eventListener = viewModel
        binding.level8Spell3.binding.spellName.tag = "SpellName8-3"
        binding.level8Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell3.binding.spellButton.eventListener = viewModel
        binding.level8Spell3.binding.spellButton.tag = "SpellButton8-3"
        binding.level8Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(3) ?: ""
        binding.level8Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell4.binding.spellName.eventListener = viewModel
        binding.level8Spell4.binding.spellName.tag = "SpellName8-4"
        binding.level8Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell4.binding.spellButton.eventListener = viewModel
        binding.level8Spell4.binding.spellButton.tag = "SpellButton8-4"
        binding.level8Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(4) ?: ""
        binding.level8Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell5.binding.spellName.eventListener = viewModel
        binding.level8Spell5.binding.spellName.tag = "SpellName8-5"
        binding.level8Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell5.binding.spellButton.eventListener = viewModel
        binding.level8Spell5.binding.spellButton.tag = "SpellButton8-5"
        binding.level8Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(5) ?: ""
        binding.level8Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell6.binding.spellName.eventListener = viewModel
        binding.level8Spell6.binding.spellName.tag = "SpellName8-6"
        binding.level8Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell6.binding.spellButton.eventListener = viewModel
        binding.level8Spell6.binding.spellButton.tag = "SpellButton8-6"
        binding.level8Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(6) ?: ""
        binding.level8Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell7.binding.spellName.eventListener = viewModel
        binding.level8Spell7.binding.spellName.tag = "SpellName8-7"
        binding.level8Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell7.binding.spellButton.eventListener = viewModel
        binding.level8Spell7.binding.spellButton.tag = "SpellButton8-7"
        binding.level8Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(7) ?: ""
        binding.level8Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell8.binding.spellName.eventListener = viewModel
        binding.level8Spell8.binding.spellName.tag = "SpellName8-8"
        binding.level8Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell8.binding.spellButton.eventListener = viewModel
        binding.level8Spell8.binding.spellButton.tag = "SpellButton8-8"
        binding.level8Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellName?.get(8) ?: ""
        binding.level8Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level8Spell9.binding.spellName.eventListener = viewModel
        binding.level8Spell9.binding.spellName.tag = "SpellName8-9"
        binding.level8Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(7)?.spellChecked?.get(0) ?: false
        binding.level8Spell9.binding.spellButton.eventListener = viewModel
        binding.level8Spell9.binding.spellButton.tag = "SpellButton8-9"
    }
}

class LevelNineSpellsViewHolder(val binding: LayoutSpellsLevelNineBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
        binding.level9SlotsTotal.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.totalSpellSlots ?: ""
        binding.level9SlotsTotal.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9SlotsTotal.eventListener = viewModel
        binding.level9SlotsExpended.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellSlotsExpended ?: ""
        binding.level9SlotsExpended.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9SlotsExpended.eventListener = viewModel
        binding.level9Spell1.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(0) ?: ""
        binding.level9Spell1.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell1.binding.spellName.eventListener = viewModel
        binding.level9Spell1.binding.spellName.tag = "SpellName9-1"
        binding.level9Spell1.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell1.binding.spellButton.eventListener = viewModel
        binding.level9Spell1.binding.spellButton.tag = "SpellButton9-1"
        binding.level9Spell2.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(1) ?: ""
        binding.level9Spell2.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell2.binding.spellName.eventListener = viewModel
        binding.level9Spell2.binding.spellName.tag = "SpellName9-2"
        binding.level9Spell2.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell2.binding.spellButton.eventListener = viewModel
        binding.level9Spell2.binding.spellButton.tag = "SpellButton9-2"
        binding.level9Spell3.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(2) ?: ""
        binding.level9Spell3.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell3.binding.spellName.eventListener = viewModel
        binding.level9Spell3.binding.spellName.tag = "SpellName9-3"
        binding.level9Spell3.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell3.binding.spellButton.eventListener = viewModel
        binding.level9Spell3.binding.spellButton.tag = "SpellButton9-3"
        binding.level9Spell4.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(3) ?: ""
        binding.level9Spell4.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell4.binding.spellName.eventListener = viewModel
        binding.level9Spell4.binding.spellName.tag = "SpellName9-4"
        binding.level9Spell4.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell4.binding.spellButton.eventListener = viewModel
        binding.level9Spell4.binding.spellButton.tag = "SpellButton9-4"
        binding.level9Spell5.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(4) ?: ""
        binding.level9Spell5.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell5.binding.spellName.eventListener = viewModel
        binding.level9Spell5.binding.spellName.tag = "SpellName9-5"
        binding.level9Spell5.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell5.binding.spellButton.eventListener = viewModel
        binding.level9Spell5.binding.spellButton.tag = "SpellButton9-5"
        binding.level9Spell6.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(5) ?: ""
        binding.level9Spell6.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell6.binding.spellName.eventListener = viewModel
        binding.level9Spell6.binding.spellName.tag = "SpellName9-6"
        binding.level9Spell6.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell6.binding.spellButton.eventListener = viewModel
        binding.level9Spell6.binding.spellButton.tag = "SpellButton9-6"
        binding.level9Spell7.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(6) ?: ""
        binding.level9Spell7.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell7.binding.spellName.eventListener = viewModel
        binding.level9Spell7.binding.spellName.tag = "SpellName9-7"
        binding.level9Spell7.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell7.binding.spellButton.eventListener = viewModel
        binding.level9Spell7.binding.spellButton.tag = "SpellButton9-7"
        binding.level9Spell8.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(7) ?: ""
        binding.level9Spell8.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell8.binding.spellName.eventListener = viewModel
        binding.level9Spell8.binding.spellName.tag = "SpellName9-8"
        binding.level9Spell8.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell8.binding.spellButton.eventListener = viewModel
        binding.level9Spell8.binding.spellButton.tag = "SpellButton9-8"
        binding.level9Spell9.binding.spellName.text =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellName?.get(8) ?: ""
        binding.level9Spell9.binding.spellName.isLocked = viewModel.currentCharacter.value?.editingIsLocked ?: false
        binding.level9Spell9.binding.spellName.eventListener = viewModel
        binding.level9Spell9.binding.spellName.tag = "SpellName9-9"
        binding.level9Spell9.binding.spellButton.isChecked =
            viewModel.currentCharacter.value?.spells?.get(8)?.spellChecked?.get(0) ?: false
        binding.level9Spell9.binding.spellButton.eventListener = viewModel
        binding.level9Spell9.binding.spellButton.tag = "SpellButton9-9"
    }
}
