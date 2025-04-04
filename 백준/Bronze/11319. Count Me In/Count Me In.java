import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int vowel = 0, cnt = 0;
        	String s = br.readLine();
        	for (char c : s.toCharArray()) {
        		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        			vowel++;
        		else if (c != ' ')
        			cnt++;
        	}
        	bw.write(cnt + " " + vowel + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}