import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int mx = 0, mn = INF;
        String young = "", old = "";
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String name = st.nextToken();
        	int dd = Integer.parseInt(st.nextToken());
        	int mm = Integer.parseInt(st.nextToken());
        	int yy = Integer.parseInt(st.nextToken());
        	int day = dd + mm * 30 + yy * 30 * 12;
        	if (mx < day) { mx = day; young = name; }
        	if (mn > day) { mn = day; old = name; }
        }
        bw.write(young + "\n" + old);
        bw.flush();
        bw.close(); br.close();
    }
}