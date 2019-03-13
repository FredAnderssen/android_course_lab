package se.ju.anfr16lpstudent.todo_app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DeleteTodoActivity extends AppCompatActivity {
    private TextView title;
    private Integer passedTodoIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_todo);

        passedTodoIndex = getIntent().getIntExtra("todoIndex", 0);
        String passedTodoTitle = Data.todos.get(passedTodoIndex).title;
        title = (TextView)findViewById(R.id.deleteTitle);
        title.setText(passedTodoTitle);

    }

    public void deleteButtonClicked(View view) {

        new AlertDialog.Builder(this)
                .setTitle("Delete ToDo")
                .setMessage("Do you really want to delete it?") .setPositiveButton(
                android.R.string.yes,
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton){ // Delete it.
                        Data.todos.remove(passedTodoIndex.intValue());
                        finish();
                    } }
        ).setNegativeButton( android.R.string.no,
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton){ // Do not delete it.
                    } }
        ).show();
    }

}
