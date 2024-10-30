package Chap5_Recursive;

import java.util.Stack;

enum knightMoves {
	NW, NE, EN, ES, SE, SW, WS, WN
}

class Offsets4 {
	int a;
	int b;

	public Offsets4(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class train_5_7_1KnightTracking_실습 {
	static Offsets4[] moves = new Offsets4[8];
	static final int N =6;
	
	private static int[][] board = new int[N][N];
	static class Point {
		int x, y, moveToward;

		Point(int x, int y, int move) {
			this.x = x;
			this.y = y;
			moveToward = move;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", moveToward=" + moveToward + "]";
		}

	}

	// 체스판을 초기화 (-1로 설정)
	private static void initializeBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = -1;
			}
		}

	}

	private static boolean isSafe(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
	}

	private static boolean solveKnightTracking(int startX, int startY) {
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets4(0, 0);// 배열에 Offsets4 객체를 치환해야 한다.
		moves[0].a = -2; moves[0].b = -1;// NW으로 이동
		moves[1].a = -2; moves[1].b = 1;// NE
		moves[2].a = -1; moves[2].b = 2;// EN
		moves[3].a = 1; moves[3].b = 2;// ES
		moves[4].a = 2; moves[4].b = 1;// SE
		moves[5].a = 2; moves[5].b = -1;// SW
		moves[6].a = 1; moves[6].b = -2;// WS
		moves[7].a = -1; moves[7].b = -2;// WN

		Stack<Point> stack = new Stack<>();

		stack.push(new Point(startX, startY, 0));
		board[startX][startY] = 1; // 시작 위치는 첫 번째 이동
		int d = 0;	

		while (!stack.isEmpty()) {
			startX = stack.peek().x;
			startY = stack.peek().y;
			if (d == 8) {
				board[startX][startY] = -1;
				d = stack.peek().moveToward + 1;
				stack.pop();
				continue;
			}
			if (!isSafe(startX + moves[d].a, startY + moves[d].b)) {
				d++;
				continue;
			}
			int newX = startX + moves[d].a;
			int newY = startY + moves[d].b;
			stack.push(new Point(newX, newY, d));
			board[newX][newY] = stack.size();
			d =0;
			if (stack.size() == N * N)
				return true;
		}
		
//		while (!stack.isEmpty()) {
//			startX = stack.peek().x;
//			startY = stack.peek().y;
//			if (stack.peek().moveToward == 8) {
//				board[startX][startY] = -1;
//				stack.pop();
//				continue;
//			}
//			if (!isSafe(startX + moves[stack.peek().moveToward].a, startY + moves[stack.peek().moveToward].b)) {
//				stack.peek().moveToward++;
//				continue;
//			}
//			int newX = startX + moves[stack.peek().moveToward].a;
//			int newY = startY + moves[stack.peek().moveToward].b;
//			stack.peek().moveToward += 1 ;
//			stack.push(new Point(newX, newY, 0));
//			board[newX][newY] = stack.size();
//			if (stack.size() == N * N)
//				return true;
//		}
		
		return false; // 해결하지 못함
	}

	// 결과 출력
	private static void showTracking() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + ", ");
			}
			System.out.println();
		}

	}
	public static void main(String[] args) {

		initializeBoard();

		// 나이트가 (0, 0)에서 시작
		if (solveKnightTracking(2,2)) {
			showTracking();
		} else {
			System.out.println("해결할 수 없습니다.");
		}
	}
}