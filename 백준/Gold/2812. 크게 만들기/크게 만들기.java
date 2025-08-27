import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String s = br.readLine();
        
        Stack<Integer> st = new Stack<>();
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int cnt = m;
        for (char c : s.toCharArray()) {
        	int p = c - '0';
        	while (!st.empty() && st.peek() < p && cnt > 0) {
        		cnt--;
        		st.pop();
        	}
        	st.push(p);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - m; i++) {
        	sb.append(st.get(i));
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}