import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	int g = Integer.parseInt(input[0]);
        	int c = Integer.parseInt(input[1]);
        	if (g == 1) cnt[3]++;
        	else if (c <= 2) cnt[0]++;
        	else if (c == 3) cnt[1]++;
        	else if (c == 4) cnt[2]++;
        }
        for (int i = 0; i < 4; i++) {
        	bw.write(cnt[i] + "\n");
        }
        
        bw.flush();
    }
}