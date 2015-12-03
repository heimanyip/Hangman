import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		System.out.println("Please enter a word");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();

		Game game = new Game(word);
		Prompter prompter = new Prompter(game);
		prompter.play();
	}

}