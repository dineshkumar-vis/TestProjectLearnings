package com.workouts.datastructure;

public class StringReverseWithSameSpace {
    public static void main(String[] args) {
        String orginal="hi i am dinesh kumar";
        char []asChars=orginal.replace(" ","").toCharArray();
        int last=asChars.length-1;
        for(int i=0;i<orginal.length();i++){
            if(orginal.charAt(i)==' '){
                System.out.print(" ");
            }else{
                System.out.print(asChars[last--]);
            }
        }
    }
}
