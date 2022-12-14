package com.example.mdtop

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import android.widget.PopupMenu
import android.widget.Toast
import com.example.mdtop.databinding.FragmentMenuBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding = FragmentMenuBinding.bind(view)

        super.onViewCreated(view, savedInstanceState)

        setupListener()

        val courses = listOf(
            "Experto en Firebase para android +MVP Curso completo +30Hrs",
            "Material Design/theming Profesional pra Android",
            "Kotlin 2020"
        )

        val adapter = ArrayAdapter(requireContext(), R.layout.item_menu_dropdonw, courses)
        binding.actvCourses.setAdapter(adapter)
    }

    private fun setupListener() {
        binding.btnMenuPopup.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), it)
            val inflater: MenuInflater = popupMenu.menuInflater
            inflater.inflate(R.menu.menu, popupMenu.menu)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_start -> {
                        Toast.makeText(requireContext(), "Pulsado inicio", Toast.LENGTH_SHORT).show()

                    }
                    R.id.action_favorites -> {
                        Toast.makeText(requireContext(), "Pulsado favortitos", Toast.LENGTH_SHORT).show()

                    }

                    R.id.action_profile -> {
                        Toast.makeText(requireContext(), "Pulsado perfil", Toast.LENGTH_SHORT).show()

                    }
                }
                true
            }

        }
    }
}