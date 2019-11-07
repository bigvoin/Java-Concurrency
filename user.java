import java.util.*;
import java.util.concurrent.Semaphore;

class user extends Thread
   {											
      private int userId;
      private int elements;
      private int amountDone=0;
      private  Buffer buf;
      private  semaphore sem;

      /**
       * A constructor of class user 
       * @param userId an id of the user
       * @param ele the elements of the user
       * @param b an instance of the buffer class
       * @param s an instance of the semaphore class 
       */
     public user(int userId,int ele,Buffer b, semaphore s)							//Created user will add a certain number of elements to the buffer.
     {
      this.userId = userId;
      elements = ele;
      buf = b;
      sem = s;
     }

     /**
      * get method of the use id
      * @return the current user id
      */
     public int getID()
     {
       return userId;
     }

     /**
      * a get AmoundDone method
      * @return the elements that this user has produced
      */
     public int getAmountDone()
     {
       return amountDone;
     }

     /**
      * void method which set the current elements of the user with the param
      */
     public void setElements(int e)
     {
       elements=elements+e;
     }

     /**
      * getElements
      * @return the elements of the user
      */
     public int getElements()
     {
       return elements;
     }

     /**
      * A method run which goes through every element and checks if the current bufer size is more than the buffer size
      stopping the user from adding more elements inside
      using sleep if the element is 5 to be able to full the buffer
      the semaphore methods V() and P() are used to synchonize the threads 
      after the if and else condition the elements decrement by one and the counter for the amount of elements increments by one
      */
     public void run()
     {   										            
        while (elements > 0)
           {
            
            if(elements == 5 || elements == 6)
            try {
              this.sleep(10);
            } catch (Exception e) {
            }
            sem.P();
            if(buf.currentSize() >= buf.fullSize())
              {
              System.out.println("Buffer Full: User " + userId + " is now asleep.");
              }	

              else
              {
                
                buf.addQ(1);
                System.out.println("User "+userId+" adds element "+buf.currentSize()+"/"+buf.fullSize());
                amountDone++;
                elements--;
              } 	
              sem.V();
            	
        }

     }
       
   }   