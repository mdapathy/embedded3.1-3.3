package com.duminska.lab31;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnClick;
    private EditText number;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.editText3);
        res = findViewById(R.id.textView4);

        btnClick = findViewById(R.id.button);
        btnClick.setOnClickListener(this);


    }

    public void onClick(View v) {

        ((TextView) findViewById(R.id.textView4)).setText(" ");
        if (v == btnClick && number.getText().toString().length() > 0) {
            long value;
            try {
                value = Long.parseLong(number.getText().toString());
            } catch (Exception e) {
                res.setText("Your number seems wrong!");
                findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                return;
            }
            Factorization factor = new Factorization(value);


            String calced = factor.calculate();
            res.setText(calced);


        } else if (v == btnClick) {
            res.setText("You didn't provided the number!");
        }


    }
}
