package com.iamhere.iamhere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class InstructorEnroll extends AppCompatActivity {
    private CheckBox five_min = null;
    private CheckBox ten_min = null;
    private CheckBox twenty_five_min = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_enroll);

        five_min = findViewById(R.id.five_min);
        ten_min = findViewById(R.id.ten_min);
        twenty_five_min = findViewById(R.id.twentyfive_min);

        five_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten_min.setChecked(false);
                twenty_five_min.setChecked(false);
            }
        });

        ten_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                five_min.setChecked(false);
                twenty_five_min.setChecked(false);
            }
        });

        twenty_five_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                five_min.setChecked(false);
                ten_min.setChecked(false);
            }
        });

    }

}
