# Java Program for Concurrency Example
In this program X users will add elements onto a single buffer object, which are removed by Y
webservers. The number of users, webservers and elements are all specified by user input, and
resembles the following:
..........................................................
Enter buffer capacity
20
Enter number of users
10
Enter number of servers
10
Enter number of total elements
100
.............................................................
The program must also continue to operate even if the buffer is empty or full, with the user or
webserver waiting until the buffer is again available. An example of this will resemble the following
when the buffer is empty:
Serv 6 removed element 2/20
Serv 3 removed element 1/20
Serv 2 removed element 0/20
Buffer empty – web server wait
Buffer empty – web server wait
User 2 added an element 1/20
User 6 added an element 2/20
And will resemble the following when the buffer is full:
User 9 added an element 19/20
User 5 added an element 20/20
Buffer full – User now sleeping
Serv 1 removed element 19/20
User 8 added an element 20/20
Buffer full – User now sleeping
Buffer full – User now sleeping
Serv 2 removed element 19/20
Once all users and server have completed processing all elements, the program should output
something resembling the following:
-----------------------
User 7 created a total of 10 elements
User 5 created a total of 10 elements
User 0 created a total of 10 elements
User 6 created a total of 10 elements
User 8 created a total of 10 elements
User 1 created a total of 10 elements
User 2 created a total of 10 elements
User 3 created a total of 10 elements
User 9 created a total of 10 elements
User 4 created a total of 10 elements
Consumer 9 consumed a total of 10 elements
Consumer 1 consumed a total of 10 elements
Consumer 3 consumed a total of 10 elements
Consumer 6 consumed a total of 10 elements
Consumer 4 consumed a total of 10 elements
Consumer 0 consumed a total of 10 elements
Consumer 7 consumed a total of 10 elements
Consumer 2 consumed a total of 10 elements
Consumer 5 consumed a total of 10 elements
Consumer 8 consumed a total of 10 elements
As well as check that the buffer is empty, and that all created threads have completed:
-----------------------
Buffer has 0 elements remaining
-----------------------
Server thread 0 is alive: false
Server thread 1 is alive: false
Server thread 2 is alive: false
Server thread 3 is alive: false
Server thread 4 is alive: false
Server thread 5 is alive: false
Server thread 6 is alive: false
Server thread 7 is alive: false
Server thread 8 is alive: false
Server thread 9 is alive: false
User thread 0 is alive: false
User thread 1 is alive: false
User thread 2 is alive: false
User thread 3 is alive: false
User thread 4 is alive: false
User thread 5 is alive: false
User thread 6 is alive: false
User thread 7 is alive: false
User thread 8 is alive: false
User thread 9 is alive: false
-----------------------
Program took 10052 milliseconds to complete
