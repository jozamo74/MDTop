package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.mdtop.databinding.FragmentAppBarBinding

class AppBarFragment : Fragment(R.layout.fragment_app_bar) {

    private lateinit var binding: FragmentAppBarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAppBarBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        setingListener()
    }

    private fun setingListener() {
        with(binding){
            btnTop.setOnClickListener { findNavController().navigate(R.id.appBarTopFragment) }
            btnBottom.setOnClickListener { findNavController().navigate(R.id.appBarBottomFragment) }
        }
    }
}