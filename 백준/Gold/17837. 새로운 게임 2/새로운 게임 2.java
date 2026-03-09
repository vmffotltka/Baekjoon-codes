import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = { 0, 0, -1, 1 };
    static int[] dx = { 1, -1, 0, 0 };
    static int N, K;
    static int[][] map;
    static class Piece {
        int y, x, num, d;
        public Piece(int y, int x, int num, int d) {
            this.y = y;
            this.x = x;
            this.num = num;
            this.d = d;
        }
    }

    static List<List<List<Piece>>> pieces = new ArrayList<>();
    static List<Piece> pieceList = new ArrayList<>();
    static HashMap<String, Boolean> visited = new HashMap<>();
    static boolean isVisited() {
        String s = "";
        for (int i = 0; i < K; i++) {
            Piece piece = pieceList.get(i);
            s += piece.y + "," + piece.x + "," + piece.d + ";";
        }
        if (visited.containsKey(s))
            return true;
        visited.put(s, true);
        return false;
    }

    static void move(int y, int x, int ny, int nx, int target, boolean isRed) {
        List<Piece> list = new ArrayList<>();
        for (int i = 0; i < pieces.get(y).get(x).size(); i++) {
            Piece piece = pieces.get(y).get(x).get(i);
            if (piece.num == target) {
                for (int j = i; j < pieces.get(y).get(x).size(); j++) {
                    Piece p = pieces.get(y).get(x).get(j);
                    p.y = ny;
                    p.x = nx;
                    list.add(p);
                }
                for (int j = pieces.get(y).get(x).size() - 1; j >= i; j--)
                    pieces.get(y).get(x).remove(j);
                break;
            }
        }
        if (isRed)
            Collections.reverse(list);

        pieces.get(ny).get(nx).addAll(list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            pieces.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                pieces.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            Piece piece = new Piece(y, x, i + 3, d);
            pieces.get(y).get(x).add(piece);
            pieceList.add(piece);
        }

        int turn = 0;
        while (true) {
            if (isVisited() || turn == 1000) {
                turn = -1;
                break;
            }
            turn++;
            boolean isEnd = false;
            for (int i = 0; i < K; i++) {
                Piece piece = pieceList.get(i);
                int y = piece.y, x = piece.x, d = piece.d;
                int ny = y + dy[d], nx = x + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 2) {
                    piece.d = d % 2 == 0 ? d + 1 : d - 1;
                    d = piece.d;
                    ny = y + dy[d];
                    nx = x + dx[d];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 2)
                        continue;

                    boolean isRed = map[ny][nx] == 1;
                    move(y, x, ny, nx, piece.num, isRed);
                }
                else {
                    boolean isRed = map[ny][nx] == 1;
                    move(y, x, ny, nx, piece.num, isRed);
                }
                if (pieces.get(ny).get(nx).size() >= 4) {
                    isEnd = true;
                    break;
                }
            }
            if (isEnd)
                break;
        }
        System.out.print(turn);
    }
}