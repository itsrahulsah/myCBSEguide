package com.sample.app.mycbseguide.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.sample.app.mycbseguide.database.AppDatabase
import com.sample.app.mycbseguide.models.CategoryModel
import com.sample.app.mycbseguide.network.RetrofitClient
import org.json.JSONObject

class CategoryRepository(private  val db:AppDatabase) {
    private val _categoriesList = MutableLiveData<List<CategoryModel>>()
    val categoriesList:LiveData<List<CategoryModel>>
    get() = _categoriesList

    private val _somethingWentWrong = MutableLiveData<Unit>()
    val somethingWentWrong:LiveData<Unit>
    get() = _somethingWentWrong

    suspend fun getAllCategories(){
       val response =  RetrofitClient.getApiService().getCategoryAll()
        if(response.isSuccessful){
            val json = JSONObject(response.body()?.string().toString())
            if(json.getInt("status") == 200){
                val categories = Gson().fromJson(json.getString("categories"),Array<CategoryModel>::class.java).toList()
                db.getCategoriesDao().truncate()
                categories.forEach{
                    db.getCategoriesDao().insetAllCategoryChildren(it.children)
                }
                _categoriesList.postValue(categories)
            }else{
                _somethingWentWrong.postValue(Unit)
            }
        }else{
            _somethingWentWrong.postValue(Unit)
        }
    }
}