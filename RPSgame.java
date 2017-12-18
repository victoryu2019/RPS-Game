import java.util.Scanner;
public class RPSGame 
{
	private Player player;
	private Computer computer;
	private int playerScore;
	private int computerScore;
	private int numberOfGames;
	private int userMoney;
	private int computerMoney;
	private int betvalue;
	
	public RPSGame() 
	{
		player = new Player();
		computer = new Computer();
		playerScore = 0;
		computerScore = 0;
		numberOfGames = 1;
		userMoney = 0;
		computerMoney = 0;
	}
	public static void main(String[] args) 
	{

		RPSGame rps = new RPSGame();
		rps.getplayerName();
		rps.startGame();
	}
	public void startGame()
	{
		System.out.println("Please enter how much money you want to start off with?");
		Scanner sc = new Scanner(System.in);
		userMoney = computerMoney = sc.nextInt();
		do
		{
		System.out.println("How much do you want to bet?");
		betvalue = sc.nextInt();
		int playerinput = player.getInput();
		Weapon.display(player.getName(), playerinput);
		int computerinput = computer.getInput();
		Weapon.display("computer", computerinput);
		int compareResult = Weapon.compareSelections(playerinput, computerinput);
		switch (compareResult) 
		{
		case 0: 
			System.out.println("You guys both picked the same thing! It's a tie!");
			userMoney = userMoney;
			computerMoney = computerMoney;
			printStats();
			break;
		case 1: 
			System.out.println(player.getName()+ " beats " + "computer!" +" You won this round!");
			playerScore++;
			userMoney += betvalue;
			computerMoney -= betvalue;
			printStats();
			break;
		case -1:
			System.out.println("Computer" +" beats "+ player.getName()+"! You lost this round!");
			computerScore++;
			userMoney -= betvalue;
			computerMoney += betvalue;
			printStats();
			break;
		}
		numberOfGames++;
		} while(userMoney > 0 && computerMoney > 0);
		if(userMoney <= 0)
		{
			System.out.println("You ran out of money! The computer "+" won!");
			while(player.playAgain() == !true);
			startGame();
		}
		if(computerMoney <= 0)
		{
			System.out.println("The computer ran out of money! " + player.getName()+" won!");
			while(player.playAgain() == !true);
			startGame();
		}
	}
	
	public void getplayerName()
	{
		player.askName();
	}
	public void printStats()
	{
		System.out.println("Number of games played: "+numberOfGames);
		System.out.println(player.getName()+" has won " + playerScore + " times");
		System.out.println(player.getName() + " has lost " + computerScore + " times. ");
		System.out.println(player.getName()+ " has " + userMoney + " dollars left");
		System.out.println("The computer has won " + computerScore + " times");
		System.out.println("The computer has lost " + playerScore + " times. ");
		System.out.println("The computer has " + computerMoney + " dollars left");
	}
}
