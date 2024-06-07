package com.example.gerenciadordetarefas

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val tasks = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addTaskButton = findViewById<Button>(R.id.addTaskButton)
        val removeTaskButton = findViewById<Button>(R.id.removeTaskButton)
        val taskListView = findViewById<ListView>(R.id.taskListView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        taskListView.adapter = adapter

        addTaskButton.setOnClickListener {
            // Redirecionar para a atividade de adicionar tarefa
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, ADD_TASK_REQUEST_CODE)
        }

        removeTaskButton.setOnClickListener {
            // Remover a última tarefa da lista (apenas como exemplo)
            if (tasks.isNotEmpty()) {
                tasks.removeAt(tasks.size - 1)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_TASK_REQUEST_CODE && resultCode == RESULT_OK) {
            val newTask = data?.getStringExtra("TASK")
            newTask?.let {
                tasks.add(it)
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        const val ADD_TASK_REQUEST_CODE = 1
    }
}
