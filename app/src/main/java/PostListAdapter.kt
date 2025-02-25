import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTaskBinding

class PostListAdapter(
    private val tasks: MutableList<String>,
    private val onTaskRemoved: (String) -> Unit // Adicionando essa função
) : RecyclerView.Adapter<PostListAdapter.TaskViewHolder>() {
    private val taskStatus = mutableMapOf<String, Boolean>() // Armazena o estado de cada tarefa

    inner class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.binding.taskText.text = task

        // Define o texto do botão baseado no estado da tarefa
        holder.binding.btnMarkTask.text = if (taskStatus[task] == true) "❎" else "⬜"

        // Alterna o estado ao clicar no botão
        holder.binding.btnMarkTask.setOnClickListener {
            taskStatus[task] = !(taskStatus[task] ?: false) // Alterna entre marcado e não marcado
            notifyItemChanged(position) // Atualiza apenas esse item
        }

        // Configura o botão de remoção
        holder.binding.btnRemoveTask.setOnClickListener {
            onTaskRemoved(task) // Chamando a função para remover a tarefa
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateTasks(newTasks: List<String>) {
        tasks.clear()
        tasks.addAll(newTasks)
        taskStatus.clear() // Limpa os estados para evitar inconsistências
        notifyDataSetChanged() // Atualiza a RecyclerView
    }
}