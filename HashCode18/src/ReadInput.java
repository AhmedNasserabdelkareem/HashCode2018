import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ReadInput {
    int [][] ridesArr ;
    int rows ;
    int coloumns ;
    int vehicles ;
    int rides;
    int bonus ;
    int maxSteps ;
    
	public void read(File file) throws FileNotFoundException {
		

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
    	}
    }
	
	}
	
	
	

}