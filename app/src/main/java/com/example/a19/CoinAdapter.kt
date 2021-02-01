package com.example.a19

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CoinAdapter(private val coinList: List<CoinItem>) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return CoinViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val currentItem = coinList[position]
        Picasso.get().load("https://s2.coinmarketcap.com/static/img/coins/64x64/"+currentItem.id+".png").into(holder.icon)
        holder.symbol.text = currentItem.symbol
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price
        holder.change_24h.text = currentItem.change_24h
    }

    override fun getItemCount() = coinList.size

    class CoinViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val icon : ImageView = itemView.findViewById(R.id.image_view)
        val symbol : TextView = itemView.findViewById(R.id.text_symbol)
        val name : TextView = itemView.findViewById(R.id.text_name)
        val price : TextView = itemView.findViewById(R.id.text_price)
        val change_24h : TextView = itemView.findViewById(R.id.text_change)
    }
}