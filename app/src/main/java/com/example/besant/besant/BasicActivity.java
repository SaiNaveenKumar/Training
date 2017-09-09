package com.example.besant.besant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BasicActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private static final String TAG ="Basic Activity" ;
    private CardView cardView;
    private SharedPreferences sp;
    Button itemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        itemlist=(Button)findViewById(R.id.itembtn);
        itemlist.setOnClickListener(this);

        sp = getSharedPreferences("com.example.besant.login",MODE_PRIVATE);

        String username = sp.getString("username","username");
        TextView txtUserName = (TextView) findViewById(R.id.usernametxt);
        Intent intent  = getIntent();
        // String username = intent.getStringExtra("usernam");
        Log.d(TAG, "Recived Username : "+username);
        if(username != null){
            txtUserName.setText(username.toLowerCase());
        }



            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Logout:
                sp.edit().putBoolean("isLogged",false).apply();
                Intent i=new Intent(this,LoginActivity.class);
                startActivity(i);
                finish();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.itembtn)
        {
            Intent i = new Intent(BasicActivity.this,RecyclerViewActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }
}
