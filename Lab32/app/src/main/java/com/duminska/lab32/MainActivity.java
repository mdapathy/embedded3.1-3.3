package com.duminska.lab32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup learningRate, iterations;
    private RadioButton learningRateChoice, iterationsChoice;
    private TextView result;
    private EditText p1, p2, p3, p4;
    private Button okButton;
    ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>(4);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtons();
    }

    @Override
    public void onClick(View w) {
        if (w == okButton) {
            pairs = new ArrayList<>(4);
            result.setText("");
            learningRateChoice = findViewById(learningRate.getCheckedRadioButtonId());
            iterationsChoice = findViewById(iterations.getCheckedRadioButtonId());

            if (iterationsChoice == null || learningRateChoice == null) {
                result.setText("Mark all choices!");
                return;
            }


            String[] ps = new String[4];
            ps[0] = p1.getText().toString();
            ps[1] = p2.getText().toString();
            ps[2] = p3.getText().toString();
            ps[3] = p4.getText().toString();

            for (int i = 0; i < ps.length; i++) {


                if (!ps[i].matches("^[0-9]+,\\s*[0-9]+\\s*$")) {

                    result.setText("Something wrong with the input!");
                    return;
                }

                String arr[] = ps[i].split(",");


                int ii = Integer.valueOf(arr[0].trim());
                int jj = Integer.valueOf(arr[1].trim());


                pairs.add(new Pair<>(ii, jj));

            }

            Double r = Double.valueOf(learningRateChoice.getText().toString().trim());
            Integer it = Integer.valueOf(iterationsChoice.getText().toString());

            NeuralNetwork neuralNetwork = new NeuralNetwork(r, it, pairs);
            String s = neuralNetwork.calculate();
            result.setText(s);
        }
    }

    private void setButtons() {
        iterations = findViewById(R.id.radioGroup);
        learningRate = findViewById(R.id.radioGroup3);
        result = findViewById(R.id.results);
        p1 = findViewById(R.id.editText10);
        p2 = findViewById(R.id.editText11);
        p3 = findViewById(R.id.editText12);
        p4 = findViewById(R.id.editText13);
        okButton = findViewById(R.id.button);
        okButton.setOnClickListener(this);

    }


}
