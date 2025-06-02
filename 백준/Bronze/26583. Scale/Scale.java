import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
            String[] line = input.split(" ");
            for (int i = 0; i < line.length; i++) {
                int mul = 1;
                for (int j = Math.max(0, i - 1); j <= Math.min(line.length - 1, i + 1); j++) {
                    mul *= Integer.parseInt(line[j]);
                }
                bw.write(mul + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}