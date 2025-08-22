import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (long i = 1; i <= n; i++) {
        	sb.append(String.valueOf(i * (n - i + 1)) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}