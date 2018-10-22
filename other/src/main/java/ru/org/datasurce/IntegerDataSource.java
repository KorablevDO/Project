package ru.org.datasurce;

import java.util.Random;

public class IntegerDataSource {
    private final Random random = new Random();
    private static IntegerDataSource integerDataSource;

    private IntegerDataSource(){

    }

    public static IntegerDataSource get(){
        if(integerDataSource == null){
            integerDataSource = new IntegerDataSource();
        }

        return integerDataSource;
    }

    public int[] getArrayInt(int size){
        int[] arrInt = new int[size];
        for(int i = 0; i < arrInt.length - 1; i++){
            arrInt[i] = this.random.nextInt(size);
        }

        return arrInt;
    }
}
