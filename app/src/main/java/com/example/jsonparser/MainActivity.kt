package com.example.jsonparser

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonParser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)
        val apiWorker = ApiWorker(applicationContext)
        apiWorker.makeGetRequest("https://jsonplaceholder.typicode.com/todos/1",
            {
                with(JsonParser.parseString(it).asJsonObject) {
                    val userId = get("userId").asInt
                    val id = get("id").asInt
                    val title = get("title").asString
                    val completed = get("completed").asBoolean
                    textView.text ="Id:$id\nUser Id:$userId\nTitle:$title\nCompleted:$completed"
                }
            }
        )
    }
}