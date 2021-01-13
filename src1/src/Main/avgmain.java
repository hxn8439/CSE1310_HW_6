/*
Hamilton Nguyen 1000538439 08/8/2018
 */
package Main;

import filecontent .filehandling;
import static filecontent.filehandling.fileQuery;
import static filecontent.filehandling.genFile;
import java.util.ArrayList;

import java.util.Scanner;

public class avgmain {
     public static void main(String []args){
     
     Scanner in=new Scanner(System.in);
        String fcol,scol;
        int fpos,spos;
        String[][] Data=genFile();
        
        do {
            System.out.println("\nEnter first column to find.");
            fcol=in.nextLine();
            fpos=fileQuery(Data,fcol);
            
        }
        while(fpos==-1);
        
        do {
            System.out.println("\nEnter second column to find.");
            scol=in.nextLine();
            spos=fileQuery(Data,scol);
            
        }
        while(spos==-1);
        
        System.out.printf("\n**Avg of: %s and %s:**\n\n",fcol,scol);
        
        for(int i=0;i<Data.length-1;i++) {
            double avg1=Double.parseDouble(Data[i+1][fpos]);
            double avg2=Double.parseDouble(Data[i+1][spos]);
            System.out.printf("%s: %.2f\n",Data[i+1][0],((avg1+avg2)/2));
        }
                
        ArrayList<String> step=filehandling.convert2D(Data,",");
        filehandling.fileOutput(step);
     
     
     
     }
}
