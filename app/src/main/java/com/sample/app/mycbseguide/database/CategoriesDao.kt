package com.sample.app.mycbseguide.database

import androidx.room.*
import com.sample.app.mycbseguide.models.CategoryChildren
import com.sample.app.mycbseguide.utils.Constraints
import retrofit2.http.DELETE

@Dao
interface CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetAllCategoryChildren(list:List<CategoryChildren>)

    @Query("SELECT * FROM ${Constraints.CHILD_CATEGORY} WHERE parent = :parentId")
    suspend fun getChildCategories(parentId:Int):List<CategoryChildren>

    @Query("DELETE FROM ${Constraints.CHILD_CATEGORY}")
    suspend fun truncate()
}