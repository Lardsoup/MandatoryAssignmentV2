package com.example.lardman.mandatoryassignmentv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Login extends AppCompatActivity
{
    private String TAG = "LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginButtonClicked(View view)
    {
        Log.d(TAG, "Login button pressed");
        Intent intent = new Intent(this, MainMenu.class);
        //startActivity(intent);
        startActivityForResult(intent, 31415);
    }
}
