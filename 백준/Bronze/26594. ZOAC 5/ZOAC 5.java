import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        char first = s.charAt(0);
        int cnt = 0;
        for (char c : s.toCharArray()) {
        	if (c != first) break;
        	else cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close(); br.close();
    }
}