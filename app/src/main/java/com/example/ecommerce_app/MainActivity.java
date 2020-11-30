package com.example.ecommerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    Animation topAnim,buttomAnim;
    TextView logo,salogan;
    ImageView imagelogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        buttomAnim = AnimationUtils.loadAnimation(this,R.anim.buttom_animation);

        //connect id with xml
        imagelogo = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView);
        salogan = findViewById(R.id.textView2);

        imagelogo.setAnimation(topAnim);
        logo.setAnimation(buttomAnim);
        salogan.setAnimation(buttomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(imagelogo,"logo_image");
                pairs[1] = new Pair<View,String>(logo,"logo_text");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(intent, options.toBundle());
                finish();
            }
        },SPLASH_TIMER);
    }
}
