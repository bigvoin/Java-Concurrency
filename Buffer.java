import java.util.*;

public class Buffer							//Provides data and operations onto the fixed-length buffer
  {     									
  private LinkedList<Object> buf_list;
  private int buf_size;
  semaphore s = new semaphore(1);	// instance of the semaphore class with param 1

    /**
     * A constructor of Buffer class, creating a buffer with the size of n and buf_list is a LinkedList, where the data is stored
     * @param n the size of this buffer
     */
    public Buffer(int n)						//Buffer creation, with n indicating the maximum capacity
	    {
        buf_list = new LinkedList<Object>();
        buf_size = n;
      }

        /**
         * Method addQ, which adds the given param into the LinkedList called buf_list;
         * using the semaphore class methods P() and V(), enable only a single thread to enter this method
         * @param el an element
         */
        public void addQ(int el)
        {
            try {
              s.P();
              buf_list.add(el);
              s.V();
          } catch (Exception e) {
            e.printStackTrace();
          }

        }

        /**A method pop, which removes the last added element from the LinkedList called buf_list
         * using the semaphore class methods P() and V(), enable only a single thread to enter this method
         */
        public void pop()
        {
          try {
            s.P();
            buf_list.removeLast();
            s.V();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        /**
         * Method fullSize return the size of the buffer, declared by the user input
         * @return the size of the buffer in integer value
         */
        public int fullSize()
        {
          return buf_size;
        }

        /**
         * A method wich return the current size of the buffer 
         * @return current size in integer value
         */
        public int currentSize()
        {
          return buf_list.size();
        }

}	  
