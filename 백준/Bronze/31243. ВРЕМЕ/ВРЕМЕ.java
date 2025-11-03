import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int h1 = Integer.parseInt(st.nextToken());
        	int m1 = Integer.parseInt(st.nextToken());
        	int h2 = Integer.parseInt(st.nextToken()) + 24;
        	int m2 = Integer.parseInt(st.nextToken());
        	
        	int start = h1 * 60 + m1, end = h2 * 60 + m2;
        	int duration = (end - start) % (24 * 60);
        	mn = Math.min(mn, duration);
        	mx = Math.max(mx, duration);
        }
        System.out.printf("%d:%02d\n%d:%02d", mn / 60, mn % 60, mx / 60, mx % 60);
    }
}