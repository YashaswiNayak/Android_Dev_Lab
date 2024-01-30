package com.example.food_items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var  listView: ListView
    private lateinit var submit: Button
    private var orderSubmitted=false
    private val foodItems=arrayOf("Pizza","Burger","Pasta","Cake")
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
        submit.setOnClickListener {
            if(!orderSubmitted){
                displayOrder()
                disableListViewItems()
                orderSubmitted=true
            }
        }
    }
    private fun displayOrder(){
        val selectedItems= mutableListOf<String>()
        val adapter=listView.adapter as ArrayAdapter<*>
        for (i in 0 until adapter.count) {
            val item = adapter.getItem(i) as String
            val view = listView.getChildAt(i)
            val checkBox = view.findViewById<CheckBox>(R.id.checkbox_food)
            if (checkBox.isChecked) {
                selectedItems.add(item)
            }
        }
        val orderDetails = StringBuilder()
        val totalCost = selectedItems.sumOf { getFoodCost(it) }
        orderDetails.append("\nTotal Cost: $$totalCost")
        Toast.makeText(this, orderDetails.toString(), Toast.LENGTH_LONG).show()
    }
    private fun getFoodCost(foodItem: String): Int {
        // You can customize the cost based on your menu
        return when (foodItem) {
            "Pizza" -> 10
            "Burger" -> 8
            "Pasta" -> 12
            "Cake"->20
            else -> 0
        }
    }
    private fun disableListViewItems() {
        for (i in 0 until listView.childCount) {
            val view = listView.getChildAt(i)
            val checkBox = view.findViewById<CheckBox>(R.id.checkbox_food)
            checkBox.isEnabled = false
        }
    }
}