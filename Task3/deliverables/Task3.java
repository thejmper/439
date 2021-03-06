import javax.swing.SwingUtilities;

//=============================================================================================================================================================
//
// DO NOT CHANGE EXISTING CODE THIS CLASS EXCEPT FOR main() AND Task3().  YOU MAY ADD YOUR OWN CODE.
//
public class Task3
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   // SELECT YOUR TEST AND ADJUST THE VIEWER HERE
   public static void main(final String[] arguments)
   {
      String testDesignator = "6.B"; // get these from the task description

      new Task3(testDesignator);
   }

   private Viewer _viewer;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   // CONFIGURE YOUR TESTS HERE
   public Task3(final String testDesignator)
   {
      System.out.println("STARTING TEST " + testDesignator + "\n");

      double zoomFactor = 100; // higher values are closer to the bodies; do not change

      double timeStep = 0.1; // time step in seconds; do not change
      
      double runToTime = 70000; // how long to run in simulation seconds before terminating automatically; collisions terminate at any time; set as needed below

      int frameDelay = 50; // milliseconds between viewer updates; you may change this depending on how well your machine handles the graphics

      boolean canCollide = true; // set as needed below

      Analyzer analyzer = new Analyzer();

      switch (testDesignator)
      {
         case "1.A": // this one is already done
         {
             Body bodyA = new Body("A", -150000, 0, 0, 0, 30000, true);
             Body bodyB = new Body("B", +150000, 0, 0, 0, 30000, true);

             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyA, bodyB);

            break;
         }

         case "1.B":
         {
            Body bodyA = new Body("A", -150000, 0, 1, 0, 30000, true);
            Body bodyB = new Body("B", +150000, 0, -1, 0, 30000, true);

            launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyA, bodyB);
                break;
         }
         
         case "1.C":
         {
            // add whatever you need
            Body bodyA = new Body("A", -150000, 0, -.5, 0, 30000, true);
            Body bodyB = new Body("B", +150000, 0, .5, 0, 30000, true);

            launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyA, bodyB);
        	 break;
         }
         
         case "2.A":
         {
            Body bodyA = new Body("A", -150000, -65000, 1, 0, 30000, true);
            Body bodyB = new Body("B", +150000, 65000, -1, 0, 30000, true);

            launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyA, bodyB);
        	 
            break;
         }
         
         case "2.B":
         {
            Body bodyA = new Body("A", -150000, -25000, 3.2, 0, 30000, true);
            Body bodyB = new Body("B", +150000, 25000, -3.2, 0, 30000, true);

            launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyA, bodyB);
                break;
         }
         
         case "3.A":
         {
             Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, false);
             Body bodyRocket = new Body("ROCKET", 0, 55000, 19, 0, 1000, false);
             
             // add whatever you need

             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRocket);

        	 break;
         }
         
         case "3.B":
         {
            Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, false);
            Body bodyRocket = new Body("ROCKET", 0, 55000, 10, 0, 1000, false);

             // add whatever you need
             bodyRocket.scheduleThruster(true,.25, .5, .75,1,1.25,1.5,1.75);

             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRocket);

        	 break;
         }
         
         case "3.C":
         {
             Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, false);
             Body bodyRocket = new Body("ROCKET", 0, 55000, 0, 19, 1000, false);
             
             // add whatever you need

             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRocket);

        	 break;
         }
         
         case "4":
         {
            Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, false);
            Body bodyRocket = new Body("ROCKET", 0, 55000, 28, 0, 1000, false);
             
             // add whatever you need

            launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRocket);

        	 break;
         }
         
         case "5.A":
         {
             Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, true);
             Body bodyRocket = new Body("ROCKET", 400000, 100000, -3, 3, 1000, true);
             
        	 // add whatever you need

             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRocket);

        	 break;
         }
         
         case "5.B":
         {
             Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, true);
             Body bodyRocket = new Body("ROCKET", 400000, 100000, -10,1.5, 1000, true);
             
        	 // add whatever you need

             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRocket);

        	 break;
         }
         
         case "6.A":
         {
             Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, true);
             Body bodyRock = new Body("ROCK", 400000, 100000, -10,1, 1000, true);
        	 
             
             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRock);
        	 break;
         }
         
         case "6.B":
         {
             Body bodyEarth = new Body("EARTH", 0, 0, 0, 0, 100000, true);
             Body bodyRock = new Body("ROCK", 400000, 100000, -10,-1.5, 1000, true);
        	 
             
             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyRock);
        	 break;
         }
         
         case "7": // grad students only
         {
             Body bodyEarth = new Body("EARTH", -50000, 0, 0, 0, 100000, true);
             Body bodyMoon = new Body("MOON", -50000, 400000, 7, 0, 40000, true);
             Body bodyRocket = new Body("ROCKET", -50000, 50500, 0, 23, 1000, true);

        	 // add whatever you need
        	 
             launch(zoomFactor, frameDelay, timeStep, runToTime, analyzer, bodyEarth, bodyMoon, bodyRocket);

        	 break;
         }
            
         default:

            throw new IllegalArgumentException("invalid test [" + testDesignator + "]");
      }

      analyzer.printResults();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   // DO NOT TOUCH
   private void launch(final double zoomFactor,
                       final int frameDelay,
                       final double timeStep,
                       final double runToTime,
                       final Analyzer analyzer,
                       final Body... bodies)
   {
      System.out.println("STARTING SIMULATOR\n");

      Simulator simulator = new Simulator(analyzer, timeStep, bodies);

      System.out.println("\nSTARTING VIEWER\n");

      _viewer = new Viewer(simulator, zoomFactor, frameDelay, bodies);

      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
            _viewer.launch();
         }
      });

      double time = 0;

      boolean hasCollision = false;

      while ((time <= runToTime) && !hasCollision)
      {
         simulator.update();

         hasCollision = simulator.hasCollision();

         time = simulator.getTime();
      }

      simulator.shutdown();

      System.out.println("\nSHUTTING DOWN\n");
   }
}
