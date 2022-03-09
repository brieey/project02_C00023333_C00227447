package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;

// Begin code changes by Jahzah Jenkins
public class AccessListThread extends Thread{
    int N;
    int M;
    LinkedList accessList;
    // constructor to get value of M and N
    AccessListThread(int objects, int domains, LinkedList acl){
        this.M = objects;
        this.N = domains;
        this.accessList = acl;
    }


    Random randomInt = new Random();
    int X = randomInt.nextInt(0,M+N) + 1;
    public void run() {
        if (X < M || X == M){
            int operation = randomInt.nextInt(0,2);
            if (operation == 0){
                new ReadObject(M-1);
            }
            else {
                new WriteObject(M);
            }
        }

    }

    // arbitrator function
    public boolean Permissions(AccessListThread thread, int objectOrDomain) {
        //read or write for Object
        if (objectOrDomain == 0){
            ArrayList elementOfaccessList = (ArrayList) accessList.get(objectOrDomain);
            /*if(elementOfaccessList.contains){

            }*/
        }
        if (objectOrDomain <= M) {
            if (accessList.get(objectOrDomain - 1).) ; {

            }
        }
    }



}













// End code changes by Jahzah Jenkins