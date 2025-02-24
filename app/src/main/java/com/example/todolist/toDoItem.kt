import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {

    private val _toDoList = MutableLiveData<List<String>>()
    val toDoList: LiveData<List<String>> get() = _toDoList

    init {
        _toDoList.value = emptyList() // Inicializa com uma lista vazia
    }

    // Adicionar tarefa
    fun addTask(task: String) {
        val currentList = _toDoList.value ?: emptyList()
        _toDoList.value = currentList + task
    }

    // Remover tarefa
    fun removeTask(task: String) {
        val currentList = _toDoList.value ?: emptyList()
        _toDoList.value = currentList.filterNot { it == task }
    }
}