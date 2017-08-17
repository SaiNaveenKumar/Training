package com.example.besant.besant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmPwdActivity extends AppCompatActivity {
    Button btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmpwd_submit);

        btn12 = (Button) findViewById(R.id.nwpsdconfirm);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in3 = new Intent(ConfirmPwdActivity.this, LoginActivity.class);
                startActivity(in3);
                Toast.makeText(getApplicationContext(), "New password created successfully", Toast.LENGTH_SHORT).show();//
            }
        });
    }

}