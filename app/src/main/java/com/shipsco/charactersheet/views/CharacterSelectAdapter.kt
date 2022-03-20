package com.shipsco.charactersheet.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.shipsco.charactersheet.R
import com.shipsco.charactersheet.data.character.Character

class CharacterSelectAdapter(var characters: List<Character>, private val navController: NavController):
    RecyclerView.Adapter<CharacterSelectAdapter.ViewHolder>() {

    private lateinit var context: Context
    private var currentPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.layout_character_select_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameEditText.text = characters[position].characterName
        holder.classEditText.text = characters[position].classLevel
        holder.raceEditText.text = characters[position].race
        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                Pair("creatingCharacter", false),
                Pair("characterName", characters[position].characterName)
            )
            navController.navigate(R.id.action_characterSelectFragment_to_viewPagerFragment, bundle)
        }
        holder.itemView.setOnLongClickListener {
            currentPosition = holder.adapterPosition
            false
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun getSelectedCharacter(): Character? {
        if (currentPosition >= 0 && !characters.isNullOrEmpty() && currentPosition <= itemCount) {
            return characters[currentPosition]
        }
        return null
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameEditText: TextView = view.findViewById(R.id.characterName)
        val classEditText: TextView = view.findViewById(R.id.characterClass)
        val raceEditText: TextView = view.findViewById(R.id.characterRace)
    }
}