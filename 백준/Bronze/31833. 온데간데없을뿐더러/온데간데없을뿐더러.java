import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder s1 = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            s1.append(st.nextToken());

        StringBuilder s2 = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            s2.append(st.nextToken());

        if (s1.length() < s2.length())
            System.out.print(s1);
        else if (s1.length() > s2.length())
            System.out.print(s2);
        else if (s1.compareTo(s2) < 0)
            System.out.print(s1);
        else
            System.out.print(s2);
    }
}