import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char cur = br.readLine().charAt(0);
        String s = "ILOVEYONSEI";
        int ans = 0;
        for (char c : s.toCharArray()) {
        	ans += Math.abs(c - cur);
        	cur = c;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}