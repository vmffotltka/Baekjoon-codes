import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int set = 1; set <= t; set++) {
        	int n = Integer.parseInt(br.readLine());
        	String media = br.readLine();
        	
        	int ans = 0;
        	for (int i = 0; i < n; i++) {
        		String s = br.readLine();
        		for (char c : s.toCharArray()) {
        			boolean matched = false;
        			for (char c2 : media.toCharArray()) {
        				if (c == c2) {
        					matched = true;
        					break;
        				}
        			}
        			if (matched) {
        				ans++;
        				break;
        			}
        		}
        	}
        	sb.append(String.format("Data Set %d:\n%d\n\n", set, ans));
        }
        System.out.print(sb.toString());
    }
}