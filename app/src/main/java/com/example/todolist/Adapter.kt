package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val todoList: List<todoData>):RecyclerView.Adapter<Adapter.viewHolder>(){
    inner class viewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.apply {
            val isDone = findViewById<CheckBox>(R.id.isDone)
            isDone.isChecked = todoList[position].isDone
            val todoText = findViewById<TextView>(R.id.todoText)
            todoText.text = todoList[position].title
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}