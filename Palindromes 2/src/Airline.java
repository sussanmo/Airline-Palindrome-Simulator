import java.util.ArrayList;

public class Airline {

    private static ArrayList<String> flights  = new ArrayList<>(); //collection of flights
    protected static String departureDate;
    protected static String flight;
    private static double ticketPrice = 150; //flat rate of 150 for each ticket


    public Airline(){
        flights.add("ATL: Atlanta, GA at 6:00PM ");
        flights.add("GRU: Cancun, Mexico at 12:00PM ");
        flights.add("ORD: Chicago, IL at 1:15PM ");
        flights.add("YYZ: Toronto, Canada  at 2:45AM ");
        flights.add("JFK: New York City, NY at 4:10AM ");
        flights.add("LHR: London, United Kingdom at 6:15AM ");
        flights.add("LAX: Los Angeles, CA at 3:30PM ");
        flights.add("OKA: Okinawa, Japan at 6:15AM ");
        flights.add("BOS: Boston, MA at 9:35AM ");
        flights.add("BCN: Barcelona, Spain at 1:40PM ");


    }

    //prints first 2 flights in the arraylist flight collection
    public static void printTodaySchedule(){
        for(int i =0; i < 2; i++){
            System.out.println(flights.get(i));
        }
    }

    //prints all elements in the arraylist flight collection
    public static void printAvailableFlights(){
        for (String s : flights) {
            System.out.println(s);
        }
    }

    //sets user's flight based on whether user's desired transit airport is a valid airport option
    public static void setTicket(String airport) {

        //compares user input to each individual airport offered
            //sets user's flight to corresponding arraylist flight
            //sets a departure date
            //prints out flight info and price info
        if(airport.equals("ATL")){
         flight = flights.get(0);
             departureDate = "Your are scheduled to depart BNA at 7:30PM";
            System.out.println("Your ticket info: " + flight + " Price $" + (ticketPrice*2));
         }
        if(airport.equals("GRU")){
            flight = flights.get(1);
            departureDate = "Your are scheduled to depart BNA at 1:00AM";
            System.out.println("Your ticket info: "  + flight + " Price $" + (ticketPrice*5));
        }
        if(airport.equals("ORD")){
            flight = flights.get(2);
            departureDate = "Your are scheduled to depart BNA at 2:15PM";
            System.out.println("Your ticket info: " + flight + " Price $" + (ticketPrice*2.3));
        }
        if(airport.equals("YYZ")){
            flight = flights.get(3);
            departureDate = "Your are scheduled to depart BNA at 8:10AM";
            System.out.println("Your ticket info: " + flight + " Price $" + (ticketPrice*5.9));
        }
        if(airport.equals("JFK")){
            flight = flights.get(4);
            departureDate = "You are scheduled to depart BNA at 5:12PM";
            System.out.println("Your ticket info: " + flight + " Price $" + (ticketPrice*3) );
        }
        if(airport.equals("LHR")){
            flight = flights.get(5);
            departureDate = "You are scheduled to depart BNA at 12:00PM";
            System.out.println("Your ticket info: "  + flight + "  Price $" + (ticketPrice*5.3));
        }
        if(airport.equals("LAX")){
            flight = flights.get(6);
            departureDate = "You are scheduled to depart BNA at 12:00AM";
            System.out.println("Your ticket info: " + flight + " Price $" + (ticketPrice*3.2));
        }
        if(airport.equals("OKA")){
            flight = flights.get(7);
            departureDate = "You are scheduled to depart BNA at 2:00PM";
            System.out.println("Your ticket info: " + flight + " Price $" + (ticketPrice*6.8));
        }
        if(airport.equals("BOS")){
            flight = flights.get(8);
            departureDate = "You are scheduled to depart BNA at 2:24AM";
            System.out.println("Your ticket info: " + flight + " Price $" + (ticketPrice*2.8));
        }
        if(airport.equals("BCN")){
            flight = flights.get(9);
            departureDate = "You are scheduled to depart BNA at 12:00PM";
            System.out.println("Your ticket info: " + flight + " $" + (ticketPrice*7.3));
        }
        else if (flight == null) { //prompts user to select another flight if flight field is still null after checking each airport
           System.out.println("BAC does not connect to this airport. Please check the available flight and select again.");
        }
    }

    //gets flight info if flight has been booked
    //returns user's current flight booking
    public static String getTicket(){
        if(flight == null){
            System.out.println("You have not booked a ticket. Please book a ticket. ");
        }
        return departureDate + flight ;
    }
}
