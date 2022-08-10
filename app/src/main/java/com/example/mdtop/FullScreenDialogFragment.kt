package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mdtop.databinding.FragmentFullScreenDialogBinding


class FullScreenDialogFragment : DialogFragment(R.layout.fragment_full_screen_dialog) {

    private lateinit var binding: FragmentFullScreenDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_screen_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFullScreenDialogBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()

        setupBtnSave()
    }

    private fun setupBtnSave() {
        binding.btnSave.setOnClickListener {
            Toast.makeText(context, "Pulsado botón guardar", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    private fun setupToolbar() {
        with(binding.toolbar) {
            setTitle(R.string.dialog_full_screen)
            setNavigationIcon(R.drawable.ic_close)
            setNavigationOnClickListener { dismiss() }
        }
    }

    companion object {
        val TAG = "FullScreenDialogFragment"
    }
}