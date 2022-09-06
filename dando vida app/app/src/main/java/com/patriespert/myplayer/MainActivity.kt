package com.patriespert.myplayer


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.patriespert.myplayer.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(){

    //Ejercicio. Usa lazy para inicializar el adapter solo en el momento en que se vaya a usar
    private val adapter by lazy  { MediaAdapter(MediaProvider.getItems()){ toast(it.title) }}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Ejercicio. Crear un menu de filtro que nos permita mostrar todos los elementos, solo fotos o solo videos.
    //(utilizar coleccion con el filter y main.xml)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        /*adapter.items = when(item.itemId) {
            R.id.filter_photos -> getItems().filter { it.type == MediaItem.Type.PHOTO }
            R.id.filter_videos -> getItems().filter { it.type == MediaItem.Type.VIDEO }
            R.id.filter_all -> getItems()
            else -> emptyList()
        }*/

        adapter.items = MediaProvider.getItems().let { media ->
            when(item.itemId) {
                R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }
                R.id.filter_all -> media
                else -> emptyList()
            }
        }





        return super.onOptionsItemSelected(item)
    }

}
