import java.util.InputMismatchException;
import java.util.Scanner;

public class Run_Account {

    protected static Scanner account = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("Thank you for choosing Belmont's Airlines Corporation ");

        System.out.println("Please enter the account name: ");
        Account.setName(account.nextLine());

        System.out.println("Please enter the user's birthday: ");
        Account.setValidBirthday(account.nextLine());

        System.out.println("Please enter the account password: ");
        Account.setPassword(account.nextLine());

        System.out.println("Please enter a four-digit account pin: ");
        Account.setPin(account.nextInt());

        Account.getAccountInfo();

        System.out.println("---------------------------------------------------------");

        System.out.println("Today's flight schedule: ");
        Airline bu = new Airline();
        Airline.printTodaySchedule();


        System.out.println("How can BAC serve u today?");
        System.out.println("Please type in 1 to see your options.");

        int entry = account.nextInt();

            while (entry <= 5 && entry != 0) {

                System.out.println("1: View Available Flights ");
                System.out.println("2: Book a Flight ");
                System.out.println("3: View your Booked Ticket ");
                System.out.println("4: Change Your Password");
                System.out.println("5: Quit");
                System.out.println("How can BAC serve u today?");
                System.out.println("Please select an option, 1-5");

                try {
                    entry = account.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("This is an invalid selection. Please select an option between 1-5");
                    account.next();
                }

                if (entry == 1) {
                    System.out.println("Here are our available flights:");

                    Airline.printAvailableFlights();

                    System.out.println("If you would like to book a flight please press 2");
                    if(!account.hasNextInt()){
                        System.out.println("Please press 2 to book a flight.");
                    }

                    entry = account.nextInt();

                }
                if (entry == 2) {

                    System.out.println("What flight would you like to book?");
                    System.out.println("All flights will depart at BNA");
                    System.out.println("Please type in the origin airport you wish to arrive in. Here is a list of available flights");

                    Airline.printAvailableFlights();

                    System.out.println();

                    Airline.setTicket(account.next());
                    Airline.getTicket();

                    System.out.println("Thank you for flying with BAC");


                }
                if (entry == 3) {

                    if(Airline.flight != null) {
                        System.out.println(Airline.departureDate + " and arrive at " + Airline.flight);
                        System.out.println("Thank you for flying with BAC");
                    }
                    else if(Airline.flight == null){
                        System.out.println("You have not booked a ticket. Please press 2 to book a ticket. ");
                    }

                }
                if (entry == 4) {

                        System.out.println("What would you like to change your password to?");

                        Account.password = account.next();

                        System.out.println("Your new password is " + Account.password);
                        Account.getAccountInfo();

                }
                if (entry == 5) {

                    System.out.println("Thank you for flying with BAC");

                    System.exit(0); //quits program
                    break;
                }
            }

            if (entry > 5 || entry == 0 || !account.hasNextInt()) {

                System.out.println("Please select an option between 1-4");

            }
        }
    }
