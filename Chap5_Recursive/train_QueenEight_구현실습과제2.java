
package Chap5_Recursive;

//92개 해 확인 필요
import java.util.ArrayList;
import java.util.List;

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		setIx(x);
		setIy(y);
	}

	public int getIx() {
		return ix;
	}

	public void setIx(int ix) {
		this.ix = ix;
	}

	public int getIy() {
		return iy;
	}

	public void setIy(int iy) {
		this.iy = iy;
	}

}

class Stack4 {
// --- 실행시 예외: 스택이 비어있음 ---//
// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		top = 0;
		this.capacity = capacity;
		data = new ArrayList<Point>();

	}

// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException("스택이 가득 참");
		data.add(x);
		top++;
		return true;

	}

// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException("스택이 비어 있음");
		top--;
		return data.remove(top);
	}

// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException("스택이 비어있음");
		return data.remove(top - 1);
	}

// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++) {
				System.out.print(data.get(i) + " ");
			}
		}
	}
}

public class train_QueenEight_구현실습과제2 {
	public static void EightQueen(int d[][]) {
		int numberOfSolutions = 0;
		int count = 0;// 퀸 배치 갯수
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		st.push(p);// 스택에 현 위치 객체를 push
		ix++;// ix는 행별로 퀸 배치되는 것을 말한다.
		iy = 0;// 다음 행으로 이동하면 열은 0부터 시작

		while (true) // 교제 p175 코드를 사용하여 구현
		{
			if (st.isEmpty() && ix == 8) {// ix가 8이면 8개 배치 완료, stack이 empty가 아니면 다른 해를 구한다
				System.out.println("종료");
				break;
			}
			System.out.println("while:: ix = " + ix + " iy = " + iy);
			if ((iy = nextMove(d, ix, iy)) == -1) {// 다음 이동할 열을 iy로 주는데 -1이면 더이상 이동할 열이 없음을 나타냄
				try {
					System.out.println("pop전에 >>>ix : " + ix + "iy : " + iy);
					p = st.pop();
					d[p.getIx()][p.getIy()] = 0;
				} catch (Stack4.EmptyGenericStackException t) {
					t.printStackTrace();
				}
				System.out.println("없을때>>>ix : " + ix + "iy : " + iy);
				count--;
				ix = p.getIx();
				iy = p.getIy() + 1;

				continue;
			} else {
				d[ix][iy] = 1;
				try {
					System.out.println("스택 push " + ix + ", " + iy);
					st.push(new Point(ix, iy));
				} catch (Stack4.OverflowGenericStackException e) {
					e.printStackTrace();
				}
				count++;
				ix++;
				iy = 0;
				System.out.println("push후에 >> ix : " + ix + " iy : " + iy);
			}
			if (count == 8) { // 8개를 모두 배치하면 출력
				showQueens(d);
			}

		}
	}

	public static boolean checkRow(int[][] d, int crow) { // 배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
		for (int i = 0; i < d[0].length; i++) {
			if (d[crow][i] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {// 배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
		for (int i = 0; i < d.length; i++) {
			if (d[i][ccol] == 1)
				return false;
		}
		return true;
	}

//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int x = cx;
		int y = cy;

		while (x >= 0 && y <= 7) {
			if (d[x][y] == 1)
				return false;
			x--;
			y++;
		}

		x = cx;
		y = cy;

		while (x <= 7 && y >= 0) {
			if (d[x][y] == 1)
				return false;
			x++;
			y--;
		}
		return true;
	}

//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		int x = cx;
		int y = cy;

		while (x >= 0 && y >= 0) {
			if (d[x][y] == 1)
				return false;
			x--;
			y--;
		}
		x = cx;
		y = cy;

		while (x <= 7 && y <= 7) {
			if (d[x][y] == 1)
				return false;
			x++;
			y++;
		}
		return true;
	}

//배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y)) {
			System.out.println("check move 통과");
			return true;
		}
		return false;
	}

//배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		System.out.println("start=> row : " + row + " col : " + col);
		for (int i = col; i < d[0].length; i++) {
			if (checkMove(d, row, i) == true) {
				System.out.println("row : " + row + " col : " + i);
				return i;
			}
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for(int i = 0 ; i < data.length ; i++) {
			for(int j = 0 ; j < data[i].length ; j++) {
				System.out.print(data[i][j] + ", ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);
	}
}
