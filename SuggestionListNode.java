import java.util.*;

public class SuggestionListNode {
    private Suggestion payload;
    private SuggestionListNode next = null;

    public SuggestionListNode (Suggestion payload , SuggestionListNode next) {
        this.payload = payload;
        this.next = next;
    }

    public SuggestionListNode (Suggestion payload) {
        this.payload = payload;
        this.next = null;
    }

    public Suggestion getSuggestion () {
        return this.payload;
    }

    public SuggestionListNode getNext () {
        return this.next;
    }
}
