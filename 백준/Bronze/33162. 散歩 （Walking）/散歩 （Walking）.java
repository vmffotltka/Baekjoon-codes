import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write((n % 2 == 0 ? n / 2 : n / 2 + 3) + "");
        bw.flush();
        bw.close(); br.close();
	}
}