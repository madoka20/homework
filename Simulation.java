//---------------------------------------------------------------------
// Simulation.java           by Dale/Joyce/Weems              Chapter 4
//
// Models a sequence of customers being serviced
// by a number of queues.
//---------------------------------------------------------------------
//package ch04.simulation;

//import support.*;       // Customer, CustomerGenerator
//import ch04.queues.*;   // LinkedGlassQueue

//CS240 simulation lab 
//Clare(Mingyang),Jianxiang
//3/21/2019
public class Simulation 
{
  final int MAXTIME = Integer.MAX_VALUE; 
  int longest=0;//the longest queue
  int longestSize=0;//the size of longest queue                    
  CustomerGenerator custGen;   // a customer generator
  float avgWaitTime = 0.0f;    // average wait time for most recent simulation
  float totalTime=0;//total time
  float totalSerTime=0;//total serving time

  public Simulation(int minIAT, int maxIAT, int minST, int maxST)
  {
    custGen = new CustomerGenerator(minIAT, maxIAT, minST, maxST);
  }
  //get the percentage of idle time
  public float getPercentIdle(){
    float percent=(totalTime-totalSerTime)/totalTime;
  return percent*100;
  }
  public int getLongestSize(){
    return longestSize;
  }//get the size of longest queue
  public float getAvgWaitTime()
  {
    return avgWaitTime;
  }

  public void simulate(int numQueues, int numCustomers)
  // Preconditions: numQueues > 0
  //                numCustomers > 0
  //                No time generated during simulation is > MAXTIME
  //
  // Simulates numCustomers customers entering and leaving the
  // a queuing system with numQueues queues
  {
    // the queues
    LinkedGlassQueue<Customer>[] queues = new LinkedGlassQueue[numQueues]; 
  
    Customer nextCust;      // next customer from generator
    Customer cust;          // holds customer for temporary use
    
    int totWaitTime = 0;    // total wait time
    int custInCount = 0;    // count of customers started so far
    int custOutCount = 0;   // count of customers finished so far
 
    int nextArrTime;        // next arrival time
    int nextDepTime;        // next departure time
    int nextQueue;          // index of queue for next departure
 
    int shortest;           // index of shortest queue
    int shortestSize;       // size of shortest queue

    Customer rearCust;      // customer at rear of shortest queue
    int finishTime;         // calculated finish time for customer being enqueued

    // instantiate the queues
    for (int i = 0; i < numQueues; i++)
      queues[i] = new LinkedGlassQueue<Customer>();
 
    // set customer generator and get first customer
    custGen.reset();
    nextCust = custGen.nextCustomer();
    
    while (custOutCount < numCustomers)  // while still more customers to handle
    { 
      // get next arrival time
      if (custInCount != numCustomers) 
        nextArrTime = nextCust.getArrivalTime();
      else 
        nextArrTime = MAXTIME; 
 
      // get next departure time and set nextQueue
      nextDepTime = MAXTIME;
      nextQueue = -1;
      for (int i = 0; i < numQueues; i++)
        if (queues[i].size() != 0)
        {
          cust = queues[i].peekFront();
          if (cust.getFinishTime() < nextDepTime)
          {
            nextDepTime = cust.getFinishTime();
            nextQueue = i;
          }          
        }

      if (nextArrTime < nextDepTime)
      // handle customer arriving
      {
        // determine shortest queue
        shortest = 0;
        shortestSize = queues[0].size();
        for (int i = 1; i < numQueues; i++)
        {
          if (queues[i].size() < shortestSize)
          {
            shortest = i;
            shortestSize = queues[i].size();
          }
        }
        //determine longest queue
        longest = 0;
        longestSize = queues[0].size();
        for (int i = 1; i < numQueues; i++)
        {
          if (queues[i].size() > longestSize)
          {
           longest = i;
            longestSize = queues[i].size();
          }
        }

        // determine the finish time
        if (shortestSize == 0){
          finishTime = nextCust.getArrivalTime() + nextCust.getServiceTime();
           totalSerTime+=nextCust.getServiceTime();//accumulate serving time
         
        }
          
        else
        {
          rearCust = queues[shortest].peekRear();
          finishTime = rearCust.getFinishTime() + nextCust.getServiceTime();
            totalSerTime+=nextCust.getServiceTime();//accumulate serving time
        }
    
        //totalSerTime/=numQueues;//serving time for each queue
        totalTime=finishTime;//get total time 
        // set finish time and enqueue customer
        nextCust.setFinishTime(finishTime);
       
        queues[shortest].enqueue(nextCust);

        custInCount = custInCount + 1;
          
        // if needed, get next customer to enqueue
        if (custInCount < numCustomers)
          nextCust = custGen.nextCustomer();
      }
      else
      // handle customer leaving
      {
          cust = queues[nextQueue].dequeue();
          totWaitTime = totWaitTime + cust.getWaitTime();
          custOutCount = custOutCount + 1;
      }
      
    }  // end while
    
    avgWaitTime = totWaitTime/(float)numCustomers;
  }
}