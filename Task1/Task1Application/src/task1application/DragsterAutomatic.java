
import java.text.DecimalFormat;

//=============================================================================================================================================================
/**
 * Defines the dragster with the automatic transmission as describe in the task document. Add your solution here. Get this one to work first, then copy it to
 * DragsterManual and modify it there.
 * 
 * IMPLEMENT PARTS 1 AND 2 HERE.
 */
public class DragsterAutomatic extends A_Dragster
{
   /** the target RPM to shift at */
   private static final int SHIFT_RPM = 9000;

   //--member fields--//
   private double time;
   private double timeInGear;
   private int gear;
   private double gearRatio;
   
   private double distance;
   private double speed;


   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a dragster with an automatic transmission
    *
    * @param engineModel - the engine model
    */
   public DragsterAutomatic(final A_EngineModel engineModel)
   {
      super(engineModel);

      this.time=0;
      this.timeInGear=0;
      this.gear=1;
      this.gearRatio = GEAR_RATIOS[this.gear-1];

      this.distance=0;
      this.speed = 0;


      System.out.println("time,distance,speed,gear_num,rpm");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    *
    * Implement Parts 1 and 2 here. There should be no difference in the code based on the engine model.
    */
   @Override
   public boolean update(final double timeStep)
   {      
        super.update(timeStep);

        //update stuff
        int currRPM = this._engineModel.getRPM(timeInGear, gear);
        
        if(currRPM >= SHIFT_RPM){
            int newGear = gear + 1;
            //if we can shift
            if(newGear <= GEAR_RATIOS.length){
                this.gear++;
                this.gearRatio = GEAR_RATIOS[gear-1];
                this.timeInGear = 0;
                
                currRPM = this._engineModel.getRPM(timeInGear, gear);
            }                
        }
            
        
            
        double distanceDelta = (currRPM / SECONDS_PER_MINUTE) * timeStep * gearRatio * FEET_PER_REVOLUTION;
                        
        //apply updates to cumulative values.
        this.distance += distanceDelta;
        this.speed = (distance/FEET_PER_MILE) / (time / SECONDS_PER_MINUTE/MINUTES_PER_HOUR);
                
        //report!
        this.printTimeFormatted();
        System.out.print((int)Math.round(distance) +",");
        System.out.print((int)Math.round(speed) + ",");
        System.out.print(gear + ",");
        System.out.println(currRPM);
        
        //update time
        this.time += timeStep;
        this.timeInGear += timeStep;
        
        //check done
        return distance >= TRACK_LENGTH_FEET;
   }
   
    private void printTimeFormatted(){
        DecimalFormat format = new DecimalFormat("0.00");
        System.out.print(format.format(time) + ",");
    }
}
