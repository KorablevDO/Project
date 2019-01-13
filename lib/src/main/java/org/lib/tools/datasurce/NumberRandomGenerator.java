package org.lib.tools.datasurce;

import java.util.Random;

public class NumberRandomGenerator {
    private static final Random random = new Random();
    private static final int defaultMin = 0;
    private static final int defaultMax = 100;

    public static int[] getIntArrayNumbers(int lenght) {
        return getIntArrayNumbers(lenght, defaultMin, defaultMax);
    }

    public static int[] getIntArrayNumbers(int lenght, int min, int max){
        int[] arrInt = new int[lenght];
        for(int i = 0; i < arrInt.length - 1; i++){
            arrInt[i] = getIntNumber(min, max);
        }

        return arrInt;
    }

    public static int getIntNumber(int min, int max){
        return random.nextInt(max) + min;
    }

    public static long getLongNumber(){
        return 0;
    }

    public static double getDoubleNumber(){
        return 0;
    }

    public static float getFloatNumber(){
        return 0;
    }
}
