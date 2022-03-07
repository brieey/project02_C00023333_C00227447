package com.company;
import java.util.Random;



public class Main {



    public static void main(String[] args) {
        Random rand = new Random();


        //Integer array for domains and objects
        int[] integerArray = {3, 4, 5, 6, 7};


        //Allows us to access those values within the array
        int nRan = rand.nextInt(5);

        //THis is the number of domains
        int N = integerArray[nRan];


        //Prints the number of domains/rows
        System.out.println("Domain Count(# of rows): " + N);

        //Allows us to access those values within the array
        int mRan = rand.nextInt(5);


        //THis is the number of objects
        int M = integerArray[mRan];


        //Gets the number of objects
        System.out.println("Object Count(# of columns): " + M);


        //Creates the 2d array
        //[Rows] [Columns]
        //There needs to be mRan + nRan of columns because it has to include the objects and the domains
        //This only creates the size of the matrix. We might have to add an extra column and row to write the
        //actual names
        String[][] accessMatrix = new String[N][M + N];
        //String[][] accessMatrix = new String[3][4];



        //This array with the object operations/rights
        //Can either read, write, read and write, or have no access at all
        String[] objectArray = {"R", "W", "R/W","-"};


        //Array with the domain operations/rights
        //Can either switch or not
        String[] domainArray = {"allow","deny"};



        System.out.println(" ");
        System.out.println("Domain/Object");
        System.out.println(" ");


        //The matrix gets populated with the rights from the object array and the domain array
        for(int row = 1; row < accessMatrix.length; row++){
            System.out.print("D" + row + "   ");

            //Only fills the object column
            for(int col = 0; col < accessMatrix[row].length; col++){

                //Adds the objects to the matrix first
                if(col < accessMatrix[row].length - N ){
                    int objRan = rand.nextInt(4);
                    String randomOperation = objectArray[objRan];
                    accessMatrix[row][col] = randomOperation;
                    System.out.print(accessMatrix[row][col] + "   ");

                } else {    //Otherwise, it adds the domains
                    int domainRandom = rand.nextInt(2);
                    String randomRight = domainArray[domainRandom];
                    accessMatrix[row][col] = randomRight;
                    //System.out.print(accessMatrix[col] + "   ");
                    System.out.print(accessMatrix[row][col] + "   ");

                }
            }
            System.out.println();
        }

        System.out.println(" ");
        System.out.println("This is the first element at 0,0: " + accessMatrix[0][0]);















    }
}
