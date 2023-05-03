package com.erererere.delegateadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erererere.delegateadapter.adapter.MultiTypeAdapter

class MainActivity : AppCompatActivity() {

    private val multiTypeAdapter = MultiTypeAdapter.Builder()
        .adapter { MessageView() }
        .adapter {
            HeaderView {
                Log.d("MyLog", "Произошел клик на элемент!")
            }
        }
        .adapter { SlidesAdapter() }
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = multiTypeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        multiTypeAdapter.submitList(MockData.get())
    }
}