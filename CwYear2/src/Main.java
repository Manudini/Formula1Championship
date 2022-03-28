import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String option;
        Formula1ChampionshipManager f1 = new Formula1ChampionshipManager(); //creating an object from Formula1ChampionshipManager
        f1.loadFile();  //loading previous data from the file in the beginning

        System.out.println();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<< FORMULA 1 RACING CAR CHAMPIONSHIP >>>>>>>>>>>>>>>>>>>>>>>>>");

        while(true) {         // printing the menu
            System.out.println();
            System.out.println("       MENU   ");
            System.out.println("Enter 1 to add a new driver");
            System.out.println("Enter 2 to remove a driver");
            System.out.println("Enter 3 to change the driver");
            System.out.println("Enter 4 to display the statistics");
            System.out.println("Enter 5 to view the driver's table ");
            System.out.println("Enter 6 to add a race");
            System.out.println("Enter 7 to save the details to file ");
            System.out.println("Enter 8 to exit from the program");
            System.out.println();
            System.out.println("Enter the option you want: ");

            option = input.nextLine();

            if (option.equals("1")) {
                f1.createNewDriver();
            } else if (option.equals("2")) {
                f1.deleteDriver();
            } else if (option.equals("3")) {
                f1.changeDriver();
            }else if(option.equals("4")){
                f1.displayStatistics();
            }else if(option.equals("5")){
                f1.displayDriverTable();
            }else if(option.equals("6")){
                f1.addRace();
            }else if(option.equals("7")){
                f1.saveToFile();
            } else if(option.equals("8")){
                System.out.println("Exiting from the program....");
                break;
            }
            else {
                System.out.println("Sorry!! Invalid option.Please enter a valid input");
            }

        }

    }


}
