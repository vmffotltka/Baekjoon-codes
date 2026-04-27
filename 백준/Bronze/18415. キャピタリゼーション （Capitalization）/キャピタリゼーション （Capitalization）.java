import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i < n - 2 && s.startsWith("joi", i)) {
                ans.append("JOI");
                i += 2;
            }
            else
                ans.append(s.charAt(i));
        }
        System.out.print(ans);
    }
}