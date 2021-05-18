package com.example.kogebog.shoppingOption

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.dicerally.R
import com.example.dicerally.databinding.FragmentHovedretBinding
import kotlinx.android.synthetic.main.fragment_shopping.*
import com.example.dicerally.R.layout.fragment_shopping

class ShoppingFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    // Initializing the array lists and the adapter
    var itemlist = arrayListOf<String>()

    var adapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_multiple_choice, itemlist)
    private var _binding: FragmentHovedretBinding?=null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_shopping,container,false)
            _binding = FragmentHovedretBinding.inflate(inflater, container, false)
        add.setOnClickListener{
            itemlist.add(editText.text.toString())
            listView.adapter = adapter
            adapter.notifyDataSetChanged()
        }


        return inflater.inflate(R.layout.fragment_shopping, container, false)


    }





}