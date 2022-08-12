package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mdtop.databinding.FragmentDialogBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class AlertDialogFragment : Fragment(R.layout.fragment_dialog) {

    private lateinit var binding: FragmentDialogBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDialogBinding.bind(view)

        setupListener()
    }

    private fun setupListener() {
        with(binding){
            btnDialogInfo.setOnClickListener {
                dialogInfo()
            }
            btnDialogChoose.setOnClickListener { dialogChoose() }
            btnDialogConfirm.setOnClickListener { dialogConfirm() }
            btnDialogFullScreen.setOnClickListener { findNavController().navigate(R.id.fullScreenDialogFragment) }
        }
    }

    private fun dialogConfirm() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.dialog_confirm_title)
            .setMessage(R.string.card_message_demo_small)
            .setNegativeButton(R.string.dialog_cancel, null)
            .setPositiveButton(R.string.dialog_confirm) { _, _ ->
                Toast.makeText(context, R.string.message_action_success, Toast.LENGTH_SHORT).show()
            }
            .show()

    }

    private fun dialogChoose() {
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.select_dialog_item)
        adapter.add("Opcion 1")
        adapter.add("Opcion 2")
        adapter.add("Opcion 3")

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.elegir)
            .setAdapter(adapter) { _, i ->
                Toast.makeText(requireContext(), adapter.getItem(i), Toast.LENGTH_SHORT).show()
            }
            .show()



    }

    private fun dialogInfo() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.card_message_demo_small)
            .setPositiveButton(R.string.dialog_ok, null)
            .show()
    }
}