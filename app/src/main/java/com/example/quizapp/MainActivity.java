package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int marks = 0;
    ScrollView scroll;
    RadioGroup radioGroupOne, radioGroupTwo, radioGroupThree;
    RadioButton bud, pages, watchful;
    EditText question5;
    CheckBox android, confarmation, sunday, talent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scroll = findViewById(R.id.Scroll);
        bud = findViewById(R.id.radio_bud);
        pages = findViewById(R.id.radio_pages);
        watchful = findViewById(R.id.radio_watchful);
        android = findViewById(R.id.checkbox_android);
        talent = findViewById(R.id.checkbox_talent);
        confarmation = findViewById(R.id.checkbox_confarmation);
        sunday = findViewById(R.id.checkbox_sunday);
        radioGroupOne = findViewById(R.id.radio_group_one);
        radioGroupTwo = findViewById(R.id.radio_group_two);
        radioGroupThree = findViewById(R.id.radio_group_three);
        question5 = findViewById(R.id.userResponse_AnswerFive);
    }

    public void SubmitTest(View view) {
        String answerFive = getResources().getString(R.string.worst);
        String wrongAnswers = "Check :";
        if (bud.isChecked()) {
            marks++;
        } else {
            wrongAnswers = wrongAnswers + "Q1\n";
        }
        if (pages.isChecked()) {
            marks++;
        } else {
            wrongAnswers = wrongAnswers + "Q2\n";
        }
        if (android.isChecked() && talent.isChecked() && sunday.isChecked() && !(confarmation.isChecked())) {
            marks++;
        } else {
            wrongAnswers = wrongAnswers + "Q3\n";
        }
        if (watchful.isChecked()) {
            marks++;
        } else {
            wrongAnswers = wrongAnswers + "Q4\n";
        }
        if (answerFive.equals(question5.getText().toString())) {
            marks++;
        } else {
            wrongAnswers = wrongAnswers + "Q5\n";
        }
        if (marks == 5) {
            Toast.makeText(this, "congrats,all answer correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Marks: " + marks +"/5\n"+ wrongAnswers, Toast.LENGTH_LONG).show();
        }
    }
    public void ResetQuiz(View v) {

        marks = 0;
        question5.getText().clear();
        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();

        if (android.isChecked()) {
            android.toggle();
        }

        if (talent.isChecked()) {
            talent.toggle();
        }

        if (confarmation.isChecked()) {
            confarmation.toggle();
        }

        if (sunday.isChecked()) {
            sunday.toggle();
        }

        scroll.fullScroll(ScrollView.FOCUS_UP);
    }


}
