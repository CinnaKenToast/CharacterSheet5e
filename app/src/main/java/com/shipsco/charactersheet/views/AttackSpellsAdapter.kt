package com.shipsco.charactersheet.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shipsco.charactersheet.BR
import com.shipsco.charactersheet.CharacterViewModel
import com.shipsco.charactersheet.data.character.AttackSpell
import com.shipsco.charactersheet.databinding.LayoutAttackSpellRecyclerViewBinding

class AttackSpellsAdapter(private val attackSpells: MutableList<AttackSpell>, val viewModel: CharacterViewModel):
    RecyclerView.Adapter<AttackSpellsAdapter.ViewHolder>() {

    lateinit var binding: LayoutAttackSpellRecyclerViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = LayoutAttackSpellRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemCount(): Int {
        return attackSpells.size
    }

    class ViewHolder(val binding: LayoutAttackSpellRecyclerViewBinding): RecyclerView.ViewHolder(binding.root) {
        val nameEditText: CSTextView = binding.spellAttackName
        val bonusEditText: CSTextView = binding.spellAttackBonus
        val damageTypeEditText: CSTextView = binding.spellAttackType

        fun getAttackSpell(): AttackSpell {
            return AttackSpell(
                nameEditText.text.toString(), bonusEditText.text.toString(), damageTypeEditText.text.toString()
            )
        }

        fun bind(viewModel: CharacterViewModel, position: Int) {
            binding.setVariable(BR.viewModel, viewModel)
            binding.setVariable(BR.position, position)
        }
    }
}