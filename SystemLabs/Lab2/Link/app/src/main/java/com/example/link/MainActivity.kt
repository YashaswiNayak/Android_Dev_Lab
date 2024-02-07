package com.example.link

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextUrl: EditText
    private lateinit var buttonOpenUrl: Button
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextUrl = findViewById(R.id.editTextUrl)
        buttonOpenUrl = findViewById(R.id.buttonOpenUrl)
        webView = findViewById(R.id.webView)

        webView.webViewClient = WebViewClient()

        buttonOpenUrl.setOnClickListener {
            val url = editTextUrl.text.toString()

            // Check if the URL is not null and not empty before loading
            if (url.isNotBlank()) {
                webView.loadUrl(url)
            } else {
                editTextUrl.setText("")

            }
        }
    }
}