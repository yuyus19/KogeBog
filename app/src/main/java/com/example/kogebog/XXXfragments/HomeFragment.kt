package com.example.kogebog.XXXfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentHomeBinding
import com.example.kogebog.homeOption.RecipeFragment


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        var v=inflater.inflate(R.layout.fragment_home,container,false)



            var fManager=requireActivity().supportFragmentManager

            var tx =fManager.beginTransaction()
            tx.add(R.id.fl_wrapper, RecipeFragment())
            tx.addToBackStack(null)
            tx.commit()





        return v
    }

}




