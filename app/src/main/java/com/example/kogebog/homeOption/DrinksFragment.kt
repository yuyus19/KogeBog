package com.example.kogebog.homeOption

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentDrinksBinding
import com.example.dicerally.databinding.FragmentForretBinding


class DrinksFragment : Fragment() {

    private var _binding: FragmentDrinksBinding?=null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrinksBinding.inflate(inflater, container, false)

        val starters=IndholdDrinks
        binding.titelOpskrift.setText(starters.title?.get(0))
        binding.ingredientsOpskrift.setText(starters.ingredients?.get(0))
        binding.manual.setText(starters.procedure?.get(0))

        binding.button1.setOnClickListener{

            binding.titelOpskrift.setText(starters.title?.get(0))
            binding.ingredientsOpskrift.setText(starters.ingredients?.get(0))
            binding.manual.setText(starters.procedure?.get(0))

        }

        binding.button2.setOnClickListener{

            binding.titelOpskrift.setText(starters.title?.get(1))
            binding.ingredientsOpskrift.setText(starters.ingredients?.get(1))
            binding.manual.setText(starters.procedure?.get(1))

        }


        binding.button3.setOnClickListener{

            binding.titelOpskrift.setText(starters.title?.get(2))
            binding.ingredientsOpskrift.setText(starters.ingredients?.get(2))
            binding.manual.setText(starters.procedure?.get(2))

        }

        binding.button4.setOnClickListener{

            binding.titelOpskrift.setText(starters.title?.get(3))
            binding.ingredientsOpskrift.setText(starters.ingredients?.get(3))
            binding.manual.setText(starters.procedure?.get(3))

        }

        binding.button5.setOnClickListener{

            binding.titelOpskrift.setText(starters.title?.get(4))
            binding.ingredientsOpskrift.setText(starters.ingredients?.get(4))
            binding.manual.setText(starters.procedure?.get(4))

        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}