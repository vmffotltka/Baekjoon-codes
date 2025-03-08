import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int c = 1; c <= t; c++) {
        	String[] input = br.readLine().split(" ");
        	long n = Integer.parseInt(input[0]);
        	long k = Integer.parseInt(input[1]);
        	long s = Integer.parseInt(input[2]);
        	long ans = Math.min(k + n, k + (k - s) + (n - s));
        	bw.write("Case #" + c + ": " + ans + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}