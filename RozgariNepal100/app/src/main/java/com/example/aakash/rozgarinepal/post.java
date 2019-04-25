package com.example.aakash.rozgarinepal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class post extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ListView mPostList;
    Button result,profile,announce,apply;

    FirebaseListAdapter<post_details> madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_datapost);
        getSupportActionBar().hide();

        profile = findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(post.this, View_user_profile.class);
                startActivity(i);
                finish();
            }
        });

        result = findViewById(R.id.result);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(post.this, result.class);
                startActivity(i);
                finish();
            }
        });

        announce = findViewById(R.id.announce);

        announce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(post.this, announce_vacancy.class);
                startActivity(i);
                finish();
            }
        });

        apply = findViewById(R.id.Apply);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(post.this, Jobapply.class);
                startActivity(i);
                finish();
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Post");
        mPostList = (ListView) findViewById(R.id.post_list);

        madapter = new FirebaseListAdapter<post_details>(this,post_details.class,R.layout.activity_post,mDatabase) {
            @Override
            protected void populateView(View v, post_details model, int position) {
                TextView tvjt =  v.findViewById(R.id.tv_jt_value);
                TextView tvre = v.findViewById(R.id.tv_re_value);
                TextView tvrq = v.findViewById(R.id.tv_rq_value);
                TextView tves = v.findViewById(R.id.tv_es_value);
                TextView tvs = v.findViewById(R.id.tv_s_value);
                TextView tvwt = v.findViewById(R.id.tv_wt_value);
                TextView tvl = v.findViewById(R.id.tv_l_value);
                TextView tvc = v.findViewById(R.id.tv_c_value);

                tvjt.setText(model.getPost_jt());
                tvre.setText(model.getPost_re());
                tvrq.setText(model.getPost_rq());
                tves.setText(model.getPost_es());
                tvs.setText(model.getPost_s());
                tvwt.setText(model.getPost_wt());
                tvl.setText(model.getPost_l());
                tvc.setText(model.getPost_c());
            }
        };
        mPostList.setAdapter(madapter);
    }
}