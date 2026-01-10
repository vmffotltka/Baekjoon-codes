import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - 'A' + 1;
        }
        System.out.print(sum);
    }
}