package com.example.kogebog.dataBase.dataFrag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dicerally.R
import com.example.kogebog.dataBase.Food
import com.example.kogebog.favouriteOption.FavouritesFragment
import com.example.kogebog.homeOption.ForretFragment
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var foodList = emptyList<Food>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.itemView.id_txt.text=currentItem.id.toString()
        holder.itemView.titel_txt.text = currentItem.titel

        holder.itemView.rowLayout.setOnClickListener {

            var fManager =(holder.itemView.context as FragmentActivity).supportFragmentManager
            var tx = fManager.beginTransaction()


            tx.replace(R.id.fl_wrapper, FavouritesFragment())
            tx.addToBackStack(null)
            tx.commit()

        }

    }

    fun setData(food: List<Food>){
        this.foodList = food
        notifyDataSetChanged()
    }




}