package com.example.to_do_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.to_do_app.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var  binding:ActivityUpdateBinding
    private lateinit var  db :TaskDatabaseHelper
    private  var taskId :Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)

        taskId =intent.getIntExtra("task_id",-1)
        if (taskId == -1){
            finish()
            return
        }

        val task = db.getNoteByID(taskId)
        binding.UpdateTitleEditText.setText(task.title)
        binding.UpdateContentEditText.setText(task.content)

        binding.UpdateSaveButton.setOnClickListener{
            val newTitle = binding.UpdateTitleEditText.text.toString()
            val newContent = binding.UpdateContentEditText.text.toString()
            val updateTask = Task(taskId,newTitle,newContent)

            db.updateNote(updateTask)
            finish()
            Toast.makeText(this, "Changes are saved",Toast.LENGTH_SHORT).show()
        }


    }
}