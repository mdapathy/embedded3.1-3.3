package com.duminska.lab33;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText[] input = new EditText[5];
    Button okbutton;
    TextView res;
    ProgressDialog progressBar;
    Handler hdlr = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    @Override
    public void onClick(View v) {

        progressBar = new ProgressDialog(v.getContext());
        progressBar.setCancelable(true);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);

        res.setText("");
        final Integer[] inputinteger = new Integer[5];

        for (int i = 0; i < input.length; i++) {
            if (input[i].getText().toString().trim().length() == 0) {
                res.setText("Not all parameters are provided!");
                return;
            }
            try {
                inputinteger[i] = Integer.valueOf(input[i].getText().toString().trim());
            } catch (Exception e) {
                res.setText("Decrease the values");
                return;
            }
        }

        for (int i = 0; i < input.length - 1; i++) {
            if (inputinteger[i] > inputinteger[inputinteger.length - 1]) {
                res.setText("Will require negative values,\n decrease the parameters!");
                return;
            }

        }
        Thread th = new Thread(new Runnable() {
            public void run() {

                GeneticAlgo geneticAlgo = new GeneticAlgo(inputinteger[0], inputinteger[1], inputinteger[2], inputinteger[3], inputinteger[4]);
                String result = geneticAlgo.calculate();
                res.setText(result);

            }
        });
        Thread th2 = new Thread(new Runnable() {
            public void run() {
                hdlr.post(new Runnable() {
                    public void run() {
                        progressBar.cancel();

                    }
                });
            }
        });

        hdlr.postDelayed(th, 330);

        progressBar.show();

        hdlr.postDelayed(th2, 900);


    }

    public void setup() {
        input[0] = findViewById(R.id.editText4);
        input[1] = findViewById(R.id.editText5);
        input[2] = findViewById(R.id.editText6);
        input[3] = findViewById(R.id.editText7);
        input[4] = findViewById(R.id.editText8);
        res = findViewById(R.id.textView6);
        okbutton = findViewById(R.id.button);
        okbutton.setOnClickListener(this);
    }

}
