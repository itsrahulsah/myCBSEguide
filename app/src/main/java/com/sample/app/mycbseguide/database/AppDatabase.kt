package com.sample.app.mycbseguide.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sample.app.mycbseguide.models.CategoryChildren

@Database( entities = [CategoryChildren::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getCategoriesDao():CategoriesDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

           return  if(INSTANCE == null){
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "cbse_guide_db"
                    ).build()
                    INSTANCE = instance
                }
               INSTANCE!!
            }else {
               INSTANCE!!
           }


        }

    }
}