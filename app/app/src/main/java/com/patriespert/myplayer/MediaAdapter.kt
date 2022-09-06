package com.patriespert.myplayer

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patriespert.myplayer.databinding.ViewMediaItemBinding

interface Listener{
    fun onClick(mediaItem: MediaItem) //(MediaItem) -> Unit
}

class MediaAdapter(private val items: List<MediaItem>, private val listener: (MediaItem) -> Unit): RecyclerView.Adapter<MediaAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = parent.inflate(R.layout.view_media_item)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{listener(item)}
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ViewMediaItemBinding.bind(view)

        fun bind(mediaItem: MediaItem) {

            //Usa la scope funcion with para simplificar las asignaciones dentro del ViewHolder
            with(binding) {
                mediaTitle.text = mediaItem.title
                mediaThumb.loadUrl(mediaItem.url)


            }
        }
    }

}