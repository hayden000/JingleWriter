import java.util.*;

public class JingleWriterCli {
    private static void printhistory (Game game) {
        if (game.getHistory() == null) {
            System.out.println("No History");
        }
        else {
            for (SuggestionListNode cursor = game.getHistory() ; cursor != null ; cursor = cursor.getNext()) {
                System.out.println(cursor.getSuggestion());
            }
        }
    }

    private static Melody toMelody () {
        System.out.println("Enter melody:");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        char[] inputGuess = new char[5];
        int guessCounter = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            if (! ((input.charAt(i)) == ' ')) {
                inputGuess[guessCounter] = input.charAt(i);
                guessCounter++;
            }
        }
        return new Melody(inputGuess);
    }

    public static void playGame (Game game) {
        boolean flag = false;
        while (! (flag)) {
            System.out.println("History:");
            printhistory(game);
            Melody melody = toMelody();
            flag = game.suggestMelody(melody);
        }
        System.out.println("Congratulations!");
    }

    public static void main (String args[]) {
        playGame(new Game());
    }
}
