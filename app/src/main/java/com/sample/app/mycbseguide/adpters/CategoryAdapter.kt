package com.sample.app.mycbseguide.adpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.mycbseguide.databinding.CategoryItemBinding
import com.sample.app.mycbseguide.models.CategoryModel
import com.sample.app.mycbseguide.utils.load

class CategoryAdapter(private val onClick:(category:CategoryModel)->Unit): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private val categories = mutableListOf<CategoryModel>()

    inner class ViewHolder(val binding:CategoryItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.imageView.load(categories[position].mobile_logo)
        holder.binding.textViewName.text = categories[position].name
        holder.binding.root.setOnClickListener {  onClick.invoke(categories[position])}
    }

    fun setCategoriesList(list:List<CategoryModel>){
        categories.clear()
        categories.addAll(list)

    }
}