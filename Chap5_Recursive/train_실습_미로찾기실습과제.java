package Chap5_Recursive;

import java.util.Stack;

/*
 * 미로 찾기 문제
 * plato(LMS)의 미로 찾기 문제 설명 자료 학습
 * int input[12][15] 테이블에서 입구는 (0,0)이며 출구는 (11,14)임
 * 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * stack을 사용한 backtracking 구현
 */

//23.2.16 수정
//23.2.24: 객체 배열 초기화, static 사용, 내부 클래스와 외부 클래스 사용 구분을 못하는 문제 => 선행 학습 필요
enum Directions {
	N, NE, E, SE, S, SW, W, NW
}

class Items {
	int x;
	int y;
	int dir;

	public Items(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

class Offsets {
	int a;
	int b;

	public Offsets(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class train_실습_미로찾기실습과제 {
	static Offsets[] moves = new Offsets[8];// static을 선언하는 이유를 알아야 한다
	static void path(int maze[][], int mark[][], int m, int p) {
		Stack<Items> stack = new Stack<>();
		int i = 1; int j = 1;
		int g = 0; int h = 0;
		int dir = 2; int d = 0;
		
		stack.push(new Items(i,j,dir));
		mark[i][j] = 1;	
		maze[i][j] = 2;
	
		while (!stack.isEmpty()){
			while (d <= 7){	
				g = i + moves[d].a;
				h = j + moves[d].b;
				if(maze[g][h] == 1) {
					g = i;
					h = j;
					d++;
					continue;
				}

				if ((g == m) && (h == p)) {	
					mark[g][h] = 1;
					maze[g][h] = 2;
					return;
				}
				if ((maze[g][h] == 0) && (mark[g][h] == 0))
				{
					mark[g][h] = 1;
					maze[g][h] = 2;
					stack.push(new Items(g,h,d));
					i = g; j = h; d = 0;
				}
				else
					d++; 
				}
			d = stack.peek().dir;
			stack.pop();
			maze[i][j] = 0;
			i = stack.peek().x;
			j = stack.peek().y;
		}
	}
	
	public static void show(String msg,int[][] arr) {
		System.out.println(msg);
		for(int k = 0; k < arr.length ; k++) {
			for(int l = 0; l < arr[0].length ; l++) {
				System.out.print(arr[k][l] + ",");
			}
			System.out.println();
		}		
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 } };

		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);// 배열에 offsets 객체를 치환해야 한다.
		moves[0].a = -1;  moves[0].b = 0;
		moves[1].a = -1;  moves[1].b = 1;
		moves[2].a = 0;   moves[2].b = 1;
		moves[3].a = 1;   moves[3].b = 1;
		moves[4].a = 1;   moves[4].b = 0;
		moves[5].a = 1;   moves[5].b = -1;
		moves[6].a = 0;   moves[6].b = -1;
		moves[7].a = -1;  moves[7].b = -1;
//		Directions d;
//		d = Directions.N;
		// maze 초기화
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (i == 13) || (j == 0) || (j == 16))
					maze[i][j] = 1;
				else
					maze[i][j] = input[i - 1][j - 1];
			}
		}
		// mark 초기화
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				mark[i][j] = 0;
			}
		}
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);
		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

	}
}
