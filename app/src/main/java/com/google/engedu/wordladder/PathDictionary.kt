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

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

class PathDictionary(inputStream: InputStream?) {

    fun isWord(word: String): Boolean {
        return words.containsKey(word.toLowerCase())
    }

    private fun neighbours(word: String): List<String> {
        return ArrayList()
    }

    fun findPath(start: String, end: String): Array<String>? {
        return null
    }

    companion object {
        private const val MAX_WORD_LENGTH = 4
        private val words = HashMap<String, MutableList<String>>()
    }

    init {
        if (inputStream != null) {
            Log.i("Word ladder", "Loading dict")
            val `in` = BufferedReader(InputStreamReader(inputStream))
            var line: String? = null
            Log.i("Word ladder", "Loading dict")
            while (`in`.readLine().also { line = it } != null) {
                val word = line!!.trim { it <= ' ' }
                if (word.length > MAX_WORD_LENGTH) {
                    continue
                }
                words[word] = mutableListOf()
                val arr = word.toCharArray()
                for (i in arr.indices) {
                    val original = arr[i]
                    arr[i] = 'a'
                    while (arr[i] <= 'z') {
                        if (arr[i] != original) {
                            if (words.containsKey(String(arr))) {
                                words[word]!!.add(String(arr))
                                words[String(arr)]!!.add(word)
                            }
                        }
                        arr[i]++
                    }
                    arr[i] = original
                }
            }
        }
    }
}