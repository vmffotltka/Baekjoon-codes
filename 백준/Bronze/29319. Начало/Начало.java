import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        int sum = 0, mx = -1;
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(arr[i]);
        	sum += p;
        	mx = Math.max(mx, p);
        }
        bw.write((sum - mx) + "");
        bw.flush();
	}
}