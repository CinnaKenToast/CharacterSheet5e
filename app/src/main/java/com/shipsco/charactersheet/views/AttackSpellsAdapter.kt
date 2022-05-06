package com.shipsco.charactersheet.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shipsco.charactersheet.CharacterViewModel
import com.shipsco.charactersheet.ManualEditListener
import com.shipsco.charactersheet.data.character.AttackSpell
import com.shipsco.charactersheet.databinding.LayoutAttackSpellRecyclerViewBinding

class AttackSpellsAdapter(private val attackSpells: MutableList<AttackSpell>, val viewModel: CharacterViewModel):
    RecyclerView.Adapter<AttackSpellsAdapter.ViewHolder>() {

    lateinit var binding: LayoutAttackSpellRecyclerViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = LayoutAttackSpellRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.spellAttackName.eventListener = viewModel
        binding.spellAttackBonus.eventListener = viewModel
        binding.spellAttackType.eventListener = viewModel
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemCount(): Int {
        return attackSpells.size
    }

    class ViewHolder(val binding: LayoutAttackSpellRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: CharacterViewModel, position: Int) {
//            binding.setVariable(BR.viewModel, viewModel)
//            binding.setVariable(BR.position, position)
            binding.spellAttackName.text = viewModel.currentCharacter.value?.attackSpells?.get(position)?.name
                ?: ""
            binding.spellAttackBonus.text = viewModel.currentCharacter.value?.attackSpells?.get(position)?.attackBonus
                ?: ""
            binding.spellAttackType.text = viewModel.currentCharacter.value?.attackSpells?.get(position)?.damageType
                ?: ""
            binding.spellAttackName.tag = "AttackName-$position"
            binding.spellAttackBonus.tag = "AttackBonus-$position"
            binding.spellAttackType.tag = "AttackType-$position"
        }
    }

//    override fun manualEditCompleted(view: View) {
//        viewModel.saveCurrentCharacter()
//    }
}