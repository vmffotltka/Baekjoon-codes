import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        
        int score = n * 10;
        if (n >= 3) score += 20;
        if (n == 5) score += 50;
        if (w > 1000) score -= 15;
        
        System.out.print(Math.max(0, score));
    }
}