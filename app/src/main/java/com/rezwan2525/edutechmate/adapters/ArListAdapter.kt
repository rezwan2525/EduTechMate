package com.rezwan2525.edutechmate.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rezwan2525.edutechmate.R
import com.rezwan2525.edutechmate.interfaces.OnArListItemClicked
import com.rezwan2525.edutechmate.models.ArItem
import com.squareup.picasso.Picasso

class ArListAdapter (
    val itemList: MutableList<ArItem>,
    val listener: OnArListItemClicked
        ): RecyclerView.Adapter<ArListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_ar_list_item, parent, false);

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val singleItem:ArItem = itemList[position]

        Picasso.get().load(singleItem.image).into(holder.image)
        holder.title.setText(singleItem.title)

        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClicked(singleItem);
        })

        if(singleItem.isLocked){
            holder.lock.visibility = View.VISIBLE
        }
        else{
            holder.lock.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.iv_item_image)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val lock: ImageView = itemView.findViewById(R.id.iv_lock_image)
    }

}