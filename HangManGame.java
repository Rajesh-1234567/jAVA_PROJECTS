import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"programming", "hangman", "java", "developer", "computer"};
    private static final int MAX_TRIES = 6;

    private String wordToGuess;
    private StringBuilder guessedWord;
    private int remainingTries;

    public HangmanGame() {
        // Initialize a new game.
        wordToGuess = selectRandomWord();
        guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));
        remainingTries = MAX_TRIES;
    }

    private String selectRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (remainingTries > 0 && guessedWord.indexOf("_") != -1) {
            System.out.println("Word: " + guessedWord);
            System.out.println("Tries left: " + remainingTries);
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().charAt(0);

            if (wordToGuess.contains(String.valueOf(guess))) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord.setCharAt(i, guess);
                    }
                }
            } else {
                System.out.println("Wrong guess!");
                remainingTries--;
            }
        }

        if (remainingTries > 0) {
            System.out.println("Congratulations! You've guessed the word: " + guessedWord);
        } else {
            System.out.println("Out of tries! The word was: " + wordToGuess);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        System.out.println("Welcome to Hangman!");
        game.play();
    }
}
