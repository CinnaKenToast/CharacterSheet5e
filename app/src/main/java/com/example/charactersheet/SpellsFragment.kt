package com.example.charactersheet

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.data.character.blankCharacter
import com.example.charactersheet.databinding.FragmentSpellsBinding
import com.example.charactersheet.utils.toJsonString
import kotlinx.coroutines.runBlocking

class SpellsFragment : Fragment() {

    private lateinit var binding: FragmentSpellsBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character

    private lateinit var characterName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = CharacterViewModelFactory(requireActivity().application)
        characterViewModel = ViewModelProvider(this, factory)[CharacterViewModel::class.java]

        runBlocking {
            arguments?.let {
                val isNewCharacter = it.getBoolean("creatingCharacter")
                if (!isNewCharacter) {
                    characterName = it.getString("characterName")!!
                    currentCharacter = characterViewModel.getCharacter(characterName)
                } else {
                    currentCharacter = blankCharacter.copy()
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpellsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuOptions()
        if (this::currentCharacter.isInitialized) {
            initializeFields()
        }
    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.saveButton -> {
//                    updateCharacter()
                    if (currentCharacter.characterName.isBlank()) {
                        characterViewModel.saveCharacter(currentCharacter)
                    }
                    true
                }
                R.id.exportButton -> {
//                    updateCharacter()
                    if (currentCharacter.characterName.isBlank()) {
                        Toast.makeText(context, "Your character must have a name", Toast.LENGTH_SHORT).show()
                    } else {
                        val json = currentCharacter.toJsonString()
                        val clipboard = requireContext().getSystemService(Service.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("characterSpellsData", json)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "${currentCharacter.characterName}'s data has been copied to your clipboard", Toast.LENGTH_SHORT).show()
                    }
                    true
                }
                else -> {true}
            }
        }
    }

    private fun initializeFields() {

    }

    companion object {
        fun createInstance(creatingCharacter: Boolean, characterName: String) = SpellsFragment().apply {
                arguments = bundleOf(
                    Pair("creatingCharacter", creatingCharacter),
                    Pair("characterName", characterName)
                )
            }
    }
}