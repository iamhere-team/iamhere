package com.iamhere.iamhere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextMail.getText().toString();
                password = editTextPassword.getText().toString();
                signIn();

            }
        });



    }

    public void signIn(){

        final AuthenticationHandler authenticationHandler = new AuthenticationHandler() {
            @Override
            public void onSuccess(CognitoUserSession userSession, CognitoDevice newDevice) {

                Toast.makeText(getBaseContext(), "Sign in successfull" , Toast.LENGTH_LONG).show();

                // navigate to app and do stuff.

            }

            @Override
            public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String userId) {

                AuthenticationDetails authenticationDetails = new AuthenticationDetails(email,password,null);

                authenticationContinuation.setAuthenticationDetails(authenticationDetails);
                authenticationContinuation.continueTask();



            }

            @Override
            public void getMFACode(MultiFactorAuthenticationContinuation continuation) {


            }

            @Override
            public void authenticationChallenge(ChallengeContinuation continuation) {

                Toast.makeText(getBaseContext(), "Sign in challenge" , Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Exception exception) {
                Toast.makeText(getBaseContext(), "Sign in failed : " + exception.getMessage() , Toast.LENGTH_LONG).show();
            }
        };


        CognitoSettings cognitoSettings = new CognitoSettings(SignInActivity.this);

        CognitoUser thisUser = cognitoSettings.getUserPool().getUser(email);

        //  Toast.makeText(getBaseContext(), "Sign in button clicked" , Toast.LENGTH_LONG).show();

        thisUser.getSessionInBackground(authenticationHandler);


    }



}
