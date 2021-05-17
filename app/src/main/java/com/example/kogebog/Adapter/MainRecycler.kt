package com.example.kogebog.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dicerally.R
import com.example.dicerally.databinding.MainRecyclerBinding
import com.example.kogebog.homeOption.DrinksFragment
import kotlinx.android.synthetic.main.fragment_drinks.*
import kotlinx.android.synthetic.main.main_recycler.*

class MainRecycler : Fragment(R.layout.main_recycler) {

    private var _binding: MainRecyclerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = RecyclerAdapter()
        val view = binding.recyclerView

        v.ViewHolder(view).itemView.setOnClickListener{
            var fManager = requireActivity().supportFragmentManager
            var tx = fManager.beginTransaction()


            tx.replace(R.id.fl_wrapper, DrinksFragment())
            tx.addToBackStack(null)
            tx.commit()

        }
        return inflater.inflate(R.layout.main_recycler, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_View.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = RecyclerAdapter()
        }


    }

}