package com.example.quizapp2.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp2.R;
import com.example.quizapp2.dataModel.QuestionModel;
import com.example.quizapp2.second.frontDashSecond;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import java.util.Arrays;
import java.util.List;

public class firstQuestionPain extends AppCompatActivity {

    int pos;
    TextView textView;
    Dialog dialog;
    Button rightNext;
    Button wrongNext ,a,b,c,d;
    int mark;
    private CountDownTimer downTimer;
    TextView timePlane;
    private long timelefttomiliseconds=20000;
    private PublisherInterstitialAd interstitialAd;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question_pain);

        if(savedInstanceState!=null){
            pos=savedInstanceState.getInt("pos");
            mark=savedInstanceState.getInt("mark");
        }else{
            pos=0;
            mark=0;
        }

//
        interstitialAd = new PublisherInterstitialAd(this);
        interstitialAd.setAdUnitId("/6499/example/interstitial");
        interstitialAd.loadAd(new PublisherAdRequest.Builder().build());



        textView=(TextView)findViewById(R.id.level1Text);
        a=(Button) findViewById(R.id.buttonA);
        b=(Button) findViewById(R.id.buttonB);
        c=(Button) findViewById(R.id.buttonC);
        d=(Button) findViewById(R.id.buttonD);
        timePlane=(TextView) findViewById(R.id.countView);
        textView.setText((pos+1)+"."+bank[pos].getQuestion());
        a.setText("A. "+bank[pos].getA());
        b.setText("B. "+bank[pos].getB());
        c.setText("C. "+bank[pos].getC());
        d.setText("D. "+bank[pos].getD());
        dialog=new Dialog(this);
        startTimer();



        // Kaweesha you have to uncomment these lines

//        List<String> testDeviceIds = Arrays.asList("33BE2250B43518CCDA7DE426D04EE231");
//        RequestConfiguration configuration =
//                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
//        MobileAds.setRequestConfiguration(configuration);


        // Kaweesha you have to uncomment these upper lines




    }

    public void rightButtonProcess(){
        downTimer.cancel();
        dialog.setContentView(R.layout.wright_alert_popup);
        dialog.setCancelable(false);
        rightNext=dialog.findViewById(R.id.rightNext);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        rightNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;
                if(pos<15) {
                    mark++;
                    textView.setText((pos + 1) + ". " + bank[pos].getQuestion());
                    a.setText("A. " + bank[pos].getA());
                    b.setText("B. " + bank[pos].getB());
                    c.setText("C. " + bank[pos].getC());
                    d.setText("D. " + bank[pos].getD());
                    startTimer();
                    dialog.dismiss();
                }else if(pos==15){
                    mark++;
//                    interstitialAd = new PublisherInterstitialAd(dialog.getContext());
//                    interstitialAd.setAdUnitId("/6499/example/interstitial");
//                    interstitialAd.loadAd(new PublisherAdRequest.Builder().build());

//                    interstitialAd.setAdListener(new AdListener(){
//                        @Override
//                        public void onAdLoaded() {
//                            Log.d("appQuize", "Ad was displayed");
//                        }
//
//                        @Override
//                        public void onAdFailedToLoad(int errorCode) {
//                            // Code to be executed when an ad request fails.
//                        }
//
//                        @Override
//                        public void onAdOpened() {
//                            // Code to be executed when the ad is displayed.
//                        }
//
//                        @Override
//                        public void onAdClicked() {
//                            // Code to be executed when the user clicks on an ad.
//                        }
//
//                        @Override
//                        public void onAdLeftApplication() {
//                            // Code to be executed when the user has left the app.
//                        }
//
//                        @Override
//                        public void onAdClosed() {
//                            Intent intent=new Intent(firstQuestionPain.this, frontDashSecond.class);
//                            intent.putExtra("prevMarks",mark);
//                            startActivity(intent);
//                            finish();
//                        }
//                    });

                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }
                    Intent intent=new Intent(firstQuestionPain.this, frontDashSecond.class);
                    intent.putExtra("prevMarks",mark);
                    startActivity(intent);
                    finish();

                }else{
//                    interstitialAd = new PublisherInterstitialAd(dialog.getContext());
//                    interstitialAd.setAdUnitId("/6499/example/interstitial");
//                    interstitialAd.loadAd(new PublisherAdRequest.Builder().build());
                    Intent intent=new Intent(firstQuestionPain.this, frontDashSecond.class);
                    intent.putExtra("prevMarks",mark);
                    startActivity(intent);
                    finish();
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }

                }
            }
        });

    }

    public void wrongButtonProcess(){
        downTimer.cancel();
        dialog.setContentView(R.layout.wrong_alert_popup);
        dialog.setCancelable(false);
        wrongNext=dialog.findViewById(R.id.wrongNext);
        wrongNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;
                if(pos<15){
                    textView.setText((pos+1)+". "+bank[pos].getQuestion());
                    a.setText("A. "+bank[pos].getA());
                    b.setText("B. "+bank[pos].getB());
                    c.setText("C. "+bank[pos].getC());
                    d.setText("D. "+bank[pos].getD());
                    startTimer();
                    dialog.dismiss();

                }else{
//                    interstitialAd = new PublisherInterstitialAd(dialog.getContext());
//                    interstitialAd.setAdUnitId("/6499/example/interstitial");
//                    interstitialAd.loadAd(new PublisherAdRequest.Builder().build());
//                    if(interstitialAd.isLoaded()){
//                        interstitialAd.show();
//                        Log.d("appQuize", "Ad was displayed");
//                    }else{
//                        Log.d("appQuize", "Ad was not displayed");
//                    }
                    Intent intent=new Intent(firstQuestionPain.this, frontDashSecond.class);
                    intent.putExtra("prevMarks",mark);
                    startActivity(intent);
                    finish();
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }
                }
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pos",pos);
        outState.putInt("mark",mark);
    }

    public void clickA(View view) {
        if(pos==3||pos==9||pos==14){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickB(View view) {
        if(pos==0||pos==5||pos==7||pos==12){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickC(View view) {
        if(pos==2||pos==6||pos==10||pos==13){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickD(View view) {
        if(pos==1||pos==4||pos==8||pos==11){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    private QuestionModel[] bank=new QuestionModel[]{
            new QuestionModel("Drink milk. Night rider. Hide in whole day. Who am I?","Cat","Bat","Rat","Rabbit","b"),
            new QuestionModel("I have a rhythm. I can flow. I havn't any colour. I am made by the man. What am I?","Rain","Wind","River","Song","d"),
            new QuestionModel("You can see through me. I am good to drink. People swim in me. What am I?","Vodka","Money","Water","Honey","c"),
            new QuestionModel("My eyes are still open when I go to sleep but I can\'t see. Who am I?","Gold Fish","Snake","Parrot","Bear","a"),
            new QuestionModel("I have four legs but I am creeping. I am not sweating but my tail pointed. Who am I?","Chameleon","Crocadile","Iguana","Monitor","d"),
            new QuestionModel("You can see it everyday. You dream to touch it but you can\'t. What is this?","Wind","Sky","Sea","Rainbow","b"),
            new QuestionModel("I am not a living being but I grow, I don't have a nose but I want air. Water is my biggest enemy. What am I?","Ice","Tree","Fire","Baloon","c"),
            new QuestionModel("This is uncountable. Solid. This is made by juice of some trees. Some time used as a food flavour. What is this?","Honey","Suger","Sand","Jam","b"),
            new QuestionModel("When I was young, I was tall but as I grow older I get shorter. Who am I?","Pen","River","Coconut tree","Pencil","d"),
            new QuestionModel("When I was broken,the result is very useful. What is this?","Egg","Mind","Bone","Glass","a"),
            new QuestionModel("This is only going up. There is no going down. What is this?","Population","Oil price","Age","US Doller","c"),
            new QuestionModel("What is the oldest of these trees?","Oak tree","Mango tree","Cocoa tree","Elder tree","d"),
            new QuestionModel("Which social media does use a bird use as its mark?","Facebook","Twitter","VK","Reddit","b"),
            new QuestionModel("This country always needs food. What is this?","Ethiopia","India","Hungary","Kenya","c"),
            new QuestionModel("What travels around the world but stays in one spot?","Stamp","Plane","Money","Ship","a"),
    };


    public void startTimer(){
        timelefttomiliseconds=20000;
        downTimer=new CountDownTimer(timelefttomiliseconds,1000) {
            @Override
            public void onTick(long l) {
                timelefttomiliseconds=l;
                int sec=(int)timelefttomiliseconds%60000/1000+1;
                String s=sec+"";
                timePlane.setText(s);
            }

            @Override
            public void onFinish() {
                wrongButtonProcess();
            }
        }.start();
    }

}
