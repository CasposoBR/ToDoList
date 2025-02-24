package com.example.todolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {
    // LiveData para armazenar as tarefas
    private val _toDoList = MutableLiveData<MutableList<String>>(mutableListOf())
    val toDoList: MutableLiveData<MutableList<String>> = _toDoList

    // Função para adicionar tarefa
    fun addTask(task: String) {
        val updatedList = _toDoList.value ?: mutableListOf()  // Garantir que sempre teremos uma lista
        updatedList.add(task)
        _toDoList.value = updatedList // Atualiza a lista de tarefas
    }

    // Função para remover tarefa
    fun removeTask(task: String) {
        val updatedList = _toDoList.value ?: mutableListOf()  // Garantir que sempre teremos uma lista
        updatedList.remove(task)
        _toDoList.value = updatedList
    }

    // Função para marcar a tarefa como concluída
    fun markTaskAsCompleted(task: String) {
        val updatedList = _toDoList.value?.map {
            if (it == task) "✅ $it" else it
        }?.toMutableList() ?: mutableListOf()  // Garante que não será nulo
        _toDoList.value = updatedList
    }
}

