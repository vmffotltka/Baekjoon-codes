import java.io.*;
import java.util.*;

public class Main {
	
	static int samgak(int n) {
		return n * (n + 1) / 2;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
        	int p = Integer.parseInt(br.readLine());
        	
        	boolean ans = false;
        	for (int i = 1; samgak(i) < p; i++) {
        		boolean a1 = false;
        		
        		for (int j = 1; samgak(i) + samgak(j) < p; j++) {
        			
        			boolean a2 = false;
        			for (int k = 1; samgak(i) + samgak(j) + samgak(k) <= p; k++) {
        				if (samgak(i) + samgak(j) + samgak(k) == p) {
        					a2 = true;
        					break;
        				}
        			}
        			if (a2) {
        				a1 = true;
        				break;
        			}
        		}
        		if (a1) {
        			ans = true;
        			break;
        		}
        	}
        	sb.append(ans ? "1\n" : "0\n");
        }
        System.out.print(sb.toString().strip());
	}
}