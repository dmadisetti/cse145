import java.util.*;
public class ConcertPromotor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Concert concert = new Concert();
		System.out.println("Welcome to the Concert Promotion tool!");
		String input = "";
		while(input.equalsIgnoreCase("quit")!= true)
		{
			System.out.println("Currently the concert featuring the band "+concert.getName());
			System.out.println("Has sold "+concert.getNumberOfTicketsSoldByPhone()+" tickets by phone");
			System.out.println("Has sold "+concert.getNumberOfTicketsSoldAtVenue()+" tickets at the venue");
			System.out.println("And has grossed $"+concert.TotalSales());
			
			System.out.println("What would you like to do?\n" +
					"Enter 1: To change name\n" +
					"Enter 2: To change ticket by phone price\n" +
					"Enter 3: To change ticket at venue price\n" +
					"Enter 4: To add tickets by phone\n" +
					"Enter 5: To add tickets at the venue\n" +
					"Enter 6: To find out how many tickets are remaining\n" +
					"Enter 7: To find out how many total tickets have been sold\n" +
					"Enter 8: To change the venue's capacity\n" +
					"Enter 9: To start a new concert\n" +
					"Enter 0: To Quit\n");
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the name of the band");
				concert.setName(keyboard.nextLine());
				break;
			case 2:
				System.out.println("Enter the new price by phone");
				concert.setPriceByPhone(keyboard.nextDouble());
				break;
			case 3:
				System.out.println("Enter the new price at the venue");
				concert.setPriceAtVenue(keyboard.nextDouble());
				break;
			case 4:
				System.out.println("Enter a number of tickets to add by phone");
				concert.BuyTicketsByPhone(keyboard.nextInt());
				break;
			case 5:
				System.out.println("Enter a number of tickets to add at the venue");
				concert.BuyTicketsAtVenue(keyboard.nextInt());
				break;
			case 6:
				System.out.println("The number of tickets remaining are "+concert.TicketsRemaining());
				break;
			case 7:
				System.out.println("The number of tickets sold are "+concert.TotalNumberOfTicketsSold());
				break;
			case 8:
				System.out.println("Enter the new capacity");
				concert.setCapacity(keyboard.nextInt());
				break;
			case 9:
				System.out.println("Starting a new concert");
				System.out.println("Enter the name of the band");
				String name = keyboard.next();
				System.out.println("Enter the capacity of the venue");
				int capacity = keyboard.nextInt();
				System.out.println("Enter the price by phone");
				double priceByPhone = keyboard.nextDouble();
				System.out.println("Enter the price at the venue");
				double priceAtVenue = keyboard.nextDouble();
				concert = new Concert(name,capacity,priceByPhone,priceAtVenue);				
				break;
			case 0:
				input = "quit";
				break;
				
			}
		}

	}

}
