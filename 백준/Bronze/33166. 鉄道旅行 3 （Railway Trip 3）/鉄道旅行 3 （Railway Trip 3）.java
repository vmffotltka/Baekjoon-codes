import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String p_q[] = br.readLine().split(" ");
        String a_b[] = br.readLine().split(" ");
        int p = Integer.parseInt(p_q[0]);
        int q = Integer.parseInt(p_q[1]);
        int a = Integer.parseInt(a_b[0]);
        int b = Integer.parseInt(a_b[1]);
        bw.write(Math.min(p, q) * a + (q > p ? (q - p) * b : 0) + "");
        bw.flush();
        bw.close(); br.close();
	}
}