
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
public class Convoy {
    //--convoy stats--//
    private int numTransports;          //number of transports the convoy currently has
    private float transportCapacity;    //transport capacity in long tons
    private int startTransports;
    
    private float surviveChance;           //chance of loosing ships on each leg.
    private int tripLegTime;             //how long, in hours, it takes to travel one leg of a trip.
    
    private int transportsLost;         //how many transports were lost
    private float cargoLost;            //how many long tons of cargo were lost
    private float cargoDelivered;       //how many long tons of cargo were delivered
    
    private int legCount;               //how many legs are in this convoy's route?
    private int time;                   //hours that have passed
    //--other objects--//
    private Random rng;
    
    public Convoy(int numTransports, float transportCapacity, float lossChance, int tripLegTime, int rngSeed){
        this.numTransports = numTransports;
        this.transportCapacity = transportCapacity;
        this.startTransports = numTransports;
        
        this.surviveChance = (1-lossChance);
        this.tripLegTime = tripLegTime;
        
        this.transportsLost = 0;
        this.cargoLost = 0;
        this.cargoDelivered = 0;
        
        this.legCount = 0;
        this.time = 0;
        
        this.rng = new Random(rngSeed);        
    }
    
    /**
     * Simulate a single leg of the trip, optionally carrying goods.
     * @param startTime time this leg starts at.
     * @param carryGoods should we carry goods on this leg of the trip?
     * @return time value when the leg is complete.
     */
    public int RunLeg(int startTime, boolean carryGoods){
        
        //account for losses!
        for(int i = 0; i < numTransports; i++){
            if(rng.nextDouble() >= surviveChance){
                                    
                //transport lost!
                numTransports--;
                transportsLost++;
                
                if(carryGoods)
                    cargoLost += transportCapacity;                
            }            
        }      
        if(carryGoods)
            cargoDelivered += (numTransports * transportCapacity);
        
        legCount ++;
        return startTime + tripLegTime;
    }
    
    public void RunConvoy(int runTime){
        
        while(time <= (runTime - (tripLegTime * 2)) && this.IsAlive()){
            time = this.RunLeg(time, true);   //outbound
            if(time >= runTime)
                break;
            time = this.RunLeg(time, false);  //inbound
        }
    }
    
    public boolean IsAlive(){
        return numTransports > 0;
    }
    
    public void Report(){
        System.out.print(1-surviveChance +",");
        System.out.print(startTransports +",");
        System.out.print(time + ",");
        System.out.print(legCount + ",");
        System.out.print(numTransports + ",");
        System.out.print(cargoDelivered + ",");
        System.out.print(transportsLost + ",");
        System.out.println(cargoLost);
    }
    public static void PrintHeader(){
        System.out.println("lossRate,startTransports,time,numlegs,numTransports,cargoDelivered,transportsLost,cargoLost");
    }
    
    //getters
    public int GetTime(){
        return legCount * tripLegTime;
    }
    public int GetNumLegs(){
        return legCount;
    }
    public int GetNumTransports(){
        return this.numTransports;
    }
    public int GetLegCount(){
        return this.legCount;
    }
    public float GetCargoDelivered(){
        return this.cargoDelivered;
    }
    public float GetCargoLost(){
        return this.cargoLost;
    }
    public int GetTransportsLost(){
        return this.transportsLost;
    }
    
    
}
