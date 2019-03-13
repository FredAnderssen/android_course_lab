package se.ju.anfr16lpstudent.todo_app;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Data extends AppCompatActivity {
    public static ArrayList<ToDo> todos = new ArrayList<>();

    static{

    }

    public static class ToDo {
        public String title;
        public ToDo(String title) {
            this.title = title;
        }
        @Override
        public String toString() {
            return "ToDo: " + title;
        }
    }
}
