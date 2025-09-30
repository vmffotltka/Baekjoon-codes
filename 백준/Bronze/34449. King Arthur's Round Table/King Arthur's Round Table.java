import java.io.*;
import java.util.*;

public class Main {

	static double pi = 3.14159;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double d = Double.parseDouble(br.readLine());
        double w = Double.parseDouble(br.readLine());
        double n = Double.parseDouble(br.readLine());
        
        System.out.print(d * pi >= w * n ? "YES" : "NO");
    }
}