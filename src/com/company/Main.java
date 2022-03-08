package com.company;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;



public class Main {



    public static void main(String[] args) {
        Random rand = new Random();


        //Integer array for domains and objects
        int[] integerArray = {3, 4, 5, 6, 7};


        //Allows us to access those values within the array
        int nRan = rand.nextInt(5);

        //This is the number of domains
        int N = integerArray[nRan];


        //Prints the number of domains/rows
        System.out.println("Domain Count(# of rows): " + N);

        //Allows us to access those values within the array
        int mRan = rand.nextInt(5);


        //This is the number of objects
        int M = integerArray[mRan];


        //Gets the number of objects
        System.out.println("Object Count(# of columns): " + M);


        //Creates the 2d array
        //[Rows] [Columns]
        //There needs to be mRan + nRan of columns because it has to include the objects and the domains
        //This only creates the size of the matrix. We might have to add an extra column and row to write the
        //actual names
        String[][] accessMatrix = new String[N][M + N];




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
        for(int row = 0; row < accessMatrix.length; row++){
            System.out.print("D" + (row /*+ 1*/) + "   ");

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
                    System.out.print(accessMatrix[row][col] + "   ");

                }
            }
            System.out.println();
        }

        System.out.println(" ");
        System.out.println(" ");



        //Creates the thread to access different objects. This is based on the number of domains we have
        for (int domainThreadCount = 0; domainThreadCount<N; domainThreadCount++){
            AccessMatrix threadObject = new AccessMatrix(domainThreadCount, accessMatrix, N, M);
            threadObject.start();
        }

        //-------------------------------------------------Task 2-----------------------------------------------------
        //Integer array for the number of Domains
        //int[]  =

        //populating the Access Control List
        //node class to represent the objects
        class Node {
            String domain;
            String accessRight;
        }
        LinkedList<ArrayList> accessList = new LinkedList<>();

        System.out.println();

        // populating the objects of the Access List
        for (int i = 0 ; i < M; i++){
            ArrayList <String> operations = new ArrayList<String>();
            for (int j = 0; j < N; j++){
                //String op = objectArray[rand.nextInt(4)];
                operations.add("D" + (j+1) + ":" + objectArray[rand.nextInt(4)]);
                System.out.print(operations.get(j) + " ");
            }
            accessList.add(i, operations);
        }

        // populating the domain objects of the Access List
       for (int i = M; i < M+N; i++){
            ArrayList <String> switches = new ArrayList<String>();
            for (int j = 0; j < N; j++){
                //String op = objectArray[rand.nextInt(4)];
                switches.add("D" + (j+1) + ":" + domainArray[rand.nextInt(2)]);
                //System.out.print(switches.get(j) + " ");
            }
            accessList.add(i, switches);
        }


        /*System.out.println();
        for (int i = 0; i < accessList.size(); i++){
            for (int j = 0

        }*/





        //-------------------------------------------------Task 3-----------------------------------------------------















    }
}
