/*
Kyle Harris
CIT-215-D01
*/

import java.util.Scanner;

public class EmailVlad //Vlad the email validator
{
    public static void ValidateEmail(String email)//'email' KEEP TRACK OF THIS STRING!
    {
        boolean ValidInput = true; //If false, you have problems.

        //Checks 'email' for Null (empty) imput.
        if (email.isEmpty())
        {
            System.out.println("Email field is empty.");
            ValidInput = false;
            return;
        }

        //Checks 'email' for less than (>) 30 characters.
        if (email.length() > 30)
        {
            System.out.println("Email field must be < 30 characters");
            ValidInput = false;
            return;
        }

        //Checks if 'email' contains "@student.stcc.edu"
        if (!email.endsWith("@student.stcc.edu"))
        {
            System.out.println("Email must end with @student.stcc.edu");
            ValidInput = false;
            return;
        }

        //Checks if 'email' contains a singular '@'.
        int iAtSignFinder = email.length() - email.replace("@", "").length();//God I hope this works.
        if(iAtSignFinder != 1)
        {
            System.out.println("Can only contain a singular @ character.");
            ValidInput = false;
            return;
/*

*/

        }

        //Checks if 'email' starts with a letter.
        char firstChar = email.charAt(0); //possibly char(1)
        if(!Character.isLetter(firstChar))
        {
            System.out.println("Email must start with a letter.");
            ValidInput = false;
            return;
        }

        //Checks for # $ % & characters.
        char[] badCharizards = {'#', '$', '%', '&'}; //Characters to look for
        //char[] badCharizard = {}; //Holds character in the for loop.
        for (char badCharizard : badCharizards)
        {
            if(email.contains(String.valueOf(badCharizard)))
            {
            System.out.println("Email can't contain: " + badCharizard);
            ValidInput = false;
            return;
            }
        }//End of for loop

        //Checks if email addresses match. WORK ON THIS!!!!!!!!!!!
        String myEmail = "";
        if (email.equals(myEmail))
        {
            System.out.println("That's my email address!");
        }
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        //Username Extraction
        String userName = email.substring(0, email.indexOf('@'));
        System.out.println("Username: " + userName);

        //Count the number of letters
        int iLetterCount = countLetters(userName); //DON'T FORGET TO MAKE THIS FUNCTION countLetters fuction!
        System.out.println("Number of letters in username: " + iLetterCount);

        //Check for ValidInput being true.
        if (ValidInput)
        {
            System.out.println("Email is Valid.");
        }

    }//End of public static void ValidateEmail(String email)

    public static int countLetters(String userName)
    {
        int iLetterCounter = 0;
        for (int i = 0; i < userName.length(); i++)
        {
            if (Character.isLetter(userName.charAt(i)))
            {
                iLetterCounter++;
            }
        }
        return iLetterCounter;
    }//End of countLetters function.

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email address:");
        String email = scanner.nextLine();

        ValidateEmail(email);
    }//End of main function.

}//End of Vlad the Emailer (public class EmailVlad)
