import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        long a = Integer.parseInt(arr[0]);
        long b = Integer.parseInt(arr[1]);
        long c = Integer.parseInt(arr[2]);
        bw.write(Math.max(Math.max(a * b + c, a + b * c), a * c + b) + "");
        bw.flush();
        bw.close(); br.close();
    }
}