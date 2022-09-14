package com.example.epoxysample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.epoxysample.compose.ComposeActivity
import com.example.epoxysample.epoxy.EpoxyActivity
import com.example.epoxysample.normal.NormalActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @OptIn(ExperimentalAnimationApi::class)
    fun btnClick(view: View) {
        when (view.id) {
            R.id.normalBtn -> {
                startActivity(Intent(this, NormalActivity::class.java))
            }
            R.id.epoxyBtn -> {
                startActivity(Intent(this, EpoxyActivity::class.java))
            }
            R.id.composeBtn -> {
                startActivity(Intent(this, ComposeActivity::class.java))
            }
        }
    }
}