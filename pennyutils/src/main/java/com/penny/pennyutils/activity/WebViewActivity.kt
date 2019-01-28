package com.penny.pennyutils.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.penny.pennyutils.R
import kotlinx.android.synthetic.main.layout_webview.*


class WebViewActivity : AppCompatActivity() {
    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_webview)

        url = intent.getStringExtra("url")

        initWebView()
        initButton()
    }

    private fun initWebView(){
        with(webView){
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    backward.isEnabled = view!!.canGoBack()
                    forward.isEnabled = view.canGoForward()
                }
            }

           loadUrl(url)
        }

    }

    private fun initButton() {

        forward.setOnClickListener {
            if (webView.canGoForward())
                webView.goForward()
        }

        backward.setOnClickListener {
            if (webView.canGoBack())
                webView.goBack()
            else
                finish()
        }

        refresh.setOnClickListener {
            webView.reload()
        }

        share.setOnClickListener {
            //TODO share
        }

        close.setOnClickListener {
            finish()
        }
    }


}
