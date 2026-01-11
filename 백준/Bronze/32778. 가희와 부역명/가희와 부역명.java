import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "(");
        String firstPart = st.nextToken();
        String secondPart = "-";
        if (st.hasMoreTokens()) {
            secondPart = st.nextToken().replace(")", "");
        }
        System.out.println(firstPart);
        System.out.print(secondPart);
    }
}