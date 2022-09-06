package com.patriespert.myplayer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,message,length).show()
}

//Ejercicio 1. Crear una funcion de extension "toast" para los ViewHolder
fun RecyclerView.ViewHolder.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    itemView.context.toast(message)
}

//Ejercicio 2. Crear una funcion inflate para ViewGroup que reciba el id del layout
fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = false): View = LayoutInflater
    .from(context)
    .inflate(resource,this,attachToRoot)

//Ejercicio 3. Crea una funcion de extension llamada loadUrl que permita a un ImageView cargar una imagen usando Picasso (o Glide)

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}


//Reified
inline fun <reified T: Activity> Context.startActivity(){
    val intent = Intent(this,T::class.java)
    startActivity(intent)
}