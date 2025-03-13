import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int time = Integer.parseInt(input[0]) * 60 + Integer.parseInt(input[1]);
        time = ((time + 60 * 24) - 10 - Integer.parseInt(br.readLine())) % (60 * 24);
        input = br.readLine().split(" ");
        time = ((time + 60 * 24) - Integer.parseInt(input[0]) * 60 - Integer.parseInt(input[1])) % (60 * 24);
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        time = ((time + 60 * 24) - (n + 1) * m) % (60 * 24);
        bw.write(String.format("%02d %02d", time / 60, time % 60));
        bw.flush();
        bw.close(); br.close();
    }
}
