package com.example.todolist

import PostListAdapter
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostListAdapter
    private val toDoViewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o Adapter e o RecyclerView
        adapter = PostListAdapter(mutableListOf())
        binding.RecyclerViewTasks.layoutManager = LinearLayoutManager(this)
        binding.RecyclerViewTasks.adapter = adapter

        // Observa a lista de tarefas e atualiza o Adapter
        toDoViewModel.toDoList.observe(this) { tasks ->
            adapter.updateTasks(tasks)
        }

        // Botão de adicionar tarefa
        binding.btnAddTask.setOnClickListener {
            val task = binding.editTextTask.text.toString()
            if (task.isNotBlank()) {
                toDoViewModel.addTask(task)
                binding.editTextTask.text.clear()
            }
        }
    }
}