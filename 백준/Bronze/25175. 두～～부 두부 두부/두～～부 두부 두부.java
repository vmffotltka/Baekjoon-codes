import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        
        int cnt = 3;
        while (cnt != k) {
        	if (cnt > k) {
        		cnt--;
        		m = (m == 1 ? n : m - 1);
        	}
        	else {
        		cnt++;
        		m = (m == n ? 1 : m + 1);
        	}
        }
        bw.write(m + "");
        bw.flush();
        bw.close(); br.close();
    }
}