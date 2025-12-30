import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine(), b = br.readLine(), c = br.readLine(), d = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == c.charAt(i)) {
                if (b.charAt(i) != d.charAt(i)) {
                    System.out.print("htg!");
                    return;
                }
                sb.append(b.charAt(i));
            }
        }
        System.out.print(sb);
    }
}