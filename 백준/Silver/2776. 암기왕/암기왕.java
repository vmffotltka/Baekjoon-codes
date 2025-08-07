import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
        	int n = Integer.parseInt(br.readLine());
        	String[] arr = br.readLine().split(" ");

        	HashSet<String> set = new HashSet<>();
        	for (int i = 0; i < n; i++) {
        		set.add(arr[i]);
        	}
        	
        	int m = Integer.parseInt(br.readLine());
        	arr = br.readLine().split(" ");
        	
        	for (int i = 0; i < m; i++) {
        		if (set.contains(arr[i])) sb.append("1\n");
        		else sb.append("0\n");
        	}
        }
        bw.write(sb.toString());
        bw.flush();
	}
}