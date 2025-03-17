import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int month = 7 + (n - 1) * 7;
        bw.write(2024 + month / 12 + " " + (month % 12 + 1));
        
        bw.flush();
        bw.close(); br.close();
    }
}