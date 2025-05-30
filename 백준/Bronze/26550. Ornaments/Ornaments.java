import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	long n = Integer.parseInt(br.readLine());
        	long ans = (n * (n + 1) * (2 * n + 1) + (3 * n * (n + 1))) / 12;
        	bw.write(ans + "\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}