import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        int[] coor = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	coor[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
        	st = new StringTokenizer(br.readLine());
        	int cmd = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (cmd == 1)
        		coor[a - 1] = b;
        	else
        		sb.append(Math.abs(coor[a - 1] - coor[b - 1])).append('\n');
        }
        System.out.print(sb);
    }
}