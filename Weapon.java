public class Weapon 
{
	public static final int Rock = 1;
	public static final int Paper = 2;
	public static final int Scissors = 3;

	public static void display(String who, int s)
	{
		switch (s)
		{
		case Weapon.Rock:
			System.out.print(who + " selected ROCK   ");
			break;
		case  Weapon.Paper:
			System.out.print(who + " selected PAPER   ");
			break;
		case  Weapon.Scissors:
			System.out.print(who + " selected SCISSORS   ");
			break;
		default:
			break;
		}
	}

	public static int compareSelections(int userChoice, int computerChoice)
	{
		if(userChoice==computerChoice) return 0;
		switch (userChoice) {
		case Rock:
			return (computerChoice == Scissors ? 1 : -1);

		case Paper:
			return (computerChoice == Rock ? 1 : -1);

		case Scissors:
			return (computerChoice == Paper ? 1 : -1);
		}
		return 0;
	}
}
