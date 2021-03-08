package com.example.gpa_21655257_calculator;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    Button button;
    EditText input1,input2,input3,input4,input5;
    TextView txt;
    private float count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        input1=(EditText)findViewById(R.id.input1);
        input2=(EditText)findViewById(R.id.input2);
        input3=(EditText)findViewById(R.id.input3);
        input4=(EditText)findViewById(R.id.input4);
        input5=(EditText)findViewById(R.id.input5);
        txt=(TextView)findViewById(R.id.txt);
        txt.setBackgroundColor(Color.WHITE);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float grade1, grade2, grade3, grade4, grade5;
                if (count % 2 == 0) {
                    if (input1.getText().toString().equals("")
                            || input2.getText().toString().equals("")
                            || input3.getText().toString().equals("")
                            || input4.getText().toString().equals("")
                            || input5.getText().toString().equals("")) {

                        Toast.makeText(MainActivity.this,"Please fill out all fields", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        grade1 = Float.parseFloat(input1.getText().toString());
                        grade2 = Float.parseFloat(input2.getText().toString());
                        grade3 = Float.parseFloat(input3.getText().toString());
                        grade4 = Float.parseFloat(input4.getText().toString());
                        grade5 = Float.parseFloat(input5.getText().toString());
                        float average = grade1 + grade2 + grade3 + grade4 + grade5;
                        average = average / 5;
                        if (average < 60) {
                            txt.setText(Float.toString(average));
                            txt.setBackgroundColor(Color.RED);
                        } else if (average > 60 && average < 80) {
                            txt.setText(Float.toString(average));
                            txt.setBackgroundColor(Color.YELLOW);
                        } else if (average >= 80 && average <= 100) {
                            txt.setText(Float.toString(average));
                            txt.setBackgroundColor(Color.GREEN);
                        }
                        count++;
                        button.setText("Clear");
                    }

                }
                else
                {
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");
                    input4.setText("");
                    input5.setText("");
                    txt.setText("");
                    button.setText("Compute GPA");
                    txt.setBackgroundColor(Color.WHITE);
                    count++;
                }
            }
        });
    }
}