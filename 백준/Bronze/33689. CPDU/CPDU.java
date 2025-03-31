import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), ans = 0;
        while (n-- > 0) {
        	String s = br.readLine();
        	if (s.charAt(0) == 'C') ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}