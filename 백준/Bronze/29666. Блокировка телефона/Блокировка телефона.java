import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().trim();
        int[] digits = new int[3];
        for (int i = 0; i < 3; i++) {
            digits[i] = input.charAt(i) - '0';
        }

        Map<Integer, int[]> pos = new HashMap<>();
        pos.put(1, new int[]{0, 0});
        pos.put(2, new int[]{0, 1});
        pos.put(3, new int[]{0, 2});
        pos.put(4, new int[]{1, 0});
        pos.put(5, new int[]{1, 1});
        pos.put(6, new int[]{1, 2});
        pos.put(7, new int[]{2, 0});
        pos.put(8, new int[]{2, 1});
        pos.put(9, new int[]{2, 2});
        pos.put(0, new int[]{3, 1});

        if (digits[0] == digits[1] || digits[0] == digits[2] || digits[1] == digits[2]) {
            bw.write("Locked");
            bw.flush();
            return;
        }

        boolean unlocked = false;
        if (pos.get(digits[0])[0] == pos.get(digits[1])[0] && pos.get(digits[1])[0] == pos.get(digits[2])[0]) {
            int[] cols = {pos.get(digits[0])[1], pos.get(digits[1])[1], pos.get(digits[2])[1]};
            Arrays.sort(cols);
            if (cols[1] == cols[0] + 1 && cols[2] == cols[1] + 1) {
                unlocked = true;
            }
        }

        if (!unlocked && pos.get(digits[0])[1] == pos.get(digits[1])[1] && pos.get(digits[1])[1] == pos.get(digits[2])[1]) {
            int[] rows = {pos.get(digits[0])[0], pos.get(digits[1])[0], pos.get(digits[2])[0]};
            Arrays.sort(rows);
            if (rows[1] == rows[0] + 1 && rows[2] == rows[1] + 1) {
                unlocked = true;
            }
        }

        bw.write(unlocked ? "Unlocked" : "Locked");
        bw.flush();
    }
}
