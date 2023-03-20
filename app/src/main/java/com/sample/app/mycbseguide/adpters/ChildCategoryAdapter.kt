package com.sample.app.mycbseguide.adpters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.mycbseguide.databinding.CategoryItemBinding
import com.sample.app.mycbseguide.models.CategoryChildren
import com.sample.app.mycbseguide.utils.load

class ChildCategoryAdapter : RecyclerView.Adapter<ChildCategoryAdapter.ViewHolder>() {
    private val categories = mutableListOf<CategoryChildren>()

    inner class ViewHolder(val binding: CategoryItemBinding): RecyclerView.ViewHolder(binding.root)

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
    }

    fun setCategoriesList(list:List<CategoryChildren>){
        categories.clear()
        categories.addAll(list)
        notifyDataSetChanged()

    }
}