package com.patriespert.myplayer


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.patriespert.myplayer.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity() : AppCompatActivity(){

    /*override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job //cada vez que creemos la activity, creamos el job de nuevo*/

    //Ejercicio. Usa lazy para inicializar el adapter solo en el momento en que se vaya a usar
    private val adapter = MediaAdapter{ toast(it.title) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //job = SupervisorJob() //si un job produce una excepcion solo se cancela ese
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
        updateItems()
    }

    private fun updateItems(filter: Int = R.id.filter_all){
        lifecycleScope.launch{
            //progress.visibility = View.VISIBLE
            adapter.items = withContext(Dispatchers.IO){ getFilteredItems(filter)}
            //progress.visibility = View.GONE
        }
    }

    private fun getFilteredItems(filter: Int):List<MediaItem>{
        return MediaProvider.getItems().let { media ->
            when (filter) {
                R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }
                R.id.filter_all -> media
                else -> emptyList()
            }
        }
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

       /* adapter.items = MediaProvider.getItems().let { media ->
            when(item.itemId) {
                R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }
                R.id.filter_all -> media
                else -> emptyList()
            }
        }*/

        updateItems(item.itemId)

        return super.onOptionsItemSelected(item)
    }

    /*override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }*/

}

//Ejercicio. Usa las corrutinas para realizar una operación en un hilo secundario y no bloquear la UI