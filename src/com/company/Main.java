package com.company;
import java.util.Random;



public class Main {



    public static void main(String[] args) {
        Random rand = new Random();


        //Integer array for domains and objects
        int[] integerArray = {3, 4, 5, 6, 7};


        //Allows us to access those values within the array
        int nRan = rand.nextInt(5);


        //Gets the number of domains
        System.out.println("Domain Count: " + integerArray[nRan]);


        int mRan = rand.nextInt(5);


        //Gets the number of objects
        System.out.println("Object Count: " + integerArray[mRan]);


        //Creates the 2d array
        //[Rows] [Columns]
        //There needs to be mRan + nRan of columns because it has to include the objects and the domains
        //This only creates the size of the matrix. We might have to add an extra column and row to write the
        //actual names
        String[][] accessMatrix = new String[nRan][mRan+nRan];


        //This array with the object operations/rights
        //Can either read, write, read and write, or have no access at all
        String[] objectArray = {"R", "W", "R/W",""};


        //Array with the domain operations/rights
        //Can either switch or not
        String[] domainArray = {"allow",""};













    }
}
