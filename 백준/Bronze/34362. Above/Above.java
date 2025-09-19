import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double n = Double.parseDouble(br.readLine());
        System.out.print(n - 0.3);
    }
}