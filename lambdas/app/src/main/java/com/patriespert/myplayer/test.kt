package com.patriespert.myplayer

import android.content.Context
import android.widget.TextView

fun test(){
    val sum:(Int,Int) -> Int = {x,y -> x + y}
    val mul:(Int,Int) -> Int = {x,y -> x * y}

    doOp(2,3,sum) //6
    doOp(2,3,mul) //6
}

fun doOp(x:Int,y:Int,op:(Int,Int) -> Int) = op(x,y)