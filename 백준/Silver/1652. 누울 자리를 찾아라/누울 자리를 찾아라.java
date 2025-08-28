import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        
        int garo = 0, sero = 0;
        for (int i = 0; i < n; i++) {
        	arr[i] = br.readLine();
        	int cnt = 0;
        	for (int j = 0; j < n; j++) {
        		if (arr[i].charAt(j) == 'X') {
        			if (cnt >= 2) garo++;
        			cnt = 0;
        		}
        		else cnt++;
        	}
        	if (cnt >= 2) garo++;
        }
        
        for (int j = 0; j < n; j++) {
        	int cnt = 0;
        	for (int i = 0; i < n; i++) {
        		if (arr[i].charAt(j) == 'X') {
        			if (cnt >= 2) sero++;
        			cnt = 0;
        		}
        		else cnt++;
        	}
        	if (cnt >= 2) sero++;
        }
        bw.write(String.format("%d %d", garo, sero));
        bw.flush();
    }
}