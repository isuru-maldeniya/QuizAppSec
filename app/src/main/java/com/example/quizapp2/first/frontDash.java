package com.example.quizapp2.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizapp2.R;

public class frontDash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_dash);
    }

    public void goInClick(View view) {
        Intent intent = new Intent(this, firstQuestionPain.class);
        startActivity(intent);
        finish();
    }

    public void exitClick(View view) {
        finish();
        System.exit(0);
    }
}
