import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] digital = { "social", "history", "language", "literacy" };
        String[] bigdata = { "bigdata", "public", "society" };

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String course = st.nextToken();
            if (Arrays.asList(digital).contains(course)) {
                System.out.print("digital humanities");
                break;
            }
            else if (Arrays.asList(bigdata).contains(course)) {
                System.out.print("public bigdata");
                break;
            }
        }
    }
}