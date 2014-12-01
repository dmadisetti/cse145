
public class SimplePVPGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Simple PVP Game");
		RPGPlayer p1 = new RPGPlayer("player1.txt");
		RPGPlayer p2 = new RPGPlayer("Bob", 100, 10, 5.5,"Rat on a Stick");
		
		System.out.println("Player 1");
		p1.printInfo();
		System.out.println();
		System.out.println("Player 2");
		p2.printInfo();
		
		boolean gameOver = false;
		boolean isPlayer1sTurn = true;
		while(gameOver == false)
		{
			//The winning condition
			if(p1.getHP()<=0||p2.getHP()<=0)
			{
				System.out.println("The battle is over!");
				if(p1.getHP()<=0)
					System.out.println(p2.getName()+" has won!");
				else
					System.out.println(p1.getName()+" has won!");
				break;
			}
			else if(isPlayer1sTurn)
			{
				Turn(p1,p2);
				isPlayer1sTurn = false;
			}
			else
			{
				Turn(p2,p1);
				isPlayer1sTurn = true;
			}
			System.out.println();
		}
		p1.writePlayerFile("results.txt");
		
		RPGPlayer p1Clone = new RPGPlayer("results.txt");
		System.out.println();
		System.out.println("The player was cloned after the battle and has the following stats");
		p1Clone.printInfo();
	}
	public static void Turn(RPGPlayer player, RPGPlayer opponent)
	{
		//Try to run away!
		if(player.getHP()<10)
		{
			if(player.getSpeed()>opponent.getSpeed())
			{
				System.out.println(player.getName()+" has run away! And falling rocks killed "+opponent.getName());
				opponent.setHP(0);
			}
			else
			{
				System.out.println(player.getName()+" cannot run away "+opponent.getName()+" is too fast!");
			}
		}
		else//ATTACK!
		{
			System.out.println(player.getName() + " attacks with "+player.getWeapon());
			opponent.setHP(opponent.getHP()- player.getStrength());
			System.out.println(opponent.getName()+" now has "+opponent.getHP()+" HP");
		}
	}

}
