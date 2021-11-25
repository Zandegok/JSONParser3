package com.example.jsonparser

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

typealias HeadersMap = MutableMap<String, String>

class ApiWorker(
    var applicationContext: Context,
) {

    private var volleyQueue = Volley.newRequestQueue(applicationContext)
    fun makeGetRequest(
        url: String,
        function: (String) -> Unit,
        headers: HeadersMap = hashMapOf(),
    ) {
        val request = object : StringRequest(
            Method.GET,
            url,
            Response.Listener(function),
            Response.ErrorListener {
                Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
                Log.d("MY TAG",it.toString())
            }
        ) {
            override fun getHeaders(): HeadersMap {
                return headers
            }
        }
        volleyQueue.add(request)
    }


}