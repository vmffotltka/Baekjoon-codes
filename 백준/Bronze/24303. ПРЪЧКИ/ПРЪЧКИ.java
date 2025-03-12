import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	final int INF = 987654321;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int L = Integer.parseInt(arr[6]), ans = INF;
        for (int i = 0; i <= Integer.parseInt(arr[3]); i++) {
        	for (int j = 0; j <= Integer.parseInt(arr[4]); j++) {
        		for (int k = 0; k <= Integer.parseInt(arr[5]); k++) {
        			int len = i * Integer.parseInt(arr[0]) + j * Integer.parseInt(arr[1]) + k * Integer.parseInt(arr[2]);
        			if (len >= L) ans = Math.min(ans, i + j + k);
        		}
        	}
        }
        bw.write((ans == INF ? "0" : ans) + "");
        
        bw.flush();
        bw.close(); br.close();
    }
}