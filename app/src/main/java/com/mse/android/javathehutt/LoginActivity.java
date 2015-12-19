package com.mse.android.javathehutt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView mUsername;
    private EditText mPassword;
    private Button mLoginButton;
    private EditText mVessel;
    private static final String LOGIN_VALIDATED =
            "com.mse.android.javathehutt.login.validated";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (TextView) findViewById(R.id.login_username);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mPassword = (EditText) findViewById(R.id.login_password);
        mVessel = (EditText) findViewById(R.id.login_vessel_name_input);

        mUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Leave blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Leave blank
            }

            @Override
            public void afterTextChanged(Editable s) {
                mVessel.setEnabled(true);
            }
        });

        mVessel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPassword.setEnabled(true);
            }
        });

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginButton.setEnabled(true);
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoginValidated();
                TripClass trip = new TripClass(mVessel.getText().toString());
                MapDataSingleton.getInstance(LoginActivity.this).addTrip(trip);
                MapDataSingleton.getInstance(LoginActivity.this).setLoginVesselname(mVessel.getText().toString());
                finish();
            }
        });
    }

    private void setLoginValidated() {
        Intent data = new Intent();
        data.putExtra(LOGIN_VALIDATED, true);
        setResult(RESULT_OK, data);
    }

    public static boolean wasLoginValidated(Intent result) {
        return result.getBooleanExtra(LOGIN_VALIDATED, false);
    }

}
