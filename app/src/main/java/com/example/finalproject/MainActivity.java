package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button ButtonSubmit = null;
    private String answerSelectedStr = null;
    private RadioGroup radioGroupQuestion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ButtonSubmit = (Button) findViewById(R.id.ButtonSubmit);

        TextView textViewQuestionTitle = null;
        TextView textViewQuestion = null;
        TextView textViewScore = null;

        RadioButton radioButtonA = null;
        RadioButton radioButtonB = null;
        RadioButton radioButtonC = null;
        RadioButton radioButtonD = null;


        radioGroupQuestion = (RadioGroup) findViewById(R.id.RadioGroup1);
        radioButtonA = (RadioButton) findViewById(R.id.RadioButtonA);
        radioButtonB = (RadioButton) findViewById(R.id.RadioButtonB);
        radioButtonC = (RadioButton) findViewById(R.id.RadioButtonC);
        radioButtonD = (RadioButton) findViewById(R.id.RadioButtonD);


            ButtonSubmit = (Button) findViewById(R.id.ButtonSubmit);
            this.ButtonSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                answerSelectedStr = getSelectedAnswer();
                Intent intent = new Intent(MainActivity.this, com.example.finalproject.Results.class);
                intent.putExtra("AgeGroup", answerSelectedStr);
                startActivity(intent);

                }


            });

        }

        private String getSelectedAnswer(){
            int selectedButtonId = this.radioGroupQuestion.getCheckedRadioButtonId();

            Log.d("selected", "onCreate: " + selectedButtonId);
            if (selectedButtonId != -1) {
                return ((RadioButton) findViewById(selectedButtonId)).getText().toString();
            }
            else {
                return "";
            }

        }
}
