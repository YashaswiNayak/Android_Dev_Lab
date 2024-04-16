package com.example.database_practice

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context,factory: CursorFactory?):SQLiteOpenHelper(context,"student.db",factory,1) {
    companion object{
        val TABLE_NAME = "student_table"
        val ID = "_id"
        val NAME = "name"
        val AGE = "age"
        val SUB1= "sub1"
        val SUB2 = "sub2"
        val SUB3 = "sub3"
    }
    override fun onCreate(db:SQLiteDatabase?){
        db?.execSQL("CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY AUTOINCREMENT,$NAME TEXT UNIQUE,$AGE INTEGER,$SUB1 INTEGER,$SUB2 INTEGER,$SUB3 INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun addName(detail:StudentData){
        val value=ContentValues()
        value.put(NAME,detail.name)
        value.put(AGE,detail.age)
        value.put(SUB1,detail.sub1)
        value.put(SUB2,detail.sub2)
        value.put(SUB3,detail.sub3)
        val db=this.writableDatabase
        db.insert(TABLE_NAME,null,value)
        db.close()
    }
    fun getAllItems(): ArrayList<String> {
        val db=this.readableDatabase
        val cursor=db?.rawQuery("SELECT * FROM $TABLE_NAME",null)
        val list=ArrayList<String>()
        if(cursor!!.moveToFirst()){
            do{
                val id=cursor.getInt(cursor.getColumnIndexOrThrow(ID))
                val name=cursor.getString(cursor.getColumnIndexOrThrow(NAME))
                val age=cursor.getInt(cursor.getColumnIndexOrThrow(AGE))
                val sub1=cursor.getInt(cursor.getColumnIndexOrThrow(SUB1))
                val sub2=cursor.getInt(cursor.getColumnIndexOrThrow(SUB2))
                val sub3=cursor.getInt(cursor.getColumnIndexOrThrow(SUB3))
                val data="ID: $id,Name: $name , Age: $age, Sub1: $sub1, Sub2: $sub2,Sub3: $sub3"
                list.add(data)
            }while(cursor.moveToNext())
        }
        cursor.close()
        return list
    }
    fun getAvg(name:String):Double{
        val db=this.readableDatabase
        var avg=0.00
        val cursor=db?.rawQuery("SELECT * FROM $TABLE_NAME WHERE $NAME='$name'",null)
        if(cursor!!.moveToFirst()){
            val sub1=cursor.getInt(cursor.getColumnIndexOrThrow(SUB1))
            val sub2=cursor.getInt(cursor.getColumnIndexOrThrow(SUB2))
            val sub3=cursor.getInt(cursor.getColumnIndexOrThrow(SUB3))
            avg= ((sub1+sub2+sub3)/3).toDouble()
        }
        cursor.close()
        db.close()
        return avg

    }

}