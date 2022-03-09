package com.company;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;



public class Main {


    public static void main(String[] args) {
        // Begin code changes by Brianna N. Jordan.
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
        for (int domainThreadCount = 1; domainThreadCount <= N; domainThreadCount++){
            AccessMatrix threadObject = new AccessMatrix(domainThreadCount, accessMatrix);
            threadObject.start();
        }

        // End code changes by Brianna Jordan.



        //-------------------------------------------------Task 2-----------------------------------------------------
        // Begin Code Changes by Jahzah Jenkins
        // Linked List that stores each object as an Array List
        LinkedList<ArrayList> accessList = new LinkedList<>();


        // populating the objects of the Linked List accessList
        for (int i = 0 ; i < M; i++){
            ArrayList <String> operations = new ArrayList<String>();
            for (int j = 0; j < N; j++){
                //String op = objectArray[rand.nextInt(4)];
                operations.add("D" + (j+1) + ":" + objectArray[rand.nextInt(4)]);
                //System.out.print(operations.get(j) + " ");
            }
            accessList.add(i, operations);
        }

        // populating the domain objects of  accessList
       for (int i = M; i < M+N; i++){
            ArrayList <String> switches = new ArrayList<String>();
            for (int j = 0; j < N; j++){
                //String op = objectArray[rand.nextInt(4)];
                switches.add("D" + (j+1) + ":" + domainArray[rand.nextInt(2)]);
                //System.out.print(switches.get(j) + " ");
            }
            accessList.add(i, switches);
        }


        System.out.println();

       // Printing the elements of accessList which has the operations that can be performed on object legal domain switching
        for (int i = 0; i < accessList.size(); i++){
            if (i < M) {
                System.out.println("F" + (i+1) + " --> " + accessList.get(i));
            }
            else {
                System.out.println("D" + (-(M-(i+1))) + " --> " + accessList.get(i));
            }
        }
        for (int i = 0; i < accessList.size(); i++){
            if (i < M) {
                System.out.println("F" + i + " --> " + accessList.get(i));
            }
            else {
                System.out.println("D" + i + " --> " + accessList.get(i));
            }
        }

        // Creating threads  to access objects and switch domains using the Access List's entries
        for (int i = 0; i < N; i++) {
            AccessListThread thread = new AccessListThread(M,N,accessList);
            thread.setName("Thread: " + String.valueOf(i) + "(D" + (i + 1) + ")");
            System.out.println(thread.getName()); //***TAKE OUT***
        }



        // End code changes by Jahzah Jenkins





        //-------------------------------------------------Task 3-----------------------------------------------------
        // Begin code changes by Brianna N. Jordan.
        // Linked List that makes it domain based
        LinkedList<ArrayList> capabilityList = new LinkedList<>();
        // End code changes by Brianna N. Jordan.


















    }
}
