import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int s_count = 0, l_count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'S') s_count++;
            else if (c == 'L') l_count++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SciCom".repeat(s_count)).append("Love".repeat(l_count));
        System.out.println(sb);
    }
}