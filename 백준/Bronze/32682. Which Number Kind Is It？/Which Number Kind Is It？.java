import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean isOdd = (n % 2 != 0), isSquare = (Math.sqrt(n) % 1 == 0);
            if (isOdd && isSquare)
                sb.append("OS\n");
            else if (isOdd)
                sb.append("O\n");
            else if (isSquare)
                sb.append("S\n");
            else
                sb.append("EMPTY\n");
        }
        System.out.print(sb);
    }
}