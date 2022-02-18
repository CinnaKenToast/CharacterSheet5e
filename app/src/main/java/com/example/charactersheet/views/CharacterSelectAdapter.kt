package com.example.charactersheet.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.charactersheet.R
import com.example.charactersheet.data.Character

class CharacterSelectAdapter(private val characters: List<Character>, private val navController: NavController):
    RecyclerView.Adapter<CharacterSelectAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_character_select_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameEditText.setText(characters[position].characterName)
        holder.classEditText.setText(characters[position].classLevel)
        holder.raceEditText.setText(characters[position].race)
        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                Pair("creatingCharacter", false),
                Pair("characterName", characters[position].characterName)
            )
            navController.navigate(R.id.action_characterSelectFragment_to_detailsFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameEditText: TextView = view.findViewById(R.id.characterName)
        val classEditText: TextView = view.findViewById(R.id.characterClass)
        val raceEditText: TextView = view.findViewById(R.id.characterRace)
    }
}