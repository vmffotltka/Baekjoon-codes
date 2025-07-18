import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < input.length(); j++) {
        		bw.write(Character.toLowerCase(input.charAt(j)));
        		if (j != input.length() - 1 && Character.isUpperCase(input.charAt(j + 1)))
        			bw.write("_");
        	}
        	bw.write("\n");
        }
        bw.flush();
    }
}