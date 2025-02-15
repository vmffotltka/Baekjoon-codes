import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0, mx1 = 0, mx2 = 0;
        for (int i = 0; i < 3; i++) {
        	int p = Integer.parseInt(st.nextToken());
        	sum += p;
        	mx1 = Math.max(mx1, p);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
        	int p = Integer.parseInt(st.nextToken());
        	sum += p;
        	mx2 = Math.max(mx2,  p);
        }
        bw.write(sum - Math.min(mx1, mx2) * 2 + "");
        bw.flush();
        bw.close(); br.close();
    }
}