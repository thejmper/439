import java.util.List;
import java.util.Random;

//=============================================================================================================================================================
/**
 * Defines the simulation as specified in the task document.
 * <p>
 * IMPLEMENT THIS CLASS YOURSELF.
 * 
 * Jonathan Pfefferle
 */
public class Simulation
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(final String[] arguments)
   {
      Simulation simulation = new Simulation();

      //simulation.doTest();
      simulation.doTest9();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Executes the initial test
    */
   private void doTest()
   {
      int randomSeed = 1; 

      double lambda = 0.75; // the random arrival rate of cars; larger is more frequent

      double simulationRunTime = 300; // the total number of seconds to simulate

      double lengthGreen = 30; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
      double lengthRed = 30;
      
      double spread = (lengthGreen + lengthRed);

      double bucketSize = 10; // the size of the histogram buckets in seconds

      // populate the traffic-light transitions
      TrafficQueue queue = new TrafficQueue("queue");
      populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
      // populate the cars randomly
      populateCars(queue, simulationRunTime, lambda, randomSeed);
      
      this.PrintSeperator();      
      
      // execute the simulation and generate a histogram 
      executeSimulation(queue, bucketSize);
   }

   private void doTest1(){
    int randomSeed = 2;
     double lambda = 0.75; // the random arrival rate of cars; larger is more frequent

     double simulationRunTime = 300; // the total number of seconds to simulate

     double lengthGreen = 30; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
     double lengthRed = 30;

     double spread = (lengthGreen + lengthRed);

     double bucketSize = 10; // the size of the histogram buckets in seconds

     // populate the traffic-light transitions
     TrafficQueue queue = new TrafficQueue("queue");
     populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
     // populate the cars randomly
     populateCars(queue, simulationRunTime, lambda, randomSeed);

     this.PrintSeperator();      

     // execute the simulation and generate a histogram 
     executeSimulation(queue, bucketSize);      
   } 
   private void doTest2(){
       int randomSeed = 1; 

      double lambda = 0.5; // the random arrival rate of cars; larger is more frequent

      double simulationRunTime = 300; // the total number of seconds to simulate

      double lengthGreen = 30; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
      double lengthRed = 30;
      
      double spread = (lengthGreen + lengthRed);

      double bucketSize = 10; // the size of the histogram buckets in seconds

      // populate the traffic-light transitions
      TrafficQueue queue = new TrafficQueue("queue");
      populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
      // populate the cars randomly
      populateCars(queue, simulationRunTime, lambda, randomSeed);
      
      this.PrintSeperator();      
      
      // execute the simulation and generate a histogram 
      executeSimulation(queue, bucketSize);
   }
   private void doTest3(){
     int randomSeed = 2;
     double lambda = 5.0; // the random arrival rate of cars; larger is more frequent

     double simulationRunTime = 300; // the total number of seconds to simulate

     double lengthGreen = 30; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
     double lengthRed = 30;

     double spread = (lengthGreen + lengthRed);

     double bucketSize = 10; // the size of the histogram buckets in seconds

     // populate the traffic-light transitions
     TrafficQueue queue = new TrafficQueue("queue");
     populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
     // populate the cars randomly
     populateCars(queue, simulationRunTime, lambda, randomSeed);

     this.PrintSeperator();      

     // execute the simulation and generate a histogram 
     executeSimulation(queue, bucketSize);      
   }
   private void doTest4(){
    int randomSeed = 2;
     double lambda = 0.75; // the random arrival rate of cars; larger is more frequent

     double simulationRunTime = 300; // the total number of seconds to simulate

     double lengthGreen = 45; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
     double lengthRed = 30;

     double spread = (lengthGreen + lengthRed);

     double bucketSize = 10; // the size of the histogram buckets in seconds

     // populate the traffic-light transitions
     TrafficQueue queue = new TrafficQueue("queue");
     populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
     // populate the cars randomly
     populateCars(queue, simulationRunTime, lambda, randomSeed);

     this.PrintSeperator();      

     // execute the simulation and generate a histogram 
     executeSimulation(queue, bucketSize);      
   }
   private void doTest5(){
    int randomSeed = 2;
     double lambda = 0.75; // the random arrival rate of cars; larger is more frequent

     double simulationRunTime = 300; // the total number of seconds to simulate

     double lengthGreen = 30; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
     double lengthRed = 45;

     double spread = (lengthGreen + lengthRed);

     double bucketSize = 10; // the size of the histogram buckets in seconds

     // populate the traffic-light transitions
     TrafficQueue queue = new TrafficQueue("queue");
     populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
     // populate the cars randomly
     populateCars(queue, simulationRunTime, lambda, randomSeed);

     this.PrintSeperator();      

     // execute the simulation and generate a histogram 
     executeSimulation(queue, bucketSize);      
   }
   private void doTest6(){
    int randomSeed = 2;
     double lambda = 0.75; // the random arrival rate of cars; larger is more frequent

     double simulationRunTime = 300; // the total number of seconds to simulate

     double lengthGreen = 10; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
     double lengthRed = 10;

     double spread = (lengthGreen + lengthRed);

     double bucketSize = 10; // the size of the histogram buckets in seconds

     // populate the traffic-light transitions
     TrafficQueue queue = new TrafficQueue("queue");
     populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
     // populate the cars randomly
     populateCars(queue, simulationRunTime, lambda, randomSeed);

     this.PrintSeperator();      

     // execute the simulation and generate a histogram 
     executeSimulation(queue, bucketSize);      
   }
   private void doTest8(){
     int randomSeed = 2;
     double lambda = 5.0; // the random arrival rate of cars; larger is more frequent

     double simulationRunTime = 300; // the total number of seconds to simulate

     double lengthGreen = 30; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
     double lengthRed = 30;

     double spread = (lengthGreen + lengthRed);

     double bucketSize = 15; // the size of the histogram buckets in seconds

     // populate the traffic-light transitions
     TrafficQueue queue = new TrafficQueue("queue");
     populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
     // populate the cars randomly
     populateCars(queue, simulationRunTime, lambda, randomSeed);

     this.PrintSeperator();      

     // execute the simulation and generate a histogram 
     executeSimulation(queue, bucketSize);      
   }
   private void doTest9(){
     int randomSeed = 2;
     double lambda = 5.0; // the random arrival rate of cars; larger is more frequent

     double simulationRunTime = 300; // the total number of seconds to simulate

     double lengthGreen = 30; // red every 30 seconds starting at 30, green every 30 seconds starting at 60
     double lengthRed = 30;

     double spread = (lengthGreen + lengthRed);

     double bucketSize = 15; // the size of the histogram buckets in seconds

     // populate the traffic-light transitions
     TrafficQueue queue = new TrafficQueue("queue");
     populateLights(queue, simulationRunTime, lengthGreen, spread, spread, spread);
     // populate the cars randomly
     populateCars(queue, simulationRunTime, lambda, randomSeed);

     this.PrintSeperator();      

     // execute the simulation and generate a histogram 
     executeSimulation(queue, bucketSize);      
   }
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Executes the simulation after setting it up with events.
    *
    * @param queue - the event queue
    * @param bucketSize - the bucket size in seconds
    */
   private void executeSimulation(final TrafficQueue queue, double bucketSize)
   {
        AnalysisGroup all = new AnalysisGroup("all", 0);
        AnalysisGroup onGreenAll = new AnalysisGroup("on_green:all", 0);
        AnalysisGroup onRedAll = new AnalysisGroup("on_red:all", 0);
        
        int lightCount = 1;
        
        AnalysisGroup onGreenLocal = new AnalysisGroup("on_green:" + lightCount++,0);
        AnalysisGroup onRedLocal = new AnalysisGroup("on_red:" + lightCount++,0);

        boolean isGreen = false;
        double lastTime = 0;
        while(queue.hasEvents()){
            List<Event> events = queue.service();
            
            for(int i = 0; i < events.size(); i++){
                Event event = events.get(i);
                double time = event.getTime();
                lastTime = time;
                if(event.getType().equals(Event.E_EventType.CAR_ARRIVAL)){
                    all.addEventTime(time);
                    
                    if(isGreen){
                        onGreenAll.addEventTime(time);
                        onGreenLocal.addEventTime(time);
                    }
                    else{
                        onRedAll.addEventTime(time);
                        onRedLocal.addEventTime(time);
                    }
                }
                else if(event.getType().equals(Event.E_EventType.LIGHT_TO_GREEN)){
                    all.addEventSeparator(time);
                    onRedAll.addEventSeparator(time);
                    onRedLocal.finalizeInterval(time);
                    onRedLocal = new AnalysisGroup("on_red:" + lightCount++, time);
                } else {
                    all.addEventSeparator(time);
                    onGreenAll.addEventSeparator(time);
                    onGreenLocal.finalizeInterval(time);
                    onGreenLocal = new AnalysisGroup("on_green:" + lightCount++, time);
                }
            }
        }
        all.finalizeInterval(lastTime);
        onGreenAll.finalizeInterval(lastTime);
        onRedAll.finalizeInterval(lastTime);
        
        all.generateHistogram(bucketSize);
        onGreenAll.generateHistogram(bucketSize);
        onRedAll.generateHistogram(bucketSize);
      // TODO: create the five analysis groups
 
     // TODO: keep looping while the queue has events

      // TODO: > pop off all events queued up for this turn of the light

      // TODO: >> for a CAR_ARRIVAL event, add it to the all analysis group and the on_green:n/green:all or on_red:n/red:all groups, depending on the light state

      // TODO: >> for a LIGHT_TO_GREEN event, add an event separator with the current time to all and red:all,
      // finalize the on_red:n group with this time, and create a new on_green:n group for the next turn. Finalizing prints its statistics

      // TODO: >> for a LIGHT_TO_RED event, add an event separator with the current time to all and green:all,
      // finalize the on_green:n group with this time, and create a new on_red:n group for the next turn. Finalizing prints its statistics

      // TODO: finalize all the all analysis groups with the final simulation time

      // TODO: generate the histograms on the all groups
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Populates a queue with car arrivals.
    *
    * @param queue - the event queue
    * @param simulationRunTime - the end time of the simulation
    * @param lambda - the lambda term of the exponential random distribution
    * @param randomSeed - the random seed
    */
   private void populateCars(final TrafficQueue queue, final double simulationRunTime, final double lambda, final int randomSeed)
   {
        // TODO: create a java.util.Random object random with randomSeed 
        Random rng = new Random(randomSeed);
        double time = 0;
        int i = 1;
        while(time < simulationRunTime){
            // TODO: starting at current time 0, loop until it reaches or exceeds simulationRunTime
            // TODO: > generate a random time with lambda from the exponential-distribution formula in the specs
            // TODO: create a CAR_ARRIVAL event at this time, add it to the queue, and advance the current time by this amount   
            
            double randomTime = Math.log(1-rng.nextDouble()) / -lambda;
            time+= randomTime;
            if(time > simulationRunTime)
                break;
            Event event = new Event(time, "car_" + i++, Event.E_EventType.CAR_ARRIVAL);
            queue.addEvent(event);
        }
  
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Populates a queue with traffic-light transitions of both types.
    *
    * @param queue - the event queue
    * @param simulationRunTime - the end time of the simulation
    * @param startTimeRed - the start time of the red lights
    * @param intervalRed - the time interval between red lights 
    * @param startTimeGreen - the start time of the green lights
    * @param intervalGreen - the time interval between green lights
    */
   private void populateLights(final TrafficQueue queue,
                               final double simulationRunTime,
                               final double startTimeRed,
                               final double intervalRed,
                               final double startTimeGreen,
                               final double intervalGreen)
   {
        // TODO: call populateTransitions for the LIGHT_TO_RED transitions
        this.populateTransitions(queue, Event.E_EventType.LIGHT_TO_RED, startTimeRed, simulationRunTime, intervalRed);
        // TODO: call populateTransitions for the LIGHT_TO_GREEN transitions
        this.populateTransitions(queue, Event.E_EventType.LIGHT_TO_GREEN, startTimeGreen, simulationRunTime, intervalGreen);

   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Populates a queue with traffic-light transitions of one type.
    *
    * @param queue - the queue
    * @param type - the type of event, either LIGHT_TO_GREEN or LIGHT_TO_RED
    * @param timeStart - the time of the first event
    * @param timeEnd - the time of the last event
    * @param timeStep - the interval between each event; the last interval may not divide evenly
    */
   private void populateTransitions(final TrafficQueue queue, 
                                    final Event.E_EventType type, 
                                    final double timeStart, 
                                    final double timeEnd, 
                                    final double timeStep)
   {
        // TODO: loop from timeStart up to and including timeEnd by timeStep, create an event for each, and add it to the queue
        int i = 1;
        for(double time = timeStart; time <= timeEnd; time+= timeStep){
            Event event = new Event(time, "transition_" + i, type);
            queue.addEvent(event);     
            i++;
        }
   }
   
   //--helper methods--//
   private void PrintSeperator(){
      System.out.println("---------------------------------------------------------------------------------------------------"); 
   }
}
