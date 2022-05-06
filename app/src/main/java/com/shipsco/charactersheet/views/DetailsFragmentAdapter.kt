package com.shipsco.charactersheet.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shipsco.charactersheet.CharacterViewModel
import com.shipsco.charactersheet.ManualEditListener
import com.shipsco.charactersheet.data.character.blankAttackSpell
import com.shipsco.charactersheet.databinding.*

class DetailsFragmentAdapter(val viewModel: CharacterViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>(), ManualEditListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_CHARACTER_NAME -> {
                val binding = LayoutDetailsCharacterNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.characterName.eventListener = this
                return CharacterNameViewHolder(binding)
            }
            TYPE_CHARACTER_DETAILS -> {
                val binding = LayoutDetailsCharacterDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.classLevel.eventListener = this
//                binding.characterBackground.eventListener = this
//                binding.playerName.eventListener = this
//                binding.characterRace.eventListener = this
//                binding.characterAlignment.eventListener = this
//                binding.experiencePoints.eventListener = this
                return CharacterDetailsViewHolder(binding)
            }
            TYPE_AC_INITIATIVE_SPEED -> {
                val binding = LayoutDetailsAcInitiativeSpeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.armorClass.eventListener = this
//                binding.initiative.eventListener = this
//                binding.speed.eventListener = this
                return ACInitiativeSpeedViewHolder(binding)
            }
            TYPE_CURRENT_HIT_POINT -> {
                val binding = LayoutDetailsCurrentHitPointsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.hitPointMax.eventListener = this
//                binding.currentHitPoints.eventListener = this
                return CurrentHitPointsViewHolder(binding)
            }
            TYPE_TEMP_HIT_POINTS -> {
                val binding = LayoutDetailsTempHitPointsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.tempHitPoints.eventListener = this
                return TempHitPointsViewHolder(binding)
            }
            TYPE_HITDICE_DEATHSAVES -> {
                val binding = LayoutDetailsHitdieDeathsavesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.totalHitDice.eventListener = this
//                binding.hitDice.eventListener = this
//                binding.successSaveButton1.eventListener = this
//                binding.successSaveButton2.eventListener = this
//                binding.successSaveButton3.eventListener = this
//                binding.failSaveButton1.eventListener = this
//                binding.failSaveButton2.eventListener = this
//                binding.failSaveButton3.eventListener = this
                return HitDiceDeathSavesViewHolder(binding)
            }
            TYPE_INSPIRATION_PROFICIENCY -> {
                val binding = LayoutDetailsInspirationProficiencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.inspirationChecked.eventListener = this
//                binding.proficiencyBonus.eventListener = this
                return InspirationProficiency(binding)
            }
            TYPE_STATS_TOP -> {
                val binding = LayoutDetailsStatsTopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.strength.eventListener = this
//                binding.strengthBonus.eventListener = this
//                binding.constitution.eventListener = this
//                binding.constitutionBonus.eventListener = this
//                binding.dexterity.eventListener = this
//                binding.dexterityBonus.eventListener = this
                return StatsTopViewHolder(binding)
            }
            TYPE_STATS_BOTTOM -> {
                val binding = LayoutDetailsStatsBottomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.intelligence.eventListener = this
//                binding.intelligenceBonus.eventListener = this
//                binding.wisdom.eventListener = this
//                binding.wisdomBonus.eventListener = this
//                binding.charisma.eventListener = this
//                binding.charismaBonus.eventListener = this
                return StatsBottomViewHolder(binding)
            }
            TYPE_SAVING_THROWS -> {
                val binding = LayoutDetailsSavingThrowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.strengthSaveButton.eventListener = this
//                binding.strengthSave.eventListener = this
//                binding.charismaSaveButton.eventListener = this
//                binding.constitutionSave.eventListener = this
//                binding.dexteritySaveButton.eventListener = this
//                binding.dexteritySave.eventListener = this
//                binding.intelligenceSaveButton.eventListener = this
//                binding.intelligenceSave.eventListener = this
//                binding.wisdomSaveButton.eventListener = this
//                binding.wisdomSave.eventListener = this
//                binding.charismaSaveButton.eventListener = this
//                binding.charismaSave.eventListener = this
                return SavingThrowsViewHolder(binding)
            }
            TYPE_SKILLS -> {
                val binding = LayoutDetailsSkillsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.acrobaticsButton.eventListener = this
//                binding.acrobatics.eventListener = this
//                binding.animalHandlingButton.eventListener = this
//                binding.animalHandling.eventListener = this
//                binding.arcanaButton.eventListener = this
//                binding.arcana.eventListener = this
//                binding.athleticsButton.eventListener = this
//                binding.athletics.eventListener = this
//                binding.deceptionButton.eventListener = this
//                binding.deception.eventListener = this
//                binding.historyButton.eventListener = this
//                binding.history.eventListener = this
//                binding.insightButton.eventListener = this
//                binding.insight.eventListener = this
//                binding.intimidationButton.eventListener = this
//                binding.intimidation.eventListener = this
//                binding.investigationButton.eventListener = this
//                binding.investigation.eventListener = this
//                binding.medicineButton.eventListener = this
//                binding.medicine.eventListener = this
//                binding.natureButton.eventListener = this
//                binding.nature.eventListener = this
//                binding.perceptionButton.eventListener = this
//                binding.perception.eventListener = this
//                binding.performanceButton.eventListener = this
//                binding.performance.eventListener = this
//                binding.persuasionButton.eventListener = this
//                binding.persuasion.eventListener = this
//                binding.religionButton.eventListener = this
//                binding.religion.eventListener = this
//                binding.sleightOfHandButton.eventListener = this
//                binding.sleightOfHand.eventListener = this
//                binding.stealthButton.eventListener = this
//                binding.stealth.eventListener = this
//                binding.survivalButton.eventListener = this
//                binding.survival.eventListener = this
                return SkillsViewHolder(binding)
            }
            TYPE_ATTACKS_SPELLS -> {
                val binding = LayoutDetailsAttackSpellsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return AttackSpellsViewHolder(binding)
            }
            TYPE_EQUIPMENT -> {
                val binding = LayoutDetailsEquipmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.copperPieces.eventListener = this
//                binding.silverPieces.eventListener = this
//                binding.electrumPieces.eventListener = this
//                binding.goldPieces.eventListener = this
//                binding.platinumPieces.eventListener = this
//                binding.equipment.eventListener = this
                return EquipmentViewHolder(binding)
            }
            TYPE_PROFICIENCIES_LANGUAGES -> {
                val binding = LayoutDetailsProficienciesLanguagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.proficienciesLanguages.eventListener = this
                return ProficienciesLanguagesViewHolder(binding)
            }
            TYPE_PERSONALITY_TRAITS -> {
                val binding = LayoutDetailsPersonalityTraitsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.personalityTraits.eventListener = this
                return PersonalityTraitsViewHolder(binding)
            }
            TYPE_IDEALS -> {
                val binding = LayoutDetailsIdealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.ideals.eventListener = this
                return IdealsViewHolder(binding)
            }
            TYPE_BONDS -> {
                val binding = LayoutDetailsBondsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.bonds.eventListener = this
                return BondsViewHolder(binding)
            }
            else -> { // TYPE_FLAWS
                val binding = LayoutDetailsFlawsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//                binding.flaws.eventListener = this
                return FlawsViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
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

    override fun manualEditCompleted(view: View) {
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
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class CharacterDetailsViewHolder(val binding: LayoutDetailsCharacterDetailsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class ACInitiativeSpeedViewHolder(val binding: LayoutDetailsAcInitiativeSpeedBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class CurrentHitPointsViewHolder(val binding: LayoutDetailsCurrentHitPointsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class TempHitPointsViewHolder(val binding: LayoutDetailsTempHitPointsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class HitDiceDeathSavesViewHolder(val binding: LayoutDetailsHitdieDeathsavesBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class InspirationProficiency(val binding: LayoutDetailsInspirationProficiencyBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class StatsTopViewHolder(val binding: LayoutDetailsStatsTopBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class StatsBottomViewHolder(val binding: LayoutDetailsStatsBottomBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class SavingThrowsViewHolder(val binding: LayoutDetailsSavingThrowsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class SkillsViewHolder(val binding: LayoutDetailsSkillsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class AttackSpellsViewHolder(val binding: LayoutDetailsAttackSpellsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
        val recyclerView = binding.attackSpellsRecyclerView
        val adapter = AttackSpellsAdapter(viewModel.currentCharacter.value?.attackSpells ?: blankAttackSpell, viewModel)
        recyclerView.adapter = adapter
    }
}

class EquipmentViewHolder(val binding: LayoutDetailsEquipmentBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class ProficienciesLanguagesViewHolder(val binding: LayoutDetailsProficienciesLanguagesBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class PersonalityTraitsViewHolder(val binding: LayoutDetailsPersonalityTraitsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class IdealsViewHolder(val binding: LayoutDetailsIdealsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class BondsViewHolder(val binding: LayoutDetailsBondsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}

class FlawsViewHolder(val binding: LayoutDetailsFlawsBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: CharacterViewModel) {
//        binding.setVariable(BR.viewModel, viewModel)
    }
}