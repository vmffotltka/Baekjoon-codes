import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String s2 = br.readLine();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s2.charAt(i)) continue;
            if ((s.charAt(i) == 'R' && s2.charAt(i) == 'S')
                || (s.charAt(i) == 'S' && s2.charAt(i) == 'P')
                || (s.charAt(i) == 'P' && s2.charAt(i) == 'R')) a++;
            if ((s2.charAt(i) == 'R' && s.charAt(i) == 'S')
                || (s2.charAt(i) == 'S' && s.charAt(i) == 'P')
                || (s2.charAt(i) == 'P' && s.charAt(i) == 'R')) b++;
        }
        System.out.print(a + " " + b);
    }
}