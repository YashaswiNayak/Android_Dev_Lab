package com.example.q1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context):SQLiteOpenHelper(context,"contact",null,1) {
    companion object{
        const val TABLE_NAME="contact"
        const val COL_ID="id"
        const val COL_NAME="name"
        const val COL_PHONE="phone"
        const val COL_EMAIL="email"

    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable=("CREATE TABLE $TABLE_NAME($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_NAME TEXT,$COL_PHONE TEXT,$COL_EMAIL TEXT)")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}