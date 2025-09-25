import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        
        System.out.print(n > c * p ? "no" : "yes");
	}
}