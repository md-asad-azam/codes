import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        nextCase:
        for(int t = 0; t < T; t++) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] map = new int[R][C];
            for(int i = 0; i < R; i++) {
                String line = in.next();
                for(int j = 0; j < C; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] sub = new int[r][c];
            for(int i = 0; i < r; i++) {
                String line = in.next();
                for(int j = 0; j < c; j++) {
                    sub[i][j] = line.charAt(j) - '0';
                }
            }
            for(int i = 0; i <= R - r; i++) {
                for(int j = 0; j <= C - c; j++) {
                    boolean works = true;
                    outer:
                    for(int a = 0; a < r; a++) {
                        for(int b = 0; b < c; b++) {
                            if(map[i + a][j + b] != sub[a][b]) {
                                works = false;
                                break outer;
                            }
                        }
                    }
                    if(works) {
                        System.out.println("YES");
                        continue nextCase;
                    }
                }
            }
            System.out.println("NO");
        }
    }
}
