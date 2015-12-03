import java.util.Scanner;

public class Prompter {
	private Game mGame;

	public Prompter(Game game) {
		mGame = game;
	}

	public void play() {
		while (mGame.getRemainingTries() > 0 && !mGame.isSolved()) {
			displayProgress();
			promptForGuess();
		}
		if (mGame.isSolved()) {
			System.out.printf("Congratulations, you won with %d tries remaining.\n", mGame.getRemainingTries());
		} else {
			System.out.printf("Bummer, the word was %s. :(\n", mGame.getAnswer());
		}
	}

	public boolean promptForGuess() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean isHit = false;
		boolean isValidGuess = false;
		while (!isValidGuess) {
			System.out.println("Enter a letter: ");
			String guessAsString = scanner.nextLine();
			try {
				isHit = mGame.applyGuess(guessAsString); // return true if value
															// is hit
				isValidGuess = true; // stop the while loop
			} catch (IllegalArgumentException iae) {
				System.out.printf("%s. Please try again.\n", iae.getMessage());
			}
		}
		return isHit;
	}

	public void displayProgress() {
		System.out.printf("You have %d tries left to solve:  %s\n", mGame.getRemainingTries(),
				mGame.getCurrentProgress());
	}
}