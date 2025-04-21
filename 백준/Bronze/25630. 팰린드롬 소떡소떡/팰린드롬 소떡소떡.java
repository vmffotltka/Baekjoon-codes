import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), ans = 0;
        String s = br.readLine();
        for (int i = 0; i < n / 2; i++) {
        	if (s.charAt(i) != s.charAt(n - i - 1)) ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}