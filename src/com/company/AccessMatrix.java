package com.company;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;



public class AccessMatrix extends Thread {


    private int domainThreadCount;
    private String[][] accessMatrix;
    private int N;
    private int M;



    ReentrantLock lock = new ReentrantLock();
    Semaphore sem = new Semaphore(1);



    public AccessMatrix(int domainThreadCount, String[][] accessMatrix, int N, int M){
        this.domainThreadCount = domainThreadCount;
        this.accessMatrix = accessMatrix;
        this.N = N; //Domains or Rows
        this.M = M; // Objects or Columns
    }



    //Tells if a thread has access or not
    public void arbFunction(String userRight, String[][] accessMatrix, int domainThreadCount, int i){
        int yieldProcess [] = {3, 4, 5, 6, 7};

        //Must check if objects and domains have access seperately



        //If access is allowed, try to claim the semaphore
        if(userRight != "-" || userRight != "deny"){
            try{
                sem.acquire();

                //Checks to see which right it is and performs that operation
                if(userRight == "R"){
                    System.out.println("Attempting to read resource");
                    lock.lock();
                    try{
                        System.out.println();
                    } finally{
                        lock.unlock();
                    }

                } else if (userRight == "W") {

                } else {

                }


            } catch(InterruptedException E){
                System.out.println(E);
            }

            sem.release();

        } else {
            //Randomly gets a number from the yieldProcess array
            Random ran = new Random();
            int yRan = ran.nextInt(5);
            int yieldTime = yieldProcess[yRan];
            //This is how many times it will yield
            //We will print to the screen how many times it yielded
            System.out.println("Yielding " + yieldTime + " times.");
            for (int j = 0; j<yieldTime; j++){
                Thread.yield();
            }
        }




        /*if(accessMatrix[domainThreadCount][i] == "R"){
            //Lock it and then try to do what it needs to do
            //Once it's finish, finally unlock it
            //Reads something. In other words, print something to the screen.
        } else if(){

        } else if(){

        } else {

        }*/

    }







    public void run(){
        //Generate a random number between 0 and the length of the row for the # of columns
        Random rand = new Random();

        //Gets a number to pick a random object.Corresponds to a column in the matrix
        int randomObjNum = rand.nextInt(M + N);

        if(randomObjNum <= M){
            //Generate another number to read/write from object
        } else {
            //Attempts to switch the domains (M+N) - x
        }







        //Each thread will generate a random # depending on the number of requests
        //Random rand = new Random();
        int ranRequests = 1 + rand.nextInt(5);




        //Maybe do the while loop based off of the request??
        while(true){
            //Allows the domain to access a random object
            String userRight = accessMatrix[domainThreadCount][randomObjNum]; //Can be R,W,R/W,-,allow, or deny


        }



        //The thread will attempt to access a different object
        //Access a random object by doing a for loop and it should be the length minus the number of domains. It should
        // then have a random number to access some random object. The domain(or row) should be the domain thread count

        //Doing accessMatrix[domainThreadCount].length - N will allow us to access that row/domain and we have to minus
        //N because we want just the objects

        //i would be considered the object. No two threads should be allowed to access the

        /*for(int i = 0; i < accessMatrix[domainThreadCount].length - N; i++){
            String userRight = accessMatrix[domainThreadCount][i]; //R, W, R/W, or -
            //Calls the arbitrator function to check if this domain has rights to this particular object
            //Sends DTC and i because we want to check it at that particular row and column
            arbFunction(userRight, accessMatrix, domainThreadCount, i);



        }*/




    }









}
