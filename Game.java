import java.util.*;

public class Game {
    private Melody solution;
    private SuggestionListNode head = null;

    public Game (Melody solution) {
        this.solution = solution;
    }

    public Game () {
        Random rand = new Random();
        char allChars[] = { 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' };
        char output[] = new char[5];
        for (int i = 0 ; i < output.length ; i++) {
            int randInt = rand.nextInt(7);
            output[i] = allChars[randInt];
        }
        this.solution = new Melody(output);
    }

    public Boolean suggestMelody (Melody Suggestion) {
        Suggestion Suggest = new Suggestion(Suggestion , this.solution);
        this.head = new SuggestionListNode(Suggest , this.head);
        return this.head.getSuggestion().isCorrect();
    }

    public SuggestionListNode getHistory () {
        return this.head;
    }

    public Melody getSolution () {
        return this.solution;
    }
}
