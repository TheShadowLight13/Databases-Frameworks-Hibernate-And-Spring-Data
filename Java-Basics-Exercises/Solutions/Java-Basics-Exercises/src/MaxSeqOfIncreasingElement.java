import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSeqOfIncreasingElement {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numSequence = Arrays.stream(buffReader.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

        List<List<Integer>> increasingNumbers = new ArrayList<>();

        int currNum = numSequence.get(0);

        if (numSequence.size() == 1) {
            System.out.println(currNum);
            return;
        }

        increasingNumbers.add(new ArrayList<>(Arrays.asList(currNum)));

        for (int i = 1; i < numSequence.size(); i++) {
            int nextNum = numSequence.get(i);

            int lastSequenceSize = increasingNumbers.get(increasingNumbers.size() - 1).size();
            int lastNumFromLastSequence = increasingNumbers.get(increasingNumbers.size() - 1)
                    .get(lastSequenceSize - 1);

            if (nextNum > lastNumFromLastSequence) {
                increasingNumbers.get(increasingNumbers.size() - 1).add(nextNum);
            }else {
                currNum = nextNum;
                increasingNumbers.add(new ArrayList<>(Arrays.asList(currNum)));
            }
        }

        List<Integer> longestSequence = getLongestSequence(increasingNumbers);
        printLongestSequence(longestSequence);
    }

    private static void printLongestSequence(List<Integer> longestSequence) {
        for (Integer number : longestSequence) {
            System.out.printf("%d ", number);
        }
    }

    private static List<Integer> getLongestSequence(List<List<Integer>> increasingNumbers) {
        List<Integer> longestSequence = new ArrayList<>();

        for (List<Integer> sequence : increasingNumbers) {
            if (sequence.size() > longestSequence.size()) {
                longestSequence = sequence;
            }
        }

        return longestSequence;
    }
}
