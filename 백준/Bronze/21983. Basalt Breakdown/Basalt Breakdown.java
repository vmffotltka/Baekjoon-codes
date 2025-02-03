import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double s = Double.parseDouble(br.readLine());
        bw.write(Math.sqrt((2 * s) / (3 * Math.sqrt(3))) * 6 + "");
        bw.flush();
        bw.close(); br.close();
	}
}