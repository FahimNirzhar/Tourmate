package com.example.bitm.tourmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class TravelHome extends AppCompatActivity {
    private String namedst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_home);
        namedst=getIntent().getStringExtra("name");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);;
        mTitle.setText("More Thing "+namedst);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void expense(View view) {
        Intent intent=new Intent(TravelHome.this,ExpenseProfileActivity.class);
        intent.putExtra("namedst",namedst);
        startActivity(intent);
    }


    public void event(View view) {
        Intent intent=new Intent(TravelHome.this,EventProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void nearby(View view) {
        Intent intent=new Intent(TravelHome.this,MapsActivity.class);
        intent.putExtra("namedst",namedst);
        startActivity(intent);
    }

    public void weather(View view) {
        Intent intent=new Intent(TravelHome.this,WeatherActivity.class);
        intent.putExtra("namedst",namedst);
        startActivity(intent);
    }

    public void moment(View view) {
        Intent intent=new Intent(TravelHome.this,MomentProfileActivity.class);
        intent.putExtra("namedst",namedst);
        startActivity(intent);
    }
}
