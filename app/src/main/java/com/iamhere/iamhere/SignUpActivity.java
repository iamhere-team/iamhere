package com.iamhere.iamhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSettings;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;

public class SignUpActivity extends AppCompatActivity {

    private String email=null;
    private String password=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText editTextMail = (EditText) findViewById(R.id.editText_signUp_email);
        editTextMail.setHint("Enter E-mail...");
        final EditText editTextPassword = (EditText) findViewById(R.id.editText_signUp_password);
        editTextPassword.setHint("Enter password...");


        Button button = (Button)findViewById(R.id.button_signUp_signUp);

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        email = editTextMail.getText().toString();
                        password = editTextPassword.getText().toString();
                        sendUserData();

                    }
                });
    }

 /*   public void onClick(View view){

        if (view.getId() == R.id.button_signUp_signUp) {
            email = editTextMail.getText().toString();
            password = editTextPassword.getText().toString();
            sendUserData();
            startActivity(new Intent(SignUpActivity.this, VerificationActivity.class));
        }
    }

*/




    public void sendUserData(){

        final CognitoUserAttributes userAttributes = new CognitoUserAttributes();
        SignUpHandler handler= new SignUpHandler() {

            @Override
            public void onSuccess(CognitoUser user, boolean signUpConfirmationState, CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                if(!signUpConfirmationState) {
                    Toast.makeText(getBaseContext(), "Sign up succesful without confirmation, verification code sent to" +
                            cognitoUserCodeDeliveryDetails.getDestination(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(SignUpActivity.this, VerificationActivity.class));
                }
                else
                    Toast.makeText(getBaseContext(),"Sign up succesful",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Exception exception) {
                Toast.makeText(getBaseContext(),"Sign up failed"+ exception.getMessage(),Toast.LENGTH_LONG).show();
            }
        };
        userAttributes.addAttribute("email",email);

        CognitoSettings cognitoSettings = new CognitoSettings(SignUpActivity.this);

        cognitoSettings.getUserPool().signUpInBackground(email,password,userAttributes,null, handler);


       // AWSConfiguration awsConfiguration = new AWSConfiguration(getApplicationContext());
       // CognitoUserPool cognitoUserPool = new CognitoUserPool(getApplicationContext(),awsConfiguration);

        //cognitoUserPool.signUpInBackground(email,password,userAttributes,null,handler);
    }



}
