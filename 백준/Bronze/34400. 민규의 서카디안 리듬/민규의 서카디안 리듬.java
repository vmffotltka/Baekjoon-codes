import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
        	int n = Integer.parseInt(br.readLine());
        	sb.append(n % 25 < 17 ? "ONLINE" : "OFFLINE").append('\n');
        }
        System.out.print(sb.toString());
    }
}