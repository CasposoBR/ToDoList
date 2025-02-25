package com.example.todolist

import TaskPreferences
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val taskPreferences = TaskPreferences(application)
    private val _toDoList = MutableLiveData(taskPreferences.getTasks().toMutableList())
    val toDoList: LiveData<MutableList<String>> = _toDoList

    fun addTask(task: String) {
        val updatedList = _toDoList.value ?: mutableListOf()
        updatedList.add(task)
        _toDoList.value = updatedList
        taskPreferences.saveTasks(updatedList) // Salva a lista sempre que for alterada
    }

    fun removeTask(task: String) {
        val updatedList = _toDoList.value ?: mutableListOf()
        updatedList.remove(task)
        _toDoList.value = updatedList
        taskPreferences.saveTasks(updatedList) // Salva a lista após remoção
    }
}

