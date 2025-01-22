import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
    	String [] p = br.readLine().split(" ");
        int a = 0, b = 0, pre = Integer.parseInt(p[0]);
    	for (int i = 1; i < n; i++) {
    		int cur = Integer.parseInt(p[i]);
        	if (pre < cur) b += cur  - pre;
        	else a += pre - cur;
        	pre = cur;
        }
    	bw.write(a + " " + b);
    	bw.flush();
    	bw.close(); br.close();
	}
}