package com.google.engedu.wordladder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.engedu.worldladder.R

class SolverActivity : AppCompatActivity() {
    var path: Array<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_solver)
        path = intent.getStringArrayExtra("Path")!!
//        for (s in path!!) {
//            Log.d("sb", "onCreate: $s")
//        }
        val startTextView = findViewById<TextView>(R.id.startTextView).apply {
            text = path!!.first()
        }
        val endTextView = findViewById<TextView>(R.id.endTextView).apply {
            text = path!!.last()
        }
        val wordLadder = findViewById<LinearLayout>(R.id.wordLadder)
        for (i in 1..path!!.size - 2) {
            wordLadder.addView(EditText(this), 1)
        }
    }

    fun onSolve(view: View?) {
        for (i in 1..path!!.size - 2) {
            val cur = findViewById<LinearLayout>(R.id.wordLadder).getChildAt(i) as EditText
            cur.setText(path!![i])
        }
    }
}