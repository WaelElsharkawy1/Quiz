package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup RadioG_q_one;
    RadioGroup RadioG_q_two;
    RadioGroup RadioG_q_four;
    CheckBox checkbox_egypt;
    CheckBox checkbox_india;
    CheckBox checkbox_turkey;
    TextView txt_five_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioG_q_one = findViewById(R.id.RadioG_one_answer);
        RadioG_q_two = findViewById(R.id.RadioG_two_answer);
        checkbox_egypt = findViewById(R.id.checkbox_egypt);
        checkbox_india = findViewById(R.id.checkbox_india);
        checkbox_turkey = findViewById(R.id.checkbox_turkey);
        RadioG_q_four = findViewById(R.id.RadioG_four_answer);
        txt_five_answer = findViewById(R.id.txt_five_answer);
    }

    public void doSubmit(View view) {
        int Counter = 0;
        StringBuilder submitMessage = new StringBuilder();
        // question 1 answer is 57
        int q_one_answer = RadioG_q_one.getCheckedRadioButtonId();
        if (q_one_answer == R.id.radioB_57) {
            submitMessage.append("correct answer for question one \n");
            Counter++;
        } else {
            submitMessage.append("Wrong answer for question one \n");
        }

        // question 2 answer is 1.2 billion people
        int q_two_answer = RadioG_q_two.getCheckedRadioButtonId();
        if (q_two_answer == R.id.radioB_1_2billionPeople) {
            submitMessage.append("correct answer for question two \n");
            Counter++;
        } else {
            submitMessage.append("Wrong answer for question two \n");
        }

        // question 3 answer is Egypt and turkey
        if (checkbox_egypt.isChecked() && checkbox_turkey.isChecked() && !checkbox_india.isChecked()) {
            submitMessage.append("correct answer for question three \n");
            Counter++;
        } else {
            submitMessage.append("Wrong answer for question three \n");
        }

        // question 4 answer is False
        int q_four_answer = RadioG_q_four.getCheckedRadioButtonId();
        if (q_four_answer == R.id.radioB_false) {
            submitMessage.append("correct answer for question four \n");
            Counter++;
        } else {
            submitMessage.append("Wrong answer for question four \n");
        }
        // question 5 answer is mohamed
        if (txt_five_answer.getText().toString().toLowerCase().equals("mohamed")) {
            submitMessage.append("correct answer for question five \n");
            Counter++;
        } else {
            submitMessage.append("Wrong answer for question five \n");
        }
        submitMessage.append("you have answered " + Counter + " questions correctly \n");
        submitMessage.append("and  " + (5 - Counter) + " questions wrong \n");
        Toast.makeText(this, submitMessage, Toast.LENGTH_LONG).show();
    }
}
