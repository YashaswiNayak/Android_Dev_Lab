package com.example.layout_practice

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ImageAdapter(private val context: Context,private val pics:Array<Int>):BaseAdapter(){
    override fun getCount(): Int {
        return pics.size
    }

    override fun getItem(position: Int): Any {
        return  pics[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
// if it's not recycled, initialize some attributes
            imageView = ImageView(context)
            imageView.layoutParams = AbsListView.LayoutParams(300, 300)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(20, 20, 20, 20)
        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(pics[position])
        return imageView

    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val places = arrayOf(
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose",
            "Austin", "Jacksonville", "Fort Worth", "Columbus", "Charlotte",
            "Detroit", "El Paso", "Seattle", "Denver", "Washington"
        )
        val pics= arrayOf(
            R.drawable.blue,
            R.drawable.green,
            R.drawable.yellow,
            R.drawable.chocolate_chocolate_cake_1
        )
        val listview:ListView=findViewById(R.id.listView)
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,places)
        listview.adapter=adapter
        val gridView: GridView = findViewById(R.id.gridView)
        val adapter2 = ImageAdapter(this, pics)
        gridView.adapter = adapter2


    }
}