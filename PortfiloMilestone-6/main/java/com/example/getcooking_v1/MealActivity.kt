package com.example.getcooking_v1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.getcooking_v1.databinding.ActivityMealBinding
import com.example.getcooking_v1.databinding.FragmentHomeBinding

class MealActivity : AppCompatActivity() {
    private lateinit var mealId:String
    private lateinit var mealName:String
    private lateinit var mealThumb:String
    private lateinit var binding: ActivityMealBinding
    private lateinit var mealMvvm:MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mealMvvm = ViewModelProviders.of(this)[MealViewModel::class.java]

        getMealInformationFromIntent()

        setInformationInViews()

        mealMvvm.getMealDetail(mealId)
        observeMealDetailsLiveData()

    }

    private fun observeMealDetailsLiveData() {
        mealMvvm.observeMealDetailsLiveData().observe(this,object :Observer<Meal>{
            override fun onChanged(t: Meal) {
                val meal = t

                binding.tvCategories.text = "Categories: ${meal!!.strCategory}"
                binding.tvArea.text = "Area : ${meal.strArea}"
                binding.tvInstructionSteps.text = meal.strInstructions
            }

        })
    }

    private fun setInformationInViews() {
        Glide.with(applicationContext)
            .load(mealThumb)
            .into(binding.imgMealDetail)

        binding.collapsingToolbar.title = mealName
        binding.collapsingToolbar.setCollapsedTitleTextColor(resources.getColor(R.color.white))
        binding.collapsingToolbar.setExpandedTitleColor(resources.getColor(R.color.white))
    }

    private fun getMealInformationFromIntent() {
        val intent = intent
        mealId = intent.getStringExtra(HomeFragment.MEAL_ID)!!
        mealName = intent.getStringExtra(HomeFragment.MEAL_NAME)!!
        mealThumb = intent.getStringExtra(HomeFragment.MEAL_THUMB)!!



    }
}