package com.example.mylocation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.HashMap;

public class AddRunActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    Button saveButton;
    private EditText mDate;
    private EditText mTime;
    private EditText mDistance;
    private EditText mAvgPace;
    private EditText mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_run);

        Toolbar toolbar = findViewById(R.id.logToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Log");
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();

        mDate = findViewById(R.id.dateField);
        mTime = findViewById(R.id.timeField);
        mDistance = findViewById(R.id.distanceField);
        mAvgPace = findViewById(R.id.avgPaceField);
        mDescription = findViewById(R.id.descriptionField);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save();
                Intent saveIntent = new Intent(v.getContext(), LogActivity.class);
                startActivityForResult(saveIntent, 0);
            }
        });
    }

    /*private void save() {
        final String date = mDate.getText().toString();
        final String time = mTime.getText().toString();
        final String distance = mDistance.getText().toString();
        final String avgPace = mAvgPace.getText().toString();
        final String description = mDescription.getText().toString();

        if (TextUtils.isEmpty(date)) {
            mDate.setError("Date is required");
            return;
        }

        if (TextUtils.isEmpty(time)) {
            mDate.setError("Time is required");
            return;
        }

        if (TextUtils.isEmpty(distance)) {
            mDate.setError("Distance is required");
            return;
        }

        if (TextUtils.isEmpty(avgPace)) {
            mDate.setError("Pace is required");
            return;
        }

        if (TextUtils.isEmpty(description)) {
            mDate.setError("Date is required");
            return;
        }

        databaseReference.child("Run").child(date).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Run run = dataSnapshot.getValue(Run.class);

                        if (run == null) {
                            //error
                        }
                        else {

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent backIntent = new Intent(this, LogActivity.class);
        startActivityForResult(backIntent, 0);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.log_menu_buttons, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
