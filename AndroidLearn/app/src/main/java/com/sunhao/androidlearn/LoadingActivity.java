package com.sunhao.androidlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {
    private final long TIME_SLEEP = 3500;
    protected Animation animation_loading;
    public TextView text_loading;
    public TextView text_loading_ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//hide status bar
        getSupportActionBar().hide();//hide title bar
        setContentView(R.layout.activity_loading);

        text_loading_ad  = findViewById(R.id.text_loading_ad);
        text_loading  = findViewById(R.id.loading_text);
        animation_loading =AnimationUtils.loadAnimation(this, R.anim.loading_anim);
//        animation_loading.setRepeatCount(Animation.INFINITE);
//        animation_loading.setRepeatMode(Animation.REVERSE);


        Thread thread_loadingActivity = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(TIME_SLEEP);

                    //start Main Activity
                    Intent MainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(MainActivityIntent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        text_loading.startAnimation(animation_loading);
        thread_loadingActivity.start();
    }

}
