package com.example.to_do_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.to_do_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  db:TaskDatabaseHelper
    private lateinit var  taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= TaskDatabaseHelper(this)
        taskAdapter = TaskAdapter(db.getAllNotes(),this)

        binding.tasksRecycleView.layoutManager = LinearLayoutManager (this)
        binding.tasksRecycleView.adapter =taskAdapter

        binding.addButton.setOnClickListener{
            var intent =Intent(this,AddTaskActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        taskAdapter.refreshData(db.getAllNotes())
    }
}