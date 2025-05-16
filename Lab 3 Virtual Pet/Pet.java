/*
Kyle Harris
CIT-215-D01
*/

// Add a Pet class here
public class Pet 
{
  // Add 3 instance variables
  public String name;
  public int thirst;
  public int happiness;

  // Add Constructor
  public Pet(String petName)
  {
    name = petName;
    thirst = 100;
    happiness = 100;
  } 
  
  // Add 3 simple methods for the pet with no arguments
  public void play()
  {
    happiness += 20;
    if (happiness > 100) 
	{
        happiness = 100;
    }
	
    thirst -= 10;
    if (thirst < 0) 
	{
        thirst = 0;
    }
	
    System.out.println(name + " played!");
    System.out.println("New happiness level: " + happiness);
    System.out.println("New thirst level: " + thirst);
  }
  
  public void drink()
  {
    thirst += 30;
    if (thirst > 100) 
	{
        thirst = 100;
    }
	
    System.out.println(name + " ate!");
    System.out.println("New happiness level: " + happiness);
    System.out.println("New thirst level: " + thirst);
	
  }
  
  public void sleep()
  {  
    happiness -= 5;
	
    if (happiness < 0) 
	{
        happiness = 0;
    }
	
    thirst -= 20;
	if (thirst < 0) 
	{
        thirst = 0;
    }
	
    System.out.println(name + " slept!");
    System.out.println("New happiness level: " + happiness);
    System.out.println("New thirst level: " + thirst);
	
  }
  
  public void print()
  {
    System.out.println("Pet Info: ");
    System.out.println("Name: " + name);
    System.out.println("thirst: " + thirst);
    System.out.println("Happiness: " + happiness);

  }
  
}
