package com.pluralsight;

import java.util.Scanner;

public class SandwichMethodsApp {

    //creating the scanner at the class level
    static Scanner theScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //this just lets us know if the app should stay running or die
        boolean appRunning = true;

        //start the point of sales system
        while(appRunning == true){

            //run the code that asks for the sammy size and store it in sammySize variable
            int sammySize = sammySizeSelection();

            double total = 0;
//            if(sammySize == 1){
//                total += 5.45;
//            } else if (sammySize == 2) {
//                total += 8.95;
//            }else {
//                System.out.println("\nInvalid Selection, try again!\n");
//                continue;
//            }

            switch (sammySize){
                case 1:
                    total += 5.45;
                    break;
                case 2:
                    total += 8.95;
                    break;
                default:
                    System.out.println("\nInvalid Selection, try again!\n");
                    continue;
            }

            //all worked out with the sammy size selection, lets figure out the discount
            int discount = 0;
            try{

                int customerAge = ageSelection();
                if(customerAge <= 17){
                    discount = 10;
                } else if (customerAge >= 65) {
                    discount = 20;
                }

            }catch (Exception e){
                System.out.println("\nInvalid age but that's okay, we'll start over\n");
                //clear the buffer before we start over
                theScanner.nextLine();
                continue;
            }

            theScanner.nextLine();

            String isLoaded = isSammyLoaded();

            double loadedUpcharge = 0;
            if(isLoaded.equalsIgnoreCase("y")){

                if(sammySize == 1){
                    loadedUpcharge = 1.00;
                }else if (sammySize == 2){
                    loadedUpcharge = 1.75;
                }

            }


            total = total - (total * discount /100) + loadedUpcharge;

            displayTotal(sammySize, total, discount);

            String orderAnother = orderAnotherSammy();

            if(!orderAnother.equalsIgnoreCase("y")){
                appRunning = false;
            }


        }


    }

    public static int sammySizeSelection() {

        //Ask the user what size sammy
        System.out.println("What size Sammy would you like?");
        System.out.println("\t1: Regular: $5.45");
        System.out.println("\t2: Large: $8.95");
        System.out.print("What size would you like? ");

        int choice = theScanner.nextInt();

        return choice;

    }

    public static String isSammyLoaded() {

        //Ask the user what size sammy
        System.out.println("Would you like your loaded");
        System.out.println("\tRegular: $1.00 up charge");
        System.out.println("\tLarge: $1.75 up charge");
        System.out.print("Please say (y/n) ");

        String choice = theScanner.nextLine();

        return choice;

    }

    public static int ageSelection() {

        //Ask the user what size sammy
        System.out.println("How old are you?");
        System.out.println("\t <= 17 gets 10% off");
        System.out.println("\t >=65 gets 20% off");
        System.out.print("Enter your age: ");

        int age = theScanner.nextInt();

        return age;

    }

    public static void displayTotal(int sammySize, double total, int discount) {

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

    public static String orderAnotherSammy() {

        //Ask the user what size sammy
        System.out.print("Would you like to order another Sammy? (Y/N) ");
        return theScanner.nextLine();

    }

}