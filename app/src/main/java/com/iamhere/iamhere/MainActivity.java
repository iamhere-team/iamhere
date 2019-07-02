package com.iamhere.iamhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;


public class MainActivity extends AppCompatActivity {

   // private AWSAppSyncClient mAWSAppSyncClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){

        if (view.getId() == R.id.button_signIn) {
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
        }else if (view.getId() == R.id.button_signUp) {
            startActivity(new Intent(MainActivity.this, SignUpActivity.class));
        }
    }

}


