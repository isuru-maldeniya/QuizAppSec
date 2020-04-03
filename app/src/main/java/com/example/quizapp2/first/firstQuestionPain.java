package com.example.quizapp2.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
    }

    public void rightButtonProcess(){
        downTimer.cancel();
        dialog.setContentView(R.layout.wright_alert_popup);
        rightNext=dialog.findViewById(R.id.rightNext);
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
                }else{
                    Log.d("appQuize", "marks"+mark);
                }
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void wrongButtonProcess(){
        downTimer.cancel();
        dialog.setContentView(R.layout.wrong_alert_popup);
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
                    Log.d("appQuize", "marks"+mark);
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
            new QuestionModel("I have a rhythms. I can flow. I havn\'t any colour. I am made by man. What am I?","Rain","Wind","River","Song","d"),
            new QuestionModel("You can see through me. I am good to drink. People swim in me. What am I?","Vodka","Money","Water","Honey","c"),
            new QuestionModel("My eyes are still open when I go to sleep but I can\'t see. Who am I?","Gold Fish","Snake","Parrot","Bear","a"),
            new QuestionModel("I have four legs but I am creeping. I am not sweating but my tail pointed. Who am I?","Chameleon","Crocadile","Iguana","Monitor","d"),
            new QuestionModel("You can see it everyday. You dream to touch it but you can\'t. What is this?","Wind","Sky","Sea","Rainbow","b"),
            new QuestionModel("I am not a living being but i grow, I don\'t have a nose but I want air. Water is my biggest enemy. What am I?","Ice","Tree","Fire","Baloon","c"),
            new QuestionModel("This is uncountable. Solid. This is made by juice of some trees. Some time used as food flavour. What is this?","Honey","Suger","Sand","Jam","b"),
            new QuestionModel("I was young, I was tall but as I get older I get shorter. Who am I?","Pen","River","Coconut tree","Pencil","d"),
            new QuestionModel("When I was broken,it is very useful. What is this?","Egg","Mind","Bone","Glass","a"),
            new QuestionModel("This is only going up. There is no downside. What is this?","Population","Oil price","Age","US Doller","c"),
            new QuestionModel("What is the oldest of these trees?","Oak tree","Mango tree","Cocoa tree","Elder tree","d"),
            new QuestionModel("Which social media does a bird use as its mark?","Facebook","Twitter","VK","Reddit","b"),
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
