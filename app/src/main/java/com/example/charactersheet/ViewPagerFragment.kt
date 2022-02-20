package com.example.charactersheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charactersheet.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)

        val fragmentList = listOf(DetailsFragment(), SpellsFragment())
        binding.viewPager.adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        return binding.root
    }

}