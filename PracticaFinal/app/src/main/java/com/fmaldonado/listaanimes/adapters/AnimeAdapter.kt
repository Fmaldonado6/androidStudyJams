package com.fmaldonado.listaanimes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.fmaldonado.listaanimes.databinding.AnimeItemBinding
import com.fmaldonado.listaanimes.models.Anime

class AnimeAdapter(val animes: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(val binding: AnimeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = AnimeItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val item = animes[position]

        holder.binding.title.text = item.title
        holder.binding.image.load(item.imageUrl)
    }

    override fun getItemCount(): Int {
        return animes.size
    }

}