import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()), cur = 1;
        Stack<Integer> stack = new Stack<>();
        String P[] = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(P[i]);
        	stack.push(p);
        	if (cur == p) {
        		while (!stack.isEmpty() && stack.peek() == cur) {
        			stack.pop();
        			cur++;
        		}
        	}
        }
        
        while (!stack.isEmpty()) {
        	if (stack.peek() != cur) {
        		bw.write("Sad");
        		bw.flush();
        		return;
        	}
        	stack.pop();
        	cur++;
        }
        bw.write("Nice");
        bw.flush();
        bw.close(); br.close();
	}
}