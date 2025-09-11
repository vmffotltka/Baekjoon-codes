import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        
        long ans = 0;
        for (char a : A.toCharArray()) {
        	for (char b : B.toCharArray()) {
        		ans += (a - '0') * (b - '0');
        	}
        }
        System.out.print(ans);
    }
}