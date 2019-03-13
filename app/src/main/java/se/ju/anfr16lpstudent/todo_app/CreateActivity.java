package se.ju.anfr16lpstudent.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class CreateActivity extends AppCompatActivity {
    Data data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }

    public void todoButtonClicked(View view) {
        EditText editText = (EditText) findViewById(R.id.enteredTitle);
        String enteredTitle = editText.getText().toString();

        final Data.ToDo enToDo = new Data.ToDo(enteredTitle);
        Data.todos.add(enToDo);

        finish();
    }
}
