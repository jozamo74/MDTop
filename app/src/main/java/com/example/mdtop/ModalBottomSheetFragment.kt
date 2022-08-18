package com.example.mdtop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mdtop.databinding.FragmentModalBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView

class ModalBottomSheetFragment : BottomSheetDialogFragment(),
    NavigationView.OnNavigationItemSelectedListener {
    private var _binding: FragmentModalBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentModalBottomSheetBinding.inflate(inflater, container, false)

        binding.navBottom.setNavigationItemSelectedListener(this)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val TAG = "ModalBottomSheetFragment"
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_cancel -> {}
            R.id.action_full_sreen_dialog -> {
                val fragment = FullScreenDialogFragment()
                fragment.show(parentFragmentManager.beginTransaction(), FullScreenDialogFragment.TAG)
            }
            else -> {
                val smg = item.title.toString()
                Toast.makeText(requireActivity(), smg, Toast.LENGTH_SHORT).show()
            }
        }
        dismiss()
        return true
    }


}