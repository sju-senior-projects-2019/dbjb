package com.example.mylocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        Toolbar toolbar = findViewById(R.id.logToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Log");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent backIntent = new Intent(this, MapsActivity.class);
        startActivityForResult(backIntent, 0);

        switch (item.getItemId()){
            case R.id.action_add:
                Intent addIntent = new Intent(this, AddRunActivity.class);
                startActivity(addIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.log_menu_buttons, menu);

        MenuItem addItem = menu.findItem(R.id.action_add);

        return super.onCreateOptionsMenu(menu);
    }
}
