import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EqualSums {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> sequence = Arrays.stream(buffReader.readLine().split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());

        int leftSum = 0;
        int rightSum = 0;

        int equalsSumIndex = -1;

        for (int i = 0; i < sequence.size(); i++) {
            if (i == 0) {
                leftSum = 0;
            }else {
                leftSum = sequence.subList(0, i).stream().mapToInt(Integer::valueOf).sum();
            }

            if (i == sequence.size() - 1) {
                rightSum = 0;
            }else {
                rightSum = sequence.subList(i + 1, sequence.size()).stream()
                        .mapToInt(Integer::valueOf).sum();
            }

            if (leftSum == rightSum) {
                equalsSumIndex = i;
                break;
            }
        }

        System.out.println(equalsSumIndex != -1 ? equalsSumIndex : "no");
    }
}
