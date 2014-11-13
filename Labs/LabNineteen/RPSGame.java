import java.util.Scanner;
public class RPSGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean gameOver = false;
		RPSHumanPlayer human = new RPSHumanPlayer();
		RPSComputerPlayer computer = new RPSComputerPlayer();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to the rock paper scissors game!");
		while(gameOver == false)
		{
			System.out.println("Enter either \"rock\", \"paper\", or \"scissors\" to compete");
			human.chooseGesture();
			computer.chooseGesture();
			
			System.out.println("You picked "+human.getGesture());
			System.out.println("The computer picked "+computer.getGesture());
			
			if(human.getGesture().equals("rock"))
			{
				if(computer.getGesture().equals("paper"))
				{
					System.out.println("You lose!");
					computer.setPoints(computer.getPoints()+1);
				}
				else if(computer.getGesture().equals("scissors"))
				{
					System.out.println("You win!");
					human.setPoints(human.getPoints()+1);
				}
				else
				{
					System.out.println("Tie");
				}
			}
			else if(human.getGesture().equals("paper"))
			{
				if(computer.getGesture().equals("scissors"))
				{
					System.out.println("You lose!");
					computer.setPoints(computer.getPoints()+1);
				}
				else if(computer.getGesture().equals("rock"))
				{
					System.out.println("You win!");
					human.setPoints(human.getPoints()+1);
				}
				else
				{
					System.out.println("Tie");
				}
			}
			else if(human.getGesture().equals("scissors"))
			{
				if(computer.getGesture().equals("rock"))
				{
					System.out.println("You lose!");
					computer.setPoints(computer.getPoints()+1);
				}
				else if(computer.getGesture().equals("paper"))
				{
					System.out.println("You win!");
					human.setPoints(human.getPoints()+1);
				}
				else
				{
					System.out.println("Tie");
				}
			}
			else
			{
				System.out.println("You lose!");
				computer.setPoints(computer.getPoints()+1);
			}
			
			System.out.println("You have "+human.getPoints()+" points");
			System.out.println("The computer has "+computer.getPoints()+" points");
			System.out.println("Press enter to continue or enter \"quit\" to quit");
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("quit"))
			{
				gameOver = true;
				System.out.println("Good bye");
			}
		}
		
	}

}
