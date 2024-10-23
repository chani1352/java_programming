package Chap5_Recursive;

import java.util.Stack;

/*
 * Knight's Tour 문제는 체스판에서 나이트(Knight) 말이 모든 체스판의 칸을 한 번씩만 방문하면서
 * 체스판의 모든 방을 방문하면 종료. 
 * 나이트는 체스에서 "L" 모양으로 움직이는데, 두 칸 직진하고 한 칸 옆으로 이동하는 방식입니다.
 * 임의 위치에서 시작

문제 설명
체스판은 보통 8x8 크기이지만, 이 문제는 임의의 N x N 체스판에서 해결할 수 있습니다.
목표는 나이트가 시작점에서 출발하여 모든 칸을 한 번씩만 방문하면서 끝나는 경로를 찾는 것입니다.
종료조건: 모든 칸이 방문하였을 때 종료 > 방문한 순서를 출력

구현조건:
(x,y)를 저장하는 point 객체를 사용하여 스택으로 non-recursive backtracking 알고리즘으로 구현
 */

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
	static Offsets4[] moves = new Offsets4[8];// static을 선언하는 이유를 알아야 한다
	static final int N = 8;

	// 체스판 배열
	private static int[][] board = new int[N][N];

	// Point 객체로 나이트의 위치를 저장
	static class Point {
		int x, y, moveToward;

		Point(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.moveToward = move;
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

	// 체스판의 범위 내에서 유효한 움직임인지 확인
	private static boolean isSafe(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
	}

	// 나이트 투어 알고리즘 (비재귀적으로 스택 사용)
	private static boolean solveKnightTracking(int startX, int startY) {
		for (int ia = 0; ia < N; ia++)
			moves[ia] = new Offsets4(0, 0);// 배열에 Offsets4 객체를 치환해야 한다.
		moves[0].a = -2;
		moves[0].b = -1;// NW으로 이동
		moves[1].a = -2;
		moves[1].b = 1;// NE
		moves[2].a = -1;
		moves[2].b = 2;// EN
		moves[3].a = 1;
		moves[3].b = 2;// ES
		moves[4].a = 2;
		moves[4].b = 1;// SE
		moves[5].a = 2;
		moves[5].b = -1;// SW
		moves[6].a = -1;
		moves[6].b = -2;// WS
		moves[7].a = 1;
		moves[7].b = -2;// WN
		// 나이트가 이동할 수 있는 8가지 방향
//    	knightMoves direction = null;
//    	
//    	switch(n) {
//    	case 1:
//    		direction = knightMoves.NW;
//    		break;
//    	}
//        
		Stack<Point> stack = new Stack<>();

		// 시작 위치를 스택에 푸시
		stack.push(new Point(startX, startY, 0));
		board[startX][startY] = 0; // 시작 위치는 첫 번째 이동
		int count = 1;
		int num = 0;

		while (!stack.isEmpty()) {
			if (num >= 8) {
				board[startX][startY] = -1;

				stack.pop();
				num = stack.peek().moveToward + 1;
				startX = stack.peek().x;
				startY = stack.peek().y;
				count--;
				continue;
			}
			if (!isSafe(startX+moves[num].a, startY+moves[num].b)) {
				num += 1;
				continue;
			}
			startX += moves[num].a;
			startY += moves[num].b;
			stack.push(new Point(startX, startY, num));
			board[startX][startY] = count;
			count++;
			num = 0;
			if (count == 64)
				return true;

		}
		// 8가지 방향으로 나이트 이동 시도
		// 더 이상 이동할 곳이 없을 경우

		return false; // 해결하지 못함
	}

//		while (!stack.isEmpty()) {
//			for (int i = num ; i < N; i++) {
//				System.out.println("i : " +i);
//				startX += moves[i].a;
//				startY += moves[i].b;
//					
//				if (count == 64)
//					return true;
//				if (isSafe(startX, startY)) {
//					stack.push(new Point(startX, startY, i));
//					board[startX][startY] = count;
//					count++;
//					System.out.println("startX : " + startX + "  startY : " + startY);
//					for (int k = 0; k < N; k++) {
//						for (int j = 0; j < N; j++) {
//							System.out.print(board[k][j] + ",");
//						}
//						System.out.println();
//					}
//					System.out.println("count : "  + count);
//					i = -1;
//					continue;
//				}
//				startX -= moves[i].a;
//				startY -= moves[i].b;
//			}
//			board[startX][startY] = -1;
//			stack.pop();
//			startX = stack.peek().x;
//			startY = stack.peek().y;
//			count--;
//			System.out.println(count);
//			System.out.println("stack x : " + stack.peek().x + "stack y : " + stack.peek().y);
//			System.out.println("stack : " + stack.peek().moveToward);
//			num = stack.peek().moveToward +1;
//
//		}
//		// 8가지 방향으로 나이트 이동 시도
//		// 더 이상 이동할 곳이 없을 경우
//
//		return false; // 해결하지 못함
//	}

	// 결과 출력
	private static void showTracking() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		initializeBoard();

		// 나이트가 (0, 0)에서 시작
		if (solveKnightTracking(0, 0)) {
			showTracking();
		} else {
			System.out.println("해결할 수 없습니다.");
		}
	}
}
