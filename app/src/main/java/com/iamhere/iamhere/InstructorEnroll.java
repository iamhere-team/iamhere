package com.iamhere.iamhere;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

        Button showStudentList = (Button)findViewById(R.id.show_student_list);

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

        showStudentList.setOnClickListener(
            new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        startActivity(new Intent(InstructorEnroll.this, EnrolledStudentsList.class));
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logout) {
            Intent signInActivityIntent = new Intent(getApplicationContext(), SignInActivity.class);
            startActivity(signInActivityIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}
