import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < s.length() / 2; i++)
            sum1 += s.charAt(i) - '0';
        for (int i = s.length() / 2; i < s.length(); i++)
            sum2 += s.charAt(i) - '0';
        System.out.print(sum1 == sum2 ? "LUCKY" : "READY");
    }
}