/**
* @author  Dylan Madisetti
* @version 1.0, Oct 21, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/


public class Concert{

    private String name = "Nameless";
    private int capacity = 0;
    private static int numberOfTicketsSoldByPhone = 0;
    private static int numberOfTicketsSoldAtVenue = 0;
    private double priceByPhone = 0.00;
    private double priceAtVenue = 0.00;


    // Constructors are constructorful
    public Concert(){}

    public Concert(String aName,int aCapacity,double aPriceOfTicketByPhone,double aPriceOfTicketAtVenue){
        this(aName, aCapacity,numberOfTicketsSoldByPhone,numberOfTicketsSoldAtVenue,aPriceOfTicketByPhone,aPriceOfTicketAtVenue);
    }

    public Concert(String aName,int aCapacity,int aNumberofTicketsSoldByPhone,int aNumberOfTicketsSoldAtVenue,double aPriceOfTicketByPhone,double aPriceOfTicketAtVenue){
        setName(aName);
        setCapacity(aCapacity);
        setNumberofTicketsSoldByPhone(aNumberofTicketsSoldByPhone);
        setNumberOfTicketsSoldAtVenue(aNumberOfTicketsSoldAtVenue);
        setPriceByPhone(aPriceOfTicketByPhone);
        setPriceAtVenue(aPriceOfTicketAtVenue);
    }


    // Getters
    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getNumberOfTicketsSoldByPhone(){
        return numberOfTicketsSoldByPhone;
    }
    public int getNumberOfTicketsSoldAtVenue(){
        return numberOfTicketsSoldAtVenue;
    }
    public double getPriceOfTicketByPhone(){
        return priceByPhone;
    }
    public double getPriceOfTicketAtVenue(){
        return priceAtVenue;
    }


    // Setters
    public void setName(String aName){
        name = aName;
    }
    public void setCapacity(int aCapacity){
        if (validiate(aCapacity))
            capacity = aCapacity;

    }
    private void setNumberofTicketsSoldByPhone(int aNumberofTicketsSoldByPhone){
        if (validiate(aNumberofTicketsSoldByPhone))
            numberOfTicketsSoldByPhone = aNumberofTicketsSoldByPhone;

    }
    private void setNumberOfTicketsSoldAtVenue(int aNumberOfTicketsSoldAtVenue){
        if (validiate(aNumberOfTicketsSoldAtVenue))
            numberOfTicketsSoldAtVenue = aNumberOfTicketsSoldAtVenue;

    }
    public void setPriceByPhone(double aPriceOfTicketByPhone){
        if (validiate(aPriceOfTicketByPhone))
            priceByPhone = aPriceOfTicketByPhone;
    }
    public void setPriceAtVenue(double aPriceOfTicketAtVenue){
        if (validiate(aPriceOfTicketAtVenue)) 
            priceAtVenue = aPriceOfTicketAtVenue;
    }

    private boolean validiate(double number){
        if(number >= 0) return true;
        System.out.println("Bad");
        return false;
    }

    private boolean isSold(int number){
        if (TotalNumberOfTicketsSold() + number < capacity) return false;
        if(TotalNumberOfTicketsSold() + number == capacity){
            System.out.println("Just sold out");
            return false;
        }
        if(TicketsRemaining() != 0){
            System.out.println(TicketsRemaining() + " remaining. Can't sell this many");
        
        }else{
           System.out.println("Sold out");
        }
        return true;
    }

    //No parameters
    //Returns the value of the phone tickets plus the venue tickets
    public int TotalNumberOfTicketsSold(){
        return numberOfTicketsSoldByPhone + numberOfTicketsSoldAtVenue;
    }

    //No parameters
    //Returns the value of the capacity minus the total number of tickets sold
    public int TicketsRemaining(){
        return capacity - TotalNumberOfTicketsSold();        
    }

    //1 parameter that corresponds to the number of tickets being bought
    //returns nothing
    public void BuyTicketsAtVenue(int number){
        if (validiate(number) && !isSold(number))
            numberOfTicketsSoldAtVenue += number;
    }
    //1 parameter that corresponds to the number of tickets being bought
    //returns nothing
    public void BuyTicketsByPhone(int number){
        if (validiate(number) && !isSold(number))
            numberOfTicketsSoldByPhone += number;
    }

    //No parameters
    //Returns the value of the ticket at the venue times the number of tickets sold at the venue, plus the tickets by phone times the price of a phone ticket
    public double TotalSales(){
        return priceByPhone * numberOfTicketsSoldByPhone + priceAtVenue * numberOfTicketsSoldAtVenue;
    }
}