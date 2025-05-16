/*
Kyle Harris
CIT-215-D01
*/

import java.util.*;

public class Main 
{
  
  public static void main(String [] args) 
  {
    Scanner scan = new Scanner(System.in);
    String answer = "";

    // Construct a Pet object:
    // You can use the default constructor or 
    // Ask the user for some pet info and
    // read answer: answer = scan.nextLine();
    // or answer = scan.nextInt();
    // and then construct a Pet object with data
	
    System.out.println("Enter your pets name: ");
    String petName = scan.nextLine();

    Pet p = new Pet(petName);
    
    while (!answer.equals("q"))
    {
        System.out.println("Game menu");
        System.out.println("1. Drink");
        System.out.println("2. Sleep");
        System.out.println("3. Play");
        System.out.println("Choose a number option above or q to quit: ");
        answer = scan.nextLine();
		
        if (answer.equals("1"))
		 {
           p.drink();
         } 
		 else if (answer.equals("2"))
		 {
           p.sleep();
         } 
		 else if (answer.equals("3"))
		 {
           p.play();
         } 
		 else if (answer.equals("q"))
		 {
           System.out.println("Good bye!");
         } 
		 else 
		 {
          System.out.println("Invalid input, please try again. ");
         } 
		 
      }
	  
    }
	
}
