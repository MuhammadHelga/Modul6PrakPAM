package com.example.tugasmodul6

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView

class songAdapter(
    private val context: Context,
    private val data:ArrayList<Song>
) : RecyclerView.Adapter<songAdapter.songViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): songAdapter.songViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false)
        return songViewHolder(view)
    }

    class song
    override fun onBindViewHolder(holder: songAdapter.songViewHolder, position: Int) {
        val song: Song = data.get(position)
        val currentItem = data[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(context, viewSong::class.java)
            intent.putExtra("judul", currentItem.judul)
            intent.putExtra("penyanyi", currentItem.penyanyi)
            context.startActivities(arrayOf(intent))
        }

        holder.delSong.setOnClickListener {
            val itemSong = holder.adapterPosition
            if (itemSong != RecyclerView.NO_POSITION) {
                data.removeAt(itemSong)
                notifyItemRemoved(itemSong)
            }
        }
        holder.judul.text = song.judul
        holder.penyanyi.text = song.penyanyi


    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class songViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val judul: TextView = itemView.findViewById(R.id.outJudul)
        val penyanyi: TextView = itemView.findViewById(R.id.outPenyanyi)
        val delSong: ImageButton = itemView.findViewById(R.id.deleteSong)
    }
}