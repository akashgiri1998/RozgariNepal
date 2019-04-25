package com.example.aakash.rozgarinepal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        getSupportActionBar().hide();
    }

    public void onClick(View v){
        Intent i=new Intent(this,announce_vacancy.class);
        startActivity(i);
    }
}
