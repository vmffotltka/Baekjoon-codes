import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int standard = Integer.parseInt(br.readLine()), low = 0, high = 0;
        for (int i = 0; i < n - 1; i++) {
        	int p = Integer.parseInt(br.readLine());
        	if (p < standard) low++;
        	else high++;
        }
        bw.write(low == 0 ? "ez" : (high == 0 ? "hard" : "?"));
        bw.flush();
	}
}