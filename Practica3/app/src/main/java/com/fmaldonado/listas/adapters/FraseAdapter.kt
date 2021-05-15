package com.fmaldonado.listas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmaldonado.listas.databinding.FraseItemBinding
import com.fmaldonado.listas.models.Frase

class FraseAdapter(
    private val data: List<Frase>,
    private val context:Context
) : RecyclerView.Adapter<FraseAdapter.FraseViewHolder>() {


    class FraseViewHolder(val binding: FraseItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FraseViewHolder {
        val binding = FraseItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return FraseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FraseViewHolder, position: Int) {
        val item = data[position]
        holder.binding.frase.text = context.getString(item.fraseId)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}