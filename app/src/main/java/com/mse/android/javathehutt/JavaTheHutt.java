package com.mse.android.javathehutt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Map;

public class JavaTheHutt extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_the_hutt);

        mListView = (ViewGroup) findViewById(R.id.list);

        addDemo("Login", LoginActivity.class);
        //addDemo("Plan Route", MapActivity.class);
        addDemo("Begin Trip", BeginTripActivity.class);
        addDemo("Collect Data", CollectDataActivity.class);
        addDemo("Complete Trip", CompleteTripActivity.class);
        addDemo("Monitor Trip", MonitorTripActivity.class);
        addDemo("Analyze Trips", AnalTripsActivity.class);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
         //       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
             //           .setAction("Action", null).show();
           // }
        //});
    }

    private void addDemo(String demoName, Class<? extends Activity> activityClass) {
        Button b = new Button(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        b.setLayoutParams(layoutParams);
        b.setText(demoName);
        b.setTag(activityClass);
        b.setOnClickListener(this);
        mListView.addView(b);
    }

    @Override
    public void onClick(View view) {
        Class activityClass = (Class) view.getTag();
        startActivity(new Intent(this, activityClass));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_java_the_hutt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
