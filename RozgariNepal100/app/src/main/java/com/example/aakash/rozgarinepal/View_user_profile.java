package com.example.aakash.rozgarinepal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class View_user_profile extends AppCompatActivity implements View.OnClickListener{
    TextView name ,address,contact,email,qualification,experience,skills;
    Button btn_edit,home,result;
    FirebaseAuth mauth;
    DatabaseReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_profile);
        getSupportActionBar().hide();

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(View_user_profile.this, post.class);
                startActivity(i);
                finish();
            }
        });


        result = findViewById(R.id.result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(View_user_profile.this, result.class);
                startActivity(i);
                finish();
            }
        });

        name = (TextView) findViewById(R.id.tv_uname);
        address = (TextView) findViewById(R.id.tv_uaddress);
        contact=(TextView)findViewById(R.id.tv_ucontact);
        email=(TextView)findViewById(R.id.tv_uemail);
        qualification=(TextView)findViewById(R.id.tv_uqualification);
        experience=(TextView)findViewById(R.id.tv_uexperience);
        skills =(TextView)findViewById(R.id.tv_uskills);

        btn_edit = (Button) findViewById(R.id.button_edit);
        btn_edit.setOnClickListener(this);
        mauth = FirebaseAuth.getInstance();
        String uid = mauth.getCurrentUser().getUid();
        mref = FirebaseDatabase.getInstance().getReference().child("User").child(uid);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user_details user = dataSnapshot.getValue(user_details.class);
                name.setText(user.getUser_name());
                address.setText(user.getUser_address());
                contact.setText(user.getUser_contact());
                email.setText(user.getUser_email());
                qualification.setText(user.getUser_quali());
                experience.setText(user.getUser_experience());
                skills.setText(user.getUser_skills());
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
            case R.id.button_edit:
                Intent i = new Intent(View_user_profile.this,Editdetails_user.class);
                startActivity(i);
                finish();
                break;
        }

    }
}
