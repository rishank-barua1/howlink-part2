package com.example.howlinkpart3.ui.signinworkflow.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.howlinkpart3.R;

public class AuthenticationScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication_screen);
    }

    public void signIn(View view) {
        Intent i = new Intent(AuthenticationScreen.this,SignInScreen.class);
        startActivity(i);
        finish();
    }
}