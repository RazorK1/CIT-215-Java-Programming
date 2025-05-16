/*
Kyle Harris
CIT-215-D01
*/

import java.util.*;

public class Main 
{
    private static Scanner scan = new Scanner(System.in);
    
    public static void main(String [] args) 
    {
        System.out.println("You've found the magic portal!");
        System.out.println("You get to choose where to go,");
        System.out.println("But you don't know where you'll go.");
        System.out.println("Try not to die.");
        System.out.println("Pick a number between 1 and 5.");
        System.out.println();

        String choice = scan.nextLine();

        if (choice.equals("1"))
        {
            Option1();
        }
        else if (choice.equals("2"))
        {
            Option2();
        }
        else if (choice.equals("3"))
        {
            Option3();
        }
        else if (choice.equals("4"))
        {
            Option4();
        }
        else if (choice.equals("5"))
        {
            Option5();
        }
    }
    
//////////////////////////////////////////////////

    //Option 1 --->  Macau, China
    public static void Option1()
    {
        System.out.println("You've arrived in Macau, China!");
        System.out.println("Do you like gambling?");
        System.out.println("y for yes, n for no");

        String choice = scan.nextLine().toLowerCase();

        if (choice.equals("y"))
        {
            System.out.println("You lose all your money gambling.");
            System.out.println("You live, but you're broke.");
        }
        if (choice.equals("n"))
        {
            System.out.println("The local government is furious with you and");
            System.out.println("pushes you back into the portal.");
            Option3();
        }
    }//End of Option1

    //Option 2 ---> Prague, Czech Republic
    public static void Option2()
    {
        System.out.println("Congratulations! You've arrived in Prague!");
        System.out.println("Do you drink alcohol?");
        System.out.println("y for yes, n for no");

        String choice = scan.nextLine().toLowerCase();

        if (choice.equals("y"))
        {
            System.out.println("You have a great time drinking with the locals.");
            System.out.println("But you drink too much and sustain alcohol poisoning.");
            System.out.println("You died.");
        }
        if (choice.equals("n"))
        {
            System.out.println("...");
            System.out.println("...");
            System.out.println("...");
            System.out.println("The local population is furious with you and");
            System.out.println("pushes you back into the portal.");
            System.out.println("...");
            System.out.println("Oh no! The portal is a time machine too!");  
            //1744 Saxony    
            System.out.println("You've arrived in Saxony");
            System.out.println("The year is 1744.");
            System.out.println("Frederick II (King of Prussia) has invaded Saxony");
            System.out.println("The Second Silesian War has started.");
            System.out.println("Frederick asks you for directions to Bohemia.");
            System.out.println("Do you give him the right directions?");
            System.out.println("y for yes, n for no");

            choice = scan.nextLine().toLowerCase();

            if (choice.equals("y"))
            {
                System.out.println("You give Frederick the right directions.");
                System.out.println("Frederick thanks you a rewards you gold.");
                System.out.println("You live! And you're wealthy");
            }
            if (choice.equals("n"))
            {
                System.out.println("Frederick becomes lost and fails to destroy");
                System.out.println("the Austrian army.");
                System.out.println("Frederick finds you and is furious.");
                System.out.println("He orders your execution");
                System.out.println("You died.");
            }
        }
    }//End of Option2

    //Option 3 ---> 1453 Constantinople, Byzantium (Eastern Roman Empire)
    public static void Option3()
    {
        System.out.println("...");
        System.out.println("Oh no! The portal is a time machine too!");
        System.out.println("The year is 1453.");
        System.out.println("You've arrived in the city of Constantinople");
        System.out.println("...");
        System.out.println("The Ottomans are besieging the city!");
        System.out.println("Do you fight or surrender?");
        System.out.println("y for fight");
        System.out.println("n for surrender");

        String choice = scan.nextLine().toLowerCase();

        if (choice.equals("y"))//Yes to fight
        {
            System.out.println("Orban the Hungarian engineer walks in and");
            System.out.println("offers you to sell you an advanced cannon.");
            System.out.println("Do you accept?");
            System.out.println("y for yes, n for no");
            System.out.println();

            choice = scan.nextLine().toLowerCase();

            if (choice.equals("y"))
            {
                System.out.println("You accept the advanced cannon from Orban");
                System.out.println("You use the cannon to blast the sultan's camp.");
                System.out.println("You saved the city!");
                System.out.println("You live!");
            }
            if (choice.equals("n"))
            {
                System.out.println("You reject the offer for the advanced cannon.");
                System.out.println("Orban sells the cannon to Sultan Mehmed II.");
                System.out.println("The sultan blasts a hole in the city's walls.");
                System.out.println("You are killed in the fighting.");
                System.out.println("You died.");
                
            }
        }
        if (choice.equals("n"))//No to surrender
        {
            System.out.println("You've surrendered to the Ottomans.");
            System.out.println("Sultan Mehmed II thanks you for surrendering.");
            System.out.println("Do you feel lucky?");
            System.out.println("y for yes, n for no");
            System.out.println();

            choice = scan.nextLine().toLowerCase();

            if (choice.equals("y"))
            {
            System.out.println("The sultan orders your execution and");
            System.out.println("you are beheaded.");
            System.out.println("You died.");
            }
            if (choice.equals("n"))
            {
            System.out.println("You are enslaved into the Ottoman's Janissaries.");
            System.out.println("You live!");
            }
        }
    }//End of Option3

    //Option 4 ---> Kursk, Russia
    public static void Option4()
    {
        System.out.println("...");
        System.out.println("Oh no! You're in Russia!");
        System.out.println("...");
        System.out.println("A Russian soldier hands a you a military summons.");
        System.out.println("Do you run away?");
        System.out.println("y for yes, n for no");
        System.out.println();

        String choice = scan.nextLine().toLowerCase();

        if (choice.equals("y"))
        {
            System.out.println("You've run away!");
            Option5();

        }
        if (choice.equals("n"))
        {
            System.out.println("You've joined the Russian Army.");
            System.out.println("You are sent to Ukraine.");
            System.out.println("...");
            System.out.println("You encounter a Ukrainian soldier.");
            System.out.println("Ви російський військовий?");//Ukrainian
            System.out.println("y for yes, n for no");

            choice = scan.nextLine().toLowerCase();

            if (choice.equals("n"))
            {
                System.out.println("Я вам не вірю. Я беру тебе в полон");//Ukrainian
                System.out.println("...");
                System.out.println("You are taken prisoner");
                System.out.println("You live!");
            }
            if (choice.equals("y"))
            {
                System.out.println("you are killed by a Ukrainian drone.");
                System.out.println("You died.");
            }
        }
    }//End of Option4

    //Option 5 ---> Stepanakert, Nagorno-Karabakh, (Azerbaijan)
    public static void Option5()
    {
        System.out.println("You've arrived in Stepanakert, Nagorno-Karabakh, Azerbaijan!");
        System.out.println("...");
        System.out.println("Are you Armenian or Azeri?");
        System.out.println("Press 1 if you're Armenian.");
        System.out.println("Press 2 if you're Azeri.");

        String choice = scan.nextLine();

        if (choice.equals("1"))
        {
            System.out.println("You are beaten up my the Azerbaijani military and then");
            System.out.println("deported to Yerevan.");
            System.out.println("...");
            System.out.println("...");
            System.out.println("...");
            //Yerevan, Armenia
            System.out.println("You've arrived in Yerevan");
            System.out.println("You live, but just barely.");
        }
        if (choice.equals("2"))
        {
            System.out.println("WELCOME HOME!");
            System.out.println("You live!");
        }

    }//End of Option5

}//End of Main

//////////////////////////////////////////////////////////////////
// System.out.println(); 

//System.out(0); 

/*
        if (choice.equals())
        {
            System.out.println();
        }
*/ 
