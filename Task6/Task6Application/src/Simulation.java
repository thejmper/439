
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Simulation {

    public static int NUM_RUNS = 20;

    public static void main(String[] args) throws FileNotFoundException{
        
        //testA1();   //plane, bulk cargo, short war
        //testA2();   //ship, bulk carco, short war
        
        //testB1();   //plane, bulk cargo, long war
        //testB2();   //ship, bulk cargo, long war.
        
        testC1();
        testC2();
        
        testD1();
        testD2();
        
    }
    
    
    
    //simulates a convoy given the following parameters
    //transportNum:         how many transports are sent
    //transportCapacity:    how many long tons of *stuff* each transport carries
    //tripLength:           how many hours one leg of the trip takes
    //lossChance:           chance each transport could be lost
    //runTime:              run time of this simulation in hours.
    //seed:                 RNG seed!
    private static void SimulateConvoy(int transportNum, float transportCapacity,float lossChance,int tripLegLength,int seed, int runTime){
        Convoy convoy = new Convoy(transportNum, transportCapacity, lossChance, tripLegLength, seed);
        
        int time = 0;
        while(time <= (runTime - (tripLegLength * 2)) && convoy.IsAlive()){
            time = convoy.RunLeg(time, true);   //outbound
            if(time >= runTime)
                break;
            time = convoy.RunLeg(time, false);  //inbound
        }
        convoy.Report();
    }
    
    //bulk cargo block!
    //test1: simulate a 4 year war with surface loss rate scaling between .000 and .1 in .001 increments.
    //done twice, once with planes and once with ships
    private static void testA1() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1200;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 66.96f;   //long tons
        float lossChance = 0.00001f;        //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 11;             //Halifax to Liverpool (~2718 miles) / cruise speed (250 mph)
        int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                 //always run in thousand-trip chunks.
        
        System.out.println("TestA1: Plane bulk cargo, short war");
        
        PrintWriter pw = new PrintWriter(new File("testA1.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Loss chance,Avg Time,stdDev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev, LegCount, stdDev");        
        sb.append(System.getProperty("line.separator"));

        SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
    //test 2: simulate 4 year war with ships
    private static void testA2() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1000;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 10000f;   //long tons
        //float lossChance = 0.00001f;      //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 360;            //Halifax to Liverpool convoy route known to  be 15 days. 15 * 24 = 360 hours
        int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                   //always run in 25 run chunks.
        
        System.out.println("TestA2: Ship bulk cargo, short war");
        
        PrintWriter pw = new PrintWriter(new File("testA2.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Loss chance,Avg Time,stdDev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev,LegCount, stdDev");        
        sb.append(System.getProperty("line.separator"));
                
        //Convoy.PrintHeader();
        for(float lossChance = 0; lossChance <= .05; lossChance += .001){
            SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
        }
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");        
    }
    
    //simulate a war lasting somewhere between 4 and 14 years.
    private static void testB1() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1200;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 66.96f;   //long tons
        float lossChance = 0.00001f;        //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 11;             //Halifax to Liverpool (~2718 miles) / cruise speed (250 mph)
        //int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                 //always run in thousand-trip chunks.
        
        System.out.println("TestB1: Plane bulk cargo, long war");
        
       
        
        for(int years = 5; years <= 6;){
            PrintWriter pw = new PrintWriter(new File("testB1Year" + years + ".csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("WarLength,Loss chance,Avg Time,stdev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev,LegCount, stdDev");        
            sb.append(System.getProperty("line.separator"));
            
            int runTime = years * 365 * 24;
            sb.append(years +",");
            SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
            
            years++;
            pw.write(sb.toString());
            pw.close();
        }
        

        System.out.println("done!");
    }
    //simulate a longer war
    private static void testB2() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1000;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 10000f;   //long tons
        //float lossChance = 0.00001f;      //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 360;            //Halifax to Liverpool convoy route known to  be 15 days. 15 * 24 = 360 hours
        //int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                   //always run in 25 run chunks.
        
        System.out.println("TestB2: Ship bulk cargo, long war");
        
       
        
        for(int years = 5; years <= 6;){
            PrintWriter pw = new PrintWriter(new File("testB2Year" + years + ".csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("WarLength,Loss chance,Avg Time,stdev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev,LegCount, stdDev");        
            sb.append(System.getProperty("line.separator"));
            
            int runTime = years * 365 * 24;
           
            for(float lossChance = 0; lossChance <= .05; lossChance += .001){
                sb.append(years +",");
                SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
            }            
            years++;
            pw.write(sb.toString());
            pw.close();
        }
        

        System.out.println("done!");
    }
    
    
    
    //same as the above, but with troops instead!
    private static void testC1() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1200;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 150f;   //troops
        float lossChance = 0.00001f;        //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 11;             //Halifax to Liverpool (~2718 miles) / cruise speed (250 mph)
        int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                 //always run in thousand-trip chunks.
        
        System.out.println("TestC1: Plane troops, short war");
        
        PrintWriter pw = new PrintWriter(new File("testC1.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Loss chance,Avg Time,stdDev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev, LegCount, stdDev");        
        sb.append(System.getProperty("line.separator"));

        SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
    //test 2: simulate 4 year war with ships
    private static void testC2() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1000;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 550f;     //armed troops
        //float lossChance = 0.00001f;      //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 360;            //Halifax to Liverpool convoy route known to  be 15 days. 15 * 24 = 360 hours
        int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                   //always run in 25 run chunks.
        
        System.out.println("TestC2: Ship troops, short war");
        
        PrintWriter pw = new PrintWriter(new File("testC2.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Loss chance,Avg Time,stdDev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev,LegCount, stdDev");        
        sb.append(System.getProperty("line.separator"));
                
        //Convoy.PrintHeader();
        for(float lossChance = 0; lossChance <= .05; lossChance += .001){
            SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
        }
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");        
    }
    
    //simulate a war lasting somewhere between 4 and 14 years.
    private static void testD1() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1200;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 150f;     //troops
        float lossChance = 0.00001f;        //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 11;             //Halifax to Liverpool (~2718 miles) / cruise speed (250 mph)
        //int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                 //always run in thousand-trip chunks.
        
        System.out.println("TestD1: Plane troops, long war");
        
       
        
        for(int years = 5; years <= 6;){
            PrintWriter pw = new PrintWriter(new File("testD1Year" + years + ".csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("WarLength,Loss chance,Avg Time,stdev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev,LegCount, stdDev");        
            sb.append(System.getProperty("line.separator"));
            
            int runTime = years * 365 * 24;
            sb.append(years +",");
            SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
            
            years++;
            pw.write(sb.toString());
            pw.close();
        }
        

        System.out.println("done!");
    }
    //simulate a longer war
    private static void testD2() throws FileNotFoundException{
        //when scaled to 1941 dollars, Spruce Geese cost 1.65 million each. Liberty ships cost 2 million give or take.
        
        int numTransports = 1000;           //always start with 2 bilion dollars worth of hardware. 
        float transportCapacity = 550f;     //troops
        //float lossChance = 0.00001f;      //1 out of every 100,000 flights is an accident. 40 times worse than modern airlines.
        int tripLegLength = 360;            //Halifax to Liverpool convoy route known to  be 15 days. 15 * 24 = 360 hours
        //int runTime = 365 * 24 * 4;         //4 years converted to hours.
        int numRuns = NUM_RUNS;                   //always run in 25 run chunks.
        
        System.out.println("TestD2: Ship troops, long war");
        
       
        
        for(int years = 5; years <= 6;){
            PrintWriter pw = new PrintWriter(new File("testD2Year" + years + ".csv"));
            StringBuilder sb = new StringBuilder();
            sb.append("WarLength,Loss chance,Avg Time,stdev,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev,LegCount, stdDev");        
            sb.append(System.getProperty("line.separator"));
            
            int runTime = years * 365 * 24;
           
            for(float lossChance = 0; lossChance <= .05; lossChance += .001){
                sb.append(years +",");
                SimulateMultipleConvoys(numTransports, transportCapacity, lossChance, tripLegLength, runTime, numRuns, sb);
            }            
            years++;
            pw.write(sb.toString());
            pw.close();
        }
        

        System.out.println("done!");
    }
    
    //simulates a batch of covnoys and averages the results//
    private static void SimulateMultipleConvoys(int transportNum, float transportCapacity, float lossChance, int tripLegLength, int runTime, int numRuns, StringBuilder sb){
        double[] time = new double[numRuns];
        double[] transportsLost = new double[numRuns];
        double[] cargoDelivered = new double[numRuns];
        double[] cargoLost = new double[numRuns];
        
        double[] convoyRuns = new double[numRuns];
        
        for(int i = 0; i < numRuns; i++){
            Convoy convoy = new Convoy(transportNum, transportCapacity, lossChance, tripLegLength, i);
            convoy.RunConvoy(runTime);
            
            time[i] = convoy.GetTime();
            transportsLost[i] = convoy.GetTransportsLost();
            cargoDelivered[i] = convoy.GetCargoDelivered();
            cargoLost[i] = convoy.GetCargoLost();
            convoyRuns[i] = convoy.GetNumLegs();            
            //convoy.Report();
        }      
        
        
        //write to CSV file
        String newLine = System.getProperty("line.separator");        
        //header
        //System.out.println("Loss chance,Avg Time,Avg transport Loss, stdDev, Avg Cargo Delivered, stdDev, Avg Cargo Lost, stdDev");
        //System.out.print(lossChance +",");
        sb.append(lossChance + ",");
        
        
        double avgTime = Statistics.GetAverage(time);
        double timeStdDev = Statistics.GetStandardDeviation(time, avgTime);
        //System.out.print(avgTime + "," + timeStdDev + ",");
        sb.append(avgTime + "," + timeStdDev + ",");
        
        double avgTranLost = Statistics.GetAverage(transportsLost);
        double tranStdDev = Statistics.GetStandardDeviation(transportsLost, avgTranLost);
        //System.out.print(avgTranLost +"," + tranStdDev + ",");
        sb.append(avgTranLost +"," + tranStdDev + ",");
        
        double avgCargoDelivered = Statistics.GetAverage(cargoDelivered);
        double cargoStdDev = Statistics.GetStandardDeviation(cargoDelivered, avgCargoDelivered);
        //System.out.print(avgCargoDelivered +"," + cargoStdDev + ",");
        sb.append(avgCargoDelivered +"," + cargoStdDev + ",");
      
        double avgCargoLost = Statistics.GetAverage(cargoLost);
        double lossStdDev = Statistics.GetStandardDeviation(cargoLost,avgCargoLost);
        //System.out.println(avgCargoLost +"," + lossStdDev + ",");       
        sb.append(avgCargoLost +"," + lossStdDev + ",");

        double avglegCount = Statistics.GetAverage(convoyRuns);
        double legCountSdDev = Statistics.GetStandardDeviation(convoyRuns, avglegCount);
        sb.append(avglegCount +"," + legCountSdDev);

        sb.append(newLine);

    }
}
