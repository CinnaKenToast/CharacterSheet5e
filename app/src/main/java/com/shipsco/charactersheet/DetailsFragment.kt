package com.shipsco.charactersheet

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.shipsco.charactersheet.data.character.AttackSpell
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.data.character.blankCharacter
import com.shipsco.charactersheet.databinding.FragmentDetailsBinding
import com.shipsco.charactersheet.utils.toJsonString
import com.shipsco.charactersheet.views.AttackSpellsAdapter
import com.shipsco.charactersheet.views.CSTextView
import kotlinx.coroutines.runBlocking

class DetailsFragment : Fragment(), TextChangedEventListener {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var characterName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val factory = CharacterViewModelFactory(requireActivity().application)
//        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]
        characterViewModel = requireActivity().viewModels<CharacterViewModel>().value

        runBlocking {
            arguments?.let {
                val isNewCharacter = it.getBoolean("creatingCharacter")
                if (!isNewCharacter) {
                    characterName = it.getString("characterName")!!
                    currentCharacter = characterViewModel.getCharacter(characterName)
                } else {
                    currentCharacter = blankCharacter.copy()
                    characterViewModel.setCharacter(currentCharacter)
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        binding.viewModel = characterViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        initRecyclerView()
        println("----------------------- IN DETAILS")
    }

    override fun onPause() {
        super.onPause()
        characterViewModel.saveCurrentCharacter()
    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.saveButton -> {
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        characterViewModel.saveCharacter(currentCharacter)
                    }
                    true
                }
                R.id.exportButton -> {
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        val json = currentCharacter.toJsonString()
                        val clipboard = requireContext().getSystemService(Service.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("characterData", json)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "${currentCharacter.characterName}'s data has been copied to your clipboard", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                else -> {true}
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.attackSpellsRecyclerView
        val adapter = AttackSpellsAdapter(currentCharacter.attackSpells, characterViewModel)
        recyclerView.adapter = adapter
    }

    private fun getAttackSpells(): List<AttackSpell> {
        val list = mutableListOf<AttackSpell>()

        val recyclerView = binding.attackSpellsRecyclerView
        for (i in 0 until recyclerView.childCount) {
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(i)!! as AttackSpellsAdapter.ViewHolder
            list.add(
                viewHolder.getAttackSpell()
            )
        }
        return list
    }

    companion object {
        fun createInstance(creatingCharacter: Boolean, characterName: String) = DetailsFragment().apply {
            arguments = bundleOf(
                Pair("creatingCharacter", creatingCharacter),
                Pair("characterName", characterName)
            )
        }
    }

    override fun textChangedByDialog() {
        characterViewModel.saveCurrentCharacter()
    }
}