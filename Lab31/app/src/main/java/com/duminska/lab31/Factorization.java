package com.duminska.lab31;

public class Factorization {

    public long n;
    public long xres;
    public long yres;

    Factorization(long N) {
        n = N;
    }

    public String calculate() {
        long startTime = System.currentTimeMillis();

        int i = 1;
        long x = (long) Math.sqrt(n);
        long temp;
        for (; i < Integer.MAX_VALUE / 600; i++) {

            temp = (long) Math.pow(x + i, 2) - n;

            if ((int) Math.sqrt(temp) == Math.sqrt(temp)) {
                this.xres = x + i;
                this.yres = (long) Math.sqrt(temp);
                long difference = System.currentTimeMillis() - startTime;

                return (int) ((x + i) - (int) Math.sqrt(temp)) + " * " + (int) ((x + i) + (int) Math.sqrt(temp)) + "  \nTime:" + (long) difference + "ms \nIterations: " + i;// = " + (int)((x + i) * (x + i) - Math.pow((int) Math.sqrt(temp), 2));
            }


        }

        return "Something went wrong, too many iterations";

    }

}
