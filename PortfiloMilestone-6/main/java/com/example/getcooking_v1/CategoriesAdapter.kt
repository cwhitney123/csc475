package com.example.getcooking_v1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getcooking_v1.databinding.CategoryItemBinding
import com.example.getcooking_v1.Category


class CategoriesAdapter() : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>(){

    private var categoriesList = ArrayList<Category>()

    fun setCategoriesList(categoriesList:List<Category>){
        this.categoriesList = categoriesList as ArrayList<Category>
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(val binding:CategoryItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoryViewHolder, position: Int) {
        Glide.with(holder.itemView).load(categoriesList[position].strCategoryThumb).into(holder.binding.imgCategory)
        holder.binding.tvCategoryName.text = categoriesList[position].strCategory
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }


}