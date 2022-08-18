package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.mdtop.databinding.FragmentNavigationDrawerBinding

class NavigationDrawerFragment : Fragment(R.layout.fragment_navigation_drawer) {

    private lateinit var binding: FragmentNavigationDrawerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNavigationDrawerBinding.bind(view)

        setupListener()
    }

    private fun setupListener() {
        with(binding){
            btnModal.setOnClickListener { findNavController().navigate(R.id.modalNavigationDrawerFragment) }
            btnBottom.setOnClickListener { findNavController().navigate(R.id.bottomNavigationDrawerFragment) }
        }
    }

}