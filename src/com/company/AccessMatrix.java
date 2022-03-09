package com.company;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


// Begin code changes by Brianna Jordan.
public class AccessMatrix extends Thread {


    private int domainThreadCount;
    private String[][] accessMatrix;


    Semaphore sem = new Semaphore(1);
    ReentrantLock lock = new ReentrantLock();



    public AccessMatrix(int domainThreadCount, String[][] accessMatrix){
        this.domainThreadCount = domainThreadCount;
        this.accessMatrix = accessMatrix;

    }

    // Examines users rights
    public void arbFunction(int domainThreadCount, String randomObject, int ranObjColumnNum){
        // Character array to read from
        char[] charArrayR = {'A', 'B', 'C', 'D', 'E'};
        // Character array to get things from to add to the other array
        char[] charArrayW = {'F', 'G', 'H', 'I', 'J'};


        int yieldProcess [] = {3, 4, 5, 6, 7};

        // Take the first character of a string to see if it's a domain or object
        if(randomObject.charAt(0) == 'F'){
            //Checks the domain at that particular colum and see if it's not null or empty
            String accessRight = accessMatrix[domainThreadCount][ranObjColumnNum]; //R,W,R/W,-

            // Checks to see if access is allowed
            // If access is not allowed
            if(accessRight == "-"){
                System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")]" + " " + "Operation failed, permission denied." );
                // No access so we yield and keep going
                Random rand = new Random();
                int yRan = rand.nextInt(5);
                int yieldTime = yieldProcess[yRan];
                System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")]" + "Yielding " + yieldTime + " times.");
                for (int j = 0; j<yieldTime; j++){
                    Thread.yield();
                }
            } else { // Executes if access is allowed
                // Access is allowed so we try claim the semaphore & then yield
                try{
                    sem.acquire();

                    //Checks to see which right it is and performs that operation
                    if(accessRight == "R"){
                        //
                        System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")]" + " " +
                                "Attempting to read resource " + randomObject);
                        lock.lock();
                        try{
                            System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")]" + "Resource " + randomObject + " contains " + new String(charArrayR));
                        } finally{
                            lock.unlock();
                        }

                        Random rand = new Random();
                        int yRan = rand.nextInt(5);
                        int yieldTime = yieldProcess[yRan];
                        System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")] " + " Yielding " + yieldTime + " times.");
                        for (int j = 0; j<yieldTime; j++){
                            Thread.yield();
                        }

                    } else if (accessRight == "W") {
                        System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")] " +
                                " Attempting to write to resource " + randomObject);
                        lock.lock();
                        try{
                            //Pick a random letter from the array.
                            Random rand = new Random();
                            int ranNum = rand.nextInt(5);
                            int letter = charArrayW[ranNum];
                            System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")] " + "Writing " + letter + " to resource " + randomObject);
                        } finally{
                            lock.unlock();
                        }

                        Random rand = new Random();
                        int yRan = rand.nextInt(5);
                        int yieldTime = yieldProcess[yRan];
                        System.out.println("[Thread: " + domainThreadCount + "(D" + domainThreadCount + ")] " + " Yielding " + yieldTime + " times.");
                        for (int j = 0; j<yieldTime; j++){
                            Thread.yield();
                        }

                    } else {
                    }

                } catch(InterruptedException E){
                    System.out.println(E);
                }

                sem.release();

            }



        } else { // Otherwise, do this if it's a domain
            //[Thread: 0(D1)] Attemping to switch from D1 to D5.
            System.out.println("[Thread:" + " " + domainThreadCount + "(" + randomObject + ")]" + " " + "Attempting to switch from " + "D" + domainThreadCount
                    + " to " + randomObject);

            if(accessMatrix[domainThreadCount][ranObjColumnNum] == "allow"){
                System.out.println("[Thread:" + " " + domainThreadCount + "(" + randomObject + ")] " + " Switched to " + randomObject);
            } else {
                System.out.println("[Thread:" + " " + domainThreadCount + "(" + randomObject + ")]" + " "+ "Operation failed, permission denied.");
            }
        }

    }







    public void run(){
        //Allows the threads to only execute at a min of 5 times
        for(int i = 0; i < 5; i++) {
            Random rand = new Random();
            // Gives me numbers between 1 and 6
            int ranObjColumnNum = rand.nextInt(accessMatrix[0].length - 1) + 1;
            String randomObject = accessMatrix[0][ranObjColumnNum]; //Ex f1
            //The arbitrator function is called to check permissions
            arbFunction(domainThreadCount, randomObject, ranObjColumnNum);


        }

    }






}

// End code changes by Brianna Jordan.
