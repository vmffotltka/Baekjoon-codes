import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[100];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
        	int p = Integer.parseInt(br.readLine());
        	cnt[p / 10]++;
        	sum += p;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(sum / 10).append('\n');
        
        int mx = 0, chebin = 0;
        for (int i = 0; i < 100; i++) {
        	if (mx < cnt[i]) {
        		mx = cnt[i];
        		chebin = i * 10;
        	}
        }
        sb.append(chebin);
        
        System.out.print(sb.toString());
    }
}