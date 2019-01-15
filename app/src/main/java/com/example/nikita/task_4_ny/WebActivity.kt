package com.example.nikita.task_4_ny

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val url = intent.getStringExtra("item_url")
        web_view.webViewClient = MyWebViewClient()
        web_view.loadUrl(url)
    }

    inner class MyWebViewClient: WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, request: String): Boolean {
            view?.loadUrl(request)
            return true
        }
    }
}