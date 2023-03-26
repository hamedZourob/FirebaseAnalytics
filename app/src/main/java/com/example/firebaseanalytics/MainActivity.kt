package com.example.firebaseanalytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var Button: Button
    private lateinit var Button2: Button
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = Firebase.analytics
        Button = findViewById(R.id.button)
        Button2 = findViewById(R.id.button2)
        Button.setOnClickListener {
            selectContentEvent("image1","ImageView","image")
        }
        Button2.setOnClickListener {
            TraakScreenEvent()
        }
    }
    fun selectContentEvent(id: String, name: String, contentType: String) {
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT) {
            param(FirebaseAnalytics.Param.ITEM_ID, id)
            param(FirebaseAnalytics.Param.ITEM_NAME, name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)

        }

    }
    fun TraakScreenEvent() {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, "Main")
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
            param(FirebaseAnalytics.Param.SCREEN_NAME, "Main")

        }
    }
}