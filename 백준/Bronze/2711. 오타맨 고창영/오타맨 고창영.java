import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int idx = Integer.parseInt(st.nextToken());
        	String line = st.nextToken();

        	for (int i = 0; i < line.length(); i++) {
        		if (i == idx - 1) continue;
        		sb.append(line.charAt(i));
        	}
        	sb.append('\n');
        }
        System.out.print(sb.toString());
	}
}