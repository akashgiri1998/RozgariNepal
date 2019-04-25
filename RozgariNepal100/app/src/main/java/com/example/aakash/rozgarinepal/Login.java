package com.example.aakash.rozgarinepal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText Name_EditText, Pass_EditText;
    private FirebaseAuth fAuth;
    Button  Login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Name_EditText = findViewById(R.id.editUsername);
        Pass_EditText = findViewById(R.id.editPassword);
        Login_button = findViewById(R.id.Login_button);
        fAuth = FirebaseAuth.getInstance();
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lEmail = Name_EditText.getText().toString().trim();
                String lPassword = Pass_EditText.getText().toString().trim();
                if(!TextUtils.isEmpty(lEmail)&& !TextUtils.isEmpty(lPassword)) {
                    Login_function(lEmail, lPassword);
                }else{

                    Toast.makeText(Login.this, "Please Fill Complete Data", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private void Login_function(String email, String password){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging in, Please wait...");
        progressDialog.show();

        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this,View_user_profile.class);
                    startActivity(i);
                    finish();

                }else {
                    Toast.makeText(Login.this, "Error"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}

