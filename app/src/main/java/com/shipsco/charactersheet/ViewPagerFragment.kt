package com.shipsco.charactersheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.shipsco.charactersheet.data.character.Character
import com.shipsco.charactersheet.data.character.blankCharacter
import com.shipsco.charactersheet.databinding.FragmentViewPagerBinding
import kotlinx.coroutines.runBlocking

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var currentCharacter: Character
    private var creatingCharacter = false
    private var characterName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        characterViewModel = requireActivity().viewModels<CharacterViewModel>().value

        arguments?.let {
            creatingCharacter = it.getBoolean("creatingCharacter")
            characterName = it.getString("characterName")!!
        }

        characterViewModel = requireActivity().viewModels<CharacterViewModel>().value
        runBlocking {
            arguments?.let {
                val isNewCharacter = it.getBoolean("creatingCharacter")
                if (!isNewCharacter) {
                    characterName = it.getString("characterName")!!
                    characterViewModel.getCharacter(characterName)
                } else {
                    characterViewModel.setCharacter(blankCharacter.copy())
                }

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)

        val fragmentList = listOf(DetailsFragment(), NewSpellsFragment(), MiscFragment())
        binding.viewPager.adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.offscreenPageLimit = 1
        return binding.root
    }

}