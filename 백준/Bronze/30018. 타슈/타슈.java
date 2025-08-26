import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	ans += Math.abs(Integer.parseInt(input[i]) - Integer.parseInt(st.nextToken()));
        }
        
        bw.write(String.valueOf(ans / 2));
        bw.flush();
    }
}