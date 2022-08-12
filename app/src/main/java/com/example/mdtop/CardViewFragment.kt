package com.example.mdtop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mdtop.databinding.FragmentCardViewBinding


class CardViewFragment : Fragment(R.layout.fragment_card_view) {


  private lateinit var binding: FragmentCardViewBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding = FragmentCardViewBinding.bind(view)

        super.onViewCreated(view, savedInstanceState)
        val url = "https://cdn.pixabay.com/photo/2017/12/10/14/47/pizza-3010062_960_720.jpg"
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageCardLarge)

        setupListener()

    }

    private fun setupListener() {
        with(binding){
            chipFirst.setOnClickListener {
                Toast.makeText(context, "Pulsado chip primero", Toast.LENGTH_SHORT).show()
            }

            chipSecond.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    Toast.makeText(context, "Checked 2", Toast.LENGTH_SHORT).show()
                }
            }

            chipThird.setOnCloseIconClickListener { _ ->
                chipThird.visibility = View.GONE

            }
        }
    }


}