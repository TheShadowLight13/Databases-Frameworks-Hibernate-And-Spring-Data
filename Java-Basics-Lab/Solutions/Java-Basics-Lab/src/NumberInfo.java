import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberInfo {

    private int value;
    private int occurrences;
    private List<Integer> occurrenceIndexes;

    public NumberInfo(int value) {
        this.setValue(value);
        this.occurrences = 0;
        this.occurrenceIndexes = new ArrayList<>();
    }

    public int getValue() {
        return this.value;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getOccurrences() {
        return this.occurrences;
    }

    public List<Integer> getOccurrenceIndexes() {
        return Collections.unmodifiableList(this.occurrenceIndexes);
    }

    public void incrementOccurrences() {
        this.occurrences++;
    }

    public void addOccurrenceIndex(int index) {
        this.occurrenceIndexes.add(index);
    }
}
