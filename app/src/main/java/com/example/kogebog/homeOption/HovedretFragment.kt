package com.example.kogebog.homeOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentHovedretBinding


class HovedretFragment : Fragment() {

    private var _binding: FragmentHovedretBinding?=null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHovedretBinding.inflate(inflater, container, false)

        val array=resources.getStringArray(R.array.Lasagne)
        binding.titelOpskrift.setText(array[0])
        binding.ingredientsOpskrift.setText(array[1])
        binding.manual.setText(array[2])
        val imageURL = "https://vielskermad.dk/wp-content/uploads/2020/11/lasagne-1200x900.jpg"
        Glide.with(this)
            .load(imageURL)
            .into(binding.mainCorse1Image)


        binding.button1.setOnClickListener {
         val array = resources.getStringArray(R.array.Lasagne)
            binding.titelOpskrift.setText(array[0])
            binding.ingredientsOpskrift.setText(array[1])
            binding.manual.setText(array[2])
            val imageURL = "https://vielskermad.dk/wp-content/uploads/2020/11/lasagne-1200x900.jpg"

            Glide.with(this)
                .load(imageURL)
                .into(binding.mainCorse1Image)
        }
        binding.button2.setOnClickListener {
            val array = resources.getStringArray(R.array.Spaghetti)
            binding.titelOpskrift.setText(array[0])
            binding.ingredientsOpskrift.setText(array[1])
            binding.manual.setText(array[2])

            val imageURL = "https://www.valdemarsro.dk/wp-content/2015/09/bolognese.jpg"

            Glide.with(this)
                .load(imageURL).centerCrop()
                .into(binding.mainCorse1Image)
        }

        binding.button3.setOnClickListener{
            val getta=IndholdHovedret
            binding.titelOpskrift.setText(getta.ingredients?.get(0))


        }


        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}