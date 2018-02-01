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

      int testNum = 18; // change this to run each test separately

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
        airplane.setPitch(.60);
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
        String filename = getWorkingDir() + "/test_6_30";

        double timeLimit = 72; 

        //create airplane, 30 degree bank
        Airplane airplane30 = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane30.setPitch(0);
        airplane30.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
           airplane30.update(timeStep);

           time = airplane30.getTime();
           
           
        }
        airplane30.terminate(); // do not forget this
        
        //create airplane, 45 degree bank
        timeLimit = 51;
        filename = getWorkingDir() + "/test_6_45";
        Airplane airplane45 = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane45.setPitch(0);
        airplane45.setRoll(45);

        time = 0;

        while (time < timeLimit)
        {
           airplane45.update(timeStep);

           time = airplane45.getTime();
           
           
        }
        airplane45.terminate(); // do not forget this
        
        //create airplane, 60 degree bank
        timeLimit = 41;
        filename = getWorkingDir() + "/test_6_60";
        Airplane airplane60 = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane60.setPitch(0);
        airplane60.setRoll(60);

        time = 0;

        while (time < timeLimit)
        {
           airplane60.update(timeStep);

           time = airplane60.getTime();
           
           
        }
        airplane60.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 7 here.
    */
   public void runTest7() throws IOException
   {
     double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_7_50";

        double timeLimit = 72; 

        //create airplane, 30 degree bank
        Airplane airplane50 = new Airplane(x, y, altitude, 50, filename);

        //set airplane initial conditions
        airplane50.setPitch(0);
        airplane50.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
           airplane50.update(timeStep);

           time = airplane50.getTime();
           
           
        }
        airplane50.terminate(); // do not forget this
        
        //create airplane, 45 degree bank
        timeLimit = 72;
        filename = getWorkingDir() + "/test_7_100";
        Airplane airplane100 = new Airplane(x, y, altitude, 100, filename);

        //set airplane initial conditions
        airplane100.setPitch(0);
        airplane100.setRoll(30);

        time = 0;

        while (time < timeLimit)
        {
           airplane100.update(timeStep);

           time = airplane100.getTime();
           
           
        }
        airplane100.terminate(); // do not forget this
        
        //create airplane, 60 degree bank
        timeLimit = 72;
        filename = getWorkingDir() + "/test_7_150";
        Airplane airplane150 = new Airplane(x, y, altitude, 150, filename);

        //set airplane initial conditions
        airplane150.setPitch(0);
        airplane150.setRoll(30);

        time = 0;

        while (time < timeLimit)
        {
           airplane150.update(timeStep);

           time = airplane150.getTime();
           
           
        }
        airplane150.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 8 here.
    */
   public void runTest8() throws IOException
   {
        double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_8";

        double timeLimit = 72; 

        double turnTime = 36;
        
        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(.60);
        airplane.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
            if(time > turnTime)
                airplane.setRoll(-30);
            airplane.update(timeStep);

            time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 9 here.
    */
   public void runTest9() throws IOException
   {
        double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_9";

        double timeLimit = 144; 

        double changeSpeedTime = 36;
        double secondSpeedChange = 72;
        
        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(.60);
        airplane.setRoll(30);

        double time = 0;

        while (time < timeLimit)
        {
            if(time > changeSpeedTime)
                airplane.setSpeed(150);
            
            if(time > secondSpeedChange)
                airplane.setSpeed(200);
            
            airplane.update(timeStep);

            
            
            time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 10 here.
    */
   public void runTest10() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_10";

        double timeLimit = 300; 

        //waypoints
        
        //accelerate and pitch up!
        double way1 = 43;   
        
        //level off and turn
        double way2 = way1 + 16;
        
        //stop turning, continue climbing.
        double way3 = way2 + 18;    //it takes 72 seconds to turn at 30 degrees of bank. 
        
        //stop climbing
        double way4 = way1 + 34;
        
        //turn onto westbound leg
        double way5 = way4 + 18;

        //abeam of origin, shed altitude
        double way6 = way4 + 55;
        
        //at 750, turn on to southbound leg        
        double way7 = way6 + 19;
        
        //turned onto the soutbound leg.
        double way8 = way7 +18;
        
        //at 500, level off
        //double way9 = way7+19;
        
        //align with runway
        double way10 = way8 + 18;
        
        //level off onto runway surface.
        double way11 = way10 + 8;
        
        //roll halfway down the runway.
        double way12 = way11 + 28;
        //create airplane
        Airplane airplane = new Airplane(x, y, 0, 60, filename);

        //set airplane initial conditions
        airplane.setPitch(0f);
        airplane.setRoll(0f);

        double time = 0;

        while (time < way12 + 1)
        {
            if(time > way1){
                airplane.setPitch(60);
                airplane.setSpeed(80);
            }
            if(time > way2){
                airplane.setRoll(-30);
            }
            if(time > way3){
                airplane.setRoll(0);
            }
            if(time > way4){
                airplane.setPitch(0);
                airplane.setRoll(-30);
            }
            if(time > way5){
                airplane.setRoll(0);
            }
            if(time > way6){
                airplane.setPitch(-30);
            }
            if(time > way7){
                airplane.setRoll(-30);
            }
            if(time > way8){
                //airplane.setRoll(0);
            }
            if(time > way10){
                 airplane.setRoll(0);    
                 airplane.setSpeed(60);
            }
            if(time > way11){
                airplane.setPitch(0);
            }
            if(time > way12){
                airplane.setSpeed(0);
            }
            airplane.update(timeStep);

            
            
            time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 11 here.
    */
   public void runTest11() throws IOException
   {
        double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_11";

        //double timeLimit = 99999; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(0);
        airplane.setRoll(0);

        double time = 0;

        double pitch = 0;
        
        while (pitch < 360)
        {
            if((time %3) < timeStep && pitch <= 360){
                pitch += 10;
                airplane.setPitch(pitch);
            }
            
            airplane.update(timeStep);

            
            
            time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 12 here.
    */
   public void runTest12() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_12";

        double timeLimit = 72; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(.60);
        airplane.setRoll(30);
        airplane.setWind(45,10);
        
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
    * Put Test 13 here.
    */
   public void runTest13() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_13";

        double timeLimit = 72; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(.60);
        airplane.setRoll(-30);
        airplane.setWind(45,10);
        
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
    * Put Test 14 here.
    */
   public void runTest14() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_14";

        double timeLimit = 72; 

        double turnTime = 36;
        
        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(.60);
        airplane.setRoll(30);
        airplane.setWind(45,10);

        double time = 0;

        while (time < timeLimit)
        {
            if(time > turnTime)
                airplane.setRoll(-30);
            airplane.update(timeStep);

            time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 15 here.
    */
   public void runTest15() throws IOException
   {
 double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_15";

        double timeLimit = 300; 

        //waypoints
        
        //accelerate and pitch up!
        double way1 = 43;   
        
        //level off and turn
        double way2 = way1 + 16;
        
        //stop turning, continue climbing.
        double way3 = way2 + 18;    //it takes 72 seconds to turn at 30 degrees of bank. 
        
        //stop climbing
        double way4 = way1 + 34;
        
        //turn onto westbound leg
        double way5 = way4 + 18;

        //abeam of origin, shed altitude
        double way6 = way4 + 55;
        
        //at 750, turn on to southbound leg        
        double way7 = way6 + 19;
        
        //turned onto the soutbound leg.
        double way8 = way7 +18;
        
        //at 500, level off
        //double way9 = way7+19;
        
        //align with runway
        double way10 = way8 + 18;
        
        //level off onto runway surface.
        double way11 = way10 + 8;
        
        //roll halfway down the runway.
        double way12 = way11 + 28;
        //create airplane
        Airplane airplane = new Airplane(x, y, 0, 60, filename);

        //set airplane initial conditions
        airplane.setPitch(0f);
        airplane.setRoll(0f);
        airplane.setWind(45,10);
        
        double time = 0;

        while (time < way12 + 1)
        {
            if(time > way1){
                airplane.setPitch(60);
                airplane.setSpeed(80);
            }
            if(time > way2){
                airplane.setRoll(-30);
            }
            if(time > way3){
                airplane.setRoll(0);
            }
            if(time > way4){
                airplane.setPitch(0);
                airplane.setRoll(-30);
            }
            if(time > way5){
                airplane.setRoll(0);
            }
            if(time > way6){
                airplane.setPitch(-30);
            }
            if(time > way7){
                airplane.setRoll(-30);
            }
            if(time > way8){
                //airplane.setRoll(0);
            }
            if(time > way10){
                 airplane.setRoll(0);    
                 airplane.setSpeed(60);
            }
            if(time > way11){
                airplane.setPitch(0);
            }
            if(time > way12){
                airplane.setSpeed(0);
            }
            airplane.update(timeStep);

            
            
            time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Put Test 16 here.
    */
   public void runTest16() throws IOException
   {
      double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_16";

        double timeLimit = 30; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(0);
        airplane.setRoll(0);
        airplane.setWind(45,10);
           
        
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
    * Put Test 17 here.
    */
   public void runTest17() throws IOException
   {
        double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_17";

        double timeLimit = 30; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(0);
        airplane.setRoll(1);        
        airplane.setWind(45,10);

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
    * Put Test 18 here.
    */
   public void runTest18() throws IOException
   {
double timeStep = 0.1; // don't touch
	    
        //setup variables
        double x = 0;
        double y = 0;
        double altitude = 1000;
        double speed = 100;
        String filename = getWorkingDir() + "/test_18";

        double timeLimit = 54; 

        //create airplane
        Airplane airplane = new Airplane(x, y, altitude, speed, filename);

        //set airplane initial conditions
        airplane.setPitch(.60);
        airplane.setRoll(30);
        airplane.setWind(45,10);

        double time = 0;

        double way1 = 15;
        double way2 = 30;
        double way3 = 45;
        double way4 = 53;
        
        while (time < timeLimit)
        {
            if(time > way1){
                airplane.setRoll(45);
            }
            if(time > way2){
                airplane.setRoll(50);
            }
            if(time > way3){
                airplane.setRoll(55);
            }
           
           airplane.update(timeStep);           
           time = airplane.getTime();
           
           
        }

      airplane.terminate(); // do not forget this        
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
