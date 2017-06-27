import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSeqOfEqualElements {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numSequence = Arrays.stream(buffReader.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer[]> equalNumbers = new ArrayList<>();

        int currNum = numSequence.get(0);
        int occurrenceCount = 1;

        if (numSequence.size() == 1) {
            System.out.println(currNum);
            return;
        }

        for (int i = 1; i < numSequence.size(); i++) {
            int nextNum = numSequence.get(i);
            if (currNum == nextNum) {
                occurrenceCount++;
            }else {
                equalNumbers.add(new Integer[occurrenceCount]);
                Arrays.fill(equalNumbers.get(equalNumbers.size() - 1), currNum);
                currNum = nextNum;
                occurrenceCount = 1;
            }

            if (i == numSequence.size() - 1) {
                equalNumbers.add(new Integer[occurrenceCount]);
                Arrays.fill(equalNumbers.get(equalNumbers.size() - 1), currNum);
            }
        }

        Integer[] longestSequence = getLongestSequence(equalNumbers);
        printLongestSequence(longestSequence);
    }

    private static void printLongestSequence(Integer[] longestSequence) {
        for (Integer number : longestSequence) {
            System.out.printf("%d ", number);
        }
    }

    private static Integer[] getLongestSequence(List<Integer[]> equalNumbers) {
        Integer[] longestSequence = new Integer[0];

        for (Integer[] sequence : equalNumbers) {
            if (sequence.length > longestSequence.length) {
                longestSequence = sequence;
            }
        }

        return longestSequence;
    }
}
