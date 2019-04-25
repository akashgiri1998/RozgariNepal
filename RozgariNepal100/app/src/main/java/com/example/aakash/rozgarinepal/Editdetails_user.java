package com.example.aakash.rozgarinepal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Editdetails_user extends AppCompatActivity implements View.OnClickListener{
    EditText name_edit,address_edit,contact_edit,email_edit,qualification_edit,experience_edit,skills_edit;
    Button btn_save,signout;
    DatabaseReference mref;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdetails_user);
        getSupportActionBar().hide();
        name_edit = (EditText) findViewById(R.id.et_name_edit);
        address_edit = (EditText) findViewById(R.id.et_address_edit);
        contact_edit = (EditText) findViewById(R.id.et_contact_edit);
        email_edit = (EditText) findViewById(R.id.et_email_edit);
        qualification_edit = (EditText) findViewById(R.id.et_qualification_edit);
        experience_edit = (EditText) findViewById(R.id.et_experience_edit);
        skills_edit = (EditText) findViewById(R.id.et_skills_edit);

        btn_save = (Button) findViewById(R.id.button_save_details);
        signout=(Button)findViewById(R.id.signout);
        btn_save.setOnClickListener(this);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseAuth.getInstance().signOut();
                Toast.makeText(Editdetails_user.this, "Signed Out", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Editdetails_user.this, Login.class);
                startActivity(i);
                finish();
            }
        });

        mauth = FirebaseAuth.getInstance();
        FirebaseUser usr = mauth.getCurrentUser();
        String uid = mauth.getCurrentUser().getUid();
        mref = FirebaseDatabase.getInstance().getReference().child("User").child(uid);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user_details usr = dataSnapshot.getValue(user_details.class);
                name_edit.setText(usr.getUser_name());
                address_edit.setText(usr.getUser_address());
                contact_edit.setText(usr.getUser_contact());
                email_edit.setText(usr.getUser_email());
                qualification_edit.setText(usr.getUser_quali());
                experience_edit.setText(usr.getUser_experience());
                skills_edit.setText(usr.getUser_skills());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button_save_details:
                String newname = name_edit.getText().toString();
                String newaddress = address_edit.getText().toString();
                String newcontact = contact_edit.getText().toString();
                String newemail = email_edit.getText().toString();
                String newqualification = qualification_edit.getText().toString();
                String newexperience = experience_edit.getText().toString();
                String newskills = skills_edit.getText().toString();

                String uid = mauth.getUid();

                user_details usr = new user_details(newname,newaddress,newcontact,newemail,newqualification,newexperience,newskills);
                //user_details usr = new user_details(newname,newaddress,null,null,null,null,null);
                mref.setValue(usr);
                Intent i = new Intent(Editdetails_user.this,View_user_profile.class);
                startActivity(i);
                finish();
                break;

        }

    }
}
