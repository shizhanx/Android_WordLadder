package com.google.engedu.wordladder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.engedu.worldladder.R

class SolverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_solver)
        val path = intent.getStringArrayExtra("Path")!!
//        for (s in path) {
//            Log.d("sb", "onCreate: $s")
//        }
        findViewById<TextView>(R.id.startTextView).text = path.first()
        findViewById<TextView>(R.id.endTextView).text = path.last()
    }
}