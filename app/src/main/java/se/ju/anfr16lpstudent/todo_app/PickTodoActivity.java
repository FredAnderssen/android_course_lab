package se.ju.anfr16lpstudent.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PickTodoActivity extends AppCompatActivity {
    ArrayAdapter<Data.ToDo> adapter;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_todo);
        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<Data.ToDo>(
                this,
                android.R.layout.simple_list_item_1,
                Data.todos
        );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data.ToDo clickedTodo = Data.todos.get(position);

                // Todo Start either ViewTodoActivity or DeleteTodoActivity here?
                // Todo Bondekod u moron
                Boolean passedIntentBool = getIntent().getBooleanExtra("DELETE_BTN", false);
                if(passedIntentBool) {
                    Intent intent;
                    intent = new Intent(PickTodoActivity.this, DeleteTodoActivity.class);
                    intent.putExtra("todoIndex", position);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(PickTodoActivity.this, ViewTodoActivity.class);
                    intent.putExtra("todoIndex", position);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        listView.setAdapter(adapter);

    }
}
