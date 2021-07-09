package com.example.testlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val search = findViewById<SearchView>(R.id.searchView) as SearchView
       val list = findViewById<ListView>(R.id.listView) as ListView

        val oquvchilar = arrayOf("Ollohberdi","Umidjon","Muhammad Azim","MuhammadSodiq","MuhammadAyyub","Ibrohimjon"
        ,"Sardorbek")
        val oquvchiAdap:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,oquvchilar)

        list.adapter = oquvchiAdap

        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                oquvchiAdap.filter.filter(newText)
                return false
            }

        })

    }
}