import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        
        if (n != 0)
        	st = new StringTokenizer(br.readLine());
        int rank = 1, idx = 1;
        for (int i = 0; i < n; i++) {
        	int nextScore = Integer.parseInt(st.nextToken());
        	if (nextScore > score) {
        		rank++;
        	}
        	if (nextScore >= score) {
        		idx++;
        	}
        }
        System.out.print(idx > limit ? -1 : rank);
	}
}