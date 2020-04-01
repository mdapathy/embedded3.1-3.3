package com.duminska.lab32;

import android.util.Pair;

import java.util.ArrayList;


public class NeuralNetwork {

    public static double learningRate;
    public static double iterations;
    public static ArrayList<Pair<Integer, Integer>> points = new ArrayList<>();
    public static int p;
    public static double wres1, wres2;

    NeuralNetwork(double l, int i, ArrayList<Pair<Integer, Integer>> pairs) {
        p = pairs.size();
        points = pairs;
        learningRate = l;
        iterations = i;

    }

    public String calculate() {
        double w1 = 0, w2 = 0;
        int i = 0;
        for (; i < iterations; i++) {
            for (int point = 0; point < points.size(); point++) {
                double f = w1 * points.get(point).first + w2 * points.get(point).second;
                double d = p - f;
                w1 = w1 + d * learningRate * points.get(point).first;
                w2 = w2 + d * learningRate * points.get(point).second;

            }

        }

        wres1 = w1;
        wres2 = w2;

        return "W1:" + wres1 + " \n W2: " + wres2 + "\ni:" + i;
    }

}
