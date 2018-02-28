//=============================================================================================================================================================
/**
 * Defines the simulation.
 *
 * CHANGE ANYTHING YOU WANT HERE.
 */
public class Simulation
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(final String[] arguments)
   {
      Simulation simulation = new Simulation();

      simulation.doTest();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTest()
   {
      int testNum = 9;
      
      switch (testNum)
      {
        case 1:
            doTestA1();
            break;
        case 2:
            doTestA2();
            break;
        case 3:
            doTestA3();
            break;
        case 4:
            doTestA4();
            break;
        case 5: 
            doTestA5();
            break;
         
        case 6:
            doTestB1();
            break;
        case 7:
            doTestB2();
            break;
            
        case 8:
            doTestC1();
            break;
        case 9:
            doTestC2();
            break;
            
            
        case -1:
        
             
            doTestArtillery1();
         
            break;
         
         case -2:
         
            doTestBomber1();
         
            break;
         
         // add the rest yourself based on which ones you choose to solve
            
         default:
         
            throw new RuntimeException("bad test "+ testNum);
      }
   }
   
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public Simulation()
   {
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTestArtillery1()
   {
      // runs 1000 tests
      double expectedX = 1348.7351190199681;

      int numRuns = 1000;

      double timeStep = 0.01;

      double sumX = 0;
      
      System.out.println("run,range");

      for (int iRun = 1; iRun <= numRuns; iRun++)
      {
         Artillery artillery = new Artillery(85, 500, iRun, 0, 0, 0, 0, 0, 0, 0, false);

         boolean isDone = false;

         while (!isDone)
         {
            isDone = artillery.update(timeStep);
         }
         
         double finalX = artillery.getX(); 

         System.out.println(iRun + "," + finalX);
         
         sumX += finalX;
      }
      
      double average = (sumX / (double) numRuns);
      double averageError = (average - expectedX);
      
      System.out.println("average       = "+ average);
      System.out.println("average_error = "+ averageError);
   }

   //handles test A1
   private void doTestA1(){       
      double timeStep = 0.01;
      
      //increment angle by half a degree
      double angleDelta = 0.5;
      
      System.out.println("elevation,range");

      int i = 0;
      for (double angle = 5; angle < 90; angle += angleDelta)
      {
         Artillery artillery = new Artillery(angle, 500, i++, 0, 0, 0, 0, 0, 0, 0, false);

         boolean isDone = false;

         while (!isDone)
         {
            isDone = artillery.update(timeStep);
         }
         
         double finalX = artillery.getX(); 

         System.out.println(angle + "," + finalX);
      }   
   }
   private void doTestA2(){       
      double timeStep = 0.01;
      
      //increment angle by half a degree
      double angleDelta = 0.5;
      
      System.out.println("elevation,range");

      int i = 0;
      for (double angle = 5; angle < 90; angle += angleDelta)
      {
         Artillery artillery = new Artillery(angle, 500, i++, 0, 0, 0, 0, 0, 0, 0, false);

         while (artillery.getY() > -1000)
         {
            artillery.update(timeStep);
         }
         
         double finalX = artillery.getX(); 

         System.out.println(angle + "," + finalX);
      }   
   }   
   private void doTestA3(){       
      double timeStep = 0.01;
      
      //increment angle by half a degree
      double angleDelta = 0.5;
      
      System.out.println("elevation,range");

      int i = 0;
      for (double angle = 5; angle < 90; angle += angleDelta)
      {
         Artillery artillery = new Artillery(angle, 500, i++, 0, 0, 0, 0, 0, 0, 0, false);

         boolean hasPassed = false;
         double lasty = 0;
         
         while (!(artillery.getY() <= 1000 && hasPassed))
         {             
             artillery.update(timeStep);
             if(artillery.getY() >= 1000)
                 hasPassed = true;
             
             if(artillery.getY() < lasty && !hasPassed)
                 break;
             
             lasty = artillery.getY();
         }
         
         double finalX = artillery.getX(); 

         System.out.println(angle + "," + finalX);
      }   
   }   
   private void doTestA4    (){
    double timeStep = 0.1;
      
      //increment angle by half a degree
      double angleDelta = 0.5;
      
      System.out.println("elevation,range");

      int i = 0;
      for (double angle = 5; angle < 90; angle += angleDelta)
      {
         Artillery artillery = new Artillery(angle, 500, i++, 0, 0, 0, 0, 0, 0, 0, false);

         boolean isDone = false;

         while (!isDone)
         {
            isDone = artillery.update(timeStep);
         }
         
         double finalX = artillery.getX();
         System.out.println(angle + "," + finalX);
      }          
   }
   private void doTestA5    (){
    double timeStep = 0.001;
      
      //increment angle by half a degree
      double angleDelta = 0.5;
      
      System.out.println("elevation,range");

      int i = 0;
      for (double angle = 5; angle < 90; angle += angleDelta)
      {
         Artillery artillery = new Artillery(angle, 500, i++, 0, 0, 0, 0, 0, 0, 0, false);

         boolean isDone = false;

         while (!isDone)
         {
            isDone = artillery.update(timeStep);
         }
         
         double finalX = artillery.getX();
         System.out.println(angle + "," + finalX);
      }          
   }

   private void doTestB1(){
     double timeStep = 0.01;
      
     
      double errorStep = 0.01;
      
      int numRuns = 1000;
      System.out.println("error,CEP(100)");
      
      for(double error = 0; error < 2; error+= errorStep){
        int numHits = 0;
        for (int run = 0; run < numRuns; run++)
        {
           Artillery artillery = new Artillery(20, 500, run, error, 0, 0, 0, 0, 0, 0, false);

           boolean isDone = false;

           while (!isDone)
           {
              isDone = artillery.update(timeStep);
           }

           double finalX = artillery.getX(); 

           if(Math.abs(5000-finalX) <= 100)
               numHits++;
          } 
          double circularError = (double)numHits/numRuns;
          System.out.println(error + "," + circularError);
      }
   }
   private void doTestB2(){
  double timeStep = 0.01;
      
     
      double errorStep = 0.1;
      
      int numRuns = 1000;
      System.out.println("error,CEP(100)");
      
      for(double error = 0; error < 10; error+= errorStep){
        int numHits = 0;
        for (int run = 0; run < numRuns; run++)
        {
           Artillery artillery = new Artillery(20, 500, run, 0, error, 0, 0, 0, 0, 0, false);

           boolean isDone = false;

           while (!isDone)
           {
              isDone = artillery.update(timeStep);
           }

           double finalX = artillery.getX(); 

           if(Math.abs(5000-finalX) <= 100)
               numHits++;
          } 
          double circularError = (double)numHits/numRuns;
          System.out.println(error + "," + circularError);
      }     
   }
   
    private void doTestC1(){
     double timeStep = 0.01;
      
     
      double errorStep = 0.1;
      
      int numRuns = 1000;
      System.out.println("error,CEP(100)");

      
      for(double error = 0; error < 5; error+= errorStep){
        int numHits = 0;
        for (int run = 0; run < numRuns; run++)
        {
           Artillery artillery = new Artillery(20, 500, run, 0, 0, error, 0, 0, 0, 0, false);

           boolean isDone = false;

           while (!isDone)
           {
               isDone = artillery.update(timeStep);
           }

           double finalX = artillery.getX(); 

           if(Math.abs(5000-finalX) <= 100)
               numHits++;
          } 
          double circularError = (double)numHits/(double)numRuns;
          System.out.println(error + "," + circularError);
      }
   }
   private void doTestC2(){
  double timeStep = 0.01;
      
     
      double errorStep = .1;
      
      int numRuns = 1000;
      System.out.println("error,CEP(100)");
      
      for(double error = 0; error < 10; error+= errorStep){
        int numHits = 0;
        for (int run = 0; run < numRuns; run++)
        {
           Artillery artillery = new Artillery(20, 500, run, 0, 0, error, 0, 0, 0, 0, false);

           boolean isDone = false;

           while (!isDone)
           {
              isDone = artillery.update(timeStep);
           }

           double finalX = artillery.getX(); 

           if(Math.abs(5000-finalX) <= 100)
               numHits++;
          } 
          double circularError = (double)numHits/numRuns;
          System.out.println(error + "," + circularError);
      }    
   }
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   private void doTestBomber1()
   {
      double timeStep = 0.01;

      Bomber bomber = new Bomber(500, 500, 0, 0, 0, 0, 0, true);

      boolean isDone = false;

      while (!isDone)
      {
         isDone = bomber.update(timeStep);
      }
   }
}
