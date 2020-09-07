package com.atguigu.chapter01;

public class T1 {
    public static void main(String[] args) {


//        s:     for(int i = 0 ; i < 10 ; i++){
//            if(i == 5){
//                i = 11;
//                continue s;
//            }
//            System.out.println("this is "+i);
//        }


        try {
            for (int i = 0; i < 10; i++) {
                if(i == 5){
                    throw new RuntimeException();
                }
                System.out.println(i);
            }
        }catch (Exception e){}

        System.out.println("it is out");

    }
}
