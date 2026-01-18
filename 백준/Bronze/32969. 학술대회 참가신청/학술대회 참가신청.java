import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] digital = { "social", "history", "language", "literacy" };
        String[] bigdata = { "bigdata", "public", "society" };

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            for (String str : digital) {
                if (s.startsWith(str, i)) {
                    System.out.print("digital humanities");
                    return;
                }
            }
            for (String str : bigdata) {
                if (s.startsWith(str, i)) {
                    System.out.print("public bigdata");
                    return;
                }
            }
        }
    }
}