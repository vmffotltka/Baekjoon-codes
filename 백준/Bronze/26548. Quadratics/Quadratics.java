import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	double a = Double.parseDouble(input[0]);
        	double b = Double.parseDouble(input[1]);
        	double c = Double.parseDouble(input[2]);
        	
        	double ans1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        	double ans2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        	bw.write(String.format("%.3f, %.3f\n", ans1, ans2));
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}