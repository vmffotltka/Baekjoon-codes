import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] vis = new int[101];
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	int seat = Integer.parseInt(input[i]);
        	ans += (vis[seat]++ > 0 ? 1 : 0);
        }
        System.out.print(ans);
        //bw.flush();
    }
}