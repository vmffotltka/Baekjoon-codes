import java.io.*;
import java.util.*;

public class Main {
	
	static int calculateStrikes(int a, int b) {
		int ret = 0;
		while (a > 0) {
			if (a % 10 == b % 10) ret++;
			a /= 10; b /= 10;
		}
		return ret;
	}
	
	static int calculateBalls(int a, int b) {
		int ret = 0;
		int A = a;
		for (int i = 0; i < 3; i++) {
			int B = b;
			for (int j = 0; j < 3; j++) {
				if (i == j) { B /= 10; continue; }
				if (A % 10 == B % 10) ret++;
				B /= 10;
			}
			A /= 10;
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n], strikes = new int[n], balls = new int[n];
        
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	arr[i] = Integer.parseInt(input[0]);
        	strikes[i] = Integer.parseInt(input[1]);
        	balls[i] = Integer.parseInt(input[2]);
        }
        
        int ans = 0;
        for (int i = 1; i <= 9; i++) {
        	for (int j = 1; j <= 9; j++) {
        		if (i == j) continue;
        		for (int k = 1; k <= 9; k++) {
        			if (i == k || j == k) continue;
        			int num = i * 100 + j * 10 + k;
                	boolean tri = true;
                	for (int m = 0; m < n; m++) {
                		int s = calculateStrikes(num, arr[m]), b = calculateBalls(num, arr[m]);
                		if (s != strikes[m] || b != balls[m]) {
                			tri = false;
                			break;
                		}
                	}
                	if (tri) ans++;
        		}
        	}
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
	}
}