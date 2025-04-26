import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        if (s1.length() < s2.length()) {
            while (s1.length() < s2.length()) {
                s1 = "0" + s1;
            }
        } else if (s2.length() < s1.length()) {
            while (s2.length() < s1.length()) {
                s2 = "0" + s2;
            }
        }
        
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            int digit1 = s1.charAt(i) - '0';
            int digit2 = s2.charAt(i) - '0';
            
            if ((digit1 <= 2 && digit2 <= 2) || (digit1 >= 7 && digit2 >= 7)) {
                result.append("0");
            } else {
                result.append("9");
            }
        }
        bw.write(result.toString());
        bw.flush();
        bw.close(); br.close();
    }
}