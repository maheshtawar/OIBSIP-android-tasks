package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText etTask;
    private Button btnAdd;
    private ListView listViewTasks;

    private ArrayList<String> tasksList;
    private ArrayAdapter<String> tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.et_task);
        btnAdd = findViewById(R.id.btn_add);
        listViewTasks = findViewById(R.id.list_view_tasks);

        tasksList = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasksList);
        listViewTasks.setAdapter(tasksAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etTask.getText().toString().trim();
                if (!task.isEmpty()) {
                    tasksList.add(task);
                    tasksAdapter.notifyDataSetChanged();
                    etTask.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String task = tasksList.get(position);
                // Handle task item click (e.g., update, delete)
                Toast.makeText(MainActivity.this, "Clicked task: " + task, Toast.LENGTH_SHORT).show();
            }
        });

    }
}