package com.lak.matchesfashionapp.data.loacal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lak.matchesfashionapp.data.remote.apiresponse.Converters
import com.lak.matchesfashionapp.data.remote.apiresponse.ProductDetails

//@Database(entities = [ProductDetails::class], version = 1,)
//@TypeConverters(Converters::class)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun getProductDao(): ProductDao

    companion object{
        private var instance: ProductDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ProductDatabase::class.java,
                "product_db"
            ).build()
    }
}