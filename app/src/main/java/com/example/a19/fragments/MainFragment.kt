package com.example.a19.fragments

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.a19.CoinAdapter
import com.example.a19.CoinItem
import com.example.a19.R
import org.json.JSONArray
import org.json.JSONObject


class MainFragment : Fragment(R.layout.fragment_main) {
    var list = mutableListOf<CoinItem>()
    private lateinit var recyclerView : RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        getCoinPrices()
    }

    private fun getCoinPrices() {
        val url = "http://46.101.226.190:5000/"
        val requestQueue = Volley.newRequestQueue(activity)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val json = JSONObject(response.toString())
                val coins: JSONArray = json.getJSONArray("rows")

                if (coins.length() > 0) {
                    for (countItem in 0 until coins.length()) {
                        val bookingObject: JSONObject = coins.getJSONObject(countItem)
                        val id = bookingObject.optString("id")
                        val symbol = bookingObject.optString("symbol").take(3)
                        val name = bookingObject.optString("name")
                        val price = bookingObject.optString("price")
                        val change_24h = bookingObject.optString("change_24h")

                        list.add(CoinItem(id,symbol, name, price, change_24h))
                    }
                }
                displayText()
                applyUpdates()
            },
            Response.ErrorListener { error ->
            }
        )
        requestQueue.add(jsonObjectRequest)
    }

    private fun applyUpdates() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        prefs.edit().putString("btc", list[0].price).apply()
        prefs.edit().putString("eth", list[1].price).apply()
        prefs.edit().putString("xrp", list[2].price).apply()
        prefs.edit().putString("dot", list[3].price).apply()
        prefs.edit().putString("ada", list[4].price).apply()
    }

    private fun displayText() {
        recyclerView.adapter = CoinAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
}

