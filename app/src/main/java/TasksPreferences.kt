import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("task_prefs", Context.MODE_PRIVATE)

    fun saveTasks(taskList: List<String>) {
        val json = Gson().toJson(taskList) // Converte a lista para JSON
        prefs.edit().putString("tasks", json).apply()
    }

    fun getTasks(): List<String> {
        val json = prefs.getString("tasks", null) ?: return emptyList()
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, type) // Converte JSON de volta para lista
    }
}