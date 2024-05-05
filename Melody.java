import java.util.*;

public class Melody {
    private char[] melody;
    private char[] Suggestion;
    private char[] other;

    public Melody (char[] melody) {
        this.melody = melody;
    }

    public char getNote (int i) {
        return (this.melody[i]);
    }

    public Integer getNumSamePosition (Melody other) {
        int counter = 0;
        for (int i = 0 ; i < this.melody.length ; i++) {
            if ((this.melody[i] == other.melody[i])) {
                counter = counter + 1;
            }
        }
        return (counter);
    }

    public Integer getNumSameNoPosition (Melody other) {
        char notes[] = { 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' };
        int timesCharGuessed[] = new int[7];
        int correctCharUsed[] = new int[7];
        int timesCharUsed[] = new int[7];
        for (int i = 0 ; i < this.melody.length ; i++) {
            for (int j = 0 ; j < notes.length ; j++) {
                if (this.melody[i] == notes[j]) {
                    correctCharUsed[j] = correctCharUsed[j] + 1;
                }
            }
        }
        for (int i = 0 ; i < other.melody.length ; i++) {
            for (int j = 0 ; j < timesCharGuessed.length ; j++) {
                if (other.melody[i] == notes[j]) {
                    timesCharGuessed[j] = timesCharGuessed[j] + 1;
                }
            }
        }
        for (int i = 0 ; i < correctCharUsed.length ; i++) {
            if (correctCharUsed[i] > timesCharGuessed[i]) {
                timesCharUsed[i] = timesCharGuessed[i];
            }
            else {
                timesCharUsed[i] = correctCharUsed[i];
            }
        }
        int counter = 0;
        for (int i = 0 ; i < timesCharUsed.length ; i++) {
            counter = counter + timesCharUsed[i];
        }
        return (counter);
    }

    public String toString () {
        String notesString = "";
        for (int i = 0 ; i < this.melody.length ; i++) {
            String string = new String();
            notesString = notesString + melody[i];
            if (! (i == this.melody.length - 1)) {
                notesString = notesString + " ";
            }
        }
        return notesString;
    }
}
