import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        int m = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");
        
        int cur = 0;
        for (int i = 0; i < n; i++) {
        	cur += Integer.parseInt(arr[i]);
        	for (int j = 0; j < m; j++) {
        		if (cur == Integer.parseInt(arr2[j])) {
        			cur = 0;
        			break;
        		}
        	}
        }
        bw.write(cur + "");
        bw.flush();
    }
}