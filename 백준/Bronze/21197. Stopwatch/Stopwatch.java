import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), sum = 0, pre = -1;
        for (int i = 0; i < n; i++) {
        	int cur = Integer.parseInt(br.readLine());
        	if (i % 2 == 1) sum += cur - pre;
        	else pre = cur;
        }
        if (n % 2 == 1) bw.write("still running");
        else bw.write(sum + "");
        
        bw.flush();
	}
}