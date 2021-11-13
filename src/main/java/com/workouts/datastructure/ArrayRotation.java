package com.workouts.datastructure;

import java.util.Arrays;

public class ArrayRotation {
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    public static void main(String[] arg) {
        System.out.println("Before : " + Arrays.toString(numbers));
        int numberOfTimesRotate = 5;
        while (0 < numberOfTimesRotate) {
            rotateRight();
            numberOfTimesRotate--;
        }
        System.out.println("After : " + Arrays.toString(numbers));
    }

    public static void rotateRight() {
        int count = numbers.length;
        int temp = numbers[0];
        for (int i = 0; i < count - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[count - 1] = temp;
    }
}	
