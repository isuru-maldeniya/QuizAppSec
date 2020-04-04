package com.example.quizapp2.conclusion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.quizapp2.R;

public class endDash extends AppCompatActivity {

    int marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_dash);

        if(savedInstanceState!=null){
            marks=savedInstanceState.getInt("mark");
        }else{
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                marks=extras.getInt("prevMarks");
                Log.d("appQuize", "Marks(fill) : "+marks);
            }else{
                marks=0;
                Log.d("appQuize", "Marks(null) : "+marks);
            }
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mark",marks);
    }

}
