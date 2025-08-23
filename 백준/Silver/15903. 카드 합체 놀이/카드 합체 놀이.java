import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]), m = Long.parseLong(input[1]);
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0;
        
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
        	long p = Long.parseLong(input[i]);
        	pq.add(p);
        	sum += p;
        }
        
        for (int i = 0; i < m; i++) {
        	long a = pq.poll(), b = pq.poll();
        	pq.add(a + b);
        	pq.add(a + b);
        	sum += a + b;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}