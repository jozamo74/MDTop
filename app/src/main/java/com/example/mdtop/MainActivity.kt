package com.example.mdtop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mdtop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment
        //val navController = navHostFragment.navController
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId)  {
            R.id.action_start -> {
                Toast.makeText(this, "Pulsado Incio", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_favorites -> {
                Toast.makeText(this, "Pulsado Favoritos", Toast.LENGTH_SHORT).show()

                true
            }
            R.id.action_profile -> {
                Toast.makeText(this, "Pulsado Perfil", Toast.LENGTH_SHORT).show()

                true
            }
            else -> super.onOptionsItemSelected(item)


        }
    }


}