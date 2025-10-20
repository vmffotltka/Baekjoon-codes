import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < k; i++) {
        	sum += Integer.parseInt(st.nextToken());
        }
        System.out.print(sum / m + (sum % m == 0 ? 0 : 1));
    }
}