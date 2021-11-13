package com.workouts.hackerearth;

import java.util.Scanner;

public class ASmallestNumber {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        //System.out.println("NO_OF_TC");
        int t = Integer.parseInt(s.nextLine());
        if(!(t>0 && t<11)){
            return;
        }
        long k[]=new long[t];

        for(int i=0;i<t;i++){
            k[i]=Long.parseLong(s.nextLine());
        }

        for(int i=0;i<t;i++){
            long kv=k[i];
            //System.out.println("DIGIT : "+kv);
            long min=minDigitNonZero(kv);
            long max=maxDigitNonZero(kv);
            for (long j=min;j<max;j++){
                if(!(j>0 && j<(5*(long)Math.pow(10,5)))){
                    break;
                }
                long prod=productOfDigits(j);
                long sum=SummationOfDigits(j);
                System.out.println("\nValue J : "+j);
                if(prod>=sum){
                    //System.out.println("PASS PROD > SUM : "+prod +">"+sum);
                    System.out.println(prod);
                    break;
                }//else System.out.println("PROD < SUM : "+prod +"<"+sum);
            }

        }


    }

    private static long SummationOfDigits(long value) {
        long sum=0;
        while (value>0){
            long temp=value%10;
            sum=sum+temp;
            value=value/10;
        }
        return sum;
    }

    private static long productOfDigits(long value) {
        long prod=1;
        while (value>0){
            long temp=value%10;
            prod=prod*temp;
            value=value/10;
        }
        return prod;
    }

    public static long minDigitNonZero(long kv){
        long minDigitNonZero=0;
        while(kv-1>-1){
            minDigitNonZero=minDigitNonZero+(long)Math.pow(10,kv-1);
            kv--;
        }
        return minDigitNonZero;
    }

    public static long maxDigitNonZero(long kv){
        long maxDigitNonZero=(long)Math.pow(10,kv);
        return --maxDigitNonZero;
    }
}
