package com.penny.pennyutils.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient
import com.penny.pennyutils.E.URL
import com.penny.pennyutils.R
import kotlinx.android.synthetic.main.layout_webview.*


class WebViewActivity : AppCompatActivity() {
    private lateinit var url: String

    public fun createIntent(context: Context, url: String): Intent {
        return Intent(context, WebViewActivity::class.java).apply {
            putExtra(URL, url)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_webview)

        url = intent.getStringExtra(URL)

        initWebView()
        initView()
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
