
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

//=============================================================================================================================================================
//
// Jonathan Pfefferle
//
// IMPLEMENT THIS CLASS HOWEVER YOU WANT, BUT DO NOT CHANGE THE SIGNATURES OF Analyzer(), addEntry(), or printResults(). YOU MUST USE addEntry() TO GET THE
// DATA; DO NOT ACCESS OTHER CLASSES IN THE PROJECT (UNLESS THEY ARE YOURS).
//
public class Analyzer
{
    //--member fields--//
    /**
     * keyed list of recordings for each body
     */
    private HashMap<String, List<Entry>> bodies;
    
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public Analyzer()
   {
       this.bodies = new HashMap<>();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public void addEntry(final long step, final double time, final String id, final double x, final double y)
   {
       //System.out.println("<log>: "+ step + "," + time + "," + id + "," + x + "," + y);
        
       Entry entry = new Entry(step, time, id, x,y);
       
       //create a new bodies list if we don't have one already
       if(!bodies.containsKey(entry.id)){
           bodies.put(id, new ArrayList<>());
       }
       
       //insert the entry into the approriate list
       bodies.get(id).add(entry);       
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   public void printResults()
   {
      System.out.println("<your metrics here for all bodies>");
      
        Collection<List<Entry>> values = bodies.values();
        
        for(List<Entry> list : values){
            ProcessEntries(list);
        }
      
   }
   
   private void ProcessEntries(List<Entry> entries){
        //velocity between frames
        double[] velocity = new double[entries.size()-1];
        double[] acceleration = new double[entries.size()-2];
        
        double totalDisplacement = 0;
        
        
        //cache our last viewed
        Entry lastEntry = entries.get(0);
        
        for(int i = 1; i < entries.size(); i++){
            Entry curr = entries.get(i);
            
            double dx = curr.x - lastEntry.x;
            double dy = curr.y - lastEntry.y;
            
            //just the pythagorean distance formula dist = sqrt (x1-x2) + (y1-y2)
            double dPos = Math.sqrt((dx * dx) + (dy * dy));
            totalDisplacement += dPos;            
                        
            //velocity is just distance/time
            velocity[i-1] = Math.abs(dPos / curr.step); 
            
            if(i >= 2){
                double lastVelocity = velocity[i-2];
                
                double deltaV = velocity[i-1] - lastVelocity;                
                acceleration[i-2] = Math.abs(deltaV/ curr.step);
            }
            
            lastEntry = curr;           
        }
        
        
        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println("Body: " + lastEntry.id);
        System.out.println("Time: " + df.format(lastEntry.time));
        System.out.println("Distance: " + df.format(totalDisplacement));
        
        Statistics stats = new Statistics(velocity);
        System.out.println("Velocity:");
        System.out.println("    Min: " + (stats.Min()));   
        System.out.println("    Max: " + (stats.Max()));
        System.out.println("    Avg: " + (stats.getMean()));
        System.out.println("    Std: " + (stats.getStdDev()));
        
        stats = new Statistics(acceleration);
        System.out.println("Acceleration:");
        System.out.println("    Min: " + (stats.Min()));   
        System.out.println("    Max: " + (stats.Max()));
        System.out.println("    Avg: " + (stats.getMean()));
        System.out.println("    Std: " + (stats.getStdDev()));
        
        System.out.println("\n");
   }
   
   
   
   
   
   private class Entry{
       public long step;
       public double time;
       public String id;
       public double x;
       public double y;
       
       public Entry(long step, double time, String id, double x, double y){
           this.step = step;
           this.time = time;
           this.id = id;
           this.x = x;
           this.y = y;
       }
   }
}
