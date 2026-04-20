import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] box = new int[n];
        for (int i = 0; i < n; i++)
            box[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] book = new int[m];
        for (int i = 0; i < m; i++)
            book[i] = Integer.parseInt(st.nextToken());

        int box_idx = 0, book_idx = 0;
        while (box_idx < n && book_idx < m) {
            int curBox = box[box_idx], curBook = book[book_idx];
            if (curBox < curBook)
                box_idx++;
            else {
                box[box_idx] -= curBook;
                book_idx++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += box[i];

        System.out.print(ans);
    }
}