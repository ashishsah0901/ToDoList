package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val todoList = mutableListOf<todoData>()
        val adapter = Adapter(todoList)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editText)
            val text = editText.text.toString()
            val todo = todoData(text,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}