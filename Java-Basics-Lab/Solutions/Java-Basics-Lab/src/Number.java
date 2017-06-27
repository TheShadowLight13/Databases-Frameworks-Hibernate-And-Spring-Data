import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Number {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> enteredNumbers = new ArrayList<>();
        enteredNumbers.addAll(Arrays.stream(buffReader.readLine().split(" ")).
                map(Integer::valueOf).collect(Collectors.toList()));

        HashMap<Integer, NumberInfo> infoForNumbers = new HashMap<>();
        setInfoForNumbers(enteredNumbers, infoForNumbers);
        printDuplicatedNumbers(infoForNumbers);
    }

    private static void printDuplicatedNumbers(HashMap<Integer, NumberInfo> infoForNumbers) {
        List<NumberInfo> duplicatedNumbersInfo = infoForNumbers.entrySet().stream()
                .filter(e -> e.getValue().getOccurrences() > 1)
                .map(Map.Entry::getValue).collect(Collectors.toList());

        for (NumberInfo numberInfo : duplicatedNumbersInfo) {
            System.out.printf("Number - %d, occurrences - %d, occurrence indexes - ",
                    numberInfo.getValue(), numberInfo.getOccurrences());
            List<Integer> occurrenceIndexes = numberInfo.getOccurrenceIndexes();
            occurrenceIndexes.forEach(i -> System.out.printf("%d ", i));
            System.out.println();
        }
    }

    private static void setInfoForNumbers(
            List<Integer> enteredNumbers, HashMap<Integer, NumberInfo> infoForNumbers) {

        int currentNumberIndex = 0;

        for (Integer enteredNumber : enteredNumbers) {
            infoForNumbers.putIfAbsent(enteredNumber, new NumberInfo(enteredNumber));
            infoForNumbers.get(enteredNumber).incrementOccurrences();
            infoForNumbers.get(enteredNumber).addOccurrenceIndex(currentNumberIndex);
            currentNumberIndex++;
        }
    }
}
