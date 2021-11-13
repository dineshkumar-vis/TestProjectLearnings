package com.workouts;



class TestClass{

    public static void main(String arg[]){
        System.out.println("Diensh");
    //<class-Name> objectName=new <class-NAme>;
    TestClass testObject=new TestClass();
    int result=testObject.add();
    System.out.println("INSIDE MAIN: "+result);
    }

    int add(){
        int a=5;
        int b=6;
        int c=a+b;
        System.out.println("IN SIDE M: "+c);
        return c;
    }

}

/*public class TestClass {
    public static void main(String arg[]){
        System.out.println("Haillll");
    }
}*/

