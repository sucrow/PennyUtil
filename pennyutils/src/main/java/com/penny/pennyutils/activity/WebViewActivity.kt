package com.penny.pennyutils.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.penny.pennyutils.R
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import com.penny.pennyutils.E.URL


class WebViewActivity : AppCompatActivity() {
    private lateinit var url: String
    private lateinit var webView: WebView
    private lateinit var backward: ImageButton
    private lateinit var forward: ImageButton
    private lateinit var refresh: ImageButton
    private lateinit var share: ImageButton
    private lateinit var close: ImageButton


    public fun createIntent(context: Context, url: String): Intent {
        return Intent(context, WebViewActivity::class.java).apply {
            putExtra(URL, url)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_webview)

        url = intent.getStringExtra(URL)

        init()
        initWebView()
        initView()
    }

    private fun init() {
        forward = findViewById<View>(R.id.forever) as ImageButton
        backward = findViewById<View>(R.id.backward) as ImageButton
        refresh = findViewById<View>(R.id.refresh) as ImageButton
        share = findViewById<View>(R.id.share) as ImageButton
        close = findViewById<View>(R.id.close) as ImageButton

        webView = findViewById<View>(R.id.webView) as WebView
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

    private fun initView() {
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
