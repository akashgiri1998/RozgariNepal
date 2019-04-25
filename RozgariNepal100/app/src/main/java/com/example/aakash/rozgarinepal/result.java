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

public class result extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ListView mResultList;
    Button home,profile,announce;

    FirebaseListAdapter<result_details> madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dataresult);
        getSupportActionBar().hide();

        profile = findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(result.this, View_user_profile.class);
                startActivity(i);
                finish();
            }
        });

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(result.this, post.class);
                startActivity(i);
                finish();
            }
        });

        announce = findViewById(R.id.announce);

        announce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(result.this, announce_results.class);
                startActivity(i);
                finish();
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Result");
        mResultList = (ListView) findViewById(R.id.result_list);

        madapter = new FirebaseListAdapter<result_details>(this,result_details.class,R.layout.activity_result,mDatabase) {
            @Override
            protected void populateView(View v, result_details model, int position) {
                TextView tvrt =  v.findViewById(R.id.tv_rt_value);
                TextView tvsc = v.findViewById(R.id.tv_sc_value);
                TextView tvm = v.findViewById(R.id.tv_m_value);
                TextView tvfp = v.findViewById(R.id.tv_fp_value);

                tvrt.setText(model.getResult_rt());
                tvsc.setText(model.getResult_sc());
                tvm.setText(model.getResult_m());
                tvfp.setText(model.getResult_fp());
            }
        };
        mResultList.setAdapter(madapter);
    }
}