//---------------------------------------------------------------------
// SimulationCLI.java       by Dale/Joyce/Weems               Chapter 4
//
// Simulates customers waiting in queues. Customers always enter
// the shortest queue.
//
// Input consists of customer information:
//    Minimum and maximum customer interarrival time.
//    Minimum and maximum customer service time.
// Followed by a sequence of simulation instance information:
//    Number of queues and customers.
//
// Output includes, for each simulation instance:
//    The average waiting time for a customer.
//
// Uses a command line interface.
//----------------------------------------------------------------------
//package ch04.apps;

//import ch04.simulation.Simulation;

//CS240 simulation lab 
//Clare(Mingyang),Jianxiang
//3/21/2019
import java.util.Scanner;

public class SimulationCLI 
{
  public static void main(String[] args)
  {
    Scanner conIn = new Scanner(System.in);

    int minIAT;    // minimum interarrival time
    int maxIAT;    // maximum interarrival time
    int minST;     // minimum service time
    int maxST;     // maximum service time
    int numQueues; // number of queues
    int numCust;   // number of customers

    String skip;           // skip end of line after reading an integer
    String more = null;    // used to stop or continue processing

    // Get customer information
    System.out.print("Enter minimum interarrival time: ");
    minIAT = conIn.nextInt();
    System.out.print("Enter maximum interarrival time: ");
    maxIAT = conIn.nextInt();
    System.out.print("Enter minimum service time: ");
    minST = conIn.nextInt();
    System.out.print("Enter maximum service time: ");
    maxST = conIn.nextInt();
    System.out.println();      

    // create object to perform simulation
    Simulation sim = new Simulation(minIAT, maxIAT, minST, maxST);

    do
    {
      // Get next simulation instance to be processed.
      System.out.print("Enter number of queues: ");
      numQueues = conIn.nextInt();     
      System.out.print("Enter number of customers: ");
      numCust = conIn.nextInt();    
      skip = conIn.nextLine();   // skip end of line
      
      // run simulation and output average waiting time
      sim.simulate(numQueues, numCust);
      System.out.println("Average waiting time is " + sim.getAvgWaitTime());
      sim.totalSerTime/=numQueues;//serving time for each queue
      System.out.println("The largest number of customers who were on a queue at the same time is: "+sim.getLongestSize());
      
      System.out.println("Total serving time: "+sim.totalSerTime);
      System.out.println("Total time: "+sim.totalTime);
      System.out.println("The percentage of idle server time is: "+sim.getPercentIdle()+"%");
      // Determine if there is another simulation instance to process
      System.out.println(); 
      System.out.print("Evaluate another simulation instance? (Y=Yes): ");
      more = conIn.nextLine();
      
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }
}
/*Sample interactions:
Enter minimum interarrival time: 5
Enter maximum interarrival time: 5
Enter minimum service time: 5
Enter maximum service time: 5
 
Enter number of queues: 1
Enter number of customers: 1000
Average waiting time is 0.0 
The largest number of customers who were on a queue at the same time is: 0 
Total serving time: 5000.0 
Total time: 5005.0 
The percentage of idle server time is: 0.0999001% 

Evaluate another simulation instance? (Y=Yes): Enter minimum interarrival time: 0
Enter maximum interarrival time: 20
Enter minimum service time: 20
Enter maximum service time: 100
 
Enter number of queues: 10
Enter number of customers: 1000
Average waiting time is 0.458 
The largest number of customers who were on a queue at the same time is: 1 
Total serving time: 5848.6 
Total time: 10053.0 
The percentage of idle server time is: 41.822342% 
 */