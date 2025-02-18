import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int score[] = new int[3];
        for (int i = 0; i < 3; i++) {
        	score[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine()), ans = 0;
        for (int i = 0; i < n; i++) {
        	int sum = 0;
        	for (int j = 0; j < 3; j++) {
        		st = new StringTokenizer(br.readLine());
        		for (int k = 0; k < 3; k++) {
        			sum += Integer.parseInt(st.nextToken()) * score[k];
        		}
        	}
        	ans = Math.max(sum, ans);
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}