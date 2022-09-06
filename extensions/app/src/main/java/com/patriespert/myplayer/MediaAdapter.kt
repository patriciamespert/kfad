package com.patriespert.myplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.patriespert.myplayer.databinding.ViewMediaItemBinding

class MediaAdapter(private val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*val binding = ViewMediaItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding.root)*/
        val v = parent.inflate(R.layout.view_media_item)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ViewMediaItemBinding.bind(view)

        /*private val title: TextView = view.findViewById(R.id.mediaTitle)
        private val thumb: ImageView = view.findViewById(R.id.mediaThumb)*/


        fun bind(mediaItem: MediaItem) {
            binding.mediaTitle.text = mediaItem.title
            binding.mediaThumb.loadUrl(mediaItem.url)
            binding.root.setOnClickListener{toast(mediaItem.title)}
        }
    }

}