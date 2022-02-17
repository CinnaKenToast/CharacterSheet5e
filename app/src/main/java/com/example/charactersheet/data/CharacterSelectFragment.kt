package com.example.charactersheet.data

import android.os.Bundle
import android.transition.Visibility
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.charactersheet.CharacterViewModel
import com.example.charactersheet.DetailsFragment
import com.example.charactersheet.R
import com.example.charactersheet.databinding.FragmentCharacterSelectBinding
import com.example.charactersheet.databinding.FragmentDetailsBinding
import com.example.charactersheet.views.CharacterSelectAdapter

class CharacterSelectFragment : Fragment() {

    private lateinit var binding: FragmentCharacterSelectBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var allCharacters: List<Character>

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
        initMenuOptions()

        allCharacters = characterViewModel.getCharacters()

        if (allCharacters.isEmpty()) {
            binding.addCharacterPrompt.visibility = View.VISIBLE
        } else {
            initRecyclerView()
            binding.characterSelectRecycyler.visibility = View.VISIBLE
        }

        binding.fab.setOnClickListener {
            val bundle = bundleOf(
                Pair("creatingCharacter", true)
            )
            findNavController().navigate(R.id.action_characterSelectFragment_to_detailsFragment, bundle)
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.characterSelectRecycyler
        val adapter = CharacterSelectAdapter(allCharacters, findNavController())
        recyclerView.adapter = adapter
    }

    private fun initMenuOptions() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.importButton -> {
                    Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {true}
            }
        }
    }
}