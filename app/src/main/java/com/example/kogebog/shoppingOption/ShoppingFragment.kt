package com.example.kogebog.shoppingOption

import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dicerally.databinding.FragmentShoppingBinding
import kotlinx.android.synthetic.main.fragment_shopping.*

//import kotlinx.android.synthetic.main.fragment_shopping.*



class ShoppingFragment : Fragment() {

//    private var mCallback: OnHeadlineSelectedListener? = null
//
//    // The container Activity must implement this interface so the frag can deliver messages
//    interface OnHeadlineSelectedListener {
//        /** Called by HeadlinesFragment when a list item is selected  */
//        open fun onArticleSelected(position: Int)
//    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

//        var listView: ListView? = null
//        var adapter: ArrayAdapter<String>? = null
//        var itemlist = arrayListOf<String>()
//        listView = binding.listView
//
//        fun popupaleListView(){
//        adapter = ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_multiple_choice, itemlist)
//        listView?.adapter = adapter
//        }
//        add.setOnClickListener{
//            popupaleListView()
//            Toast.makeText(context, "Something is going through", Toast.LENGTH_LONG).show()
//        }

//    }

    private var _binding: FragmentShoppingBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoppingBinding.inflate(inflater, container, false)
        // Initializing the array lists and the adapter
        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_multiple_choice, itemlist)

        binding.btnAdd.setOnClickListener {
            Toast.makeText(context, "You have added an item", Toast.LENGTH_LONG).show()
            itemlist.add(binding.editText.text.toString())
            binding.listView.adapter = adapter
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }
        binding.delete.setOnClickListener{
            Toast.makeText(context, "You have deleted an item", Toast.LENGTH_LONG).show()
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }
        binding.clear.setOnClickListener{
            Toast.makeText(context, "You have cleared the shopping list", Toast.LENGTH_LONG).show()
            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
            return binding.root
        //inflater.inflate(R.layout.fragment_shopping, container, false)
        }
    //fun onViewCreated(view:View?, savedInstanceState: Bundle?){
    //  super.onViewCreated(view, savedInstanceState)

    //}
}