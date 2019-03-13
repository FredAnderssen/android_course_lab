package se.ju.anfr16lpstudent.todo_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class ViewTodoActivity extends AppCompatActivity {
    private TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo);

        Integer passedTodoIndex = getIntent().getIntExtra("todoIndex", 0);
        String passedTodoTitle = Data.todos.get(passedTodoIndex).title;

        title = (TextView)findViewById(R.id.todoTitle);
        title.setText(passedTodoTitle);

    }
}
