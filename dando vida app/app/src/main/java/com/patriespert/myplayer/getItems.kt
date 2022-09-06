package com.patriespert.myplayer

import com.patriespert.myplayer.MediaItem.Type

/*//Ejercicio.Convertir getItems para que use un rango
fun getItems(): List<MediaItem> = (1..10).map{
    MediaItem(
        "Title $it",
        "https://placekitten.com/200/200?image=$it",
        if(it % 3 == 0 ) Type.VIDEO else Type.PHOTO
    )
}*/

//Ejercicio. Transformar getItems en un object

object MediaProvider {
    fun getItems(): List<MediaItem> = (1..10).map{
        MediaItem(
            "Title $it",
            "https://placekitten.com/200/200?image=$it",
            if(it % 3 == 0 ) Type.VIDEO else Type.PHOTO
        )
    }
}