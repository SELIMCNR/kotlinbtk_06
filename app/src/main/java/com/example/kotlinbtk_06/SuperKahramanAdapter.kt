package com.example.kotlinbtk_06

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.kotlinbtk_06.databinding.RecyclerRowBinding

class SuperKahramanAdapter(val superKahramanListesi:ArrayList<SuperKahraman>) : RecyclerView.Adapter<SuperKahramanAdapter.SuperKahramanViewHolder>() {
    class  SuperKahramanViewHolder(val binding:RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperKahramanAdapter.SuperKahramanViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuperKahramanViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SuperKahramanAdapter.SuperKahramanViewHolder,
        position: Int
    ) {
        holder.binding.textViewbaslik.text = superKahramanListesi.get(position).isim
        holder.binding.textViewaciklama.text = superKahramanListesi.get(position).meslek
        holder.binding.imageViewgorsel.setImageResource(superKahramanListesi.get(position).gorselıcon)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,TanitimAktivitesi::class.java)
           // intent.putExtra("secilenKahraman",superKahramanListesi[position])  intent ile veri gönder
            MySıngleton.secilenSuperKahraman = superKahramanListesi[position]
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return  superKahramanListesi.size
    }


}