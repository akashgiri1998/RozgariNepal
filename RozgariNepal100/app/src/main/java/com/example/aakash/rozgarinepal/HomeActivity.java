package com.example.aakash.rozgarinepal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
    }

    public void onClick(View v){
        Intent i=new Intent(this,Login.class);
        startActivity(i);
    }

    public void onClick2(View v){
        Intent i=new Intent(this,JobSignup.class);
        startActivity(i);
    }
}
