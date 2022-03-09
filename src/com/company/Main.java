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
        // Added one so that I can have an extra row to add the column names
        String[][] accessMatrix = new String[N + 1][(N+M) + 1];




        //This array with the object operations/rights
        String[] objectArray = {"R", "W", "R/W","-"};


        //Array with the domain operations/rights
        //allow = switch , deny = no switch
        String[] domainArray = {"allow","deny"};



        System.out.println(" ");
        System.out.println(" ");


        // While 0 < 4. This will allow it to go row by row
        for(int row = 0; row < accessMatrix.length; row++){
            //If the row is equal to 0 then we should populate the first row with the column names
            if(row == 0){
                // Populates/loops the columns with the names
                // 0 < 7
                // Going from 0 to 6 ONLY
                for(int colNum = 0; colNum < accessMatrix[0].length; colNum++){
                    if(colNum == 0){
                        accessMatrix[0][0] = "D/Obj";
                        System.out.printf("%5s", accessMatrix[0][0] + "   ");
                    } else if (colNum <= M) {
                        //Assigns the column for the number of objects
                        accessMatrix[0][colNum] = "F" + colNum;
                        System.out.printf("%5s", accessMatrix[0][colNum] + "   ");
                    } else {
                        //Assigns the column for the number of domains
                        accessMatrix[0][colNum] = "D" + (colNum - N);
                        System.out.printf("%5s", accessMatrix[0][colNum] + "   ");
                    }
                }
            } else {
                accessMatrix[row][0] = "D" + row;
                System.out.printf("%5s","D" + row + "   ");
                // Populates/loops the columns with access rights
                // 1 < 7
                for(int colNum = 1; colNum < accessMatrix[0].length; colNum++){
                    if(colNum <= M){
                        int objRan = rand.nextInt(4);
                        String randomOperation = objectArray[objRan];
                        accessMatrix[row][colNum] = randomOperation;
                        System.out.printf("%5s",accessMatrix[row][colNum] + "   ");
                    } else {
                        int domainRandom = rand.nextInt(2);
                        String randomRight = domainArray[domainRandom];
                        accessMatrix[row][colNum] = randomRight;
                        System.out.printf("%5s", accessMatrix[row][colNum] + "   ");

                    }

                }


            }

            //Starts a new row on another line
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
