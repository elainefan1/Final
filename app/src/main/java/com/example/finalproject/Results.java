package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    private Button TakeAgain = null;
    private String ageGroup = null;
    private TextView textView = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        this.TakeAgain = (Button) findViewById(R.id.TakeAgain);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        ageGroup = extras.getString("AgeGroup");
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Thank you for completing the survey. " + "The age group you Chose: " + ageGroup);
        TakeAgain = (Button) findViewById(R.id.TakeAgain);
        this.TakeAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Results.this,
                        com.example.finalproject.MainActivity.class);
                startActivity(intent);
            }
        });
    }
}