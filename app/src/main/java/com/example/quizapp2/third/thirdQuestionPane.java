package com.example.quizapp2.third;

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
import com.example.quizapp2.conclusion.endDash;
import com.example.quizapp2.dataModel.QuestionModel;
import com.example.quizapp2.second.secondQuestionPlane;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

public class thirdQuestionPane extends AppCompatActivity {

    int pos;
    TextView textView;
    Dialog dialog;
    Button rightNext;
    Button wrongNext ,a,b,c,d;
    int mark;
    int prevMarks;
    private CountDownTimer downTimer;
    TextView timePlane;
    private long timelefttomiliseconds=20000;
    private PublisherInterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question_pane);


        if(savedInstanceState!=null){
            pos=savedInstanceState.getInt("pos");
            mark=savedInstanceState.getInt("mark");
            prevMarks=savedInstanceState.getInt("prevMarks");
        }else{
            pos=0;
            mark=0;
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                prevMarks=extras.getInt("prevMarks");
            }else{
                prevMarks=0;
            }
        }

        interstitialAd = new PublisherInterstitialAd(this);
        interstitialAd.setAdUnitId("/6499/example/interstitial");
        interstitialAd.loadAd(new PublisherAdRequest.Builder().build());

        textView=findViewById(R.id.questionView_3);
        a=(Button) findViewById(R.id.buttonA_3);
        b=(Button) findViewById(R.id.buttonB_3);
        c=(Button) findViewById(R.id.buttonC_3);
        d=(Button) findViewById(R.id.buttonD_3);
        timePlane=(TextView) findViewById(R.id.countView_3);
        textView.setText((pos+1)+"."+bank[pos].getQuestion());
        a.setText("A. "+bank[pos].getA());
        b.setText("B. "+bank[pos].getB());
        c.setText("C. "+bank[pos].getC());
        d.setText("D. "+bank[pos].getD());
        dialog=new Dialog(this);
        startTimer();

    }

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

    public void wrongButtonProcess(){
        downTimer.cancel();
        dialog.setContentView(R.layout.wrong_alert_popup);
        dialog.setCancelable(false);
        wrongNext=dialog.findViewById(R.id.wrongNext);
        wrongNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;
                if(pos<10){
                    textView.setText((pos+1)+". "+bank[pos].getQuestion());
                    a.setText("A. "+bank[pos].getA());
                    b.setText("B. "+bank[pos].getB());
                    c.setText("C. "+bank[pos].getC());
                    d.setText("D. "+bank[pos].getD());
                    startTimer();
                    dialog.dismiss();

                }else{
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }
                    Log.d("appQuize", "marks"+prevMarks);
                    Intent intent=new Intent(thirdQuestionPane.this, endDash.class);
                    intent.putExtra("prevMarks",prevMarks);
                    startActivity(intent);
                    finish();
                }
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void rightButtonProcess(){
        downTimer.cancel();
        dialog.setContentView(R.layout.wright_alert_popup);
        dialog.setCancelable(false);
        rightNext=dialog.findViewById(R.id.rightNext);
        TextView tex=dialog.findViewById(R.id.markText);
        tex.setText("you have earned 3 mark");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        rightNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;
                if(pos<10) {
                    prevMarks=prevMarks+3;
                    textView.setText((pos + 1) + ". " + bank[pos].getQuestion());
                    a.setText("A. " + bank[pos].getA());
                    b.setText("B. " + bank[pos].getB());
                    c.setText("C. " + bank[pos].getC());
                    d.setText("D. " + bank[pos].getD());
                    startTimer();
                    dialog.dismiss();
                }else if(pos==10){
                    prevMarks=prevMarks+3;
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }
                    Log.d("appQuize", "marks"+prevMarks);
                    Intent intent=new Intent(thirdQuestionPane.this, endDash.class);
                    intent.putExtra("prevMarks",prevMarks);
                    startActivity(intent);
                    finish();
                }else{
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }
                    Log.d("appQuize", "marks"+prevMarks);
                    Intent intent=new Intent(thirdQuestionPane.this, endDash.class);
                    intent.putExtra("prevMarks",prevMarks);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pos",pos);
        outState.putInt("mark",mark);
        outState.putInt("prevMarks",mark);
    }

    private QuestionModel[] bank=new QuestionModel[]{
            new QuestionModel("Can't touch. Can't store. Can't make movement. What is this?","Air","Time","Energy","Force","a"),
            new QuestionModel("I am flying. I have no engine. Starting only from higer place. Who am I?","Bird","Plane","Jet","Parachute","c"),
            new QuestionModel("I use for transportation. I am helping to keep connectivity. My value is depend on material made by me. What am I?","Plane","Lane","Chain","Train","b"),
            new QuestionModel("When it is in the sky it is represnting some special thing. But it is located in the sky only very special times. What is this?","Flag","Logo","Fuction","Tower","d"),
            new QuestionModel("I am used in cutting. As well as I am used in binding two things. What is this?","Knife","Sward","String","Tape","a"),
            new QuestionModel("Some kind of these are in the sky can't touch but can see from ground. Some kind of these are on the ground can touch can see and can store data. What is this?","Pen drive","Sun","Clouds","CD","b"),
            new QuestionModel("Everyone thinks this dish was originally made in Italy but this dish was originally made in Chaina. What is this dish?","Cake","Roles","Burger","Pasta","d"),
            new QuestionModel("How many seconds are there in one year?","31,536,000","12","3600","31,622,400","c"),
            new QuestionModel("Tommorrow is neither thursday nor friday. Yesterday was not tuesday or wednesday. Today is not saturday,monday or sunday. What is today?","Wednesday","Friday","Tuesday","Thursday","d"),
            new QuestionModel("I am five times as old as my young brother. After 3 years I will two times as old as my young brother. How old is my after 5 years?","10 years","12 years","14 years","8 years","b"),

    };

    public void clickA_3(View view) {
        if(pos==3||pos==9){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickB_3(View view) {
        if(pos==0||pos==7){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickC_3(View view) {
        if(pos==2||pos==4||pos==5||pos==8){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickD_3(View view) {
        if(pos==1||pos==6){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }
}
