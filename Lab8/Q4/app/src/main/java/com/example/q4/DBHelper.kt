package com.example.q4

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context,factory: CursorFactory?):SQLiteOpenHelper(context,"student.db",factory,1) {
    companion object{
        const val TABLE_NAME = "student"
        const val ID = "id"
        const val NAME = "name"
        const val SEMESTER_ID="sem_id"
        const val SEM="sem"
        const val BRANCH = "branch"
        const val FACULTY = "faculty"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME TEXT,$SEMESTER_ID INTEGER,$SEM INTEGER,$BRANCH TEXT NOT NULL, $FACULTY TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")

    }
    fun insertData(student:StudentDetails){
        val db=writableDatabase
        val values=ContentValues()
        values.put(NAME,student.name)
        values.put(SEMESTER_ID,student.studentid)
        values.put(SEM,student.semester)
        values.put(BRANCH,student.branch)
        values.put(FACULTY,student.faculty)
        db.insert(TABLE_NAME,null,values)
        db.close()
    }

}