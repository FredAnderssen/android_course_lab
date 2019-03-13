package se.ju.anfr16lpstudent.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    static final int DELETE_BUTTON_CLICKED = 1;
    static final int SELECT_BUTTON_CLICKED = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createButtonClicked(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    public void userChooseBtn(View view) {
        Intent intent = new Intent(this, PickTodoActivity.class);
        AtomicInteger btnClicked = new AtomicInteger();
        switch(view.getId()) {
            case R.id.button:
                btnClicked.set(SELECT_BUTTON_CLICKED);
                intent.putExtra("SELECT_BTN", false);
                break;
            case R.id.button8:
                btnClicked.set(DELETE_BUTTON_CLICKED);
                intent.putExtra("DELETE_BTN", true);
                break;
        }

        startActivityForResult(intent, btnClicked.get());
        onActivityResult(btnClicked.get(), PickTodoActivity.RESULT_OK, intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == DELETE_BUTTON_CLICKED) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected
                // Do something with the contact here (bigger example below)

                data.putExtra("DELETE", true);

            }
        }
    }



}
