package com.example.besant.besant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signup=(Button)findViewById(R.id.Signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });
        {

        }

    }
}

























/*
  android:name="com.example.screenorientation.MainActivity"
          android:label="@Besant"
          android:screenOrientation="landscape"*/
