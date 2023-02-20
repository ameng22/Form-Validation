package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
//    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "on Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "on Back Pressed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "on Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "on Destroy", Toast.LENGTH_SHORT).show();
    }
}