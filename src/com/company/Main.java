package com.company;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        //dynamically generate n(domains) between 3 and 7
        Random nRan = new Random(0,5);
        System.out.println("This is the domain number: " + nRan);

        //dynamically generate m(objects) between 3 and 7
        Random mRan = new Random(6,10);
        System.out.println("This is the object number: " + mRan);

    }
}
