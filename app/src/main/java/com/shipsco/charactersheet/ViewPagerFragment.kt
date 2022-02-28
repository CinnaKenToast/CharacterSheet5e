package com.shipsco.charactersheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shipsco.charactersheet.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private var creatingCharacter = false
    private var characterName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            creatingCharacter = it.getBoolean("creatingCharacter")
            characterName = it.getString("characterName")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)

        val fragmentList = listOf(DetailsFragment.createInstance(creatingCharacter, characterName), SpellsFragment.createInstance(creatingCharacter, characterName))
        binding.viewPager.adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        return binding.root
    }

}