package com.shipsco.charactersheet.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shipsco.charactersheet.BR
import com.shipsco.charactersheet.CharacterViewModel
import com.shipsco.charactersheet.ManualEditListener
import com.shipsco.charactersheet.databinding.*

class DetailsFragmentAdapter(val viewModel: CharacterViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>(), ManualEditListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_CHARACTER_NAME -> {
                val binding = LayoutDetailsCharacterNameBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return CharacterNameViewHolder(binding)
            }
            TYPE_CHARACTER_DETAILS -> {
                val binding = LayoutDetailsCharacterDetailsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return CharacterDetailsViewHolder(binding)
            }
            TYPE_AC_INITIATIVE_SPEED -> {
                val binding = LayoutDetailsAcInitiativeSpeedBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return ACInitiativeSpeedViewHolder(binding)
            }
            TYPE_CURRENT_HIT_POINT -> {
                val binding = LayoutDetailsCurrentHitPointsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return CurrentHitPointsViewHolder(binding)
            }
            TYPE_TEMP_HIT_POINTS -> {
                val binding = LayoutDetailsTempHitPointsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return TempHitPointsViewHolder(binding)
            }
            TYPE_HITDICE_DEATHSAVES -> {
                val binding = LayoutDetailsHitdieDeathsavesBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return HitDiceDeathSavesViewHolder(binding)
            }
            TYPE_INSPIRATION_PROFICIENCY -> {
                val binding = LayoutDetailsInspirationProficiencyBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return InspirationProficiency(binding)
            }
            TYPE_STATS_TOP -> {
                val binding = LayoutDetailsStatsTopBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return StatsTopViewHolder(binding)
            }
            TYPE_STATS_BOTTOM -> {
                val binding = LayoutDetailsStatsBottomBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return StatsBottomViewHolder(binding)
            }
            TYPE_SAVING_THROWS -> {
                val binding = LayoutDetailsSavingThrowsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return SavingThrowsViewHolder(binding)
            }
            TYPE_SKILLS -> {
                val binding = LayoutDetailsSkillsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return SkillsViewHolder(binding)
            }
            TYPE_ATTACKS_SPELLS -> {
                val binding = LayoutDetailsAttackSpellsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return AttackSpellsViewHolder(binding)
            }
            TYPE_EQUIPMENT -> {
                val binding = LayoutDetailsEquipmentBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return EquipmentViewHolder(binding)
            }
            TYPE_PROFICIENCIES_LANGUAGES -> {
                val binding = LayoutDetailsProficienciesLanguagesBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return ProficienciesLanguagesViewHolder(binding)
            }
            TYPE_PERSONALITY_TRAITS -> {
                val binding = LayoutDetailsPersonalityTraitsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return PersonalityTraitsViewHolder(binding)
            }
            TYPE_IDEALS -> {
                val binding = LayoutDetailsIdealsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return IdealsViewHolder(binding)
            }
            TYPE_BONDS -> {
                val binding = LayoutDetailsBondsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return BondsViewHolder(binding)
            }
            else -> { // TYPE_FLAWS
                val binding = LayoutDetailsFlawsBinding.inflate(LayoutInflater.from(parent.context))
                println("------------------CREATE ${binding.root.height}")
                return FlawsViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        println("------------------BIND ${holder.itemViewType}")
        println(holder.itemView.height)
        when (holder.itemViewType) {
            TYPE_CHARACTER_NAME -> {
                (holder as CharacterNameViewHolder).bind(viewModel)
            }
            TYPE_CHARACTER_DETAILS -> {
                (holder as CharacterDetailsViewHolder).bind(viewModel)
            }
            TYPE_AC_INITIATIVE_SPEED -> {
                (holder as ACInitiativeSpeedViewHolder).bind(viewModel)
            }
            TYPE_CURRENT_HIT_POINT -> {
                (holder as CurrentHitPointsViewHolder).bind(viewModel)
            }
            TYPE_TEMP_HIT_POINTS -> {
                (holder as TempHitPointsViewHolder).bind(viewModel)
            }
            TYPE_HITDICE_DEATHSAVES -> {
                (holder as HitDiceDeathSavesViewHolder).bind(viewModel)
            }
            TYPE_INSPIRATION_PROFICIENCY -> {
                (holder as InspirationProficiency).bind(viewModel)
            }
            TYPE_STATS_TOP -> {
                (holder as StatsTopViewHolder).bind(viewModel)
            }
            TYPE_STATS_BOTTOM -> {
                (holder as StatsBottomViewHolder).bind(viewModel)
            }
            TYPE_SAVING_THROWS -> {
                (holder as SavingThrowsViewHolder).bind(viewModel)
            }
            TYPE_SKILLS -> {
                (holder as SkillsViewHolder).bind(viewModel)
            }
            TYPE_ATTACKS_SPELLS -> {
                (holder as AttackSpellsViewHolder).bind(viewModel)
            }
            TYPE_EQUIPMENT -> {
                (holder as EquipmentViewHolder).bind(viewModel)
            }
            TYPE_PROFICIENCIES_LANGUAGES -> {
                (holder as ProficienciesLanguagesViewHolder).bind(viewModel)
            }
            TYPE_PERSONALITY_TRAITS -> {
                (holder as PersonalityTraitsViewHolder).bind(viewModel)
            }
            TYPE_IDEALS -> {
                (holder as IdealsViewHolder).bind(viewModel)
            }
            TYPE_BONDS -> {
                (holder as BondsViewHolder).bind(viewModel)
            }
            TYPE_FLAWS -> {
                (holder as FlawsViewHolder).bind(viewModel)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position + 1
    }

    override fun getItemCount(): Int {
        return 18
    }

    override fun manualEditCompleted() {
        viewModel.saveCurrentCharacter()
    }

    companion object {
        // CHANGE GETITEMCOUNT IF ADDING SECTIONS
        const val TYPE_CHARACTER_NAME = 1
        const val TYPE_CHARACTER_DETAILS = 2
        const val TYPE_AC_INITIATIVE_SPEED = 3
        const val TYPE_CURRENT_HIT_POINT = 4
        const val TYPE_TEMP_HIT_POINTS = 5
        const val TYPE_HITDICE_DEATHSAVES = 6
        const val TYPE_INSPIRATION_PROFICIENCY = 7
        const val TYPE_STATS_TOP = 8
        const val TYPE_STATS_BOTTOM = 9
        const val TYPE_SAVING_THROWS = 10
        const val TYPE_SKILLS = 11
        const val TYPE_ATTACKS_SPELLS = 12
        const val TYPE_EQUIPMENT = 13
        const val TYPE_PROFICIENCIES_LANGUAGES = 14
        const val TYPE_PERSONALITY_TRAITS = 15
        const val TYPE_IDEALS = 16
        const val TYPE_BONDS = 17
        const val TYPE_FLAWS = 18
    }
}

class CharacterNameViewHolder(val binding: LayoutDetailsCharacterNameBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class CharacterDetailsViewHolder(val binding: LayoutDetailsCharacterDetailsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class ACInitiativeSpeedViewHolder(val binding: LayoutDetailsAcInitiativeSpeedBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class CurrentHitPointsViewHolder(val binding: LayoutDetailsCurrentHitPointsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class TempHitPointsViewHolder(val binding: LayoutDetailsTempHitPointsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class HitDiceDeathSavesViewHolder(val binding: LayoutDetailsHitdieDeathsavesBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class InspirationProficiency(val binding: LayoutDetailsInspirationProficiencyBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class StatsTopViewHolder(val binding: LayoutDetailsStatsTopBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class StatsBottomViewHolder(val binding: LayoutDetailsStatsBottomBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class SavingThrowsViewHolder(val binding: LayoutDetailsSavingThrowsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class SkillsViewHolder(val binding: LayoutDetailsSkillsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class AttackSpellsViewHolder(val binding: LayoutDetailsAttackSpellsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        val recyclerView = binding.attackSpellsRecyclerView
        val adapter = AttackSpellsAdapter(viewModel.currentCharacter.value!!.attackSpells, viewModel)
        recyclerView.adapter = adapter
    }
}

class EquipmentViewHolder(val binding: LayoutDetailsEquipmentBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class ProficienciesLanguagesViewHolder(val binding: LayoutDetailsProficienciesLanguagesBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class PersonalityTraitsViewHolder(val binding: LayoutDetailsPersonalityTraitsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class IdealsViewHolder(val binding: LayoutDetailsIdealsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class BondsViewHolder(val binding: LayoutDetailsBondsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}

class FlawsViewHolder(val binding: LayoutDetailsFlawsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        binding.setVariable(BR.viewModel, viewModel)
    }
}