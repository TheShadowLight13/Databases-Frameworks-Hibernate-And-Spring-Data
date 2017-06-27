import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MostFrequentNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(buffReader.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        LinkedHashMap<Integer, Integer> occurrenceByNumber = new LinkedHashMap<>();

        for (Integer number : numbers) {
            occurrenceByNumber.putIfAbsent(number, 0);
            int newValue = occurrenceByNumber.get(number) + 1;
            occurrenceByNumber.put(number, newValue);
        }

        int mostFrequentNumber = getMostFrequentNumber(occurrenceByNumber);
        System.out.println(mostFrequentNumber);
    }

    private static int getMostFrequentNumber(LinkedHashMap<Integer, Integer> occurrenceByNumber) {
        int mostFrequentNumber = Integer.MIN_VALUE;
        int frequencyRate = 0;

        for (Integer number : occurrenceByNumber.keySet()) {

            int currFrequencyRate = occurrenceByNumber.get(number);
            if (currFrequencyRate > frequencyRate) {
                mostFrequentNumber = number;
                frequencyRate = currFrequencyRate;
            }
        }

        return mostFrequentNumber;
    }
}
