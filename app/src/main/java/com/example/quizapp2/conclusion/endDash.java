package com.example.quizapp2.conclusion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.quizapp2.R;

public class endDash extends AppCompatActivity {
    double presentage;
    TextView textView;
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
        textView=(TextView) findViewById(R.id.markText_3);
        presentage=(double) (marks*100/75);
        textView.setText("Overall you have earned "+presentage+"%");

    }


    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mark",marks);
    }

    public void toWhatsApp(View view) {
        final String packageName=getApplicationContext().getPackageName();
        String url="";

        try
        {
            url = "https://play.google.com/store/apps/details?id=" + packageName;
        }
        catch (android.content.ActivityNotFoundException anfe)
        {
            url = "https://play.google.com/store/apps/details?id=" + packageName;
        }

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "#new #Qurantine #challenge. Hi this is a marvelous riddle quiz app. Here I am challenging you to think smarter. Here is the Playstore link "+url);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }
}
