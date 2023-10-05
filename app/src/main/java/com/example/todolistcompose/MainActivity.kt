package com.example.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolistcompose.ui.theme.TodoListComposeTheme
import com.example.todolistxml.Priority
import com.example.todolistxml.Task

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    val taskList = mutableListOf<Task>().apply {
        for (i in 0..100) add(Task(i, "Titre $i", "Contenue $i", Priority.values().random()))
    }

    LazyColumn(modifier = modifier) {
        items(taskList) { task ->
            TaskItem(task = task)
        }
    }
}

@Composable
fun TaskItem(task: Task, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier

                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = task.title)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = task.content)
        }
        Text(
            modifier = Modifier.wrapContentWidth(),
            text = task.priority.name
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoListComposeTheme {
        MyApp()
    }
}