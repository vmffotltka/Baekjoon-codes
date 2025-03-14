import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	final int INF = 987654321;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < 4; i++) {
        	sum += Integer.parseInt(input[i]);
        }
        int ans = INF;
        for (int i = 0; i < 4; i++) {
        	int cur = Integer.parseInt(input[i]);
        	ans = Math.min(ans, Math.abs(sum - cur * 2));
        	for (int j = i + 1; j < 4; j++) {
        		ans = Math.min(ans, Math.abs(sum - (cur + Integer.parseInt(input[j])) * 2));
        	}
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}
