package com.example.newsapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Category
import com.example.newsapp.R
import com.example.newsapp.fragment.NewsFragment

class CategoryAdapter(
    private val array: ArrayList<Category>,
    val context: FragmentActivity
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.itemCategory)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = holder.itemView.context.getString(item.name)

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("category", item)
            context.supportFragmentManager.beginTransaction()
                .replace(R.id.container, NewsFragment::class.java, bundle)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}