package com.example.todoapplicationexample;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todoapplicationexample.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> tasks;
    private ArrayAdapter<String> tasksAdapter;
    private ListView listItems;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems =findViewById(R.id.listViewItems);
        tasks = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listItems.setAdapter(tasksAdapter);
        button = findViewById(R.id.btnAddItem);
        addItem();
        removeItem();
    }

    private void addItem() {
        button.setOnClickListener(item -> {
            EditText taskText = findViewById(R.id.editTextAddItem);
            String task = taskText.getText().toString();
            tasks.add(task);
            taskText.setText("");
        });
    }

    private void removeItem() {
        listItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                System.out.println(item.toString());
                tasks.remove(pos);
                tasksAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
