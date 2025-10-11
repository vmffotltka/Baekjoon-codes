import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int mx = -1, cnt = 0;
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	int pre = 0, blacks = 0;
        	for (int j = 0; j < l; j++) {
        		if (s.charAt(j) == '0' && pre == 1) {
        			blacks++;
        		}
        		pre = s.charAt(j) - '0';
        	}
        	if (pre == 1) blacks++;
        	
        	if (mx < blacks) {
        		mx = blacks;
        		cnt = 1;
        	}
        	else if (mx == blacks)
        		cnt++;
        }
        StringBuilder sb = new StringBuilder().append(mx).append(' ').append(cnt);
        System.out.print(sb.toString());
    }
}