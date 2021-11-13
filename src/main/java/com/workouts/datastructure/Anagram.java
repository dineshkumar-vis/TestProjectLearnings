package com.workouts.datastructure;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] arg) {
        String word1 = "i love india y";
        String word2 = "peek1";
        int []numbers=new int[]{1,2,3,4,5,6,7,8,9};
        int search=0;
        System.out.println("is Number "+search+" found : "+binarySearch(numbers,search));
        //System.out.println("Sentence are anagram : " + isAnagramArray(word1, word2));
        //System.out.println("Transformed String : "+transform(word1));
        //System.out.println("Reverse string : "+reverseSort(word1));
    }

    public static boolean isAnagram(String a, String b) {
        String temp = b;
        if (a.length() == b.length()==!a.isEmpty()) {
            for (int i = 0; i < a.length(); i++) {
                int removeIndex = temp.indexOf(a.charAt(i));
                if (removeIndex > -1) {
                    temp = temp.substring(0, removeIndex) + temp.substring(removeIndex + 1);
                } else return false;

            }
        } else return false;
        return true;
    }

    public static boolean isAnagramArray(String a, String b) {
        if (a.length() == b.length()==!a.isEmpty()) {
            char[] aChars=a.toLowerCase().toCharArray();
            char[] bChars=b.toLowerCase().toCharArray();

            Arrays.sort(aChars);
            Arrays.sort(bChars);

            if(!Arrays.equals(aChars,bChars))
                return false;
        } else return false;
        return true;
    }

    public static String transform(String s)
    {
        StringBuilder sb=new StringBuilder(s);
        sb.setCharAt(0,Character.toUpperCase(sb.charAt(0)));
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)==' '){
                sb.setCharAt(i+1,Character.toUpperCase(sb.charAt(i+1)));
            }
        }
        return sb.toString();
    }

    public static String reverseSort(String str)
    {
        StringBuilder br=new StringBuilder();
        char []letters=str.toCharArray();
        Arrays.sort(letters);
        for (char c:letters){
            br.append(c);
        }
        return br.toString();
    }
    public static boolean binarySearch(int numbers[],int searchNumber){
        int low=0,high=numbers.length;
        int mid;
        while (low<high){
            mid=((high-low)/2)+low;;
            if(numbers[mid]==searchNumber)
                return true;
            else if(numbers[mid]<searchNumber)
                low=mid+1;
            else if(numbers[mid]>searchNumber)
                high=mid-1;
        }
        return false;
    }
}
