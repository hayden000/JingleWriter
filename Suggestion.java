import java.util.*;

class Suggestion {
    private Melody Suggestion;
    private Melody Solution;
    private Melody Answer;

    public Suggestion (Melody Suggestion , Melody Solution) {
        this.Suggestion = Suggestion;
        this.Solution = Solution;
    }

    public Melody getSolution () {
        return this.Solution;
    }

    public Melody getMelody () {
        return this.Suggestion;
    }

    public int getNumCorrect () {
        String stringSolution = String.valueOf(getSolution());
        String stringSuggestion = String.valueOf(getMelody());
        int counter = 0;
        for (int i = 0 ; i < stringSolution.length() ; i++) {
            char guessChar = stringSuggestion.charAt(i);
            char correctChar = stringSolution.charAt(i);
            if ((guessChar == correctChar) && (correctChar != ' ')) {
                counter = counter + 1;
            }
        }
        return counter;
    }

    public int getNumOutOfOrder () {
        return Solution.getNumSameNoPosition(Suggestion) - getNumCorrect();
    }

    public String toString () {
        return getMelody() + " Correct " + this.getNumCorrect() + " Out of Order " + this.getNumOutOfOrder();
    }

    public Boolean isCorrect () {
        if (this.getNumCorrect() == 5) {
            return true;
        }
        return false;
    }
}