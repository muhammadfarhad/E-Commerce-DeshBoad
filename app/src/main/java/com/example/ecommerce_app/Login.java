package com.example.ecommerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextView logotext,salogantext;
    ImageView imageView;
    Button callsignup,login_btn;
    TextInputLayout username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        //Hooks for connect this xml file
        imageView = findViewById(R.id.loginlogoimage);
        logotext = findViewById(R.id.textwelcome);
        salogantext = findViewById(R.id.textsignsalogan);
        callsignup = findViewById(R.id.createnewuser);
        login_btn = findViewById(R.id.login_btn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Dashboard.class);
                startActivity(intent);
            }
        });
        callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignUp.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View,String>(imageView,"logo_image");
                pairs[1] = new Pair<View,String>(logotext,"logo_text");
                pairs[2] = new Pair<View,String>(salogantext,"logo_text_sologan");
                pairs[3] = new Pair<View,String>(callsignup,"button_sign_trans");
                pairs[4] = new Pair<View,String>(login_btn,"button_trans");
                pairs[5] = new Pair<View,String>(username,"username_trans");
                pairs[6] = new Pair<View,String>(password,"password_trans");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                startActivity(intent,options.toBundle());
            }
        });
    }
}
