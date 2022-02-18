package com.example.charactersheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactersheet.data.character.Character
import com.example.charactersheet.databinding.FragmentImportDialogBinding
import com.example.charactersheet.utils.fromJsonString

class ImportDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentImportDialogBinding
    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        characterViewModel = activity?.let {
            ViewModelProvider(it)[CharacterViewModel::class.java]
        } ?: throw Exception("Activity is null")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentImportDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelImport.setOnClickListener {
            dismiss()
        }
        binding.importCharacter.setOnClickListener {
            val newCharacterData = binding.importCharacterData.text.toString()
            if (binding.importCharacterData.text.toString().isNotEmpty()) {
                val newCharacter = newCharacterData.fromJsonString<Character>()
                characterViewModel.saveCharacter(newCharacter)
                dismiss()
                requireActivity()
            } else {
                Toast.makeText(requireContext(), "Character data cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface CharacterAddedInterface {
        fun characterAdded(newCharacter: Character)
    }
}