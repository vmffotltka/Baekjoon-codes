import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Math.min(a, b); i++) {
        	if (a % i == 0 && b % i == 0) {
        		sb.append(String.format("%d %d %d\n", i, a / i, b / i));
        	}
        }
        System.out.print(sb.toString().strip());
    }
}