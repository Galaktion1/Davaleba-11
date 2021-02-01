package com.example.a19.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.TextUtils
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.a19.R

class ConverterFragment : Fragment(R.layout.fragment_converter) {
    private lateinit var text_first: TextView
    private lateinit var text_price: TextView
    private var operand: Double = 0.0
    private var operaton: String = ""


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
        val spinner3: Spinner = view.findViewById(R.id.spinner3)


        mText.text = "BTC Price: $btcPrice \n ETH Price: $ethPrice \n XRP Price: $xrpPrice \n DOT Price: $dotPrice \n ADA Price: $adaPrice"
        // marto btc, eth, xrp, dot, ada-s fasebia USD-shi

    }

    private fun spinner3() {
        TODO("Not yet implemented")
    }

    private fun spinner2() {

    }


    fun numberClick(view: View) {

        if (view is TextView) {

            val number: String = view.text.toString()
            var result: String = text_first.text.toString()

            if (result == "0") {
                result = ""
            }

            text_first.text = result + number


        }
    }


    fun operationClick(view: View){

        if (view is TextView) {

            if(!TextUtils.isEmpty(text_first.text)) {
                operand = text_first.text.toString().toDouble()
            }
            this.operaton = view.text.toString()

            text_first.text =""

        }

    }

}