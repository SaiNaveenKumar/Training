package com.example.besant.besant;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.besant.besant.R.id.email12;

/*import static com.example.besant.besant.R.id.pswd;
import static com.example.besant.besant.R.id.emial12;*/

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    EditText firstname, lastname, emailid, address, pwd, username, password;
    Button b, b3, loginb2;
    SharedPreferences sp;
   // LoginButton Facebook;
   // CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("com.example.besant.login", MODE_PRIVATE);
        if (sp.getBoolean("isLogged", false)) {
            startActivity(new Intent(this, BasicActivity.class));
            finish();
        }
        username = (EditText) findViewById(email12);
        password = (EditText) findViewById(R.id.pswd);
        firstname = (EditText) findViewById(R.id.FirstName);
        lastname = (EditText) findViewById(R.id.LastName);
        emailid = (EditText) findViewById(email12);
        address = (EditText) findViewById(R.id.Address);
        b = (Button) findViewById(R.id.btnsign);
        loginb2 = (Button) findViewById(R.id.btn112);
        pwd = (EditText) findViewById(R.id.pswd);
        b3 = (Button) findViewById(R.id.forgetpwd);
        b.setOnClickListener(this);
        loginb2.setOnClickListener(this);
        b3.setOnClickListener(this);

        emailid.setOnFocusChangeListener(this);
        pwd.setOnFocusChangeListener(this);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.btnsign) {
            Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(i);
            //Set your own toast  message
            Toast.makeText(getApplicationContext(), "Fill the details", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btn112) {

            if (emailid.length() == 0 || pwd.length() == 0) {
                emailid.setError("Please fill all the fields ");
                return;
            }

            String email = emailid.getText().toString();
            String password = pwd.getText().toString();

            //we will get the data from database orfrom network

            if (email.equals("demo.com") && password.equals("demo")) {
                //sp.edit().putString("email", email).apply();
                Intent i2 = new Intent(LoginActivity.this, BasicActivity.class);
                startActivity(i2);
            } else {
                pwd.setError("Invalid user credintials");
            }
            switch (id) {
                case R.id.btn112:
                    Intent signInIntent = new Intent(LoginActivity.this, BasicActivity.class);
                    if (emailid.length() > 0) {
                        signInIntent.putExtra("usernam", email12);
                    }
                    signInIntent.putExtra("username", email12);
                    sp.edit().putBoolean("isLogged", true).apply();
                    sp.edit().putString("username", email).apply();

                    startActivity(signInIntent);
                    finish();
            }

     /*   else if(id==  R.id.forgetpwd){
            Intent i3 = new Intent(LoginActivity.this, ConfirmPwdActivity.class);
            startActivity(i3);
            Toast.makeText(getApplicationContext(), "Account created successfully", Toast.LENGTH_SHORT).show();
*/
        }

    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int viewId = v.getId();

        if (viewId == R.id.email && emailid.getText().length() < 10) {
            emailid.setError("password should be more than 10 chars");
        }

        if (viewId == R.id.pswd && pwd.length() > 5) {
            pwd.setError("Password must be minimum 5 digits");
        }


    }
}