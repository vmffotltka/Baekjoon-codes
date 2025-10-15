import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        
        long a = -1;
        while (l <= 100) {
        	long p = n * 2 - l * l + l;
        	if (p % (l * 2) == 0) {
        		a = p / (l * 2);
        		break;
        	}
        	l++;
        }
        if (a < 0) System.out.print(-1);
        else {
        	StringBuilder sb = new StringBuilder();
        	for (long i = a; i < a + l; i++) {
        		sb.append(i).append(' ');
        	}
        	System.out.print(sb.toString());
        }
	}
}