import java.util.*;

public class startServer{
    /**Declaring variables for buffer Size, number of users, number of servers and number of elements 
     * creating instance of a buffer class and a semaphore class
    */
        private static  int bufferNum;
        private static int userNum;
        private static int serverNum;
        private static int elementNum;

        private Buffer b; 
        private static Scanner scann = new Scanner(System.in);
        private semaphore s = new semaphore(1);

        /**Constructor of the class startServer, where all the main action is done */
    public startServer()
    {
        /**Instance of the user and webeserver classes declared with an array of users/webservers, with the size of the number of users/webeservers */
        user[] u;
        webserver[] w;
        b = new Buffer(bufferNum);
        u = new user[userNum];
        w = new webserver[serverNum];

        long startTime = System.currentTimeMillis(); // declaring the start time of the program in long variable startTime
        
        for(int i=0;i<userNum;i++)
        {
            u[i]= new user(i,elementNum/userNum,b,s);
        }

        for(int a=0;a<elementNum%userNum;a++)
            {
                u[a].setElements(1);
            } 
        
        /**2 for loops generating all the users and webserves and because they are threads the loops starts each thread(user/webserver) */
        for(int i=0 ; i<userNum ; i++)
        {               
            u[i].start();
        }

        for(int j=0 ; j<serverNum ; j++)
        {
            w[j]= new webserver(j,elementNum/serverNum,b,s);                   
            w[j].start();
        }

        /**A loop joining all the webserver threads, using try and catch to catch the thrown exeptions */
        for(int k=0 ; k<userNum ; k++)
            {
                try {
                w[k].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /**Loops to print the final created/consumed elements from each user/webserver */
        for(int i=0; i<userNum;i++)
        {
            System.out.println("User "+u[i].getID()+" created a total of "+u[i].getAmountDone()+" elements");
        }
        for(int i=0;i<serverNum;i++)
        {
            System.out.println("Consumer "+w[i].getID()+" consumed a total of "+w[i].getAmountDone()+" elements");
        }

        /**Printing the current size of the buffer 
         * and checking if the threads for user or webserver are still running with for loops
         */
        System.out.println(".....................");
        System.out.println("Buffer has "+b.currentSize()+" elements remaining");
        System.out.println(".....................");
        for(int i=0;i<serverNum;i++)
        {
            System.out.println("Server thread "+w[i].getID()+" is alive: "+w[i].isAlive());
        }

        for(int i=0;i<userNum;i++)
        {
            System.out.println("User thread "+u[i].getID()+" is alive: "+u[i].isAlive());
        }
            
            
            /**Declaring the endTime, which represents the time, which the program took and printing the final time in milliseconds */
            long endTime = System.currentTimeMillis();
            System.out.println("Program took " + (endTime - startTime) + " milliseconds to complete");
    }


        
    

    public static void main(String[] args){

        System.out.println("Enter buffer capacity");
        bufferNum = scann.nextInt();
        System.out.println("Enter nuber of users");
        userNum = scann.nextInt();
        System.out.println("Enter number of servers");
        serverNum = scann.nextInt();
        System.out.println("Enter nuber of total elements");
        elementNum = scann.nextInt();
        startServer ser = new startServer();
            
               
        


    
        
        
           
        

    }
    
}