//==============================================================
//
// Title: Text File Input And Output With File Specification
// Description:
//   This program demonstrates reading from and writing to a
// text file per file specification:
//
//   Field             Type     Start-End
//   Planet            string      1-14
//   Escape Velocity   real       15-30
//   Mean Temperature  integer    31-52   
//   Number of Moons   integer    53-74
//
//   This file contains a header row.
//
//==============================================================
package wsu.TextFileInputAndOutputWithFileSpecification;

// Import classes
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//==============================================================
// class TextFileInputAndOutputWithFileSpecification
//==============================================================
public class TextFileInputAndOutputWithFileSpecification
{
    
    //----------------------------------------------------------------
    // Constants
    //----------------------------------------------------------------
	
	// Declare file constants
    public static final String FILE_NAME = "PlanetDataEnglish.txt ";
    public static final String FILE_NAME2 = "PlanetDataMetric.txt ";
    public static final int COL1_START = 0;
    public static final int COL1_END = 14;
    public static final int COL2_START = 15;
    public static final int COL2_END = 30;
    public static final int COL3_START = 31;
    public static final int COL3_END = 52;
    public static final int COL4_START = 53;
    public static final int COL4_END = 74;
	
	// Declare formatting constants
    public static final String COLFMT1 = "%-" + COL1_END + "s";
    public static final String COLFMT2 = "%" + 
		(COL2_END - COL2_START + 1) + ".1f";
    public static final String COLFMT3 = "%" + 
		(COL3_END - COL3_START + 1) + "d";
    public static final String COLFMT4 = "%" + 
		(COL4_END - COL4_START + 1) + "d";
    
    //----------------------------------------------------------------
    // Variables
    //----------------------------------------------------------------
    private static String header;
    
    //----------------------------------------------------------------
    // readTextFile
    //----------------------------------------------------------------
    public static void readTheData(String[] planets, double[]velocities, int[] temperatures, int[] moons)
    {
        // Declare variables
        Scanner fileIn = null;
        boolean headerRead;
        String line;
        int dataCount;
    
        // Attempt to open input file
        try
        {
        	
        	// Assign external file to file handle
            fileIn = new Scanner(new FileInputStream(FILE_NAME));
        
            // Loop to read data
            headerRead = false;
            dataCount = 0;
            while (fileIn.hasNextLine())
            {
                
                // Read line and test if header row
                line = fileIn.nextLine();
            	if (!headerRead)
            	{
            		System.out.println(line);
            		header = line;
            		headerRead = true;
            	}
            	else
            	{

                    // Parse input line and store tokens
            		planets[ dataCount]=line.substring(COL1_START, COL1_END).trim();
            		 velocities[dataCount]=Double.parseDouble(line.substring(COL2_START, COL2_END).trim());
            		 temperatures[dataCount]=Integer.parseInt(line.substring(COL3_START, COL3_END).trim());
            		 moons[dataCount]=Integer.parseInt(line.substring(COL4_START, COL4_END).trim());

                    // Print tokens
//    System.out.printf(COLFMT1 + COLFMT2 + COLFMT3 + COLFMT4 + "%n", planets[dataCount],  velocities[dataCount], temperatures[dataCount], 
//                		moons[dataCount]);

                    // Increment line counter
                    dataCount = dataCount + 1;
            		
            	}

            }
            
            // Show number of lines read
         

            // Close input file
            fileIn.close();
            
        }
        
        // Handle file error
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file '" + FILE_NAME +  "' not found.");
            System.out.println("Error message:\n" + e.getMessage());
        }
     
    }
    // print array
    public static void Printarray(String[] planets, double[]velocities, int[] temperatures, int[] moons) 
    {
    // Loop to write data
     int  dataCount = 0;
        // System.out.println(header);
    for (int i = 0; i < planets.length; i++)
    {
   
        // Write tokens
    	
  System.out.printf(COLFMT1 + COLFMT2 + COLFMT3 + COLFMT4 + "%n", planets[dataCount], velocities[dataCount], temperatures[dataCount], moons[dataCount]);

        // Increment line counter
        dataCount = dataCount + 1;

    }
    System.out.println("\n" + dataCount + " data line(s) " + "read from file '" + FILE_NAME + "'.");
    }
    // convertArrays
      
    public static void convertArrays(double[]velocities, int[] temperatures)
    {
    	double count;
    	for(int i=0;i<temperatures.length;i++)
    	{
    		count=(temperatures[i]-32/1.8);
    		temperatures[i]=(int)count;
    		count=velocities[i]/0.62137;
    		velocities[i]=count;
    	}
    	System.out.println("\n Convert Arrays");
    	header= "Planet        Escape Velocity (Km/s)   Mean Temperature (C)    Number of Moons";
    	
    	
    }
    // print array
  
     //) Bubblesort method 
    public static void BubbleSort(String[] planets, double[]velocities, int[] temperatures, int[] moons) 
	 {
	    String  t;
	    double t2;
	    int t3,t4;
	   
	    int dataCount=0;
	    
	    for(int i=0; i<planets.length; i++)
	    {
	        for(int j=0; j<planets.length-1-i; j++)
	        {
	        if(planets[j].compareTo(planets[j+1])>0)
	        {
	            t= planets[j];
	            planets[j] = planets[j+1];
	            planets[j+1] = t;
	            
	            t2= velocities[j];
	            velocities[j] = velocities[j+1];
	            velocities[j+1] = t2;
	            
	            t3= temperatures[j];
	            temperatures[j] = temperatures[j+1];
	            temperatures[j+1] = t3;
	            
	            t4= moons[j];
	            moons[j] = moons[j+1];
	            moons[j+1] = t4;
	            
	        }
	    }
	    }
	    
	    for(int i=0; i<planets.length; i++)
	    {
	    	 System.out.printf(COLFMT1 + COLFMT2 + COLFMT3 + COLFMT4 + "%n", planets[dataCount],  velocities[dataCount], temperatures[dataCount], 
             		moons[dataCount]);
                 // Increment line counter
                 dataCount = dataCount + 1;
	    }
	    }
      
    //----------------------------------------------------------------
    // writeTextFile
    //----------------------------------------------------------------
    public static void writeTheData(String[] planets, double[]velocities, int[] temperatures, int[] moons)
    {
        
        // Declare variables
        PrintWriter fileOut = null;
        int dataCount;

        // Attempt to open output file
        try
        {
        	
        	// Assign external file to file handle
            fileOut = new PrintWriter(new FileOutputStream(FILE_NAME2));
            
            // Loop to write data
            dataCount = 0;
            fileOut.println(header);
            for (int i = 0; i < planets.length; i++)
            {

                // Write tokens
            	
          fileOut.printf(COLFMT1 + COLFMT2 + COLFMT3 + COLFMT4 + "%n", planets[dataCount], velocities[dataCount], temperatures[dataCount], moons[dataCount]);

                // Increment line counter
                dataCount = dataCount + 1;

            }
            
            // Show number of lines written
            System.out.println("\n" + dataCount + " data line(s) " + "written to file '" + FILE_NAME2 + "'.");
                
            // Close output file
            fileOut.close();

        }
        
        // Handle file error
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file '" + FILE_NAME2 +
                "' cannot be created or opened.");
            System.out.println("Error message: " + e.getMessage());
        }
    
    }

    //----------------------------------------------------------------
    // main
    //----------------------------------------------------------------
    public static void main(String[] args)
    {
        
        // Declare variables
    	
        String [] planets = new String [9];
        double[] velocities = new double[9];
        int[] temperatures = new int[9];
        int[] moons = new int[9];
        int dataCount=0;
        // Show application header
        System.out.println("Welcome to Text File Input And Output " +
    		"With File Specification");
        System.out.println("--------------------------------------" +
    		"-----------------------\n");

        // Load data from text file
        readTheData(planets, velocities, temperatures, moons);
        // print array
         Printarray( planets, velocities,temperatures,  moons); 
        // Write data to text file
         convertArrays(velocities, temperatures);
         Printarray( planets, velocities,temperatures,  moons);
         BubbleSort(planets,velocities, temperatures,  moons) ;
        writeTheData(planets, velocities, temperatures, moons);
     
        // Show application close
       
        
        System.out.println("\nEnd of Text File Input And Output " +
    		"With File Specification");

    } 

} 