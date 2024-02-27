package com.example.food_items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var  listView: ListView
    private lateinit var submit: Button
    private var orderSubmitted=false
    private val foodItems=arrayOf("Carrot: 40","Tomato: 25","Potato: 10","Pumpkin: 150","Coriander: 5","Mango: 100","Apples: 50","Watermelon: 200")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView=findViewById<ListView>(R.id.listview)
        submit=findViewById<Button>(R.id.submit)
        val adapter= ArrayAdapter<String>(
            this,
            R.layout.list_item,
            R.id.food_text,
            foodItems
        )
        listView.adapter=adapter
        listView.setOnItemClickListener { _, _, _, _ ->
            displayOrder()
//        }
        submit.setOnClickListener {
            displayOrder()
            if(!orderSubmitted){

                disableListViewItems()
                orderSubmitted=true
            }
        }
    }
    fun displayOrder(){
        val selectedItems= mutableListOf<String>()
        val adapter=listView.adapter as ArrayAdapter<*>
        for (i in 0 until adapter.count) {
            val item = adapter.getItem(i) as String
            val view = listView.getChildAt(i)
            val checkBox = view.findViewById<CheckBox>(R.id.checkbox_food)
            if (checkBox.isChecked) {
                selectedItems.add(item)
                val orderDetails = StringBuilder()
                val totalCost = selectedItems.sumOf { getFoodCost(it) }
                orderDetails.append("\nTotal : $$totalCost")
                Toast.makeText(this, orderDetails.toString(), Toast.LENGTH_LONG).show()
            }
        }
        val orderDetails = StringBuilder()
        val totalCost = selectedItems.sumOf { getFoodCost(it) }
        orderDetails.append("\nTotal : $$totalCost")
        Toast.makeText(this, orderDetails.toString(), Toast.LENGTH_LONG).show()
    }
    fun getFoodCost(foodItem: String): Int {
        // You can customize the cost based on your menu
        return when (foodItem) {
            "Carrot: 40" -> 40
            "Tomato: 25" -> 25
            "Potato: 10" -> 10
            "Pumpkin: 150"->150
            "Coriander: 5"->5
            "Mango: 100"->100
            "Apples: 50"->50
            "Watermelon: 200"->200
            else -> 0
        }
    }
    fun disableListViewItems() {
        for (i in 0 until listView.childCount) {
            val view = listView.getChildAt(i)
            val checkBox = view.findViewById<CheckBox>(R.id.checkbox_food)
            checkBox.isEnabled = false
        }
    }
}