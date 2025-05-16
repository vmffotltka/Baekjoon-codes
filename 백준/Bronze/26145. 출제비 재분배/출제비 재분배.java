import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[] ans = new int[n + m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	ans[i] += Integer.parseInt(st.nextToken());
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n + m; j++) {
        		int p = Integer.parseInt(st2.nextToken());
        		ans[j] += p;
        		ans[i] -= p;
        	}
        }
        for (int i = 0; i < n + m; i++) {
        	bw.write(ans[i] + " ");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}