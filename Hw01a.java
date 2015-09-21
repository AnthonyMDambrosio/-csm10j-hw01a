/*
    Programmer : Anthony D'Ambrosio

    Date       : 9/21/2015

    Purpose    : This program displays stock prices that are read from a file.

    Limitations: User entered data can conflict with the data types causing the
                 program to crash.
                 
                 Must have a stocks.txt file in the same folder as the 
                 Hw01a.java
*/

//package hw01a;
import java.io.*;
import java.util.*;

public class Hw01a
{
    static Scanner console = new Scanner(System.in);
    
    public static void main( String[] args ) throws FileNotFoundException
    {
        /* Creates the txt file used for debugging. 
         PrintWriter outFile = new PrintWriter("stocks.txt");
         outFile.println("AAPL 101.50");
         outFile.println("MSFT 42.50");
         outFile.close();
        */
        
        // Variables being declared.
        Scanner inFile = new Scanner(new FileReader("stocks.txt"));
        
        String firstStr,
               secondStr,
               userInputStr;
        
        double firstNum,
               secondNum,
               userInputPrice;
        
        int userInputMenuChoice;
     
        
        // Variables being initialized.
        firstStr = inFile.next();
        firstNum = inFile.nextDouble();
        
        secondStr = inFile.next();
        secondNum = inFile.nextDouble();
       
        
        // Closing the file.
        inFile.close();
        
        
        // Converting the strings to lowercase for comparisons.
        firstStr = firstStr.toLowerCase();
        secondStr = secondStr.toLowerCase();
        
        
        // For debugging purposes only.
        /*
        System.out.print(firstStr + " " + firstNum);
        System.out.print(" ");
        System.out.println(secondStr + " " + secondNum );
        System.out.println();
        */
       
        
        // Menu
        System.out.println("Enter '1' to get price by stock ticker");
        System.out.println("Enter '2' to get stocks greater than or equal to "
                + "specified price");
        System.out.println("Enter '3' to quit");
        System.out.print("Your choice: ");
        userInputMenuChoice = console.nextInt();
        System.out.println();
        
       
        switch (userInputMenuChoice)
        {
            case 1:
                System.out.print("Enter a stock ticker: ");
                userInputStr = console.next();
                System.out.println();
                userInputStr = userInputStr.toLowerCase();
               
                if (userInputStr.equals( firstStr ))
                    System.out.printf( firstStr.toUpperCase() + 
                            " current price is %.2f\n", firstNum );
                
                if (userInputStr.equals( secondStr ))
                    System.out.printf( secondStr.toUpperCase() + 
                            " current price is %.2f\n", secondNum );
               
                break;
            case 2:
                System.out.print("Enter a price: ");
                userInputPrice = console.nextDouble();
                System.out.println();
                
                
                if ( firstNum >= userInputPrice )
                    System.out.printf( firstStr.toUpperCase() + 
                            " is more than %.2f\n", userInputPrice );
                
                if ( secondNum >= userInputPrice )
                    System.out.printf( secondStr.toUpperCase() + 
                            " is more than %.2f\n", userInputPrice );
                
                if ( ( firstNum < userInputPrice ) && 
                        ( secondNum < userInputPrice ) )
                    System.out.printf("Both are less than %.2f\n", 
                            userInputPrice);
                
                break;
            case 3:
                System.out.println("Goodbye");
                break;
            default: 
                System.out.println("Invalid");
                break;
                        
        }
        
    }
    
}
