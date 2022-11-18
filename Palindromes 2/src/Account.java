/* Name: Suad Mohamed
        # Date: 4/19/2022
        # Class: CSC 1120
        # Pledge: I have neither given nor received unauthorized aid on this
      program.
        # Description: This program stimulates an airline account creation. It checks to see if a user's password input is
        a palindrome which is a word, phrase, or sequence that reads the same backward as forward.
        # Input: The user types in their name, password, birthdate, and an account pin. The user also chooses
        # Output:The program will display whether a user's inputted password is considered a palindrome. The program also displays a
        number of flight options for the user to select.
play. */


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class Account {
    private static String name;
    private static String birthdate;
    protected static String password;
    private static String pin;

    //class constructor
    public Account() {

    }

    //takes in user input to set acccount name
    public static void setName(String nameEntry){
        name = nameEntry;
    }

    //takes in user input to set account password
    public static void setPassword(String passEntry){
        password = passEntry;
    }

    //takes in user input to set account pin
    public static void setPin (Integer pinEntry){
        if(pinEntry.toString().length() == 4){ //only sets pin if user input is 4 digits long
            pin = pinEntry.toString();
        }
        else if(pin==null){   //prompts user to try again if desired pin doesn't meet 4 digit criteria
            System.out.println("This is an invalid pin entry.");
            System.out.println("Please enter a four-digit account pin: ");
            System.out.println("For example, 1234 ");
            Run_Account.account.nextLine(); //prompts user's next entry
        }
    }


    //checks if user birthday input is a valid birthday
    public static void setValidBirthday(String birthEntry) {

        SimpleDateFormat sample = new SimpleDateFormat("MM/dd/yyyy"); //creates required pattern for user Birthday input

        boolean validDate = false; //variable to check whether user input is a valid calendar entry


        while(!validDate) { //loops as long as birthday entry is invalid

            try {

                Date samp = sample.parse(birthEntry); //changes SimpleDateForm object into Date object
                validDate = true; //if previous method call works then birthday entry is valid
                birthdate = birthEntry; //stores birthday entry since its valid

            } catch (Exception e) { //catches Exception thrown for any invalid bday entries

                System.out.println("This is an invalid birthday entry.");
                System.out.println("A birthday must be in the format MM/DD/YYYY");
                System.out.println("Please enter a valid user's birthday entry.");

                setValidBirthday(Run_Account.account.nextLine()); //recursively begins method again in order until user has valid birthday entry
                return; //ends loop as soon as valid birthday entry is given
            }
        }
    }



    //prints out all account details
        public static void getAccountInfo() {

            if (name != null && birthdate != null && pin != null && password != null) { //checks to see if each account
                                                                                        //detail has a valid entry
                System.out.println(name + "'s Account details: ");
                System.out.println("Birthdate: " + birthdate);
                System.out.println("Pin: " + pin);
                System.out.println("Password: " + password);
                checkPalindrome(); //calls for method to check whether password is a palindrome
            }
            //checks to see if indivual account components exists
            //prompts user to set null account component if it doesn't exists
            //recursively recalls this method to check each component again
            else if(name == null){
                System.out.println("You do not inputted the correct criteria for one or more of your account details.");
                System.out.println("Please set your account name");

                setName(Run_Account.account.next());

                getAccountInfo();
            }
            else if(birthdate == null) {
                System.out.println("You do not inputted the correct criteria for one or more of your account details.");
                System.out.println("Please set your birthdate");

                setValidBirthday(Run_Account.account.next());

                getAccountInfo();
            }
            else if(pin == null) { //checks wehther
                System.out.println("You do not inputted the correct criteria for one or more of your account details.");
                System.out.println("Please set your account pin");

                setPin(Run_Account.account.nextInt());

                getAccountInfo();
            }
            else if(password == null) {
                System.out.println("You do not inputted the correct criteria for one or more of your account details.");
                System.out.println("Please set your account password");

                setPassword(Run_Account.account.next());

                getAccountInfo();
            }
        }

        //checks whether password is a palindrome
        public static void checkPalindrome() {

            Stack<Character> passwordStack; //temporary stack of characters to represent user's password entry
            passwordStack = new Stack<>();

            String character = ""; //placeholder for characters of user's desired password

            for (int i = 0; i < password.length(); i++) { //loops through each character and adds it to stack in reverse
                passwordStack.push(password.charAt(i));
            }

            while (!passwordStack.isEmpty()) { //adds characters of stack into String variable in order to compare it later
                character = character + passwordStack.pop();
            }

            if (password.equals(character)) { //compares current password and password characters in reverse order
                    System.out.println("Your password is a palindrome.");
                    //System.out.println("ts1");
            }

             if(!password.equals(character)) {
                System.out.println("Your password is not a palindrome.");
            }
        }
    }
