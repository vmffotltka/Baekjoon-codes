import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        
        int ans = 0, cur = 1;
        for (int i = 0; i < x; i++) {
        	ans += cur;
        	cur *= 10;
        }
        cur = 1;
        for (int i = 0; i < y; i++) {
        	ans += cur;
        	cur *= 10;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}