package com.example.a19.fragments

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.a19.R

class ConverterFragment : Fragment(R.layout.fragment_converter) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mText : TextView = view.findViewById(R.id.text_first)
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val btcPrice = prefs.getString("btc", "")
        val ethPrice = prefs.getString("eth", "")
        val xrpPrice = prefs.getString("xrp", "")
        val dotPrice = prefs.getString("dot", "")
        val adaPrice = prefs.getString("ada", "")


        val spinner2: Spinner = view.findViewById(R.id.spinner2)
        ArrayAdapter.createFromResource(this, R.array.coins, android.R.layout.simple_spinner_item)
            .also {  adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter
            }


        val spinner3: Spinner = view.findViewById(R.id.spinner3)
        ArrayAdapter.createFromResource(this, R.array.coins,android.R.layout.simple_spinner_item)
            .also {  adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter
            }


        mText.text = "BTC Price: $btcPrice \n ETH Price: $ethPrice \n XRP Price: $xrpPrice \n DOT Price: $dotPrice \n ADA Price: $adaPrice"
        // marto btc, eth, xrp, dot, ada-s fasebia USD-shi

        val text_first : TextView = view.findViewById(R.id.text_first)
        if(view is TextView) {

            var price: String = text_first.text.toString()
            text_first.text = "1"



        }

        val text_price : TextView = view.findViewById(R.id.text_price)
        if(view is TextView) {

            val result: String = text_price.text.toString()
            text_price.text = ""

        }




    }


}