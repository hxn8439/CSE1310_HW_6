/*
Hamilton Nguyen 1000538439 08/8/2018
 */
package albumstuff;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class AlbumCollection {
    
public static ArrayList<String> readFile(String filename) {
        File temp=new File(filename);
        Scanner input_file;
        
        try {
            input_file=new Scanner(temp);
        }
        catch(Exception e) {
            System.out.printf("Failed to open file %s\n\n",filename);
            return null;
        }
        ArrayList<String> result=new ArrayList<>();
        
        while(input_file.hasNextLine()) {
            String line=input_file.nextLine();
            result.add(line);
        }
        input_file.close();
        return result;
    }
    
    public static ArrayList<String> readFile() {
        String filename=getUserInput("Enter filename");
        
        File temp=new File(filename);
        Scanner input_file;
        
        try {
            input_file=new Scanner(temp);
        }
        catch(Exception e) {
            System.out.printf("Failed to open file%s\n\n",filename);
            return null;
        }
        ArrayList<String> result=new ArrayList<>();
        
        while(input_file.hasNextLine()) {
            String line=input_file.nextLine();
            result.add(line);
        }
        input_file.close();
        return result;
    }
     
    public static void fileOutput(ArrayList<String> toFile,String filename) {
        PrintWriter out=null;
        
        try {
            out=new PrintWriter(filename);
        }
        catch(Exception e) {
            System.out.printf("Error: failed to open file %s.\n",filename);
            System.exit(0);
        }
        String input="";
        
        for(int i=0;i<toFile.size();i++) {
            out.println(toFile.get(i));
        }
        
        out.close();
        System.out.printf("Done writing to output2.txt\n");
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
        String input="";
        
        for(int i=0;i<toFile.size();i++) {
            out.println(toFile.get(i));
        }
        out.close();
        System.out.printf("Done writing to output2.txt\n");
    }
    
    public static String[] getInfo(String s,String regex) {
        String[] info=s.split(regex);
        return info;
    }
    
    public static String getUserInput(String s) {
        System.out.println(s);
        Scanner in=new Scanner(System.in);
        return in.nextLine();
    }

 ArrayList<Album> allAlbums=new ArrayList();
    
    public AlbumCollection() {
        ArrayList<String> fileInfo=null;
        
        while(fileInfo==null) {
            String f=getUserInput("Enter file name:");
            fileInfo=readFile(f);
        }
        
        for(int i=0;i<fileInfo.size();i++) {
            String st=fileInfo.get(i);
            String[] info=getInfo(st,"-|\\(|\\)");
            Album a=new Album(info);
            allAlbums.add(a);
        }
    }
    
    public ArrayList<String> printOutAlbum() {
        System.out.println("\n\n***Albums by Year***");
        ArrayList<String> ret=new ArrayList();
                
        for(int i=0;i<allAlbums.size();i++) { 
        //This section is missing a catch for repeat years
            Album a=allAlbums.get(i);
            
            System.out.printf("\n--%s: \n",a.year);
            ret.add("\n--"+a.year+": \n");
                
            for(int j=0;j<allAlbums.size();j++) {
                Album a1=allAlbums.get(j);
                    
                if(a1.year.equals(a.year)) {
                    System.out.println(a1.song);
                    ret.add(a1.song+"\n");
                }
            }
            ret.add("\n");
        }
        return ret;        
    }
    
}
