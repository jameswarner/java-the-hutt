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

import java.util.HashMap;
import java.util.Map;

public class JavaTheHutt extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup mListView;
    private static final int REQUEST_LOGIN_RESPONSE = 100;
    private HashMap<String, Button> mButtonMap = new HashMap<String, Button>();

    private static final String A_LOGIN = "LOGIN";
    private static final String A_PLAN = "PLAN";
    private static final String A_BEGIN = "BEGIN";
    private static final String A_COLLECT = "COLLECT";
    private static final String A_COMPLETE = "COMPLETE";
    private static final String A_MONITOR = "MONITOR";
    private static final String A_ANALYZE ="ANALYZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_the_hutt);

        mListView = (ViewGroup) findViewById(R.id.list);

        addDemo(A_LOGIN, LoginActivity.class);
        addDemo(A_PLAN, MapsActivity.class);
        addDemo(A_BEGIN, BeginTripActivity.class);
        addDemo(A_COLLECT, CollectDataActivity.class);
        addDemo(A_COMPLETE, CompleteTripActivity.class);
        addDemo(A_MONITOR, MonitorTripActivity.class);
        addDemo(A_ANALYZE, AnalTripsActivity.class);

        mButtonMap.get(A_LOGIN).setEnabled(true);
    }

    private void addDemo(String demoName, Class<? extends Activity> activityClass) {
        Button b = new Button(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        b.setLayoutParams(layoutParams);
        b.setText(demoName);
        b.setTag(activityClass);
        b.setOnClickListener(this);
        b.setEnabled(false);
        mListView.addView(b);
        mButtonMap.put(demoName, b);
    }

    @Override
    public void onClick(View view) {
        Class activityClass = (Class) view.getTag();
        if (LoginActivity.class == activityClass) {
            startActivityForResult(new Intent(this, activityClass), REQUEST_LOGIN_RESPONSE);
        }
        else {
            startActivity(new Intent(this, activityClass));
        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_LOGIN_RESPONSE) {
            if (data == null) {
                return;
            }

            if (true == LoginActivity.wasLoginValidated(data)) {
                for(Button btn: mButtonMap.values()) {
                    btn.setEnabled(true);
                }
            }
        }

    }
}
