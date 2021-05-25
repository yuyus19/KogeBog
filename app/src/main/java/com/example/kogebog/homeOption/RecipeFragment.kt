package com.example.kogebog.homeOption

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentRecipeBinding


class RecipeFragment : Fragment() {


    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentRecipeBinding.inflate(inflater, container, false)

        // Binds the value in the fl_wrapper view to the ForretFragment layout values when button is clicked.
        binding.theforret.setOnClickListener {
            val fManager = requireActivity().supportFragmentManager
            val tx = fManager.beginTransaction()

            // Start a series of replace operations on the Fragments associated with this FragmentManager.
            tx.replace(R.id.fl_wrapper, ForretFragment())
            tx.addToBackStack(null)
            tx.commit()
        }

        // Binds the value in the fl_wrapper view to the HovedretFragment layout values when button is clicked.
        binding.hoved.setOnClickListener {

            val fManager = requireActivity().supportFragmentManager
            val tx = fManager.beginTransaction()

            // Start a series of replace operations on the Fragments associated with this FragmentManager.
            tx.replace(R.id.fl_wrapper, HovedretFragment())
            tx.addToBackStack(null)
            tx.commit()
        }

        // Binds the value in the fl_wrapper view to the DessertFragment layout values when button is clicked.
        binding.dessert.setOnClickListener {
            val fManager = requireActivity().supportFragmentManager
            val tx = fManager.beginTransaction()

            // Start a series of replace operations on the Fragments associated with this FragmentManager.
            tx.replace(R.id.fl_wrapper, DessertFragment())
            tx.addToBackStack(null)
            tx.commit()
        }


        // Binds the value in the fl_wrapper view to the DrinksFragment layout values when button is clicked.
        binding.drinks.setOnClickListener {
            val fManager = requireActivity().supportFragmentManager
            val tx = fManager.beginTransaction()

            // Start a series of replace operations on the Fragments associated with this FragmentManager.
            tx.replace(R.id.fl_wrapper, DrinksFragment())
            tx.addToBackStack(null)
            tx.commit()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}