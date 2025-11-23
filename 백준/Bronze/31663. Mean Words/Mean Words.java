import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[45], cnt = new int[45];
        
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	for (int j = 0; j < s.length(); j++) {
        		ans[j] += s.charAt(j);
        		cnt[j]++;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 45; i++) {
        	if (ans[i] == 0) break;
        	sb.append((char)(ans[i] / cnt[i]));
        }
        System.out.print(sb);
	}
}