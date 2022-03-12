package com.shipsco.charactersheet.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shipsco.charactersheet.BR
import com.shipsco.charactersheet.CharacterViewModel
import com.shipsco.charactersheet.ManualEditListener
import com.shipsco.charactersheet.databinding.*

class SpellsFragmentAdapter(val viewModel: CharacterViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    ManualEditListener {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_SPELL_CLASS -> {
                val binding = LayoutSpellsClassTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.viewModel = viewModel
                return SpellClassViewHolder(binding)
            }
            TYPE_CLASS_INFO -> {
                val binding = LayoutSpellsClassInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.viewModel = viewModel
                return ClassInfoViewHolder(binding)
            }
            TYPE_CANTRIPS -> {
                val binding = LayoutSpellsCantripsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.cantrip1.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  0
                binding.cantrip2.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  1
                binding.cantrip3.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  2
                binding.cantrip4.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  3
                binding.cantrip5.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  4
                binding.cantrip6.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  5
                binding.cantrip7.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  6
                binding.cantrip8.binding.viewModel = viewModel
                binding.cantrip1.binding.position =  7
                return CantripsViewHolder(binding)
            }
            TYPE_LEVEL_ONE -> {
                val binding = LayoutSpellsLevelOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level1Spell1.binding.viewModel = viewModel
                binding.level1Spell1.binding.spellLevel = 0
                binding.level1Spell1.binding.spellPosition = 0
                binding.level1Spell2.binding.viewModel = viewModel
                binding.level1Spell2.binding.spellLevel = 0
                binding.level1Spell2.binding.spellPosition = 1
                binding.level1Spell3.binding.viewModel = viewModel
                binding.level1Spell3.binding.spellLevel = 0
                binding.level1Spell3.binding.spellPosition = 2
                binding.level1Spell4.binding.viewModel = viewModel
                binding.level1Spell4.binding.spellLevel = 0
                binding.level1Spell4.binding.spellPosition = 3
                binding.level1Spell5.binding.viewModel = viewModel
                binding.level1Spell5.binding.spellLevel = 0
                binding.level1Spell5.binding.spellPosition = 4
                binding.level1Spell6.binding.viewModel = viewModel
                binding.level1Spell6.binding.spellLevel = 0
                binding.level1Spell6.binding.spellPosition = 5
                binding.level1Spell7.binding.viewModel = viewModel
                binding.level1Spell7.binding.spellLevel = 0
                binding.level1Spell7.binding.spellPosition = 6
                binding.level1Spell8.binding.viewModel = viewModel
                binding.level1Spell8.binding.spellLevel = 0
                binding.level1Spell8.binding.spellPosition = 7
                binding.level1Spell9.binding.viewModel = viewModel
                binding.level1Spell9.binding.spellLevel = 0
                binding.level1Spell9.binding.spellPosition = 8
                binding.level1Spell10.binding.viewModel = viewModel
                binding.level1Spell10.binding.spellLevel = 0
                binding.level1Spell10.binding.spellPosition = 9
                binding.level1Spell11.binding.viewModel = viewModel
                binding.level1Spell11.binding.spellLevel = 0
                binding.level1Spell11.binding.spellPosition = 10
                binding.level1Spell12.binding.viewModel = viewModel
                binding.level1Spell12.binding.spellLevel = 0
                binding.level1Spell12.binding.spellPosition = 11
                binding.level1Spell13.binding.viewModel = viewModel
                binding.level1Spell13.binding.spellLevel = 0
                binding.level1Spell13.binding.spellPosition = 12
                return LevelOneSpellsViewHolder(binding)
            }
            TYPE_LEVEL_TWO -> {
                val binding = LayoutSpellsLevelTwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level2Spell1.binding.viewModel = viewModel
                binding.level2Spell1.binding.spellLevel = 1
                binding.level2Spell1.binding.spellPosition = 0
                binding.level2Spell2.binding.viewModel = viewModel
                binding.level2Spell2.binding.spellLevel = 1
                binding.level2Spell2.binding.spellPosition = 1
                binding.level2Spell3.binding.viewModel = viewModel
                binding.level2Spell3.binding.spellLevel = 1
                binding.level2Spell3.binding.spellPosition = 2
                binding.level2Spell4.binding.viewModel = viewModel
                binding.level2Spell4.binding.spellLevel = 1
                binding.level2Spell4.binding.spellPosition = 3
                binding.level2Spell5.binding.viewModel = viewModel
                binding.level2Spell5.binding.spellLevel = 1
                binding.level2Spell5.binding.spellPosition = 4
                binding.level2Spell6.binding.viewModel = viewModel
                binding.level2Spell6.binding.spellLevel = 1
                binding.level2Spell6.binding.spellPosition = 5
                binding.level2Spell7.binding.viewModel = viewModel
                binding.level2Spell7.binding.spellLevel = 1
                binding.level2Spell7.binding.spellPosition = 6
                binding.level2Spell8.binding.viewModel = viewModel
                binding.level2Spell8.binding.spellLevel = 1
                binding.level2Spell8.binding.spellPosition = 7
                binding.level2Spell9.binding.viewModel = viewModel
                binding.level2Spell9.binding.spellLevel = 1
                binding.level2Spell9.binding.spellPosition = 8
                binding.level2Spell10.binding.viewModel = viewModel
                binding.level2Spell10.binding.spellLevel = 1
                binding.level2Spell10.binding.spellPosition = 9
                binding.level2Spell11.binding.viewModel = viewModel
                binding.level2Spell11.binding.spellLevel = 1
                binding.level2Spell11.binding.spellPosition = 10
                binding.level2Spell12.binding.viewModel = viewModel
                binding.level2Spell12.binding.spellLevel = 1
                binding.level2Spell12.binding.spellPosition = 11
                binding.level2Spell13.binding.viewModel = viewModel
                binding.level2Spell13.binding.spellLevel = 1
                binding.level2Spell13.binding.spellPosition = 12
                return LevelTwoSpellsViewHolder(binding)
            }
            TYPE_LEVEL_THREE -> {
                val binding = LayoutSpellsLevelThreeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level3Spell1.binding.viewModel = viewModel
                binding.level3Spell1.binding.spellLevel = 2
                binding.level3Spell1.binding.spellPosition = 0
                binding.level3Spell2.binding.viewModel = viewModel
                binding.level3Spell2.binding.spellLevel = 2
                binding.level3Spell2.binding.spellPosition = 1
                binding.level3Spell3.binding.viewModel = viewModel
                binding.level3Spell3.binding.spellLevel = 2
                binding.level3Spell3.binding.spellPosition = 2
                binding.level3Spell4.binding.viewModel = viewModel
                binding.level3Spell4.binding.spellLevel = 2
                binding.level3Spell4.binding.spellPosition = 3
                binding.level3Spell5.binding.viewModel = viewModel
                binding.level3Spell5.binding.spellLevel = 2
                binding.level3Spell5.binding.spellPosition = 4
                binding.level3Spell6.binding.viewModel = viewModel
                binding.level3Spell6.binding.spellLevel = 2
                binding.level3Spell6.binding.spellPosition = 5
                binding.level3Spell7.binding.viewModel = viewModel
                binding.level3Spell7.binding.spellLevel = 2
                binding.level3Spell7.binding.spellPosition = 6
                binding.level3Spell8.binding.viewModel = viewModel
                binding.level3Spell8.binding.spellLevel = 2
                binding.level3Spell8.binding.spellPosition = 7
                binding.level3Spell9.binding.viewModel = viewModel
                binding.level3Spell9.binding.spellLevel = 2
                binding.level3Spell9.binding.spellPosition = 8
                binding.level3Spell10.binding.viewModel = viewModel
                binding.level3Spell10.binding.spellLevel = 2
                binding.level3Spell10.binding.spellPosition = 9
                binding.level3Spell11.binding.viewModel = viewModel
                binding.level3Spell11.binding.spellLevel = 2
                binding.level3Spell11.binding.spellPosition = 10
                binding.level3Spell12.binding.viewModel = viewModel
                binding.level3Spell12.binding.spellLevel = 2
                binding.level3Spell12.binding.spellPosition = 11
                binding.level3Spell13.binding.viewModel = viewModel
                binding.level3Spell13.binding.spellLevel = 2
                binding.level3Spell13.binding.spellPosition = 12
                return LevelThreeSpellsViewHolder(binding)
            }
            TYPE_LEVEL_FOUR -> {
                val binding = LayoutSpellsLevelFourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level4Spell1.binding.viewModel = viewModel
                binding.level4Spell1.binding.spellLevel = 3
                binding.level4Spell1.binding.spellPosition = 0
                binding.level4Spell2.binding.viewModel = viewModel
                binding.level4Spell2.binding.spellLevel = 3
                binding.level4Spell2.binding.spellPosition = 1
                binding.level4Spell3.binding.viewModel = viewModel
                binding.level4Spell3.binding.spellLevel = 3
                binding.level4Spell3.binding.spellPosition = 2
                binding.level4Spell4.binding.viewModel = viewModel
                binding.level4Spell4.binding.spellLevel = 3
                binding.level4Spell4.binding.spellPosition = 3
                binding.level4Spell5.binding.viewModel = viewModel
                binding.level4Spell5.binding.spellLevel = 3
                binding.level4Spell5.binding.spellPosition = 4
                binding.level4Spell6.binding.viewModel = viewModel
                binding.level4Spell6.binding.spellLevel = 3
                binding.level4Spell6.binding.spellPosition = 5
                binding.level4Spell7.binding.viewModel = viewModel
                binding.level4Spell7.binding.spellLevel = 3
                binding.level4Spell7.binding.spellPosition = 6
                binding.level4Spell8.binding.viewModel = viewModel
                binding.level4Spell8.binding.spellLevel = 3
                binding.level4Spell8.binding.spellPosition = 7
                binding.level4Spell9.binding.viewModel = viewModel
                binding.level4Spell9.binding.spellLevel = 3
                binding.level4Spell9.binding.spellPosition = 8
                binding.level4Spell10.binding.viewModel = viewModel
                binding.level4Spell10.binding.spellLevel = 3
                binding.level4Spell10.binding.spellPosition = 9
                binding.level4Spell11.binding.viewModel = viewModel
                binding.level4Spell11.binding.spellLevel = 3
                binding.level4Spell11.binding.spellPosition = 10
                binding.level4Spell12.binding.viewModel = viewModel
                binding.level4Spell12.binding.spellLevel = 2
                binding.level4Spell12.binding.spellPosition = 11
                binding.level4Spell13.binding.viewModel = viewModel
                binding.level4Spell13.binding.spellLevel = 2
                binding.level4Spell13.binding.spellPosition = 12
                return LevelFourSpellsViewHolder(binding)
            }
            TYPE_LEVEL_FIVE -> {
                val binding = LayoutSpellsLevelFiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level5Spell1.binding.viewModel = viewModel
                binding.level5Spell1.binding.spellLevel = 4
                binding.level5Spell1.binding.spellPosition = 0
                binding.level5Spell2.binding.viewModel = viewModel
                binding.level5Spell2.binding.spellLevel = 4
                binding.level5Spell2.binding.spellPosition = 1
                binding.level5Spell3.binding.viewModel = viewModel
                binding.level5Spell3.binding.spellLevel = 4
                binding.level5Spell3.binding.spellPosition = 2
                binding.level5Spell4.binding.viewModel = viewModel
                binding.level5Spell4.binding.spellLevel = 4
                binding.level5Spell4.binding.spellPosition = 3
                binding.level5Spell5.binding.viewModel = viewModel
                binding.level5Spell5.binding.spellLevel = 4
                binding.level5Spell5.binding.spellPosition = 4
                binding.level5Spell6.binding.viewModel = viewModel
                binding.level5Spell6.binding.spellLevel = 4
                binding.level5Spell6.binding.spellPosition = 5
                binding.level5Spell7.binding.viewModel = viewModel
                binding.level5Spell7.binding.spellLevel = 4
                binding.level5Spell7.binding.spellPosition = 6
                binding.level5Spell8.binding.viewModel = viewModel
                binding.level5Spell8.binding.spellLevel = 4
                binding.level5Spell8.binding.spellPosition = 7
                binding.level5Spell9.binding.viewModel = viewModel
                binding.level5Spell9.binding.spellLevel = 4
                binding.level5Spell9.binding.spellPosition = 8
                binding.level5Spell10.binding.viewModel = viewModel
                binding.level5Spell10.binding.spellLevel = 4
                binding.level5Spell10.binding.spellPosition = 9
                binding.level5Spell11.binding.viewModel = viewModel
                binding.level5Spell11.binding.spellLevel = 4
                binding.level5Spell11.binding.spellPosition = 10
                return LevelFiveSpellsViewHolder(binding)
            }
            TYPE_LEVEL_SIX -> {
                val binding = LayoutSpellsLevelSixBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level6Spell1.binding.viewModel = viewModel
                binding.level6Spell1.binding.spellLevel = 5
                binding.level6Spell1.binding.spellPosition = 0
                binding.level6Spell2.binding.viewModel = viewModel
                binding.level6Spell2.binding.spellLevel = 5
                binding.level6Spell2.binding.spellPosition = 1
                binding.level6Spell3.binding.viewModel = viewModel
                binding.level6Spell3.binding.spellLevel = 5
                binding.level6Spell3.binding.spellPosition = 2
                binding.level6Spell4.binding.viewModel = viewModel
                binding.level6Spell4.binding.spellLevel = 5
                binding.level6Spell4.binding.spellPosition = 3
                binding.level6Spell5.binding.viewModel = viewModel
                binding.level6Spell5.binding.spellLevel = 5
                binding.level6Spell5.binding.spellPosition = 4
                binding.level6Spell6.binding.viewModel = viewModel
                binding.level6Spell6.binding.spellLevel = 5
                binding.level6Spell6.binding.spellPosition = 5
                binding.level6Spell7.binding.viewModel = viewModel
                binding.level6Spell7.binding.spellLevel = 5
                binding.level6Spell7.binding.spellPosition = 6
                binding.level6Spell8.binding.viewModel = viewModel
                binding.level6Spell8.binding.spellLevel = 5
                binding.level6Spell8.binding.spellPosition = 7
                binding.level6Spell9.binding.viewModel = viewModel
                binding.level6Spell9.binding.spellLevel = 5
                binding.level6Spell9.binding.spellPosition = 8
                binding.level6Spell10.binding.viewModel = viewModel
                binding.level6Spell10.binding.spellLevel = 5
                binding.level6Spell10.binding.spellPosition = 9
                binding.level6Spell11.binding.viewModel = viewModel
                binding.level6Spell11.binding.spellLevel = 5
                binding.level6Spell11.binding.spellPosition = 10
                return LevelSixSpellsViewHolder(binding)
            }
            TYPE_LEVEL_SEVEN -> {
                val binding = LayoutSpellsLevelSevenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level7Spell1.binding.viewModel = viewModel
                binding.level7Spell1.binding.spellLevel = 6
                binding.level7Spell1.binding.spellPosition = 0
                binding.level7Spell2.binding.viewModel = viewModel
                binding.level7Spell2.binding.spellLevel = 6
                binding.level7Spell2.binding.spellPosition = 1
                binding.level7Spell3.binding.viewModel = viewModel
                binding.level7Spell3.binding.spellLevel = 6
                binding.level7Spell3.binding.spellPosition = 2
                binding.level7Spell4.binding.viewModel = viewModel
                binding.level7Spell4.binding.spellLevel = 6
                binding.level7Spell4.binding.spellPosition = 3
                binding.level7Spell5.binding.viewModel = viewModel
                binding.level7Spell5.binding.spellLevel = 6
                binding.level7Spell5.binding.spellPosition = 4
                binding.level7Spell6.binding.viewModel = viewModel
                binding.level7Spell6.binding.spellLevel = 6
                binding.level7Spell6.binding.spellPosition = 5
                binding.level7Spell7.binding.viewModel = viewModel
                binding.level7Spell7.binding.spellLevel = 6
                binding.level7Spell7.binding.spellPosition = 6
                binding.level7Spell8.binding.viewModel = viewModel
                binding.level7Spell8.binding.spellLevel = 6
                binding.level7Spell8.binding.spellPosition = 7
                binding.level7Spell9.binding.viewModel = viewModel
                binding.level7Spell9.binding.spellLevel = 6
                binding.level7Spell9.binding.spellPosition = 8
                binding.level7Spell10.binding.viewModel = viewModel
                binding.level7Spell10.binding.spellLevel = 6
                binding.level7Spell10.binding.spellPosition = 9
                binding.level7Spell11.binding.viewModel = viewModel
                binding.level7Spell11.binding.spellLevel = 6
                binding.level7Spell11.binding.spellPosition = 10
                return LevelSevenSpellsViewHolder(binding)
            }
            TYPE_LEVEL_EIGHT -> {
                val binding = LayoutSpellsLevelEightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level8Spell1.binding.viewModel = viewModel
                binding.level8Spell1.binding.spellLevel = 7
                binding.level8Spell1.binding.spellPosition = 0
                binding.level8Spell2.binding.viewModel = viewModel
                binding.level8Spell2.binding.spellLevel = 7
                binding.level8Spell2.binding.spellPosition = 1
                binding.level8Spell3.binding.viewModel = viewModel
                binding.level8Spell3.binding.spellLevel = 7
                binding.level8Spell3.binding.spellPosition = 2
                binding.level8Spell4.binding.viewModel = viewModel
                binding.level8Spell4.binding.spellLevel = 7
                binding.level8Spell4.binding.spellPosition = 3
                binding.level8Spell5.binding.viewModel = viewModel
                binding.level8Spell5.binding.spellLevel = 7
                binding.level8Spell5.binding.spellPosition = 4
                binding.level8Spell6.binding.viewModel = viewModel
                binding.level8Spell6.binding.spellLevel = 7
                binding.level8Spell6.binding.spellPosition = 5
                binding.level8Spell7.binding.viewModel = viewModel
                binding.level8Spell7.binding.spellLevel = 7
                binding.level8Spell7.binding.spellPosition = 6
                binding.level8Spell8.binding.viewModel = viewModel
                binding.level8Spell8.binding.spellLevel = 7
                binding.level8Spell8.binding.spellPosition = 7
                binding.level8Spell9.binding.viewModel = viewModel
                binding.level8Spell9.binding.spellLevel = 7
                binding.level8Spell9.binding.spellPosition = 8
                return LevelEightSpellsViewHolder(binding)
            }
            else -> {
                val binding = LayoutSpellsLevelNineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.level9Spell1.binding.viewModel = viewModel
                binding.level9Spell1.binding.spellLevel = 8
                binding.level9Spell1.binding.spellPosition = 0
                binding.level9Spell2.binding.viewModel = viewModel
                binding.level9Spell2.binding.spellLevel = 8
                binding.level9Spell2.binding.spellPosition = 1
                binding.level9Spell3.binding.viewModel = viewModel
                binding.level9Spell3.binding.spellLevel = 8
                binding.level9Spell3.binding.spellPosition = 2
                binding.level9Spell4.binding.viewModel = viewModel
                binding.level9Spell4.binding.spellLevel = 8
                binding.level9Spell4.binding.spellPosition = 3
                binding.level9Spell5.binding.viewModel = viewModel
                binding.level9Spell5.binding.spellLevel = 8
                binding.level9Spell5.binding.spellPosition = 4
                binding.level9Spell6.binding.viewModel = viewModel
                binding.level9Spell6.binding.spellLevel = 8
                binding.level9Spell6.binding.spellPosition = 5
                binding.level9Spell7.binding.viewModel = viewModel
                binding.level9Spell7.binding.spellLevel = 8
                binding.level9Spell7.binding.spellPosition = 6
                binding.level9Spell8.binding.viewModel = viewModel
                binding.level9Spell8.binding.spellLevel = 8
                binding.level9Spell8.binding.spellPosition = 7
                binding.level9Spell9.binding.viewModel = viewModel
                binding.level9Spell9.binding.spellLevel = 8
                binding.level9Spell9.binding.spellPosition = 8
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

    override fun manualEditCompleted() {
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
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class ClassInfoViewHolder(val binding: LayoutSpellsClassInfoBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class CantripsViewHolder(val binding: LayoutSpellsCantripsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelOneSpellsViewHolder(val binding: LayoutSpellsLevelOneBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelTwoSpellsViewHolder(val binding: LayoutSpellsLevelTwoBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelThreeSpellsViewHolder(val binding: LayoutSpellsLevelThreeBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelFourSpellsViewHolder(val binding: LayoutSpellsLevelFourBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelFiveSpellsViewHolder(val binding: LayoutSpellsLevelFiveBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelSixSpellsViewHolder(val binding: LayoutSpellsLevelSixBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelSevenSpellsViewHolder(val binding: LayoutSpellsLevelSevenBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelEightSpellsViewHolder(val binding: LayoutSpellsLevelEightBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class LevelNineSpellsViewHolder(val binding: LayoutSpellsLevelNineBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}
