package com.iamhere.iamhere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CourseSelectionActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selection);

        spinner = findViewById(R.id.spinner);

        List<String>  lectures = new ArrayList<>();
        lectures.add(0,"Choose Lecture");
        lectures.add("BİL 422");
        lectures.add("BİL 476");
        lectures.add("BİL 212");
        lectures.add("BİL 481");
        lectures.add("BİL 372");
    }

}
