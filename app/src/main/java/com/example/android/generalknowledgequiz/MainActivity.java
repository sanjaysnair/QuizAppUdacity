package com.example.android.generalknowledgequiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.duration;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @desc Function to handle submit action
     * @param view
     */
    public void submitQuiz(View view) {

        RadioGroup question1 = (RadioGroup) findViewById(R.id.q1_option);
        RadioGroup question3 = (RadioGroup) findViewById(R.id.q3_option);
        RadioGroup question4 = (RadioGroup) findViewById(R.id.q4_option);
        RadioGroup question5 = (RadioGroup) findViewById(R.id.q5_option);

        // Fetching the value
        String q1_ans = "";
        int q1_ans_id = question1.getCheckedRadioButtonId();
        if (q1_ans_id != -1) {
            RadioButton q1_ans_radio = (RadioButton) findViewById(q1_ans_id);
            q1_ans = q1_ans_radio.getText().toString();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.err_msg_part) + getString(R.string.q_linux_creator), Toast.LENGTH_LONG).show();
            return;
        }

        CheckBox q2_a2_checkbox = (CheckBox) findViewById(R.id.q2_a2);
        CheckBox q2_a3_checkbox = (CheckBox) findViewById(R.id.q2_a3);

        String q3_ans = "";
        int q3_ans_id = question3.getCheckedRadioButtonId();
        if (q3_ans_id != -1) {
            RadioButton q3_ans_radio = (RadioButton) findViewById(q3_ans_id);
            q3_ans = q3_ans_radio.getText().toString();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.err_msg_part) + getString(R.string.q_latest_android), Toast.LENGTH_LONG).show();
            return;
        }


        String q4_ans = "";
        int q4_ans_id = question4.getCheckedRadioButtonId();
        if (q4_ans_id != -1) {
            RadioButton q4_ans_radio = (RadioButton) findViewById(q4_ans_id);
            q4_ans = q4_ans_radio.getText().toString();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.err_msg_part) + getString(R.string.q_marley), Toast.LENGTH_LONG).show();
            return;
        }

        String q5_ans = "";
        int q5_ans_id = question5.getCheckedRadioButtonId();
        if (q5_ans_id != -1) {
            RadioButton q5_ans_radio = (RadioButton) findViewById(q5_ans_id);
            q5_ans = q5_ans_radio.getText().toString();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.err_msg_part) + getString(R.string.q_fib), Toast.LENGTH_LONG).show();
            return;
        }

        String q6_ans = "";
        EditText q6_ans_edit_text = (EditText) findViewById(R.id.q6_a);
        q6_ans = q6_ans_edit_text.getText().toString();
        if (q6_ans == "") {
            Toast.makeText(getApplicationContext(), getString(R.string.err_msg_part2) + getString(R.string.q_arithemetic), Toast.LENGTH_LONG).show();
            return;
        }


        // Answer comparison
        String quiz_summary = getString(R.string.result);
        int error_count = 0;

        if (q1_ans != getString(R.string.a_linus)) {
            quiz_summary += getString(R.string.err_q1);
            error_count++;
        } else {
            quiz_summary += getString(R.string.success_q1);
        }

        if (q2_a2_checkbox.isChecked() == false || q2_a3_checkbox.isChecked() == false) {
            quiz_summary += "\n" + getString(R.string.err_q2);
            error_count++;
        } else {
            quiz_summary += "\n" + getString(R.string.success_q2);
        }

        if (q3_ans != getString(R.string.a_nougat)) {
            quiz_summary += "\n" + getString(R.string.err_q3);
            error_count++;
        } else {
            quiz_summary += "\n" + getString(R.string.success_q3);
        }

        if (q4_ans != getString(R.string.a_bob_marley)) {
            quiz_summary += "\n" + getString(R.string.err_q4);
            error_count++;
        } else {
            quiz_summary += "\n" + getString(R.string.success_q4);
        }

        if (q5_ans != getString(R.string.a_fib)) {
            quiz_summary += "\n" + getString(R.string.err_q5);
            error_count++;
        } else {
            quiz_summary += "\n" + getString(R.string.success_q5);
        }

        int q6_answer = 0;
        try {
            q6_answer = Integer.parseInt(q6_ans);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), getString(R.string.err_msg_part2) + getString(R.string.q_arithemetic), Toast.LENGTH_LONG).show();
            return;
        }
        if (q6_answer != parseInt("55")) {
            quiz_summary += "\n" + getString(R.string.err_q6);
            error_count++;
        } else {
            quiz_summary += "\n" + getString(R.string.success_q6);
        }

        quiz_summary += getString(R.string.summary) + (6 - error_count);

        if (6 - error_count == 6) {
            quiz_summary += getString(R.string.congrats);
        }

        // Toast message
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, quiz_summary, duration);
        toast.show();

    }
}
