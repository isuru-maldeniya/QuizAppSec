package com.example.quizapp2.third;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.quizapp2.R;

public class frontDashThird extends AppCompatActivity {
    double presentage;
    int marks;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_dash_third);

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

        textView=(TextView) findViewById(R.id.overallpane_3);
        presentage=(double) (marks*100/30);
        textView.setText("Overall you have earned "+presentage+"% marks");

    }

    public void nextplane_3(View view) {
        Intent intent = new Intent(this, thirdQuestionPane.class);
        intent.putExtra("prevMarks",marks);
        startActivity(intent);
        finish();
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mark",marks);
    }


}
