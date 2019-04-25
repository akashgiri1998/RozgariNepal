package com.example.aakash.rozgarinepal;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ViewDatabase extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ListView mUserList;

    FirebaseListAdapter<user_details> madapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database);
        getSupportActionBar().hide();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");
        mUserList = (ListView) findViewById(R.id.user_list);

        madapter = new FirebaseListAdapter<user_details>(this,user_details.class,R.layout.view_databasae_layout,mDatabase) {
            @Override
            protected void populateView(View v, user_details model, int position) {
                TextView tvname =  v.findViewById(R.id.tv_name_value);
                TextView tvaddress = v.findViewById(R.id.tv_address_value);
                TextView tvcontact = v.findViewById(R.id.tv_contact_value);
                TextView tvemail = v.findViewById(R.id.tv_email_value);
                TextView tvqualification = v.findViewById(R.id.tv_qualification_value);
                TextView tvexperience = v.findViewById(R.id.tv_experience_value);
                TextView tvskills = v.findViewById(R.id.tv_skills_value);


                tvname.setText(model.getUser_name());
                tvaddress.setText(model.getUser_address());
                tvcontact.setText(model.getUser_contact());
                tvemail.setText(model.getUser_email());
                tvqualification.setText(model.getUser_quali());
                tvexperience.setText(model.getUser_experience());
                tvskills.setText(model.getUser_skills());

            }
        };
        mUserList.setAdapter(madapter);

    }
}

