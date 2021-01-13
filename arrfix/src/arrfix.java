/*
Hamilton Nguyen 1000538439 08/8/2018
 */
import java.util.ArrayList;
import java.util.Scanner;

   public class arrfix {

/*This method should return an integer entered by the user*/

public static int getUserInput(){ //var type must be int

Scanner in=new Scanner(System.in);
System.out.println("Enter a number or -1 to quit.");
boolean done=true;
int n=0;

/*This while loop should run until the user enters a number-once a
number is entered, the loop should terminate*/
while(done){
    try{
        n=in.nextInt();
        done=false; //boolean done must be variable assign to false
    }
    catch(Exception e){
    System.out.println("That is not a number. Please enter an number.");
    in.nextLine();
        }
    }
    return n; //must return value in as n
}

/*This method should take an ArrayList of integers and print out
all elements*/
public static ArrayList<Integer> printOutList(ArrayList<Integer> a){ //modify return type before the method and inside the parameter

    System.out.println("Currently in the list:");
    for(int i=0;i<a.size();i++){
    
        /*Each element is printed out*/
System.out.printf("%d ", a.get(i)); //use array method .get to fetch data from an array
}
System.out.println("\n");

return a; //return an array, a, when its done fetching printing out  
}
    public static void main(String[] args) {
        
        /*Declare an ArrayList of integers*/
    ArrayList<Integer> numbers=new ArrayList<Integer>();
    int n;
    
    do{
        n=getUserInput();
        if(n==-1)
        {
            System.out.println("Bye!");
            return;
        }
        
        /*Check if the ArrayList already has the number entered by the user*/
        else if(numbers.contains(n)) //add method to compare contained data entered previously by user
        {
            System.out.println("Already have this number.");
        }

        /*Add the number given by the user to the ArrayList */
        else
        {
            numbers.add(n); //change method using add method to an array
        }
        printOutList(numbers);

    }

    while(n!=-1);
    
    }
    
}
