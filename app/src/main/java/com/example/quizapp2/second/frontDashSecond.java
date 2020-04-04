package com.example.quizapp2.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.quizapp2.R;

public class frontDashSecond extends AppCompatActivity {
    int marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_dash_second);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            marks=extras.getInt("prevMarks");
            Log.d("appQuize", "Marks(fill) : "+marks);
        }else{
            marks=0;
            Log.d("appQuize", "Marks(null) : "+marks);
        }


    }

    public void nextplane(View view) {
        Intent intent=new Intent(this,secondQuestionPlane.class);
        intent.putExtra("prevMarks",marks);
        startActivity(intent);
        finish();
    }
}
