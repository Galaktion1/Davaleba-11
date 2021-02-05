package com.example.a19.fragments

import android.app.Activity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.a19.R

class ConverterFragment : Fragment(R.layout.fragment_converter) {

    private var btcPrice : Float = 0.0f
    private var ethPrice : Float = 0.0f
    private var xrpPrice : Float = 0.0f
    private var dotPrice : Float = 0.0f
    private var adaPrice : Float = 0.0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val price_1 : TextView = view.findViewById(R.id.price_1)
        val price_2 : TextView = view.findViewById(R.id.price_2)
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        btcPrice = prefs.getString("btc", "0")!!.toFloat()
        ethPrice = prefs.getString("eth", "0")!!.toFloat()
        xrpPrice = prefs.getString("xrp", "0")!!.toFloat()
        dotPrice = prefs.getString("dot", "0")!!.toFloat()
        adaPrice = prefs.getString("ada", "0")!!.toFloat()


        val spinner2: Spinner = view.findViewById(R.id.spinner2)
        activity?.let {
            ArrayAdapter.createFromResource(it, R.array.coins, android.R.layout.simple_spinner_item)
                .also {  adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner2.adapter = adapter
                }
        }

        // ესე იცვლება ვალუე-ბი
        spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                price_1.text = spinner2.getSelectedItem().toString()
            }

        }


        val spinner3: Spinner = view.findViewById(R.id.spinner3)
        activity?.let {
            ArrayAdapter.createFromResource(it, R.array.coins,android.R.layout.simple_spinner_item)
                .also {  adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner3.adapter = adapter
                }
        }


        spinner3?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                price_2.text = spinner3.getSelectedItem().toString()
            }

        }

        // marto btc, eth, xrp, dot, ada-s fasebia USD-shi

    }


}