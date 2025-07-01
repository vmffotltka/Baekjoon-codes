import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int n = Integer.parseInt(input[0]);
        	int m = Integer.parseInt(input[1]);
        	String[] arr1 = br.readLine().split(" ");
        	String[] arr2 = br.readLine().split(" ");
        	int ans = 0;
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < m; j++) {
        			if (arr1[i].equals(arr2[j])) ans++;
        		}
        	}
        	bw.write(ans + "\n");
        }
        
        bw.flush(); 
    }
}   