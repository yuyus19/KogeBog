package com.example.kogebog.homeOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentRecipeBinding
import com.example.kogebog.Adapter.MainRecycler


class RecipeFragment : Fragment() {


private var _binding:FragmentRecipeBinding?=null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)


        binding.theforret.setOnClickListener {



            var fManager = requireActivity().supportFragmentManager
            var tx = fManager.beginTransaction()


            tx.replace(R.id.fl_wrapper, ForretFragment())
            tx.addToBackStack(null)
            tx.commit()

        }

        binding.hoved.setOnClickListener {

            var fManager = requireActivity().supportFragmentManager
            var tx = fManager.beginTransaction()


            tx.replace(R.id.fl_wrapper, HovedretFragment())
            tx.addToBackStack(null)
            tx.commit()


        }
        binding.dessert.setOnClickListener {
            var fManager = requireActivity().supportFragmentManager
            var tx = fManager.beginTransaction()


            tx.replace(R.id.fl_wrapper, DessertFragment())
            tx.addToBackStack(null)
            tx.commit()
        }
        binding.drinks.setOnClickListener {
            var fManager = requireActivity().supportFragmentManager
            var tx = fManager.beginTransaction()


            tx.replace(R.id.fl_wrapper, MainRecycler())
            tx.addToBackStack(null)
            tx.commit()
        }




        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}