package com.example.kogebog.homeOption

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.dicerally.databinding.FragmentHovedretBinding
import com.example.kogebog.contents.IndholdHovedret
import com.example.kogebog.dataBase.Food
import com.example.kogebog.dataBase.FoodViewModel
import kotlinx.android.synthetic.main.fragment_forret.*


@Suppress("NAME_SHADOWING")
class HovedretFragment : Fragment() {

    private var _binding: FragmentHovedretBinding? =
        null // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mFoodViewModel: FoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHovedretBinding.inflate(inflater, container, false)
        mFoodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        val indhold = IndholdHovedret

        // Defult values first the recipe
        binding.titelOpskrift.text = indhold.title[0]
        binding.ingredientsOpskrift.text = indhold.ingredients[0]
        binding.manual.text = indhold.procedure[0]
        val imageURL = "https://vielskermad.dk/wp-content/uploads/2020/11/lasagne-1200x900.jpg"
        Glide.with(this)
            .load(imageURL)
            .into(binding.mainCorse1Image)


        // When button is clicked the data for the first recipes get put in to the layout.
        binding.button1.setOnClickListener {

            binding.titelOpskrift.text = indhold.title[0]
            binding.ingredientsOpskrift.text = indhold.ingredients[0]
            binding.manual.text = indhold.procedure[0]

            // Gets an image from the web to use in the imageview
            val imageURL = "https://vielskermad.dk/wp-content/uploads/2020/11/lasagne-1200x900.jpg"
            Glide.with(this)
                .load(imageURL)
                .into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the first recipes get put in to the layout.
        binding.button2.setOnClickListener {
            binding.titelOpskrift.text = indhold.title[1]
            binding.ingredientsOpskrift.text = indhold.ingredients[1]
            binding.manual.text = indhold.procedure[1]

            // Gets an image from the web to use in the imageview
            val imageURL = "https://www.valdemarsro.dk/wp-content/2015/09/bolognese.jpg"
            Glide.with(this)
                .load(imageURL)
                .centerCrop().into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the first recipes get put in to the layout.
        binding.button3.setOnClickListener {
            binding.titelOpskrift.text = indhold.title[2]
            binding.ingredientsOpskrift.text = indhold.ingredients[2]
            binding.manual.text = indhold.procedure[2]

            // Gets an image from the web to use in the imageview
            val imageURL =
                "https://www.valdemarsro.dk/wp-content/2014/07/stegt-flaesk-persillesauce.jpg"
            Glide.with(this)
                .load(imageURL)
                .into(binding.mainCorse1Image)

        }

        // When button is clicked the data for the first recipes get put in to the layout.
        binding.button4.setOnClickListener {
            binding.titelOpskrift.text = indhold.title[3]
            binding.ingredientsOpskrift.text = indhold.ingredients[3]
            binding.manual.text = indhold.procedure[3]

            // Gets an image from the web to use in the imageview
            val imagURL = "https://www.valdemarsro.dk/wp-content/2008/01/burgere.jpg"
            Glide.with(this)
                .load(imagURL)
                .into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the first recipes get put in to the layout.
        binding.button5.setOnClickListener {
            binding.titelOpskrift.text = indhold.title[4]
            binding.ingredientsOpskrift.text = indhold.ingredients[4]
            binding.manual.text = indhold.procedure[4]

            // Gets an image from the web to use in the imageview
            val imagURL = "https://www.valdemarsro.dk/wp-content/2017/12/moerbrad-fyldt.jpg"
            Glide.with(this)
                .load(imagURL)
                .into(binding.mainCorse1Image)

        }

        // When the heart button is pressed, the recipe gets put in a database
        binding.heart.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Method used to insert data into the DB
    private fun insertDataToDatabase() {
        val mTitel = titel_opskrift.text.toString()
        val mIngredients = ingredients_opskrift.text.toString()
        val mManual = manual.text.toString()

        // Checks if the title, ingredients or recipe is missing
        if (inputCheck(mTitel, mIngredients, mManual)) {
            // Create User Object
            val food = Food(
                0,
                mTitel,
                mIngredients,
                mManual
            )

            // Adds Data to Database
            mFoodViewModel.addFood(food)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            // Returns that not all the values are filled.
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                .show()
        }
    }
    // Method that checks it any of the values are missing
    private fun inputCheck(mTitel: String, mIngredients: String, mManual: String): Boolean {
        return !(TextUtils.isEmpty(mTitel) && TextUtils.isEmpty(mIngredients) && TextUtils.isEmpty(
            mManual))
    }

}