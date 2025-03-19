import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int a = Integer.parseInt(arr[1]);
        int b = Integer.parseInt(arr[2]);
        int c = Integer.parseInt(arr[3]);
        int mn = Math.min(Math.min(a, b), c);
        int dist = (n == 1 ? 0 : c == mn ? Math.min(a, b) + (n - 2) * c : (n - 1) * mn);
        bw.write(dist / 100 + " " + dist % 100);
        
        bw.flush();
        bw.close(); br.close();
    }
}