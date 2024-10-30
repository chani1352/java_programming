package Chap5_Recursive;

public class KnightTour {
    private static final int N = 8; // 체스판의 크기
    private static final int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1; // 모든 칸을 방문하지 않은 상태로 초기화
            }
        }

        board[0][0] = 0; // 시작 위치
        if (solveKT(0, 0, 1, board)) {
            printSolution(board);
        } else {
            System.out.println("해결할 수 없습니다.");
        }
    }

    private static boolean solveKT(int currX, int currY, int movei, int[][] board) {
        if (movei == N * N) {
            return true; // 모든 칸을 방문했으면 성공
        }

        for (int k = 0; k < 8; k++) {
            int nextX = currX + moveX[k];
            int nextY = currY + moveY[k];

            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = movei; // 현재 이동 수를 기록
                if (solveKT(nextX, nextY, movei + 1, board)) {
                    return true; // 다음 위치에서 성공하면 종료
                } else {
                    board[nextX][nextY] = -1; // 실패하면 다시 초기화
                }
            }
        }
        return false; // 모든 경우를 시도해도 실패
    }

    private static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

