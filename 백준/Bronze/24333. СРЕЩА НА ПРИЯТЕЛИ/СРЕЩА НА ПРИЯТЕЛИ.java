import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int start = Math.max(Integer.parseInt(input[0]), Integer.parseInt(input[2]));
        int end = Math.min(Integer.parseInt(input[1]), Integer.parseInt(input[3]));
        int ans = end - start + 1;
        if (start <= Integer.parseInt(input[4]) && Integer.parseInt(input[4]) <= end) ans--;
        bw.write(Math.max(0, ans) + "");
        
        bw.flush();
        bw.close(); br.close();
    }
}