package com.example.q2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var cost:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val groceryList= arrayListOf(Grocery(1,"Apple",1.0), Grocery(2,"Banana",2.0), Grocery(3,"Orange",3.0))
        val groceryNames=groceryList.map{it.item}
        val dbHandler = DatabaseHandler(this,null)
        val list=findViewById<Spinner>(R.id.list)
        list.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,groceryNames)
        list.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {

                for (i in groceryList){
                    if (i.item==groceryNames[position]){
                        dbHandler.addGrocery(i)
                        cost+=i.cost
                        Toast.makeText(applicationContext,"Total cost is $cost",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext,"Total cost is $cost",Toast.LENGTH_SHORT).show()
            }

        }

    }
}