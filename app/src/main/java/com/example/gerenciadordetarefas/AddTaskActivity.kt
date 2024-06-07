package com.example.gerenciadordetarefas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.gerenciadordetarefas.R

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val taskName = findViewById<EditText>(R.id.taskName)
        val taskSubject = findViewById<EditText>(R.id.taskSubject)
        val taskDueDate = findViewById<EditText>(R.id.taskDueDate)
        val saveTaskButton = findViewById<Button>(R.id.saveTaskButton)

        saveTaskButton.setOnClickListener {
            val task = "Task: ${taskName.text}, Subject: ${taskSubject.text}, Due: ${taskDueDate.text}"
            val resultIntent = Intent()
            resultIntent.putExtra("TASK", task)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
