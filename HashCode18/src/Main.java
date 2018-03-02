import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int [][] ridesArr ;
    static int rows ;
    static int coloumns ;
    static int vehicles ;
    static int rides;
    static int bonus ;
    static int maxSteps ;
    
    
    public static void main (String[] args)
    {
    try {
		read(new File("a_example.in"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	Vehicle[] vehicle = new Vehicle[vehicles];
    	//System.out.println(vehicles);
    	Ride[] ride = new Ride[rides];
    	for (int i=0;i<rides;i++) {
    		ride[i]= new Ride();
   		
    			ride[i].setEarliest(ridesArr[i][4]);
    			ride[i].setFinalX(ridesArr[i][2]);
    			ride[i].setFinalY(ridesArr[i][3]);
    			ride[i].setLatest(ridesArr[i][5]);
    			ride[i].setStartX(ridesArr[i][0]);
    			ride[i].setStartY(ridesArr[i][1]);
    			ride[i].setValid(true);
    		
    	}
    	for(int stepCounter =0 ,rideCounter=0 ;stepCounter<maxSteps&&rideCounter<rides ; stepCounter++) {
    		for(int vehiclesCounter=0;vehiclesCounter<vehicles;vehiclesCounter++) {
    			if ( vehicle[vehiclesCounter]==null) {
        			vehicle[vehiclesCounter]= new Vehicle();

    			}
    			int min = Integer.MAX_VALUE;
    	    	int minIndex = 0;
    	    	int total=0;
    	    	int rideSteps=0,vehicleSteps=0,delay=0;
    	    	
    			if(vehicle[vehiclesCounter].available) {
    				for(int ridesCounter=0 ; ridesCounter<rides;ridesCounter++) {
    					if(ride[ridesCounter].isValid()) {
    						rideSteps = ride[ridesCounter].getSteps();
    						vehicleSteps = Math.abs(vehicle[vehiclesCounter].currentX-ride[ridesCounter].getStartX())+Math.abs(vehicle[vehiclesCounter].currentY-ride[ridesCounter].getStartY());
    						delay = ride[ridesCounter].getEarliest()-(vehicleSteps+stepCounter);
    						
							if(delay>0) total = rideSteps+vehicleSteps+delay;
							else total = rideSteps+vehicleSteps;
							 if(total<min) {
								 min = total;
								 minIndex = ridesCounter;
							 }							 
    					}   					
    				}
    				vehicle[vehiclesCounter].assignRide(minIndex,total,ride[minIndex].getFinalX(),ride[minIndex].getFinalY());
    				ride[minIndex].setValid(false);
    				rideCounter++;
    			}
    			else {
    				vehicle[vehiclesCounter].decrease();
    			}
    		}
    	}
    	
    	File c = new File("Output.txt");
    	try {
			FileWriter bf = new FileWriter(c);
			for(int i=0;i<vehicle.length;i++)
	    	{
	    		bf.write((i+1)+" ");
	    		for(int j=0;j<vehicle[i].rides.size();j++)
	    		{
	    			bf.write(vehicle[i].rides.get(j)+" ");
	    		}
	    		bf.write("\n");
	    	}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
	public static void read(File file) throws FileNotFoundException {
		

    Scanner sc = new Scanner(file);
    rows = sc.nextInt();
    coloumns = sc.nextInt();
    vehicles = sc.nextInt();
    rides = sc.nextInt();
    bonus = sc.nextInt();
    maxSteps = sc.nextInt();
    ridesArr = new int [rides][6];

    for(int i=0;i<rides;i++) {
    	for (int j=0;j<6;j++) {
    		ridesArr[i][j] = sc.nextInt();
    		//System.out.print(ridesArr[i][j]+" ");
    	}
    	//System.out.println();
    }
	
	}
	
}