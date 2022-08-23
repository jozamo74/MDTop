package com.example.mdtop

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.transition.TransitionManager
import com.example.mdtop.databinding.FragmentMotionBinding
import com.google.android.material.transition.MaterialArcMotion
import com.google.android.material.transition.MaterialContainerTransform


class MotionFragment : Fragment(R.layout.fragment_motion) {

    private lateinit var binding: FragmentMotionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMotionBinding.bind(view)

        setupListener()
    }

    private fun setupListener() {

        val transform = MaterialContainerTransform()
        transform.scrimColor = Color.TRANSPARENT
        transform.duration = 500L

        binding.btnCancel.setOnClickListener {
            with(binding) {

                transform.startView = viewEnd
                transform.endView = viewStart
                transform.addTarget(viewStart)

                TransitionManager.beginDelayedTransition(containerMain, transform)

                viewStart.visibility = View.VISIBLE
                viewEnd.visibility = View.GONE
            }
        }

        binding.viewStart.setOnClickListener {
            transform.setPathMotion(MaterialArcMotion())
            transform.startView = binding.viewStart
            transform.endView = binding.viewEnd
            transform.addTarget(binding.viewEnd)

            TransitionManager.beginDelayedTransition(binding.containerMain, transform)
            with(binding){
                viewStart.visibility = View.GONE
                viewEnd.visibility = View.VISIBLE
            }
        }
    }

}