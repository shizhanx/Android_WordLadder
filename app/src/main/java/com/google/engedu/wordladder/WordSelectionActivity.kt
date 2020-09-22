/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.engedu.wordladder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.engedu.worldladder.R
import java.io.IOException

class WordSelectionActivity : AppCompatActivity() {
    private var dictionary: PathDictionary? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_selection)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val assetManager = assets
        try {
            val inputStream = assetManager.open("words.txt")
            dictionary = PathDictionary(inputStream)
        } catch (e: IOException) {
            val toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG)
            toast.show()
        }
    }

    fun onStart(view: View?): Boolean {
        val startWordView = findViewById<View>(R.id.startWord) as TextView
        val endWordView = findViewById<View>(R.id.endWord) as TextView
        val words = dictionary!!.findPath(
                startWordView.text.toString().toLowerCase(),
                endWordView.text.toString().toLowerCase())
        if (words != null) {
            // TODO: Launch new activity here
        } else {
            Log.i("Word ladder", "Word combination is not possible")
            val toast = Toast.makeText(this, "Couldn't find path between the two given words",
                    Toast.LENGTH_SHORT)
            toast.show()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_word_selection, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}