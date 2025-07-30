import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int d = Integer.parseInt(input[3]);
        
        int cnt = 0, ans = 0;
        for (int x = 1; x <= 3; x++) {
        	int sum = 0;
        	for (int i = 0; i < 3; i++) {
            	int p = 1;
        		for (int j = 0; j < x; j++) {
            		p *= Integer.parseInt(input[i]);
            	}
        		sum += p;
        	}
        	if (sum == d) {
        		cnt++;
        		ans = x;
        	}
        }
        bw.write((cnt == 1 ? ans : -1) + "");
        bw.flush();
	}
}