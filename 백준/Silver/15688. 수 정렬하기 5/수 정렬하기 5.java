import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}