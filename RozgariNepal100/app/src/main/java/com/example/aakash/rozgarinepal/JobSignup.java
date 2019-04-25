package com.example.aakash.rozgarinepal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.aakash.rozgarinepal.Login;
import com.example.aakash.rozgarinepal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class JobSignup extends AppCompatActivity {

    //private EditText Email_editText , Password_editText , Name_editText;
    private Button Register_button ;
    private EditText inName, inEmail, inPassword, inContact, inAddress, inRePassword, inQual , inSkill ,inExp;
    private FirebaseAuth fAuth;
    private DatabaseReference fUserDatabase;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_signup);
        getSupportActionBar().hide();

        Register_button = (Button) findViewById(R.id.Register_button);
        inEmail = (EditText) findViewById(R.id.Email_editText);
        inName = (EditText) findViewById(R.id.Name_editText);
        inPassword = (EditText) findViewById(R.id.Password_editText);
        inContact = (EditText) findViewById(R.id.Contact_editText);
        inAddress = (EditText) findViewById(R.id.Address_editText);
        inQual = (EditText) findViewById(R.id.Qualification_editText);
        inExp = (EditText) findViewById(R.id.Experience_editText);
        inSkill = (EditText) findViewById(R.id.Skill_editText);
        inRePassword = (EditText) findViewById(R.id.RePassword_editText);

        fAuth = FirebaseAuth.getInstance();

        fUserDatabase = FirebaseDatabase.getInstance().getReference().child("User");


        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uEmail = inEmail.getText().toString().trim();
                String uName = inName.getText().toString().trim();
                String uPassword = inPassword.getText().toString().trim();
                String uRePassword = inRePassword.getText().toString().trim();
                String uContact = inContact.getText().toString().trim();
                String uAddress = inAddress.getText().toString().trim();
                String uSkill = inSkill.getText().toString().trim();
                String uExp = inExp.getText().toString().trim();
                String uQual = inQual.getText().toString().trim();
                register_user(uName ,uEmail,uPassword,uRePassword,uAddress,uContact,uSkill,uQual,uExp);
            }
        });
    }
    private void register_user(final String name, final String email, String password, String rePassword, final String address , final String contact,final String Skill, final String Qualification,final String Exp) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing your data, Please wait . . .");
        progressDialog.show();


        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    user_details user = new user_details(name, address, contact, email, Qualification, Exp, Skill);
                    fUserDatabase.child(fAuth.getCurrentUser().getUid()).setValue(user);

                    Toast.makeText(JobSignup.this, "User has been created!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(JobSignup.this, Login.class);
                    startActivity(i);
                    finish();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(JobSignup.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}
