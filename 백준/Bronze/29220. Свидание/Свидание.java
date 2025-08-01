import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	sum += Integer.parseInt(input[i]);
        }
        
        boolean ans = false;
        for (int i = 0; i < n; i++) {
        	if (sum - Integer.parseInt(input[i]) >= k) ans = true;
        }
        bw.write(ans ? "YES" : "NO");
        bw.flush();
	}
}