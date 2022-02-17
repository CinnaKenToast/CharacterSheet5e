package com.example.charactersheet.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.charactersheet.R
import com.example.charactersheet.data.AttackSpell

class AttackSpellsAdapter(private val attackSpells: MutableList<AttackSpell>):
    RecyclerView.Adapter<AttackSpellsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_attack_spell_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameEditText.setText(attackSpells[position].name)
        holder.bonusEditText.setText(attackSpells[position].attackBonus)
        holder.damageTypeEditText.setText(attackSpells[position].damageType)
    }

    override fun getItemCount(): Int {
        return attackSpells.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameEditText: CSEditText = view.findViewById(R.id.spellAttackName)
        val bonusEditText: CSEditText = view.findViewById(R.id.spellAttackBonus)
        val damageTypeEditText: CSEditText = view.findViewById(R.id.spellAttackType)
    }
}