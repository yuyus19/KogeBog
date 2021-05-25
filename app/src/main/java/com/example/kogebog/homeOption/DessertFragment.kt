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
import com.example.dicerally.databinding.FragmentDessertBinding
import com.example.kogebog.contents.IndholdDessert
import com.example.kogebog.dataBase.Food
import com.example.kogebog.dataBase.FoodViewModel
import kotlinx.android.synthetic.main.fragment_forret.*

@Suppress("NAME_SHADOWING")
class DessertFragment : Fragment() {

    private lateinit var mFoodViewModel: FoodViewModel
    private var _binding: FragmentDessertBinding?=null
    private val binding get() = _binding!!  // This property is only valid between onCreateView and onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDessertBinding.inflate(inflater, container, false)
        mFoodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        val starters = IndholdDessert

        // Defult values first the recipe
        binding.titelOpskrift.text = starters.title[0]
        binding.ingredientsOpskrift.text = starters.ingredients[0]
        binding.manual.text = starters.procedure[0]
        val imageURL = "https://www.valdemarsro.dk/wp-content/2015/09/saltkaramelis-opskrift.jpg"
        Glide.with(this).load(imageURL).into(binding.mainCorse1Image)

        // When button is clicked the data for the first recipes get put in to the layout.
        binding.button1.setOnClickListener {

            binding.titelOpskrift.text = starters.title[0]
            binding.ingredientsOpskrift.text = starters.ingredients[0]
            binding.manual.text = starters.procedure[0]

            // Gets an image from the web to use in the imageview
            val imageURL =
                "https://www.valdemarsro.dk/wp-content/2015/09/saltkaramelis-opskrift.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the second recipes get put in to the layout.
        binding.button2.setOnClickListener {

            binding.titelOpskrift.text = starters.title[1]
            binding.ingredientsOpskrift.text = starters.ingredients[1]
            binding.manual.text = starters.procedure[1]

            // Gets an image from the web to use in the imageview
            val imageURL = "https://www.valdemarsro.dk/wp-content/2016/09/creme-brulee.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the third recipes get put in to the layout.
        binding.button3.setOnClickListener {

            binding.titelOpskrift.text = starters.title[2]
            binding.ingredientsOpskrift.text = starters.ingredients[2]
            binding.manual.text = starters.procedure[2]

            // Gets an image from the web to use in the imageview
            val imageURL = "https://www.valdemarsro.dk/wp-content/2007/09/pandekager1.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the fourth recipes get put in to the layout.
        binding.button4.setOnClickListener {

            binding.titelOpskrift.text = starters.title[3]
            binding.ingredientsOpskrift.text = starters.ingredients[3]
            binding.manual.text = starters.procedure[3]

            // Gets an image from the web to use in the imageview
            val imageURL =
                "https://www.valdemarsro.dk/wp-content/2015/08/grillede-bananer_opskrift.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the fifth recipes get put in to the layout.
        binding.button5.setOnClickListener {

            binding.titelOpskrift.text = starters.title[4]
            binding.ingredientsOpskrift.text = starters.ingredients[4]
            binding.manual.text = starters.procedure[4]

            // Gets an image from the web to use in the imageview
            val imageURL = "https://www.valdemarsro.dk/wp-content/2019/05/jordbaertrifli.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        binding.heart.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Use the method insertDataToDatabase when the button is clicked
    private fun insertDataToDatabase() {
        val mTitel = titel_opskrift.text.toString()
        val mIngredients = ingredients_opskrift.text.toString()
        val mManual = manual.text.toString()

        if(inputCheck(mTitel, mIngredients, mManual)){
            // Create User Object
            val food = Food(
                0,
                mTitel,
                mIngredients,
                mManual
            )
            // Add Data to Database
            mFoodViewModel.addFood(food)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    // Method that checks it any of the values are missing
    private fun inputCheck(mTitel: String, mIngredients: String, mManual: String): Boolean{
        return !(TextUtils.isEmpty(mTitel) && TextUtils.isEmpty(mIngredients) && TextUtils.isEmpty(mManual))
    }
}