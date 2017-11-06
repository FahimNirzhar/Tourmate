package com.example.bitm.tourmate;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class EventProfileActivity extends AppCompatActivity {
    ListView listView;
    EventManager eventManager;
    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);;
        Auth = FirebaseAuth.getInstance();
        mTitle.setText("Event Profile");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        listView= (ListView) findViewById(R.id.eventLV);
        eventManager=new EventManager(this);
        final ArrayList<Event> eventArrayList=eventManager.getAllEvent();
        EventAdapter adapter=new EventAdapter(this,eventArrayList) {
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EventProfileActivity.this,TravelHome.class);
                intent.putExtra("id",eventArrayList.get(i).getEventID());
                intent.putExtra("name",eventArrayList.get(i).getDesName());
                intent.putExtra("fDate",eventArrayList.get(i).getFromaDate());
                intent.putExtra("tDate",eventArrayList.get(i).getToDate());
                intent.putExtra("estBudget",eventArrayList.get(i).getBudget());

                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.logout:
                Auth.signOut();
                Intent intent = new Intent(EventProfileActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }
    public void moveToAdd(View view) {
        Intent intent=new Intent(this,EventActivity.class);
        startActivity(intent);
        finish();
    }


}