import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String nk[] = br.readLine().split(" "), ds[] = br.readLine().split(" ");
        double n = Double.parseDouble(nk[0]), k = Integer.parseInt(nk[1]), d = Integer.parseInt(ds[0]), s = Integer.parseInt(ds[1]);
        double ans = (n * d - k * s) / (n - k);
        bw.write(ans <= 100 && 0 <= ans ? ans + "" : "impossible");
    	bw.flush();
    	bw.close(); br.close();
	}
}