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

class ShoppingFragment : Fragment() {

    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!! // This property is only valid between onCreateView and onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShoppingBinding.inflate(inflater, container, false)

        // Initializing the array list and the adapter
        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_multiple_choice, itemlist)

        // When button Add is clicked a toast is displayed and text from editText is put into itemList
        // The adapter is noticed and editText gets cleared ready for new input.
        binding.btnAdd.setOnClickListener {
            Toast.makeText(context, "You have added an item", Toast.LENGTH_LONG).show()
            itemlist.add(binding.editText.text.toString())
            binding.listView.adapter = adapter
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }

        // When button Delete is clicked a toast is displayed and an element is removed until there is no more to remove
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

        // When button Clear is clicked a toast is displayed and every element in itemlist gets cleared.
        binding.clear.setOnClickListener{
            Toast.makeText(context, "You have cleared the shopping list", Toast.LENGTH_LONG).show()
            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
            return binding.root
        }
}