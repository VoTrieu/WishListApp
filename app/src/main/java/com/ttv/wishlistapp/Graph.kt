package com.ttv.wishlistapp

import android.content.Context
import androidx.room.Room
import com.ttv.wishlistapp.data.WishDatabase
import com.ttv.wishlistapp.data.WishRepository

object Graph {
    private lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}