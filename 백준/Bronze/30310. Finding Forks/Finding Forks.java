import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        String[] input = br.readLine().split(" ");
        
        int mn = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(input[i]);
        	if (mn > p) {
        		mn2 = mn;
        		mn = p;
        	}
        	else if (mn2 > p)
        		mn2 = p;
        }
        System.out.print(mn + mn2);
    }
}