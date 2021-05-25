package com.example.kogebog.homeOption

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.dicerally.databinding.FragmentForretBinding
import com.example.kogebog.contents.IndholdForretter
import com.example.kogebog.dataBase.Food
import com.example.kogebog.dataBase.FoodViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_forret.*


@Suppress("NAME_SHADOWING")
class ForretFragment : Fragment() {

    private var _binding: FragmentForretBinding? = null
    private val binding get() = _binding!!
    private lateinit var mFoodViewModel: FoodViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentForretBinding.inflate(inflater, container, false)
        mFoodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        val indhold = IndholdForretter

        // Defult values first the recipe
        binding.titelOpskrift.text = indhold.title[0]
        binding.ingredientsOpskrift.text = indhold.ingredients[0]
        binding.manual.text = indhold.procedure[0]
        val imageURL =
            "https://xn--minkbmand-o8a.dk/sites/minkobmand.dk/files/styles/recipe_large/public/mk-roegetlaks-800x568_0.png?itok=_LXjbgpX"
        Glide.with(this)
            .load(imageURL)
            .into(binding.mainCorse1Image)

        // When button is clicked the data for the first recipes get put in to the layout.
        binding.button1.setOnClickListener {

            binding.titelOpskrift.text = indhold.title[0]
            binding.ingredientsOpskrift.text = indhold.ingredients[0]
            binding.manual.text = indhold.procedure[0]

            // Gets an image from the web to use in the imageview
            val imageURL =
                "https://xn--minkbmand-o8a.dk/sites/minkobmand.dk/files/styles/recipe_large/public/mk-roegetlaks-800x568_0.png?itok=_LXjbgpX"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the second recipes get put in to the layout.
        binding.button2.setOnClickListener {

            binding.titelOpskrift.text = indhold.title[1]
            binding.ingredientsOpskrift.text = indhold.ingredients[1]
            binding.manual.text = indhold.procedure[1]

            // Gets an image from the web to use in the imageview
            val imageURL =
                "https://img.mummum.dk/wp-content/uploads/2019/04/Bruschetta-med-serranoskinke.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }


        // When button is clicked the data for the third recipes get put in to the layout.
        binding.button3.setOnClickListener {

            binding.titelOpskrift.text = indhold.title[2]
            binding.ingredientsOpskrift.text = indhold.ingredients[2]
            binding.manual.text = indhold.procedure[2]

            // Gets an image from the web to use in the imageview
            val imageURL =
                "https://www.pigenogpomfritten.dk/wp-content/uploads/2013/10/porresuppe6.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the fourth recipes get put in to the layout.
        binding.button4.setOnClickListener {

            binding.titelOpskrift.text = indhold.title[3]
            binding.ingredientsOpskrift.text = indhold.ingredients[3]
            binding.manual.text = indhold.procedure[3]

            // Gets an image from the web to use in the imageview
            val imageURL = "https://www.valdemarsro.dk/wp-content/2015/09/tunsalat-1.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // When button is clicked the data for the fifth recipes get put in to the layout.
        binding.button5.setOnClickListener {

            binding.titelOpskrift.text = indhold.title[4]
            binding.ingredientsOpskrift.text = indhold.ingredients[4]
            binding.manual.text = indhold.procedure[4]

            // Gets an image from the web to use in the imageview
            val imageURL =
                "https://www.madformadelskere.dk/wp-content/uploads/2019/04/Tarteletter-med-hoens-i-asparges-1.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        // Use the method insertDataToDatabase when the button is clicked
        binding.heart.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }


    // Method used to insert data into the DB
    private fun insertDataToDatabase() {
        val mTitel = titel_opskrift.text.toString()
        val mIngredients = ingredients_opskrift.text.toString()
        val mManual = manual.text.toString()

        if (inputCheck(mTitel, mIngredients, mManual)) {
            // Create User Object
            val food = Food(
                0,
                mTitel,
                mIngredients,
                mManual
            )
            // Add Data to Database
            mFoodViewModel.addFood(food)
            Toast.makeText(requireContext(), "Tilføjet til favorit!", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                .show()
        }
    }


    // Method that checks it any of the values are missing
    private fun inputCheck(mTitel: String, mIngredients: String, mManual: String): Boolean {
        return !(TextUtils.isEmpty(mTitel) && TextUtils.isEmpty(mIngredients) && TextUtils.isEmpty(
            mManual
        ))
    }

}