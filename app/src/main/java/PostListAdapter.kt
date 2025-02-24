import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTaskBinding

class PostListAdapter(
    private val tasks: MutableList<String>
) : RecyclerView.Adapter<PostListAdapter.TaskViewHolder>() {

    private val taskStatus = MutableList(tasks.size) { false } // Lista que armazena se a tarefa está marcada ou não

    inner class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.binding.taskText.text = task

        // Define o texto inicial do botão como um quadrado vazio
        holder.binding.btnMarkTask.text = if (taskStatus[position]) "❎" else "⬜"

        // Alterna o estado ao clicar no botão
        holder.binding.btnMarkTask.setOnClickListener {
            taskStatus[position] = !taskStatus[position] // Alterna entre marcado e não marcado
            notifyItemChanged(position) // Atualiza apenas esse item na RecyclerView
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateTasks(newTasks: List<String>) {
        tasks.clear()
        tasks.addAll(newTasks)

        // Atualiza a lista de estados para corresponder ao novo tamanho da lista
        taskStatus.clear()
        taskStatus.addAll(List(newTasks.size) { false })

        notifyDataSetChanged() // Notifica que os dados mudaram
    }
}