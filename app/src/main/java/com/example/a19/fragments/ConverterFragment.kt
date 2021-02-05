package com.example.a19.fragments

import android.app.Activity
import android.graphics.PorterDuff
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.*
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.a19.R
import org.w3c.dom.Text

class ConverterFragment : Fragment(R.layout.fragment_converter) {

    private var btcPrice : Float = 0.0f
    private var ethPrice : Float = 0.0f
    private var xrpPrice : Float = 0.0f
    private var dotPrice : Float = 0.0f
    private var adaPrice : Float = 0.0f

    private lateinit var price1 : TextView
    private lateinit var price2 : TextView
    private lateinit var coin1 : TextView
    private lateinit var coin2 : TextView
    private lateinit var coin1Value : TextView
    private lateinit var coin2Value : TextView
    private lateinit var amountToConvert : EditText
    private lateinit var swapButton : ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        price1 = view.findViewById(R.id.price_1)
        price2 = view.findViewById(R.id.price_2)

        coin1 = view.findViewById(R.id.coin_1)
        coin2 = view.findViewById(R.id.coin_2)
        coin1Value = view.findViewById(R.id.coin_1_value)
        coin2Value = view.findViewById(R.id.coin_2_value)

        amountToConvert = view.findViewById(R.id.amount)

        swapButton = view.findViewById(R.id.swapBut)

        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)

        val spinner1: Spinner = view.findViewById(R.id.coin_from)
        activity?.let {
            ArrayAdapter.createFromResource(it, R.array.coins, android.R.layout.simple_spinner_item)
                .also {  adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner1.adapter = adapter
                }
        }

        // ესე იცვლება ვალუე-ბი
        spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                coin1.text = spinner1.getSelectedItem().toString().toUpperCase()
                price1.text = "$" + prefs.getString(spinner1.getSelectedItem().toString(), "").toString()
                convert()
            }

        }


        val spinner2: Spinner = view.findViewById(R.id.coin_to)
        activity?.let {
            ArrayAdapter.createFromResource(it, R.array.coins,android.R.layout.simple_spinner_item)
                .also {  adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner2.adapter = adapter
                }
        }


        spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                coin2.text = spinner2.getSelectedItem().toString().toUpperCase()
                price2.text = "$" + prefs.getString(spinner2.getSelectedItem().toString(), "").toString()
                convert()
            }

        }

        amountToConvert.doAfterTextChanged {
            convert()
        }

        // marto btc, eth, xrp, dot, ada-s fasebia USD-shi

        swapButton.setOnClickListener {
            val sp1 = spinner1.selectedItemPosition
            spinner1.setSelection(spinner2.selectedItemPosition)
            spinner2.setSelection(sp1)
        }
    }

    private fun convert(){
        if(amountToConvert.text.isEmpty()) {
            coin1Value.text = "0"
            coin2Value.text = "0"
            return
        }
        val amount = amountToConvert.text.toString().toDouble()
        val p1 = price1.text.toString().drop(1).toDouble()
        val p2 = price2.text.toString().drop(1).toDouble()

        val value2 = (amount * p1) / p2

        coin1Value.text = String.format("%.2f", amount)
        coin2Value.text = String.format("%.2f", value2)

    }

}