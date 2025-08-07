import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String[] arr = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);

    	StringBuilder sb = new StringBuilder();
        if (n == r) sb.append('*');
        else {
        	int[] returned = new int[n + 1];
            for (int i = 0; i < r; i++) {
            	returned[Integer.parseInt(arr[i])]++;
            }
        	for (int i = 1; i <= n; i++) {
        		if (returned[i] == 0) sb.append(i + " ");
        	}
        }
        bw.write(sb.toString().strip());
        bw.flush();
	}
}