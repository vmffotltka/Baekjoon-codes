import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
        	String s = br.readLine();
        	int vowels = 0;
        	for (char c : s.toCharArray()) {
        		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        			vowels++;
        	}
        	bw.write(String.format("The number of vowels in %s is %d.\n", s, vowels));
        }
        
        bw.flush();
    }
}