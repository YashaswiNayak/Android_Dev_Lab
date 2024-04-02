package com.example.q3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class DBHelper(context: Context, factory: CursorFactory?): android.database.sqlite.SQLiteOpenHelper(context,"movie.db",factory,1){
    companion object{
        const val TABLE_NAME = "movie"
        const val ID = "_id"
        const val NAME = "name"
        const val YEAR = "year"
        const val RATING = "rating"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY AUTOINCREMENT,$NAME TEXT,$YEAR INTEGER NOT NULL,$RATING DOUBLE)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
     fun addMovie(review:Movie){
        val db=writableDatabase
        val values=ContentValues()
        values.put(NAME,review.name)
        values.put(YEAR,review.year)
        values.put(RATING,review.rating)
        db.insert(TABLE_NAME,null,values)
        db.close()
    }

}