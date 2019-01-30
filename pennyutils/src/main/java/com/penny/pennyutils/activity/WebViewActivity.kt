package com.penny.pennyutils.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.penny.pennyutils.R
import kotlinx.android.synthetic.main.layout_webview.*
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.penny.pennyutils.E.URL


class WebViewActivity : AppCompatActivity() {
    private lateinit var url: String

    public fun createIntent(context: Context, url: String): Intent {
        val intent = Intent(context, WebViewActivity::class.java)
        intent.putExtra(URL, url)
        return intent
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_webview)

        url = intent.getStringExtra("url")

        initWebView()
        initView()
        initButton()
    }

    private fun initWebView() {
        with(webView) {
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    backward.isEnabled = view!!.canGoBack()
                    forward.isEnabled = view.canGoForward()
                }
            }
            setNetworkAvailable(true)
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            loadUrl(url)
        }

    }

    private fun initView(){
        val close = findViewById<View>(R.id.close) as ImageButton
        close.setOnClickListener {
            finish()
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
    }


}
