import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ucpc = "UCPC";
        String s = br.readLine();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (idx < 4 && ucpc.charAt(idx) == c) {
                idx++;
            }
        }
        System.out.print(idx == 4 ? "I love UCPC" : "I hate UCPC");
    }
}