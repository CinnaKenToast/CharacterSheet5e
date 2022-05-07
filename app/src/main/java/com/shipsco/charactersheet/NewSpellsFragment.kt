package com.shipsco.charactersheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.data.character.blankCharacter
import com.shipsco.charactersheet.databinding.FragmentNewSpellsBinding
import com.shipsco.charactersheet.utils.toJsonString
import com.shipsco.charactersheet.views.SpellsFragmentAdapter

class NewSpellsFragment : Fragment() {

    private lateinit var binding: FragmentNewSpellsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var characterName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val factory = CharacterViewModelFactory(requireActivity().application)
//        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]
        characterViewModel = requireActivity().viewModels<CharacterViewModel>().value
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewSpellsBinding.inflate(layoutInflater)
        currentCharacter = characterViewModel.currentCharacter.value ?: blankCharacter.copy()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        initRecyclerView()
        println("----------------------- IN SPELLS")
    }

    override fun onResume() {
        super.onResume()
        initMenuOptions()
        binding.spellsRecyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onPause() {
        super.onPause()
        characterViewModel.saveCurrentCharacter()
    }

    private fun initMenuOptions() {
        val lockButton = binding.toolbar.menu[0]
        if (currentCharacter.editingIsLocked) {
            lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock)
        } else {
            lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock_open)
        }
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.lockButton -> {
                    currentCharacter.editingIsLocked = !currentCharacter.editingIsLocked
                    characterViewModel.saveCurrentCharacter()
                    binding.spellsRecyclerView.adapter?.notifyDataSetChanged()
                    if (currentCharacter.editingIsLocked) {
                        lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock)
                    } else {
                        lockButton.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_lock_open)
                    }
                    true
                }
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
                        val share = Intent(Intent.ACTION_SEND)
                        share.type = "text/plain"
                        share.putExtra(Intent.EXTRA_TEXT, json)
                        val shareIntent = Intent.createChooser(share, "Export Character Data")
                        if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
                            startActivity(shareIntent)
                        }
                    }
                    true
                }
                else -> {true}
            }
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.spellsRecyclerView
        val adapter = SpellsFragmentAdapter(characterViewModel)
        recyclerView.adapter = adapter
    }
}