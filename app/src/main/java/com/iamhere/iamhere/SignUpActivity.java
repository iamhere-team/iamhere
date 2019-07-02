package com.iamhere.iamhere;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                        //sendUserData();
                    }
                });
    }

    public void sendUserData(){

    /*    RetrofitCreate rc = new RetrofitCreate();
        Retrofit retrofit = rc.createRetrofit();

        RestAPI rest = retrofit.create(RestAPI.class);

        JsonObject obj = new JsonObject();
        obj.addProperty("user_name",user_name);
        obj.addProperty("password",password);
        Call<JsonObject> call = rest.saveSign(obj);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Status status = new Status(response.body().get("status").getAsInt(),
                        response.body().get("message").toString());
                Toast.makeText(getBaseContext(),status.toString(),Toast.LENGTH_LONG).show();
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Error!",Toast.LENGTH_LONG).show();
            }
        });

        */

    }



}
