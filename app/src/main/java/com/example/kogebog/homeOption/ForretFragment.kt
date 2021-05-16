package com.example.kogebog.homeOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentForretBinding
import com.example.dicerally.databinding.FragmentHovedretBinding

class ForretFragment : Fragment() {

    private var _binding: FragmentForretBinding?=null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForretBinding.inflate(inflater, container, false)

        val starters=Starters
        binding.titelOpskrift.setText(starters.Headline?.get(0))
        binding.ingredientsOpskrift.setText(starters.Ingridients?.get(0))
        binding.manual.setText(starters.Procedure?.get(0))

        binding.button1.setOnClickListener{
            val starters=Starters
            binding.titelOpskrift.setText(starters.Headline?.get(0))
            binding.ingredientsOpskrift.setText(starters.Ingridients?.get(0))
            binding.manual.setText(starters.Procedure?.get(0))

        }

        binding.button2.setOnClickListener{
            val starters=Starters
            binding.titelOpskrift.setText(starters.Headline?.get(1))
            binding.ingredientsOpskrift.setText(starters.Ingridients?.get(1))
            binding.manual.setText(starters.Procedure?.get(1))

        }


        binding.button3.setOnClickListener{
            val starters=Starters
            binding.titelOpskrift.setText(starters.Headline?.get(2))
            binding.ingredientsOpskrift.setText(starters.Ingridients?.get(2))
            binding.manual.setText(starters.Procedure?.get(2))

        }

        binding.button4.setOnClickListener{
            val starters=Starters
            binding.titelOpskrift.setText(starters.Headline?.get(3))
            binding.ingredientsOpskrift.setText(starters.Ingridients?.get(3))
            binding.manual.setText(starters.Procedure?.get(3))

        }

        binding.button5.setOnClickListener{
            val starters=Starters
            binding.titelOpskrift.setText(starters.Headline?.get(4))
            binding.ingredientsOpskrift.setText(starters.Ingridients?.get(4))
            binding.manual.setText(starters.Procedure?.get(4))

        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}