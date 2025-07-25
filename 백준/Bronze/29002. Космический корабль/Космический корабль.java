import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	sum += Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < n; i++) {
        	int cur = Integer.parseInt(arr[i]);
        	if (sum == cur * 2) {
        		for (int j = 0; j < n; j++) {
        			if (i == j) continue;
        			bw.write(arr[j] + " ");
        		}
        		bw.write(arr[i]);
        		break;
        	}
        }
        
        bw.flush();
	}
}