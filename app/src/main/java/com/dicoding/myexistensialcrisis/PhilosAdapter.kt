package com.dicoding.myexistensialcrisis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class PhilosAdapter(private val listPhilos: ArrayList<Philosophy>) : RecyclerView.Adapter<PhilosAdapter.ListViewHolder>() {

    var onItemClick : ((Philosophy) -> Unit)? = null

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_philos, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhilosAdapter.ListViewHolder, position: Int) {
        val (name, description, photo) = listPhilos[position]
        val philos = listPhilos[position]
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.imgPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(philos)
        }
    }

    override fun getItemCount(): Int = listPhilos.size
}