package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.mdtop.databinding.FragmentSheetsBottomBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class SheetsBottomFragment : Fragment() {

    private var _binding: FragmentSheetsBottomBinding? = null
    private val binding get() = _binding!!

    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var mIsExpanded : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSheetsBottomBinding.inflate(inflater, container, false)


        setupBottomSheetBehavior()

        setupListeners()

        return binding.root

    }

    private fun setupBottomSheetBehavior() {
        mBottomSheetBehavior = BottomSheetBehavior.from(binding.includeBottomSheet.bottomSheet)
        mBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        mBottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        mIsExpanded = true
                        binding.includeBottomSheet.btnResize.setImageDrawable(
                            ContextCompat.getDrawable(requireContext(), R.drawable.ic_expand_more)
                        )
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        mIsExpanded = false
                        binding.includeBottomSheet.btnResize.setImageDrawable(
                            ContextCompat.getDrawable(requireContext(), R.drawable.ic_expand_less)
                        )
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })
    }

    private fun setupListeners() {
        binding.btnStandar.setOnLongClickListener {
            mBottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            return@setOnLongClickListener true
        }

        binding.btnStandar.setOnClickListener {
            if (mBottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                mBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                mBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }

        }

        binding.includeBottomSheet.btnResize.setOnClickListener {
            if (mIsExpanded) {
                mBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                mBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val TAG = "SheetsBottomFragment"
    }


}