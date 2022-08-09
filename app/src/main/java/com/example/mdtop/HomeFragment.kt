package com.example.mdtop

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mdtop.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding = FragmentHomeBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        binding.btnCardView.setOnClickListener {
            Toast.makeText(context, "Pulsado carview", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.cardViewFragment2)
        }

        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.menuFragment)
        }
    }

}