import java.util.*;
import java.util.concurrent.Semaphore;

class webserver extends Thread
  {										//Web server removes elements from the buffer
    private int serverId;
    private int elements;
    private int amountDone=0;
    private Buffer buf;
    private semaphore sem;

    /**
     * A constructor for class webserver containg id elemenets buffer and semaphore
     * @param serverId  the id of the current server
     * @param elements  how much elements the server has
     * @param b         an instance of the buffer class
     * @param s         an instance of the semaphore class
     */
    public webserver(int serverId, int elements,Buffer b, semaphore s)			
    {
      this.serverId = serverId;
      this.elements = elements;
      buf = b;
      sem = s;
    }

    /**
     * get method
     * @return the id of the server
     */
    public int getID()
    {
      return serverId;
    }

    /**
     * get Method 
     * @return the elements of the server
     */
    public int getElements()
    {
      return elements;
    }

    /**
     * Get method
     * @return how much elements the server has removed
     */
    public int getAmountDone()
    {
      return amountDone;
    }

    /**
     * A method goes through every element of the server checking if the buffer is empty,
     * if not remove the lasted added element of the buffer
     * using the semaphore methods V() and P() to synchronize the threads, enable only a single one to enter
     * sleeping the thread on every first and second element to be able to have empty buffer
     * decrementing each time the if and else condition are completed and increasing the element removed counter by 1
     */
    public void run()
    {
      while(elements>0)
      {
        
        if(elements == 3)
            try {
              this.sleep(10);
            } catch (Exception e) {
            }
            sem.P();
        if(buf.currentSize() == 0)
        {
            
            System.out.println("Buffer Empty: Server " + serverId + " is now asleep.");

        }

        else
        {
              
              buf.pop();
              System.out.println("Server " + serverId + " removes an Element " + buf.currentSize() + "/" + buf.fullSize());
              amountDone++;
              elements--;
            
        }
        sem.V();
      }
    }
  
   
  }   