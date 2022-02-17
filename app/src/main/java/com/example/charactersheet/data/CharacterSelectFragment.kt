package com.example.charactersheet.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.charactersheet.CharacterViewModel
import com.example.charactersheet.R
import com.example.charactersheet.databinding.FragmentCharacterSelectBinding
import com.example.charactersheet.databinding.FragmentDetailsBinding

class CharacterSelectFragment : Fragment() {

    private lateinit var binding: FragmentCharacterSelectBinding
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
        binding = FragmentCharacterSelectBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            val bundle = bundleOf(
                Pair("creatingCharacter", true)
            )
            findNavController().navigate(R.id.action_characterSelectFragment_to_detailsFragment, bundle)
        }
    }
}