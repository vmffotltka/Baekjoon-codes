import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("G".repeat(n));
            sb.append(".".repeat(n * 3));
            sb.append('\n');
        }
        for (int i = 0; i < n; i++) {
            sb.append(".".repeat(n));
            sb.append("I".repeat(n));
            sb.append(".".repeat(n));
            sb.append("T".repeat(n));
            sb.append('\n');
        }
        for (int i = 0; i < n; i++) {
            sb.append(".".repeat(n * 2));
            sb.append("S".repeat(n));
            sb.append(".".repeat(n));
            sb.append('\n');
        }
        System.out.print(sb);
    }
}