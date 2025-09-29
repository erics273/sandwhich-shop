package com.pluralsight;

import java.util.Scanner;

public class SandwichApp {
    public static void main(String[] args) {

        //create the scanner
        Scanner theScanner = new Scanner(System.in);

        //Ask the user what size sammy
        System.out.println("What size Sammy would you like?");
        System.out.println("\t1: Regular: $5.45");
        System.out.println("\t2: Large: $8.95");
        System.out.print("What size would you like? ");

        //store the users selection
        int sammySize = theScanner.nextInt();

        //start a running total for the order
        double total = 0;

        //update the total based on the sammy size
        if (sammySize == 1) {
            total += 5.45;
        } else if (sammySize == 2) {
            total += 8.95;
        } else {
            System.out.println("\nInvalid Selection, try again!\n");
            System.exit(0);
        }

        //all worked out with the sammy size selection, lets figure out the discount
        int discount = 0;

        //Ask the user what size sammy
        System.out.println("How old are you?");
        System.out.println("\t <= 17 gets 10% off");
        System.out.println("\t >=65 gets 20% off");
        System.out.print("Enter your age: ");

        int customerAge = theScanner.nextInt();

        if (customerAge <= 17) {
            discount = 10;
        } else if (customerAge >= 65) {
            discount = 20;
        }

        //eat the newline because we are going from collecting
        //numbers to strings
        theScanner.nextLine();

        //Ask the user what size sammy
        System.out.println("Would you like your loaded");
        System.out.println("\tRegular: $1.00 up charge");
        System.out.println("\tLarge: $1.75 up charge");
        System.out.print("Please say (y/n) ");

        String isLoaded = theScanner.nextLine();

        double loadedUpcharge = 0;
        if(isLoaded.equalsIgnoreCase("y")){

            if(sammySize == 1){
                loadedUpcharge = 1.00;
            }else if (sammySize == 2){
                loadedUpcharge = 1.75;
            }

        }

        total = total - (total * discount /100) + loadedUpcharge;

        String size = "";
        if(sammySize == 1){
            size = "Regular";
        } else if (sammySize == 2) {
            size = "Large";
        }

        //Ask the user what size sammy
        System.out.printf("The total for your %s sandwich is: $%.2f\n", size, total);

        if(discount > 0){
            System.out.println("This includes your " + discount + "% discount");
        }
    }
}
