import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] arr = new int[10];
        for (char c : s.toCharArray()) {
        	if (c == 'L') {
        		for (int i = 0; i < 10; i++) {
        			if (arr[i] == 0) {
        				arr[i] = 1;
        				break;
        			}
        		}
        	}
        	else if (c == 'R') {
        		for (int i = 9; i >= 0; i--) {
        			if (arr[i] == 0) {
        				arr[i] = 1;
        				break;
        			}
        		}
        	}
        	else {
        		int idx = c - '0';
        		arr[idx] = 0;
        	}
        }
        for (int i = 0; i < 10; i++) {
        	bw.write(arr[i] + "");
        }
        bw.flush(); 
    }
}   