import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = {
        		{
        			1, 1, 1
        		},
        		{
        			1, 1, 1
        		},
        		{
        			1, 1, 1
        		},
        		{
        			1, 1, 1
        		},
        		{
        			2, 2, 2
        		}
        };
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	String s = st.nextToken();
        	int y = s.charAt(0) - '0' - 1;
        	int x = s.charAt(1) - 'A';
        	arr[y][x]--;
        	
        	if (arr[y][x] == 0) cnt++;
        }
        bw.write(cnt == 15 ? "TAK" : "NIE");
        bw.flush();
        bw.close(); br.close();
    }
}