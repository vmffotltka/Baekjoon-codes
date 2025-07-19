import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input1 = br.readLine();
        String input2 = br.readLine();
        int i1 = input1.indexOf('|');
        int i2 = input1.length() - i1 - 1;
        int j1 = input2.indexOf('|');
        int j2 = input2.length() - j1 - 1;
        
        bw.write(i1 == j1 || i1 == j2
        		|| i2 == j1 || i2 == j2 ? "Yes" : "No");
        
        bw.flush();
    }
}