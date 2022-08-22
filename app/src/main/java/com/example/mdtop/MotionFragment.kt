package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mdtop.databinding.FragmentMotionBinding


class MotionFragment : Fragment(R.layout.fragment_motion) {

    private lateinit var binding: FragmentMotionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMotionBinding.bind(view)
    }

}