package com.example.epoxysample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.epoxysample.epoxy.EpoxyActivity
import com.example.epoxysample.normal.NormalActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.normalBtn -> {
                startActivity(Intent(this, NormalActivity::class.java))
            }
            R.id.epoxyBtn -> {
                startActivity(Intent(this, EpoxyActivity::class.java))
            }
            R.id.composeBtn -> {
                Toast.makeText(this, "compose Button", Toast.LENGTH_SHORT).show()
            }
        }
    }
}