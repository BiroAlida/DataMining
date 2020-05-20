
package allamvizsga;

import static java.lang.Math.sqrt;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LinearRegression {
     public static ArrayList<String> Reg(String inputChannelId) throws SQLException
     {
         //List<Double> xArray  = new ArrayList<>(Arrays.asList(30400.0,30400.0,30400.0,30400.0,30400.0,30400.0,30400.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30700.0,30700.0,30700.0,30700.0,30700.0));
         //List<Double> xArray  = new ArrayList<>(Arrays.asList(30400.0,30400.0,30400.0,30400.0,30400.0,30400.0,30400.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30500.0,30600.0,30600.0,30600.0,30600.0,30600.0,30600.0,30700.0,30700.0,30700.0,30700.0,30700.0));
        
        ArrayList dateAndSubs = new ArrayList<>(); 
         List<Double> xArray  = new ArrayList<>();     
         xArray = DataMining.getSubsOfLast30Days(inputChannelId);
         List<Double> yArray = InitializeY(xArray);
                
         Double meanX = 0.0, meanY = 0.0;
         meanX = countMean(xArray);
         meanY = countMean(yArray);
      
         
        Double sum1 = 0.0, sum2 = 0.0, sum3 = 0.0, r = 0.0, Sy = 0.0, Sx = 0.0, b = 0.0, a = 0.0;
        
        ArrayList<String> basicChannelStatistics = new ArrayList();
        try {
               basicChannelStatistics = DataMining.getChannelStatistics(inputChannelId);
            
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Double y=0.0, x = 0.0; // x annak az erteke amennyi Subscribert szeretnek elerni pl 30800   
        x = Double.parseDouble(basicChannelStatistics.get(0)) + 200.0; // az aktualis subscriber szam + 200-at nezem mindig
        
        sum1 = SumArray(MultiplyArrays(ValueMinusMean(meanX, xArray),ValueMinusMean(meanY, yArray)));
        sum2 = SumArray(ExpArrayElements(ValueMinusMean(meanX, xArray)));
        sum3 = SumArray(ExpArrayElements(ValueMinusMean(meanY, yArray)));
        r = sum1 / sqrt(sum2 * sum3);
        Sy = sqrt(sum3/(xArray.size() - 1));
        Sx = sqrt(sum2/(xArray.size() - 1));
        b = r * (Sy/Sx);
        a = meanY - b * meanX;
        y = a + (b * x);
      
        String oldDate = DataMining.getFirstDateOfSubsCount(inputChannelId);
	System.out.println("Date before Addition: "+oldDate);
        
	//Specifying date format that matches the given date
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar c = Calendar.getInstance();
	try{
	   
	   c.setTime(sdf.parse(oldDate));
	}catch(ParseException e){
		e.printStackTrace();
	 }
	  
	c.add(Calendar.DAY_OF_MONTH, y.intValue());  // ennyit adok hozza ahhoz a datumhoz ahonnan elkezdtem szamolni a subsciber szamot
	
	String newDate = sdf.format(c.getTime()); 
	System.out.println("Date after Addition: "+newDate);
        
        dateAndSubs.add(String.valueOf(x.intValue()));
        dateAndSubs.add(newDate);
       // LocalDateTime datetime = LocalDateTime.parse(newDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //System.out.println(datetime);
        return dateAndSubs;                      
     }
     
     public static List<Double> InitializeY(List<Double> xArray)
     {
         Double counter = 0.0;
         List<Double> yArray = new ArrayList<>();
         for(int i=0;i<xArray.size();++i)
         {
             yArray.add(counter);
             counter++;
         }
         
         return yArray;
     }
     
     public static Double countMean(List<Double> xArray)
     {
         Double sum = 0.0,mean =0.0;
         for(int i=0;i<xArray.size();++i)
         {
             sum += xArray.get(i);
         }
         mean = sum / xArray.size();
         return mean;
     }
     
     public static List<Double> ValueMinusMean(Double mean, List<Double> xArray)
     {
         List<Double> arr = new ArrayList<>();
         for(int i=0;i<xArray.size();++i)
         {
             Double newValue = 0.0;
             newValue = xArray.get(i) - mean;
             arr.add(newValue);  
         }
         
         return arr;
     }
     
     public static List<Double> MultiplyArrays (List<Double> arr1, List<Double> arr2)
     {
         List<Double> multiplied = new ArrayList<>();
         for(int i=0;i<arr1.size();++i)
         {
             Double mult = 0.0;
             mult = arr1.get(i) * arr2.get(i);
             multiplied.add(mult);
         }
         
         return multiplied;
     }
     
     public static Double SumArray(List<Double> arr)
     {
         Double sum = 0.0;
         for(int i=0;i<arr.size();++i)
         {
             sum += arr.get(i);
         }
         
         return sum;
     }
     
     public static List<Double> ExpArrayElements(List<Double> arr)
     {
         List<Double> exponent = new ArrayList<>();
        
         for(int i=0;i<arr.size();++i)
         {
             Double exp = 0.0;
             exp = arr.get(i) * arr.get(i);
             exponent.add(exp);
         }
         return exponent;
     }
             
}
