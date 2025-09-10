import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        
        if (a > b) {
        	long tmp = a;
        	a = b;
        	b = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d\n", Math.max(0, b - a - 1)));
        for (long i = a + 1; i < b; i++) sb.append(String.format("%d ", i));
    
        System.out.print(sb.toString().strip());
    }
}