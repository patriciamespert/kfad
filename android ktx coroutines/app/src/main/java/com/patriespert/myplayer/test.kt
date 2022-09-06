package com.patriespert.myplayer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//coroutines
fun test(){

    GlobalScope.launch(Dispatchers.Main){
        val result = withContext(Dispatchers.IO) { heavyTask()}
        print(result)
    }

}

fun heavyTask():String = "Hello"

