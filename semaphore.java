import java.util.*;
public class semaphore
  {
    
   //This is an example class for using a primitive synchronization (semaphore, lock). Please note that you
   //can ONLY put the synchronization keyword within these type of classes, and nowhere else within the program.

   private int count=0;

    /**
     * A consturctor of the semaphore class, which takes a single param c, representing the counter
     * @param c the counter
     */
    public semaphore(int c)
    {
        count = c;
    }

    /**
     * Synchronized method P() enable a single thread to enter and if the counter is a negative number, executes the method wait(),
     * causing the thread to wait until is notified
     */
    public synchronized void P()
    {
        count = count - 1;
        if(count < 0)
        {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

    /**
     * A synchronized method V(), enable only single thread to enter, notifies the threads
     */
    public synchronized void V()
    {
        count = count +1;
        if(count<= 0)
        {
            notify();
        }
    }

  }

