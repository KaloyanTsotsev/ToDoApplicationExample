package com.example.todoapplicationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private List<String> tasks;
    private ArrayAdapter<String> tasksAdapter;
    private ListView listItems;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = (ListView) findViewById(R.id.listViewItems);
        tasks = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this,R.layout.simple_list_item_1);
        listItems.setAdapter(tasksAdapter);
        button = findViewById(R.id.btnAddItem);
        button.setOnClickListener{
            EditText editText = findViewById(R.id.editTextAddItem);
            String taskText = editText.getText().toString();
            tasksAdapter.add(taskText);
            editText.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}