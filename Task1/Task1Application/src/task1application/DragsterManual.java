import java.text.DecimalFormat;
import java.util.Random;

//=============================================================================================================================================================
/**
 * Defines the dragster with the manual transmission as describe in the task document. Add your solution here. Get DragsterAutomatic to work first, then copy it
 * here and modify it.
 * 
 * IMPLEMENT PARTS 3 AND 4 HERE.
 */
public class DragsterManual extends A_Dragster
{
   /** the target RPM to shift at */
   private static final int SHIFT_RPM = 9000;

   /** the human response time +/- */
   private static final double SHIFT_RESPONSE_SECONDS = 0.125;

   /** the random number generator; change the seed to meet your needs */
   private final Random _random = new Random(1);

   //member fields
   private double time;
   private double timeInGear;
   private int gear;
   private double gearRatio;
   
   private double distance;
   private double speed;
   
   private double[] shiftTimes;
   private int[] shiftRPMs;

   
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a dragster with a manual transmission
    *
    * @param engineModel - the engine model
    */
   public DragsterManual(final A_EngineModel engineModel)
   {
      super(engineModel);

        this.time=0;
        this.timeInGear=0;
        this.gear=1;
        this.gearRatio = GEAR_RATIOS[this.gear-1];

        this.distance=0;
        this.speed = 0;
        
        this.preCalcuateShifts();
        
      System.out.println("time,distance,speed,gear_num,rpm,shift_rpm");
   }
   
   private void preCalcuateShifts(){
       int numShifts = GEAR_RATIOS.length-1;
       
       this.shiftTimes = new double[numShifts];
       this.shiftRPMs = new int[numShifts];
       
       double lastShift = 0;
       
       for(int i = 0; i < numShifts; i++){
           //calculate shift time
           double idealShiftTime = this._engineModel.getTimeInGear(SHIFT_RPM, i+1);
           double error = this._random.nextGaussian() * SHIFT_RESPONSE_SECONDS;
           
           double timeSinceShift = idealShiftTime + error;
           shiftTimes[i] = timeSinceShift + lastShift;
           lastShift = shiftTimes[i];
           
           //calcuate RPMs
           shiftRPMs[i] = this._engineModel.getRPM(timeSinceShift, i+1);
       }       
   }

   private double shiftTime(){
       int i = gear-1;
       if(i >= this.shiftTimes.length)
           i = this.shiftTimes.length-1;
       
       return this.shiftTimes[i];
   }
   private int shiftRPM(){
       int i = gear-1;
       if(i >= this.shiftTimes.length)
           i = this.shiftTimes.length-1;
       
       return this.shiftRPMs[i];
   }
   
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    *
    * Implement Parts 3 and 4 here.
    */
   @Override
   public boolean update(final double timeStep)
   {
          super.update(timeStep);

        //update stuff
        int currRPM = this._engineModel.getRPM(timeInGear, gear);
        
        double shiftTime = this.shiftTime();
        if(time >= shiftTime){
            int newGear = gear + 1;
            //if we can shift
            if(newGear <= GEAR_RATIOS.length){
                this.gear++;
                this.gearRatio = GEAR_RATIOS[gear-1];
                this.timeInGear = 0;
                
                currRPM = this._engineModel.getRPM(timeInGear, gear);
            }                
        }
        
        this.report(currRPM);
        
        //calculate distance delta we covered during the time-step we just finished!
        double distanceDelta = (currRPM / SECONDS_PER_MINUTE) * timeStep * gearRatio * FEET_PER_REVOLUTION;                
        //apply updates to cumulative values.
        this.distance += distanceDelta;
        //update time
        this.time += timeStep;
        this.timeInGear += timeStep;
        //calculate speed 
        this.speed = (distance/FEET_PER_MILE) / (time / SECONDS_PER_MINUTE/MINUTES_PER_HOUR);
           
        


        //check done
        if(distance >= TRACK_LENGTH_FEET){
            report(currRPM);
            return true;
        }
        return false;
   }
  
    private void report(int currRPM){
        this.printTimeFormatted();
        System.out.print((int)Math.round(distance) +",");
        System.out.print((int)Math.round(speed) + ",");
        System.out.print(gear + ",");
        System.out.print(currRPM +",");
        System.out.println(this.shiftRPM());
   }
    private void printTimeFormatted(){
        DecimalFormat format = new DecimalFormat("0.00");
        System.out.print(format.format(time) + ",");
    }
}
