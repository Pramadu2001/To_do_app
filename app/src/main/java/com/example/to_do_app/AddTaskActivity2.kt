package com.example.to_do_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.to_do_app.databinding.ActivityAddTask2Binding
import com.example.to_do_app.databinding.ActivityMainBinding

class AddTaskActivity2 : AppCompatActivity() {

    private lateinit var  binding: ActivityAddTask2Binding
    private lateinit var  db:TaskDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTask2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        db = TaskDatabaseHelper(this)
        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val task =Task(0, title, content)
            db.insertNote(task)
            finish()
            Toast.makeText(this,"Tasked saved", Toast.LENGTH_SHORT).show()
        }

    }
}