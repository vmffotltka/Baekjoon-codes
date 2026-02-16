import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'O')
                cnt++;
        }
        System.out.print((n + 1) / 2 <= cnt ? "Yes" : "No");
    }
}