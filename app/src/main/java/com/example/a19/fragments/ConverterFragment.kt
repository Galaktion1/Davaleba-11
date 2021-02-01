package com.example.a19.fragments

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.a19.R

class ConverterFragment : Fragment(R.layout.fragment_converter) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mText : TextView = view.findViewById(R.id.textView3)
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        val btcPrice = prefs.getString("btc", "")
        val ethPrice = prefs.getString("eth", "")
        val xrpPrice = prefs.getString("xrp", "")
        val dotPrice = prefs.getString("dot", "")
        val adaPrice = prefs.getString("ada", "")

        mText.text = "BTC Price: $btcPrice \n ETH Price: $ethPrice \n XRP Price: $xrpPrice \n DOT Price: $dotPrice \n ADA Price: $adaPrice"
        // marto btc, eth, xrp, dot, ada-s fasebia USD-shi
    }
}