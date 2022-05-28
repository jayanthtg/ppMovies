package com.movies.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.movies.R
import com.movies.repo.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.Holder>() {

    private var items: List<Movie> = listOf()
    var onTapListener: OnItemTap? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_now_playing_movie, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun items(items: List<Movie>) {
        this.items = items
        notifyDataSetChanged()
    }

   inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.poster)
        val title: TextView = itemView.findViewById(R.id.titleTv)
        val desc: TextView = itemView.findViewById(R.id.descTv)

        init {
            itemView.setOnClickListener { onTap() }
        }

        fun bind(item: Movie) {
            Glide.with(poster).load(item.posterPath).into(poster)
            title.text = item.title
            desc.text = item.overview
        }

        private fun onTap() {
            val pos = itemView.tag
            if (pos is Int) {
                onTapListener?.onTap(items[pos])
            }
        }
    }

    fun interface OnItemTap {
        fun onTap(item: Movie)
    }
}