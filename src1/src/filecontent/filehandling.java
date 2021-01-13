/*
Hamilton Nguyen 1000538439 08/8/2018
 */
package filecontent;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class filehandling {

public static String[][] genFile()
{
ArrayList<String> lines=null;

Scanner in=new Scanner(System.in);

while(lines ==null) 
{
System.out.println("Enter file name:");
String fileName=in.nextLine();
lines=readFile(fileName); 
}

String[][] result = new String[lines.size()][]; 
for (int i = 0; i < lines.size(); i++)
{
String line = lines.get(i); 
result[i] = line.split(","); 
}

return result; 
}

public static ArrayList<String> readFile(String filename)
{
File temp = new File(filename); 
Scanner input_file; 
try
{
input_file = new Scanner(temp); 
}
catch (Exception e) 
{
System.out.printf("Failed to open file %s\n\n",
filename);

return null; 
}

ArrayList<String> result = new ArrayList();
while(input_file.hasNextLine())
{
String line = input_file.nextLine(); /*we a line from the file*/ 
result.add(line); /*we add that line to our ArrayList*/
}

input_file.close(); 

return result; 
}


public static int fileQuery(String[][] file,String entry) {
        for (int i=0;i<file[0].length;i++){
            if(entry.equals(file[0][i])) {
                return i;
            }
        }
        System.out.println("Sorry,we didn't find it.\n");
        return -1;
    }


public static ArrayList<String> convert2D(String[][] a,String delimiter) {
        ArrayList<String> l=new ArrayList();
        int rows=a.length;
        int columns=a[0].length;
        String s="";
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                String s2=a[i][j];
                s=s+" "+s2;
                s=s+delimiter;
            }
            l.add(s.substring(1,s.length()-1));
            s="";
        }
        return l;
    }
    
    public static void fileOutput(ArrayList<String> toFile) {
        String filename=getUserInput("\n---Enter filename to save to:");
        PrintWriter out=null;
        
        try {
            out=new PrintWriter(filename);
        }
        catch(Exception e) {
            System.out.printf("Error: failed to open file %s.\n",filename);
            System.exit(0);
        }
        
        for(int i=0;i<toFile.size();i++) {
            out.println(toFile.get(i));
        }
        out.close();
        System.out.printf("Done writing to file %s.\n",filename);
    }


public static String getUserInput(String message)
{
System.out.println(message);
Scanner in=new Scanner(System.in);
return in.nextLine();

}    
}