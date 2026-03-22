import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double bonus = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char grade = s.charAt(0);
            int w = s.charAt(1) - '0';
            int score = Math.max(4 - (grade - 'A'), 0);
            if (score >= 2) {
                if (w == 1)
                    bonus += 0.05;
                else if (w == 2)
                    bonus += 0.025;
            }
            sum += score;
        }
        System.out.print(sum / n + bonus);
    }
}