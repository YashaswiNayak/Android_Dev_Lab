package com.example.q2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context,factory:SQLiteDatabase.CursorFactory?):SQLiteOpenHelper(context,DATBASE_NAME,factory,1) {
    companion object {
        private val DATBASE_NAME = "grocery.db"
        private val TABLE_NAME = "grocery"
        private val ID = "id"
        private val ITEM = "item"
        private val COST = "cost"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY AUTOINCREMENT,$ITEM TEXT,$COST DOUBLE)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addGrocery(grocery: Grocery){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ITEM,grocery.item)
        contentValues.put(COST,grocery.cost)
        db.insert(TABLE_NAME,null,contentValues)
        db.close()

    }
}

