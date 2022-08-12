package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mdtop.databinding.FragmentPickerBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar

class PickerFragment : Fragment(R.layout.fragment_picker) {

    private lateinit var binding: FragmentPickerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPickerBinding.bind(view)

        setupListener()
    }

    private fun setupListener() {

        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText(R.string.picker_title)
        builder.setSelection(System.currentTimeMillis())

        with(binding){
            btnDialog.setOnClickListener {
                builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar)
                showPicker(builder)

            }
            btnDialogFullScreen.setOnClickListener {
                builder.setTheme(com.google.android.material.R.style.ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen)
                showPicker(builder)
            }
        }

    }

    private fun showPicker(builder: MaterialDatePicker.Builder<Long>) {
        val picker = builder.build()
        picker.show(parentFragmentManager, picker.toString())

        picker.addOnPositiveButtonClickListener {
            Snackbar.make(binding.root, picker.headerText, Snackbar.LENGTH_SHORT).show()
        }

        picker.addOnNegativeButtonClickListener {
            Snackbar.make(binding.root, R.string.dialog_negative, Snackbar.LENGTH_SHORT).show()
        }

        picker.addOnCancelListener {
            Snackbar.make(binding.root, R.string.dialog_cancel, Snackbar.LENGTH_SHORT).show()
        }

    }

}