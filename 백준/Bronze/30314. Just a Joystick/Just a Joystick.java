import java.io.*;
import java.util.*;

public class Main {

	static int alphabets = 'z' - 'a' + 1;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), sum = 0;
        String s1 = br.readLine();
        String s2 = br.readLine();
        for (int i = 0; i < n; i++) {
        	int c1 = s1.charAt(i), c2 = s2.charAt(i);
        	sum += Math.min(Math.abs(c1 + alphabets - c2) % alphabets, Math.abs(c2 + alphabets - c1) % alphabets);
        }
        System.out.print(sum);
    }
}