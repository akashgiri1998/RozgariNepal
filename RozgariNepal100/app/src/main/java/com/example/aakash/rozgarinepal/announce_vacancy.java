package com.example.aakash.rozgarinepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class announce_vacancy extends AppCompatActivity {

    private Button Job_Post_button ;
    private FirebaseAuth fAuth;
    private EditText inJob_Title, inR_Experience, inContact, inR_Qualification, inExtra_Skills, inSalary , inWork_Time ,inLocation;
    private DatabaseReference fPostDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce_vacancy);
        getSupportActionBar().hide();

        Job_Post_button = (Button) findViewById(R.id.Post_Job_buttons);
        inJob_Title = (EditText) findViewById(R.id.Job_Title_editText);
        inR_Experience = (EditText) findViewById(R.id.R_Experience_editText);
        inR_Qualification = (EditText) findViewById(R.id.R_Qualification_editText);
        inExtra_Skills = (EditText) findViewById(R.id.Extra_Skills_editText);
        inSalary = (EditText) findViewById(R.id.Salary_editText);
        inWork_Time = (EditText) findViewById(R.id.Work_Time_editText);
        inLocation = (EditText) findViewById(R.id.Location_editText);
        inContact = (EditText) findViewById(R.id.Contact_editText);

        fAuth = FirebaseAuth.getInstance();
        fPostDatabase = FirebaseDatabase.getInstance().getReference().child("Post");

        Job_Post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uJob_Title = inJob_Title.getText().toString().trim();
                String uR_Experience = inR_Experience.getText().toString().trim();
                String uR_Qualification = inR_Qualification.getText().toString().trim();
                String uExtra_Skills = inExtra_Skills.getText().toString().trim();
                String uSalary = inSalary.getText().toString().trim();
                String uWork_Time = inWork_Time.getText().toString().trim();
                String uLocation = inLocation.getText().toString().trim();
                String uContact = inContact.getText().toString().trim();
                register_user(uJob_Title, uR_Experience, uR_Qualification, uExtra_Skills, uSalary, uWork_Time, uLocation, uContact);

            }
        });
    }
    private void register_user(final String jt, final String re, String rq, String es, final String s , final String wt,final String l, final String c) {

                    post_details post = new post_details(jt,re,rq,es,s,wt,l,c);
                    fPostDatabase.child(fAuth.getCurrentUser().getUid()).setValue(post);

                    Intent i = new Intent(announce_vacancy.this, post.class);
                    startActivity(i);
                    finish();
                }
    }
