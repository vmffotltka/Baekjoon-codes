import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String sentence = br.readLine();
        	for (char c : sentence.toCharArray()) {
        		if (c == 'y') bw.write('a');
        		else if (c == 'a') bw.write('e');
        		else if (c == 'e') bw.write('i');
        		else if (c == 'i') bw.write('o');
        		else if (c == 'o') bw.write('u');
        		else if (c == 'u') bw.write('y');
        		else if (c == 'Y') bw.write('A');
        		else if (c == 'A') bw.write('E');
        		else if (c == 'E') bw.write('I');
        		else if (c == 'I') bw.write('O');
        		else if (c == 'O') bw.write('U');
        		else if (c == 'U') bw.write('Y');
        		else bw.write(c);
        	}
        	bw.write("\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}