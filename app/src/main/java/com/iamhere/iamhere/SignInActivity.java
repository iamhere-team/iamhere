package com.iamhere.iamhere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    private String email=null;
    private String password=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final EditText editTextMail = (EditText) findViewById(R.id.editText_signIn_email);
        editTextMail.setHint("Enter E-mail...");
        final EditText editTextPassword = (EditText) findViewById(R.id.editText_signIn_password);
        editTextPassword.setHint("Enter password...");

        Button button = (Button)findViewById(R.id.button_signIn_signIn);

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        email = editTextMail.getText().toString();
                        password = editTextPassword.getText().toString();
                        getSign();
                    }
                });


    }

    private void getSign(){





    }
}
