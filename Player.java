import java.util.Scanner;
public class Player
{
	private String name;
	Scanner sc = new Scanner(System.in);

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void askName()
	{
		System.out.println("Please enter your name");
		name = sc.next();
	}

	public int getInput()
	{
		System.out.println("Do you want rock, paper, or scissors");
		String input = sc.next();
		input = input.toUpperCase();
		char c = input.charAt(0);
		if (c == 'R' || c == 'r')
			return Weapon.Rock;
		else if (c == 'P' || c == 'p')
			return  Weapon.Paper;
		else if (c == 'S' || c == 's')
			return  Weapon.Scissors;
		else {
			getInput(); //will loop this function again and give them another chance to choose
			return 0;
		}
	}

	public boolean playAgain() 
	{
	
		sc = new Scanner(System.in);
		System.out.print("Do you want to play again? ");
		String userInput = sc.nextLine();
		return userInput.charAt(0) == 'Y' || userInput.charAt(0) == 'y';
	}
}
