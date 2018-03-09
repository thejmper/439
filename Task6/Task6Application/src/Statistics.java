/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan
 */
public class Statistics {
 
    public static double GetAverage(double[] values){
        double total = 0;
        for(int i = 0; i < values.length; i++){
            total += values[i];
        }
        return total/(double)values.length;
    }
    
    public static double GetStandardDeviation(double[] values, double average){
        double sd = 0;
        for (int i=0; i<values.length;i++)
        {
            {
                sd += ((values[i] - average)*(values[i] - average)) / (values.length - 1);
            }
        }
        return Math.sqrt(sd);
    }
}
