package com.example.aakash.rozgarinepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class announce_results extends AppCompatActivity {

    private Button Announce_button ;
    private FirebaseAuth fAuth;
    private EditText inResults_Title, inSelected_Candidates, inMessage, inFurther_Procedure;
    private DatabaseReference fResultDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce_result);
        getSupportActionBar().hide();

        Announce_button = (Button) findViewById(R.id.Announce_buttons);
        inResults_Title = (EditText) findViewById(R.id.Results_Title_editText);
        inSelected_Candidates = (EditText) findViewById(R.id.Selected_Candidates_editText);
        inMessage = (EditText) findViewById(R.id.Message_editText);
        inFurther_Procedure = (EditText) findViewById(R.id.Further_Procedure_editText);
        fAuth = FirebaseAuth.getInstance();
        fResultDatabase = FirebaseDatabase.getInstance().getReference().child("Result");

        Announce_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uResults_Title = inResults_Title.getText().toString().trim();
                String uSelected_Candidates = inSelected_Candidates.getText().toString().trim();
                String uMessage = inMessage.getText().toString().trim();
                String uFurther_Procedure = inFurther_Procedure.getText().toString().trim();
                register_user(uResults_Title, uSelected_Candidates, uMessage, uFurther_Procedure);
            }
        });
    }
    private void register_user(final String rt, final String sc, String m, String fp) {

        result_details result = new result_details(rt, sc, m, fp);
        fResultDatabase.child(fAuth.getCurrentUser().getUid()).setValue(result);

        Intent i = new Intent(announce_results.this, result.class);
        startActivity(i);
        finish();
    }
}

