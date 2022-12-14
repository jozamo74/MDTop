package com.example.mdtop

import android.os.Bundle
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
            findNavController().navigate(R.id.cardViewFragment)
        }

        binding.btnMenu.setOnClickListener {
            findNavController().navigate(R.id.menuFragment)
        }

        binding.btnDialog.setOnClickListener {
            findNavController().navigate(R.id.alertDialogFragment)
        }

        binding.btnAppBar.setOnClickListener {
            findNavController().navigate(R.id.appBarFragment)
        }

        binding.btnPicker.setOnClickListener {
            findNavController().navigate(R.id.pickerFragment) }

        binding.btnNavigationDrawable.setOnClickListener {
            findNavController().navigate(R.id.navigationDrawerFragment)
        }

        binding.btnSheetsBottom.setOnClickListener {
            findNavController().navigate(R.id.sheetsBottomFragment)
        }

        binding.btnMotion.setOnClickListener { findNavController().navigate(R.id.motionFragment) }

        binding.btnTextField.setOnClickListener { findNavController().navigate(R.id.textFieldsFragment) }


    }


}