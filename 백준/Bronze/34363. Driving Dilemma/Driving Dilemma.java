import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double v = Double.parseDouble(br.readLine()) / 3600;
        double d = Double.parseDouble(br.readLine()) / 5280;
        double t = Double.parseDouble(br.readLine());
        
        System.out.print(d <= t * v ? "MADE IT" : "FAILED TEST");
	}
}