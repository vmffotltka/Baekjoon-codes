import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i <= 25; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) - i < 'A')
                    sb.append((char)(s.charAt(j) - i + 26));
                else
                    sb.append((char)(s.charAt(j) - i));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}