import java.io.IOException;

//=============================================================================================================================================================
/**
 * This is the simulation that drives the model.
 *
 * PUT YOUR SIMULATIONS HERE. KEEP EACH TEST SEPARATE. DO NOT CHANGE Airplane.
 * 
 * PUT YOUR NAME HERE.
 */
public class Simulation
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Runs a test.
    *
    * @param arguments - there are no arguments
    */
   public static void main(final String[] arguments) throws IOException
   {
      Simulation simulation = new Simulation();

      int testNum = 6; // change this to run each test separately

      System.out.println("Executing Test " + testNum);

      switch (testNum)
      {
         case 0:

            simulation.runTestExample();

            break;

         case 1:

            simulation.runTest1();

            break;

         case 2:

            simulation.runTest2();

            break;

         case 3:

            simulation.runTest3();

            break;

         case 4:

            simulation.runTest4();

            break;

         case 5:

            simulation.runTest5();

            break;

         case 6:

            simulation.runTest6();

            break;

         case 7:

            simulation.runTest7();

            break;

         case 8:

            simulation.runTest8();

            break;

         case 9:

            simulation.runTest9();

            break;

         case 10:

            simulation.runTest10();

            break;

         case 11:

            simulation.runTest11();

            break;

         case 12:

            simulation.runTest12();

            break;

         case 13:

            simulation.runTest13();

            break;

         case 14:

            simulation.runTest14();

            break;

         case 15:

            simulation.runTest15();

            break;

         case 16:

            simulation.runTest16();

            break;

         case 17:

            simulation.runTest17();

            break;

         case 18:

            simulation.runTest18();

            break;

         case 19:

            simulation.runTest19();

            break;

         default:

            throw new RuntimeException("unknown test " + testNum);
      }

      System.out.println("Done");
   }

   //----------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Helper methods
    */
   private static String getWorkingDir(){
       return System.getProperty("user.dir");
   }
   
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 1 here.
    */
   public void runTest1() throws IOException
   {
        double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_1";

        double timeLimit = 30; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(0);
        airplane.setRoll(0);

        double time = 0;

        while (time < timeLimit)
        {
           airplane.update(timeStep);

           time = airplane.getTime();
        }

      airplane.terminate(); // do not forget this
       
       
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 2 here.
    */
   public void runTest2() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_2";

        double timeLimit = 30; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(10);
        airplane.setRoll(0);

        double time = 0;

        while (time < timeLimit)
        {
           airplane.update(timeStep);

           time = airplane.getTime();
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 3 here.
    */
   public void runTest3() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_3";

        double timeLimit = 72; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(0);
        airplane.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
           airplane.update(timeStep);

           time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 4 here.
    */
   public void runTest4() throws IOException
   {
        double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_4";

        double timeLimit = 72; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(10);
        airplane.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
           airplane.update(timeStep);

           time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 5 here.
    */
   public void runTest5() throws IOException
   {
double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_5";

        double timeLimit = 72; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(10);
        airplane.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
           airplane.update(timeStep);

           time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 6 here.
    */
   public void runTest6() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_6";

        double timeLimit = 72; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(0.);
        airplane.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
           airplane.update(timeStep);

           time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 7 here.
    */
   public void runTest7() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 8 here.
    */
   public void runTest8() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 9 here.
    */
   public void runTest9() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 10 here.
    */
   public void runTest10() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 11 here.
    */
   public void runTest11() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 12 here.
    */
   public void runTest12() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 13 here.
    */
   public void runTest13() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 14 here.
    */
   public void runTest14() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 15 here.
    */
   public void runTest15() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 16 here.
    */
   public void runTest16() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 17 here.
    */
   public void runTest17() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 18 here.
    */
   public void runTest18() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 19 here.
    */
   public void runTest19() throws IOException
   {
      // your code
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * This is an example test.
    */
   public void runTestExample() throws IOException
   {
	  double timeStep = 0.1; // don't touch
	      
      double x = 0;
      double y = 0;
      double altitude = 1000;
      double speed = 100;
      String filename = "test_1";
      double timeLimit = 30; 

      Airplane airplane = new Airplane(x, y, altitude, speed, filename);

      airplane.setPitch(10);
      airplane.setRoll(0);

      // airplane.setWind(45, 10); for Part II

      double time = 0;

      while (time < timeLimit)
      {
         airplane.update(timeStep);

         time = airplane.getTime();

//         // do something after the simulation starts         
//         if ((time >= 30.0) && (time < 30.1)) // time is subject to rounding errors; do not compare with ==
//         {
//            airplane.setRoll(50);
//         }
      }

      airplane.terminate(); // do not forget this
   }
}
