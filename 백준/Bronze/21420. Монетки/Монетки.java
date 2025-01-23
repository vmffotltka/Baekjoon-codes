import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), cnt = 0;
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(br.readLine());
        	if (p == 1) cnt++;
        }
        bw.write(Math.min(n - cnt, cnt) + "");
        bw.flush();
        bw.close(); br.close();
	}
}