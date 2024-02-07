package com.example.q3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout=findViewById<LinearLayout>(R.id.layouts)
        val images= arrayOf(
            R.drawable.android_1,
            R.drawable.android_cupcake,
            R.drawable.android_1_6_donut,
            R.drawable.android_2_0_eclair,
            R.drawable.android_2_2_froyo,
            R.drawable.android_2_3_gingerbread,
            R.drawable.android_3_0_honeycomb,
            R.drawable.android_4_0_ice_cream_sandwich,
            R.drawable.android_4_1_jelly_bean,
            R.drawable.android_4_4_kitkat,
            R.drawable.android_5_0_lollipop,
            R.drawable.android_6_0_marshmallow,
            R.drawable.android_7_0_nougat,
            R.drawable.android_8_0_oreo,
            R.drawable.android_9_0_pie,
            R.drawable.android_10,
            R.drawable.android_11,
            R.drawable.android_12,

        )
        val names= arrayOf(
            "1",
            "Cupcake",
            "Donut",
            "Eclair",
            "Froyo ",
            "Gingerbread ",
            "Honeycomb ",
            "Ice-Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop ",
            "Marshmallow ",
            "Nougat ",
            "Oreo ",
            "Pie ",
            "Q",
            "Android 11",
            "Android 12",

        )
        for(i in images.indices){
            val but=Button(this)
            but.text=names[i]


            but.setOnClickListener {
                val inflate=this.layoutInflater
                val layouts=inflate.inflate(R.layout.custom_toast,null)
                val image=layouts.findViewById<ImageView>(R.id.image)
                image.setBackgroundResource(images[i])
                val toast =Toast(this)
                toast.duration=Toast.LENGTH_SHORT
                toast.view=layouts
                toast.show()

            }
            layout.addView(but)

        }
    }
}