package com.example.mdtop

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.mdtop.databinding.FragmentBottomNavigationDrawerBinding

class BottomNavigationDrawerFragment : DialogFragment(R.layout.fragment_bottom_navigation_drawer) {
    private lateinit var binding: FragmentBottomNavigationDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBottomNavigationDrawerBinding.bind(view)

        binding.fragmentAppBarBottom.bottomAppBar.setNavigationOnClickListener {
            val fragment = ModalBottomSheetFragment()
            fragment.show(childFragmentManager.beginTransaction(), ModalBottomSheetFragment.TAG)
        }
    }
}