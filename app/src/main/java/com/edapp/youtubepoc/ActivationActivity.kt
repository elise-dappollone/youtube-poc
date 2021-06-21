package com.edapp.youtubepoc

import android.content.Intent

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.edapp.youtubepoc.library.YouTubeFragment

class ActivationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activation)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<Button>(R.id.embedded_button).setOnClickListener { view ->
            val fragment = YouTubeFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.viewContainer, fragment).commit()
        }

        findViewById<Button>(R.id.webView_button).setOnClickListener { view ->
            val fragment = WebViewFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.viewContainer, fragment).commit()
        }

        findViewById<Button>(R.id.link_button).setOnClickListener { view ->
            val url = "https://www.youtube.com/watch?v=R9QNrYgeZyQ"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}