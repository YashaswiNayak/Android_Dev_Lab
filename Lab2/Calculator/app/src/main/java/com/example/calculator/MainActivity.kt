package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var operator1=0.0
    private var operand=""
    private var operator2=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textview=findViewById<TextView>(R.id.tvResult)
        val buttons= arrayOf<Button>(
            findViewById(R.id._0),
            findViewById(R.id._1),
            findViewById(R.id._2),
            findViewById(R.id._3),
            findViewById(R.id._4),
            findViewById(R.id._5),
            findViewById(R.id._6),
            findViewById(R.id._7),
            findViewById(R.id._8),
            findViewById(R.id._9),
            findViewById(R.id.decimal),
        )
        val operators= arrayOf<Button>(
            findViewById(R.id.addition),
            findViewById(R.id.subtract),
            findViewById(R.id.multiply),
            findViewById(R.id.divide),
        )
        for(btn in buttons){
            btn.setOnClickListener{
                val temp=textview.text
                textview.text="$temp${btn.text}"
            }
        }
        for (operator in operators){
            operator.setOnClickListener{
                operand=operator.text.toString()
                operator1=textview.text.toString().toDouble()
                textview.text=""
            }
        }
        findViewById<Button>(R.id.equals).setOnClickListener{
            operator2=textview.text.toString().toDouble()
            var result=0.0
            when(operand){
                "+"-> result=operator1+operator2
                "-"->result=operator1-operator2
                "/"->result=operator1/operator2
                "*"->result=operator1*operator2

            }
            textview.text=result.toString()
        }
        findViewById<Button>(R.id.clear).setOnClickListener {
            textview.text=""
            operator1=0.0
            operator2=0.0
            operand=""
        }

    }
}