package com.example.quizapp2.conclusion;

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

public class endDash extends AppCompatActivity {
    double presentage;
    TextView textView;
    int marks;
    private PublisherAdView mPublisherAdView;
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

        mPublisherAdView = findViewById(R.id.adview3);
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
