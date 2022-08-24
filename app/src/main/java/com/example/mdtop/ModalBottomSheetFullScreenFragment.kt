package com.example.mdtop

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.transition.TransitionManager
import com.example.mdtop.databinding.FragmentModalBottomSheetFullScreenBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.SlideDistanceProvider


class ModalBottomSheetFullScreenFragment : BottomSheetDialogFragment() {


    private var _binding: FragmentModalBottomSheetFullScreenBinding? = null
    private val binding  get() = _binding!!

    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<View>

    private lateinit var mBottomSheetDialog: BottomSheetDialog



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentModalBottomSheetFullScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        mBottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog


        mBottomSheetDialog.setOnShowListener {
            val dialogI = it as BottomSheetDialog

            val sheet = dialogI.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)

            //mBottomSheetBehavior.isHideable = false

            binding.vExtraSpace.minimumHeight = Resources.getSystem().displayMetrics.heightPixels / 5

            mBottomSheetBehavior = BottomSheetBehavior.from(sheet!!)
            mBottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED

            mBottomSheetBehavior.addBottomSheetCallback(object :
                BottomSheetBehavior.BottomSheetCallback(){

                override fun onStateChanged(bottomSheet: View, newState: Int) {

                    val mMaterialFadeThrough = MaterialFadeThrough()
                    mMaterialFadeThrough.secondaryAnimatorProvider = SlideDistanceProvider(Gravity.TOP)
                    mMaterialFadeThrough.duration = 250L

                    TransitionManager.beginDelayedTransition(binding.containerBar, mMaterialFadeThrough)

                    var statusBarColor = ContextCompat.getColor(requireContext(), R.color.purple_700)

                    if (BottomSheetBehavior.STATE_EXPANDED == newState) {
                        Log.d("HOLA", "EXPANDED $newState")
                        with(binding){
                            tvBar.visibility = View.GONE
                            appBar.visibility = View.VISIBLE
                            statusBarColor = ContextCompat.getColor(requireContext(), R.color.colorAccent)
                        }
                    } else {
                        Log.d("HOLA", "COLAPSANDO: $newState")
                        with(binding){
                            appBar.visibility = View.GONE
                            tvBar.visibility = View.VISIBLE
                        }
                    }

                    requireActivity().window.statusBarColor = statusBarColor
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }

            })

            binding.btnCancel.setOnClickListener {
                mBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }

        }

        return mBottomSheetDialog


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.purple_700)
    }

    companion object {
            const val TAG = "ModalBottomSheetFullScreenFragment"
    }
}