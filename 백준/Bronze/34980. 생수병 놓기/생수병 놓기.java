import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'w') cnt1++;
            if (s2.charAt(i) == 'w') cnt2++;
        }
        if (cnt1 > cnt2)
            System.out.print("Oryang");
        else if (cnt1 == cnt2 && !s1.equals(s2))
            System.out.print("Its fine");
        else if (cnt1 < cnt2)
            System.out.print("Manners maketh man");
        else
            System.out.print("Good");
    }
}