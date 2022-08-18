package com.example.mdtop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.DialogFragment
import com.example.mdtop.databinding.FragmentModalNavigationDrawerBinding
import com.google.android.material.navigation.NavigationView

class ModalNavigationDrawerFragment : DialogFragment(R.layout.fragment_modal_navigation_drawer),
NavigationView.OnNavigationItemSelectedListener{

    private lateinit var binding: FragmentModalNavigationDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modal_navigation_drawer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentModalNavigationDrawerBinding.bind(view)

        val activity = activity as AppCompatActivity

        if (activity.actionBar != null) {
            activity.setSupportActionBar(binding.toolbar)
        }

        val toggle  = ActionBarDrawerToggle(activity, binding.drawerLayout, binding.toolbar, R.string.dialog_ok, R.string.dialog_cancel)

        binding.drawerLayout.addDrawerListener(toggle)

        binding.navMain.setNavigationItemSelectedListener(this)

//        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        activity.supportActionBar?.setHomeButtonEnabled(true)

        //toggle.syncState() por mostrar el icono menu en negro

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.action_cancel -> {}
           R.id.action_app_bar_bottom -> {
               val bottomFragment = AppBarBottomFragment()
               bottomFragment.show(childFragmentManager, AppBarBottomFragment.TAG)
           }
           else -> {
               val msg = item.title.toString()
               Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()

           }

       }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}