import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "SciComLove";
        int N = Integer.parseInt(br.readLine());
        N %= 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(s.charAt((N + i) % 10));
        }
        System.out.print(sb);
    }
}