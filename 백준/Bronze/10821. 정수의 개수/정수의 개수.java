import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ',') cnt++;
        }
        System.out.print(cnt + 1);
    }
}