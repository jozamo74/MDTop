package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mdtop.databinding.FragmentAppBarBottomBinding
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_END
import com.google.android.material.snackbar.Snackbar


class AppBarBottomFragment : DialogFragment(R.layout.fragment_app_bar_bottom) {
    private lateinit var binding: FragmentAppBarBottomBinding

    private var isCentered: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAppBarBottomBinding.bind(view)

        binding.fab.setOnClickListener {
            if (isCentered) {
                binding.bottomAppBar.fabAlignmentMode = FAB_ALIGNMENT_MODE_END
            } else {
                binding.bottomAppBar.fabAlignmentMode = FAB_ALIGNMENT_MODE_CENTER
            }

            isCentered = !isCentered
        }

        binding.bottomAppBar.setOnMenuItemClickListener {

            val resMessage = when(it.itemId) {
                R.id.action_profile -> {
                    R.string.perfil
                }
                R.id.action_start -> {
                    R.string.inicio
                }
                else -> {
                    R.string.favoritos
                }
            }
            Snackbar.make(binding.root, resMessage, Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.fab)
                .show()
            true

        }

        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(binding.root, R.string.message_action_success, Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.fab)
                .show()
        }
    }

    companion object {
        val TAG = "appbarbottom"
    }
}