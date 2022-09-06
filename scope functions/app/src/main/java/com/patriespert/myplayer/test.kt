package com.patriespert.myplayer

import android.content.Context
import android.widget.TextView

fun test(context: Context){
    val textView = TextView(context).apply {

        /*textView.text = "Hello"
    textView.hint = "GB"
    textView.textSize = 25f*/

        text = "Hello"
        hint = "GB"
        textSize = 25f
    }
}
