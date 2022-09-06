package com.patriespert.example1

import android.view.ViewGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun test(viewGroup: ViewGroup) {

    GlobalScope.launch(Dispatchers.Main) {
        val result = withContext(Dispatchers.IO) { heavyTask() }
        print(result)
    }
}

fun heavyTask():String = "Hello!"