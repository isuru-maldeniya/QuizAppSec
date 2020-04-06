package com.example.quizapp2.second;

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
import com.example.quizapp2.first.firstQuestionPain;
import com.example.quizapp2.third.frontDashThird;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

public class secondQuestionPlane extends AppCompatActivity {

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
        setContentView(R.layout.activity_second_question_plane);

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

        textView=findViewById(R.id.questionView_2);
        a=(Button) findViewById(R.id.buttonA_2);
        b=(Button) findViewById(R.id.buttonB_2);
        c=(Button) findViewById(R.id.buttonC_2);
        d=(Button) findViewById(R.id.buttonD_2);
        timePlane=(TextView) findViewById(R.id.countView_2);
        textView.setText((pos+1)+"."+bank[pos].getQuestion());
        a.setText("A. "+bank[pos].getA());
        b.setText("B. "+bank[pos].getB());
        c.setText("C. "+bank[pos].getC());
        d.setText("D. "+bank[pos].getD());
        dialog=new Dialog(this);
        startTimer();

    }

    public void clickA_2(View view) {
        if(pos==0||pos==4||pos==12){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickC_2(View view) {
        if(pos==1||pos==7||pos==13){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickD_2(View view) {
        if(pos==3||pos==6||pos==8||pos==10||pos==14){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    public void clickB_2(View view) {
        if(pos==2||pos==5||pos==9||pos==11){
            rightButtonProcess();
        }else{
            wrongButtonProcess();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pos",pos);
        outState.putInt("mark",mark);
        outState.putInt("prevMarks",mark);
    }

    private QuestionModel[] bank=new QuestionModel[]{
            new QuestionModel("It is a mammal. It's teeth are growing rapidly. What is it?","Rat","Cat","Pig","Dog","a"),
            new QuestionModel("I am living in a dynamic environment. I can't survive without it. I can swim. I have organs to breath here. What is my environment?","Fish","Air","Water","Tortoise","c"),
            new QuestionModel("I have a neck but haven't a head. I have two arms but haven't hands. What am I?","Robot","Shirt","Bag","Skirt","b"),
            new QuestionModel("I can talk. But you can't see me. I am talking after you call. What is it?","Secret","Alarm","Faith","Echo","d"),
            new QuestionModel("What can go up and come down without moving?","Temperature","Age","Wind","Ball","a"),
            new QuestionModel("I am only one colour but not one size. Whenever there is light, I'll be with you?","Bulb","Shadow","Sun","Moon","b"),
            new QuestionModel("This takes you whenever you go but you wan't even feel it. Others use it more than you. What is this?","Brain","Mobile phone","Watch","Name","d"),
            new QuestionModel("One battlefield at a time. Sometimes it is very peaceful. Favourite place for many. What is this place?","Bathroom","Lunchroom","Bedroom","Classroom","c"),
            new QuestionModel("My job is to fillter things. Somethings are absorbed while filtering. If my job isn't done, you'll know I am sick. What am I?","Liver","Lung","Craw","Kidney","d"),
            new QuestionModel("I am a god. Also I am a planet. Also you can use me to measure the heat. What am I?","Jupiter","Mercury","Celsius","Venus","b"),
            new QuestionModel("You can't see me but my smell can make me aware of you. I am sure you won't like my smell. What is this?","O2","CO2","H2O","H2S","d"),
            new QuestionModel("There was a green house. Inside the green house there was a white house. Inside the white house there was a red house. Inside the red house there are lot of babies. Who am I?","papaya","Watermelone","Pumpking","Apple","b"),
            new QuestionModel("What relationship would your mother's brother's brother-in-law be to you?","Father","Uncle","Cousin","Elder brother","a"),
            new QuestionModel("Which country has the most dangerous national flag?","USA","Iran","Mossambic","China","c"),
            new QuestionModel("What is the answer for this? 4+3x4(3x2) ","168","96","72","76","d"),
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
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }

                    Log.d("appQuize", "marks"+prevMarks);
                    Intent intent=new Intent(secondQuestionPlane.this, frontDashThird.class);
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
        tex.setText("you have earned 2 mark");
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        rightNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;
                if(pos<15) {
                    prevMarks=prevMarks+2;
                    textView.setText((pos + 1) + ". " + bank[pos].getQuestion());
                    a.setText("A. " + bank[pos].getA());
                    b.setText("B. " + bank[pos].getB());
                    c.setText("C. " + bank[pos].getC());
                    d.setText("D. " + bank[pos].getD());
                    startTimer();
                    dialog.dismiss();
                }else if(pos==15){
                    prevMarks=prevMarks+2;
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                        Log.d("appQuize", "Ad was displayed");
                    }else{
                        Log.d("appQuize", "Ad was not displayed");
                    }
                    Log.d("appQuize", "marks"+prevMarks);
                    Intent intent=new Intent(secondQuestionPlane.this, frontDashThird.class);
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
                    Intent intent=new Intent(secondQuestionPlane.this, frontDashThird.class);
                    intent.putExtra("prevMarks",prevMarks);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

}
