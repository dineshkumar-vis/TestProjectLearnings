package com.workouts.datastructure;

import java.util.Arrays;

public class ArrayReverse {
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    public static void main(String[] arg) {
        System.out.println("Before : " + Arrays.toString(numbers));
        for (int i = 0; i < (numbers.length / 2) - 1; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
        System.out.println("After : " + Arrays.toString(numbers));
    }
}
