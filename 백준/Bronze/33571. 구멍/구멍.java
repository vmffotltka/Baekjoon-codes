import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int ans = 0;
        for (char c : s.toCharArray()) {
        	if (c == 'A' || c == 'a' || c == 'b' || c == 'D' || c == 'd' || c == 'e' || c == 'g' || c == 'O' || c == 'o' || c == 'P' || c == 'p' || c == 'Q' || c == 'q' || c == 'R' || c == '@')
        		ans++;
        	else if (c == 'B')
        		ans += 2;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}
