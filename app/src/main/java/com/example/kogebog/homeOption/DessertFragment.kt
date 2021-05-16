package com.example.kogebog.homeOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentDessertBinding
import com.example.dicerally.databinding.FragmentHovedretBinding

class DessertFragment : Fragment() {

    private var _binding: FragmentDessertBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDessertBinding.inflate(inflater, container, false)

        val imageURL = "https://vielskermad.dk/wp-content/uploads/2020/11/lasagne-1200x900.jpg"

            Glide.with(this)
                .load(imageURL).centerCrop()
                .into(binding.dessertimage)
        val view = binding.root
        return view
    }
}