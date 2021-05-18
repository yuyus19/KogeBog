package com.example.kogebog.homeOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dicerally.databinding.FragmentHovedretBinding
import com.example.kogebog.contents.IndholdHovedret



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

        val indhold= IndholdHovedret
        binding.titelOpskrift.setText(indhold.title?.get(0))
        binding.ingredientsOpskrift.setText(indhold.ingredients?.get(0))
        binding.manual.setText(indhold.procedure?.get(0))
        val imageURL = "https://vielskermad.dk/wp-content/uploads/2020/11/lasagne-1200x900.jpg"
        Glide.with(this)
            .load(imageURL)
            .into(binding.mainCorse1Image)


        binding.button1.setOnClickListener {

            binding.titelOpskrift.setText(indhold.title?.get(0))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(0))
            binding.manual.setText(indhold.procedure?.get(0))
            val imageURL = "https://vielskermad.dk/wp-content/uploads/2020/11/lasagne-1200x900.jpg"

            Glide.with(this)
                .load(imageURL)
                .into(binding.mainCorse1Image)
        }
        binding.button2.setOnClickListener {
            binding.titelOpskrift.setText(indhold.title?.get(1))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(1))
            binding.manual.setText(indhold.procedure?.get(1))

            val imageURL = "https://www.valdemarsro.dk/wp-content/2015/09/bolognese.jpg"
            Glide.with(this).load(imageURL).centerCrop().into(binding.mainCorse1Image)
        }

        binding.button3.setOnClickListener{
            binding.titelOpskrift.setText(indhold.title?.get(2))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(2))
            binding.manual.setText(indhold.procedure?.get(2))

            val imageURL = "https://www.valdemarsro.dk/wp-content/2014/07/stegt-flaesk-persillesauce.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)

        }
        binding.button4.setOnClickListener{
            binding.titelOpskrift.setText(indhold.title?.get(3))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(3))
            binding.manual.setText(indhold.procedure?.get(3))

            val imagURL = "https://www.valdemarsro.dk/wp-content/2008/01/burgere.jpg"
            Glide.with(this).load(imagURL).into(binding.mainCorse1Image)
        }
        binding.button5.setOnClickListener{
            binding.titelOpskrift.setText(indhold.title?.get(4))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(4))
            binding.manual.setText(indhold.procedure?.get(4))

            val imagURL = "https://www.valdemarsro.dk/wp-content/2017/12/moerbrad-fyldt.jpg"
            Glide.with(this).load(imagURL).into(binding.mainCorse1Image)

        }


        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}