import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        
        while (e-- > 0) {
        	String op = br.readLine();
        	int n = Integer.parseInt(br.readLine());
        	
        	if (op.equals("+")) d += n;
        	else d -= n;
        }
        System.out.print(d);
	}
}