package com.iamhere.iamhere;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;

public class VerificationActivity extends AppCompatActivity {

    private static String TAG = "Cognito";
    private CognitoUserPool userPool;

    private String verificationCode;
    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        final EditText editTextCode = findViewById(R.id.editText_verification_code);
        editTextCode.setHint("Enter Verification Code...");
        final EditText editTextMail = findViewById(R.id.editText_verification_email);
        editTextMail.setHint("Enter E-mail...");

        Button button = (Button)findViewById(R.id.button_verify);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextMail.getText().toString();
                verificationCode = editTextCode.getText().toString();

                new ConfirmTask().execute(verificationCode,email);
            }
        });

    }

    private class ConfirmTask extends AsyncTask<String, Void, String>{

        protected String doInBackground(String ... strings) {

            final String[] result = new String[1];

            final GenericHandler confirmationCallback = new GenericHandler() {
                @Override
                public void onSuccess() {
                    result[0] = "Success!";

                    startActivity(new Intent(VerificationActivity.this, SignInActivity.class));
                }

                @Override
                public void onFailure(Exception exception) {
                    result[0] = "Failed!" + exception.getMessage();
                }
            };

            CognitoSettings cognitoSettings = new CognitoSettings(VerificationActivity.this);

            CognitoUser thisUser = cognitoSettings.getUserPool().getUser(strings[1]);

            thisUser.confirmSignUp(strings[0], false, confirmationCallback);


            return result[0];
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);
            Toast.makeText(getBaseContext(),"Verification result is: " + result,Toast.LENGTH_LONG).show();
        }


    }





}
