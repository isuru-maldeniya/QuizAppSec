package com.example.quizapp2.third;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.quizapp2.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class frontDashThird extends AppCompatActivity {
    double presentage;
    int marks;
    TextView textView;
    private PublisherAdView mPublisherAdView;
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
        presentage=(double) (marks*100/45);
        textView.setText("Overall you have earned "+presentage+"% marks");

        mPublisherAdView = findViewById(R.id.adview1);
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);

        mPublisherAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.d("appQuize", "Ad loaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                Log.d("appQuize", "Ad was not loaded");
            }
        });

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
