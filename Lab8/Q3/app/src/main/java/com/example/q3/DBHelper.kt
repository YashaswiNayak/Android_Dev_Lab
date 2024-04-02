package com.example.q3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class DBHelper(context: Context,factory: CursorFactory): android.database.sqlite.SQLiteOpenHelper(context,"movie.db",factory,1){
    override fun onCreate(db: SQLiteDatabase?) {
       
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}