package com.example.charactersheet.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.charactersheet.R
import com.example.charactersheet.data.character.AttackSpell
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.databinding.LayoutAttackSpellRecyclerViewBinding

class AttackSpellsAdapter(private val attackSpells: MutableList<AttackSpell>):
    RecyclerView.Adapter<AttackSpellsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutAttackSpellRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameEditText.text = holder.binding.viewModel?.currentCharacter?.value?.attackSpells?.get(position)?.name
            ?: ""
        holder.bonusEditText.text = holder.binding.viewModel?.currentCharacter?.value?.attackSpells?.get(position)?.attackBonus
            ?: ""
        holder.damageTypeEditText.text = holder.binding.viewModel?.currentCharacter?.value?.attackSpells?.get(position)?.damageType
            ?: ""
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
    }
}