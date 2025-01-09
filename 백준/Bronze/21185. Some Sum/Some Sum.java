import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if ((n & 1) == 1) {
            bw.write("Either\n");
        }
        else {
            bw.write((n % 4 == 2) ? "Odd\n" : "Even\n");
        }

        bw.flush();
        bw.close();
	}
}