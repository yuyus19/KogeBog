package com.example.kogebog.homeOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dicerally.databinding.FragmentForretBinding

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

        val starters=IndholdForretter
        binding.titelOpskrift.setText(starters.title?.get(0))
        binding.ingredientsOpskrift.setText(starters.ingridients?.get(0))
        binding.manual.setText(starters.procedure?.get(0))

        binding.button1.setOnClickListener{
            val starters=starters
            binding.titelOpskrift.setText(starters.title?.get(0))
            binding.ingredientsOpskrift.setText(starters.ingridients?.get(0))
            binding.manual.setText(starters.procedure?.get(0))

        }

        binding.button2.setOnClickListener{
            val starters=IndholdForretter
            binding.titelOpskrift.setText(starters.title?.get(1))
            binding.ingredientsOpskrift.setText(starters.ingridients?.get(1))
            binding.manual.setText(starters.procedure?.get(1))

        }


        binding.button3.setOnClickListener{
            val starters=IndholdForretter
            binding.titelOpskrift.setText(starters.title?.get(2))
            binding.ingredientsOpskrift.setText(starters.ingridients?.get(2))
            binding.manual.setText(starters.procedure?.get(2))

        }

        binding.button4.setOnClickListener{
            val starters=IndholdForretter
            binding.titelOpskrift.setText(starters.title?.get(3))
            binding.ingredientsOpskrift.setText(starters.ingridients?.get(3))
            binding.manual.setText(starters.procedure?.get(3))

        }

        binding.button5.setOnClickListener{
            val starters=IndholdForretter
            binding.titelOpskrift.setText(starters.title?.get(4))
            binding.ingredientsOpskrift.setText(starters.ingridients?.get(4))
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