# ✅ ToDoList App

Este é um aplicativo simples de lista de tarefas (ToDo List) desenvolvido em **Kotlin** para Android. Ele permite adicionar, remover e marcar tarefas como concluídas, salvando os dados localmente com `SharedPreferences`.

## 📱 Funcionalidades

- Adicionar novas tarefas
- Marcar tarefas como concluídas
- Remover tarefas
- Salvamento local das tarefas com `SharedPreferences`
- UI reativa com `LiveData` e `ViewModel`

## 🛠️ Tecnologias Utilizadas

- **Kotlin**
- **Android ViewModel (Architecture Components)**
- **LiveData**
- **SharedPreferences**
- **ViewBinding**

## 🧠 Arquitetura

Utiliza arquitetura MVVM básica:

- `MainActivity.kt`: exibe a interface do usuário.
- `ToDoViewModel.kt`: controla o estado da lista de tarefas.
- `SharedPreferences`: armazena as tarefas localmente em formato de texto.

## 📦 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/todolist-app.git
