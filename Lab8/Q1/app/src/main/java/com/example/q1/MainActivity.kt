package com.example.q1

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper:DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dbHelper= DatabaseHandler(this)
        val saveButton :Button= findViewById(R.id.saveButton)
        val editButton :Button= findViewById(R.id.editButton)
        val displayButton :Button= findViewById(R.id.displayButton)
        saveButton.setOnClickListener{
            addContact()
        }
        editButton.setOnClickListener{
            editContact()
        }
        displayButton.setOnClickListener{
            displayContact()
        }


    }
    private fun addContact(){
        val name =findViewById<EditText>(R.id.name).text.toString()
        val phone =findViewById<EditText>(R.id.phonenumber).text.toString()
        val email =findViewById<EditText>(R.id.emailId).text.toString()
        val db:SQLiteDatabase=dbHelper.writableDatabase
        val values=ContentValues()
        values.put(DatabaseHandler.COL_NAME,name)
        values.put(DatabaseHandler.COL_PHONE,phone)
        values.put(DatabaseHandler.COL_EMAIL,email)
        val rowId= db.insert(DatabaseHandler.TABLE_NAME,null,values)
        db.close()
        Toast.makeText(this,"Contact with $rowId added",Toast.LENGTH_SHORT).show()
    }
    private fun displayContact(){
        val db=dbHelper.readableDatabase
        val cursor:Cursor=db.rawQuery("SELECT * FROM ${DatabaseHandler.TABLE_NAME}",null)
        val data=StringBuilder()
        if(cursor.count==0){
            Toast.makeText(this,"No records found",Toast.LENGTH_SHORT).show()
        }
        else{

            while(cursor.moveToNext()){
                val id=cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHandler.COL_ID))
                val name=cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.COL_NAME))
                val phone=cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.COL_PHONE))
                val email=cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHandler.COL_EMAIL))
                data.append("ID: $id , Name: $name ,Phone: $phone ,Email: $email\n")
            }
        }
        cursor.close()
        findViewById<TextView>(R.id.display).text=data.toString()
    }
    private fun editContact(){
        val id=findViewById<EditText>(R.id.id).text.toString()
        if(id.isEmpty()){
            Toast.makeText(this,"Enter ID",Toast.LENGTH_SHORT).show()
            return
        }
        val name=findViewById<EditText>(R.id.name).text.toString()
        val phone=findViewById<EditText>(R.id.phonenumber).text.toString()
        val email=findViewById<EditText>(R.id.emailId).text.toString()
        val db=dbHelper.writableDatabase
        val values=ContentValues()
        values.put(DatabaseHandler.COL_NAME,name)
        values.put(DatabaseHandler.COL_PHONE,phone)
        values.put(DatabaseHandler.COL_EMAIL,email)
        val selection="${DatabaseHandler.COL_ID}=?"
        val selectionArgs= arrayOf(id)
        val count=db.update(DatabaseHandler.TABLE_NAME,values,selection,selectionArgs)
        Toast.makeText(this,"$count records updated",Toast.LENGTH_SHORT).show()
        db.close()
    }
}