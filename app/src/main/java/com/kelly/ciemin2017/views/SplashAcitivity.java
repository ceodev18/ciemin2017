package com.kelly.ciemin2017.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.kelly.ciemin2017.MainActivity;
import com.kelly.ciemin2017.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashAcitivity extends AppCompatActivity {
    Context context=this;
    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 3000;
    private  Window window=null;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_acitivity);
        startAnimations();
        /*setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        timer.schedule(task, SPLASH_SCREEN_DELAY);*/
    }
    private void startAnimations(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.ll_splash);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        LinearLayout ll_contenSplash = (LinearLayout) findViewById(R.id.ll_contenSplash);
        Button b_facebook=(Button) findViewById(R.id.b_facebook);
        b_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        ll_contenSplash.clearAnimation();
        ll_contenSplash.startAnimation(anim);
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (true) {
                        sleep(100);
                        waited += 100;
                    }
                   // Intent intent = new Intent(SplashAcitivity.this,
                   //         MainActivity.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    //startActivity(intent);
                   // SplashAcitivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashAcitivity.this.finish();
                }

            }
        };
        splashTread.start();
    }


}
