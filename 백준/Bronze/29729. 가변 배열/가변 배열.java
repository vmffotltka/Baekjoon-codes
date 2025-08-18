import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);
        
        int cur = 0;
        for (int i = 0; i < n + m; i++) {
        	int p = Integer.parseInt(br.readLine());
        	cur += (p == 1 ? 1 : -1);
        	if (cur > s) s *= 2;
        }
        bw.write(String.valueOf(s));
        bw.flush();
    }
}