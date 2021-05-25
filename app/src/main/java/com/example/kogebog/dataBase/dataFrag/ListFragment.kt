package com.example.kogebog.dataBase.dataFrag

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicerally.R
import com.example.kogebog.dataBase.FoodViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {
    private lateinit var mFoodViewModel: FoodViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        mFoodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        mFoodViewModel.readAllData.observe(viewLifecycleOwner,{ food -> adapter.setData(food)})

        //Button to delete all content in database
        view.delete_button.setOnClickListener {
            deleteAllFood()
        }

        return view
    }




    private fun deleteAllFood() {
        //creates alertDialog
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mFoodViewModel.deleteAllFood()
            Toast.makeText(
                requireContext(),
                "Everything is removed",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete favorites?")
        builder.setMessage("Are you sure you want to delete favorites?")
        builder.create().show()
    }

}