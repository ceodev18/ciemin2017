package com.kelly.ciemin2017.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.kelly.ciemin2017.MainActivity;
import com.kelly.ciemin2017.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashAcitivity extends AppCompatActivity {
    Context context=this;
    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_acitivity);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                    Intent mainIntent = new Intent(context,MainActivity.class);
                    context.startActivity(mainIntent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
