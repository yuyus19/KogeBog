package com.example.kogebog.homeOption

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.ListFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentForretBinding
import com.example.kogebog.contents.IndholdForretter
import com.example.kogebog.dataBase.Food
import com.example.kogebog.dataBase.FoodViewModel
import com.example.kogebog.favouriteOption.FavouritesFragment
import kotlinx.android.synthetic.main.fragment_forret.*

class ForretFragment : Fragment() {

    private var _binding: FragmentForretBinding?=null
    private val binding get() = _binding!!
    private lateinit var mFoodViewModel: FoodViewModel


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForretBinding.inflate(inflater, container, false)
        mFoodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

        val indhold= IndholdForretter
        binding.titelOpskrift.setText(indhold.title?.get(0))
        binding.ingredientsOpskrift.setText(indhold.ingredients?.get(0))
        binding.manual.setText(indhold.procedure?.get(0))

        val imageURL = "https://xn--minkbmand-o8a.dk/sites/minkobmand.dk/files/styles/recipe_large/public/mk-roegetlaks-800x568_0.png?itok=_LXjbgpX"
        Glide.with(this).load(imageURL).into(binding.mainCorse1Image)

        binding.button1.setOnClickListener{

            binding.titelOpskrift.setText(indhold.title?.get(0))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(0))
            binding.manual.setText(indhold.procedure?.get(0))

            val imageURL = "https://xn--minkbmand-o8a.dk/sites/minkobmand.dk/files/styles/recipe_large/public/mk-roegetlaks-800x568_0.png?itok=_LXjbgpX"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        binding.button2.setOnClickListener{

            binding.titelOpskrift.setText(indhold.title?.get(1))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(1))
            binding.manual.setText(indhold.procedure?.get(1))

            val imageURL = "https://img.mummum.dk/wp-content/uploads/2019/04/Bruschetta-med-serranoskinke.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }


        binding.button3.setOnClickListener{

            binding.titelOpskrift.setText(indhold.title?.get(2))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(2))
            binding.manual.setText(indhold.procedure?.get(2))

            val imageURL = "https://www.pigenogpomfritten.dk/wp-content/uploads/2013/10/porresuppe6.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }

        binding.button4.setOnClickListener{

            binding.titelOpskrift.setText(indhold.title?.get(3))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(3))
            binding.manual.setText(indhold.procedure?.get(3))

            val imageURL = "https://www.valdemarsro.dk/wp-content/2015/09/tunsalat-1.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }


        binding.button5.setOnClickListener{

            binding.titelOpskrift.setText(indhold.title?.get(4))
            binding.ingredientsOpskrift.setText(indhold.ingredients?.get(4))
            binding.manual.setText(indhold.procedure?.get(4))

            val imageURL = "https://www.madformadelskere.dk/wp-content/uploads/2019/04/Tarteletter-med-hoens-i-asparges-1.jpg"
            Glide.with(this).load(imageURL).into(binding.mainCorse1Image)
        }


        binding.heart.setOnClickListener{
            insertDataToDatabase()
            var fManager = requireActivity().supportFragmentManager
            var tx = fManager.beginTransaction()


            tx.replace(R.id.fl_wrapper, ListFragment())
            tx.addToBackStack(null)
            tx.commit()
        }


        val view = binding.root
        return view
    }


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

    private fun inputCheck(mTitel: String, mIngredients: String, mManual: String): Boolean{
        return !(TextUtils.isEmpty(mTitel) && TextUtils.isEmpty(mIngredients) && TextUtils.isEmpty(mManual))
    }

}