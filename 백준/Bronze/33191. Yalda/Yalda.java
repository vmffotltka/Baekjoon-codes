import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int b = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        bw.write(b >= w ? "Watermelon" : (b >= p ? "Pomegranates" : (b >= n ? "Nuts" : "Nothing")));
        bw.flush();
        bw.close(); br.close();
	}
}