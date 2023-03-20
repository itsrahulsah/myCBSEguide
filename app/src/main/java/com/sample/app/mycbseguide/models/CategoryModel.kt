package com.sample.app.mycbseguide.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sample.app.mycbseguide.utils.Constraints

data class CategoryModel(
     @PrimaryKey val id: Int,
    val mobile_logo: String?,
    val name: String,
    val parent: Int?,
    val web_logo: String?,
    val weight: Int,
    val children: List<CategoryChildren>
)
@Entity(tableName = Constraints.CHILD_CATEGORY)
data class CategoryChildren(
    @PrimaryKey val id: Int,
    val mobile_logo: String?,
    val name: String,
    val parent: Int,
    val web_logo: String?,
    val weight: Int,
    val absolute_url_course: String,
)