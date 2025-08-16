import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        
        bw.write(Math.max(0, n - m * k) + " " + Math.max(0, (n - m * (k - 1) - 1)));
        
        bw.flush();
    }
}