package com.example.musicplayer

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val dataList: List<Data>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    /*
Imagine you have a box (RecyclerView) to
display toys (data) neatly. "MyAdapter"
 is like your mom who arranges toys in the box.
 "context" is your home where the box is. "dataList"
  is the list of toys to put in the box.
  "RecyclerView.Adapter" is the job description for your mom.
  "MyViewHolder" is your mom's helper who helps her arrange toys.
  "itemView" is each toy she arranges. "RecyclerView.ViewHolder"
   is the helper's job description.
    So, this code helps your mom (adapter) organize toys (data)
    in the box (RecyclerView) with the help of her helper (MyViewHolder).
*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create the view in case the layout manager fails to create views for the data

        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            //populate the data into the view

        val currentData = dataList[position]


        val mediaPlayer = MediaPlayer.create(context, currentData.preview.toUri())

        holder.title.text = currentData.title

        Picasso.get().load(currentData.album.cover).into(holder.image);

        holder.play.setOnClickListener {
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }

    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView
        val title: TextView
        val play: ImageButton
        val pause: ImageButton

        init {
            image = itemView.findViewById(R.id.musicImage)
            title = itemView.findViewById(R.id.musicTitle)
            play = itemView.findViewById(R.id.btnPlay)
            pause = itemView.findViewById(R.id.btnPause)
        }


    }

}