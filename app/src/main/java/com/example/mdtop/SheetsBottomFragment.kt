package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mdtop.databinding.FragmentSheetsBottomBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class SheetsBottomFragment : Fragment() {

    private var _binding: FragmentSheetsBottomBinding? = null
    private val binding get() = _binding!!

    //private lateinit var mBottomSheetBehavior: BottomSheetBehavior

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSheetsBottomBinding.inflate(inflater, container, false)


        val mBottomSheetBehavior = BottomSheetBehavior.from(binding.includeBottomSheet.bottomSheet)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val TAG = "SheetsBottomFragment"
    }


}