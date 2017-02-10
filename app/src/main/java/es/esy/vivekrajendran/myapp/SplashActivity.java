/**
 * Copyright will updated soon
 */

package es.esy.vivekrajendran.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.esy.vivekrajendran.myapp.model.Contract;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        SharedPreferences mSharedPreferences = getSharedPreferences(Contract.Pref.PREF_NAME, MODE_PRIVATE);
        final Intent intent;
        // = new Intent(SplashActivity.this, LoginActivity.class);
        boolean islogged = mSharedPreferences.getBoolean(Contract.Pref.ISLOGGED, false);
        if (!islogged) {
            intent = new Intent(SplashActivity.this, LoginActivity.class);
        } else {
            intent = new Intent(SplashActivity.this, Home.class);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, 1000);
    }
}

