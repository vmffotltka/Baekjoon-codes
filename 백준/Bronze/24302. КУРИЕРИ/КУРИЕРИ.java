import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int ans = 0;
        for (int i = 0; i < 2; i++) {
            int x = Integer.parseInt(input[i]);
            int ans1 = 0, ans2 = 0;
            if (x < 6000) ans1 = 400;
            else if (x < 11000) ans1 = 700;
            else if (x < 21000) ans1 = 1200;
            else if (x < 31000) ans1 = 1700;
            else ans1 = (x / 1000) * 57;
            
            if (x < 3000) ans2 = 90 + (x / 1000) * 90;
            else if (x < 6000) ans2 = 100 + (x / 1000) * 85;
            else if (x < 21000) ans2 = 125 + (x / 1000) * 80;
            else if (x < 41000) ans2 = 325 + (x / 1000) * 70;
            else ans2 = 925 + (x / 1000) * 55;
            ans += Math.min(ans1, ans2);
        }
        bw.write(ans / 100 + "." + (ans % 100 < 10 ? "0" : "") + ans % 100);
        bw.flush();
        bw.close(); br.close();
    }
}
