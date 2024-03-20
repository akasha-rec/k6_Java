package Data_Ch05;
//퀸을 배치하면 스택에 저장하고 더 이상 배치가 가능하지 않으면 pop()으로 backtracking 하여 다음 열에 대하여 시도하고, 더이상 탐색할 열이 없으면 다시 pop하는 과정으로 backtracking 과정을 이해하는 것이 문제의 핵심임
//이 과제는 스택에 push, pop으로 backtracking 해결 방법을 익히는 것이 목적임

//해가 256개 확인 필요 23.12.12
import java.util.ArrayList;
import java.util.List;

import Data_Ch05.Stack4.EmptyGenericStackException;


//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {//Point 객체의 좌표 반환
		return ix;
	}

	public int getY() {//Point 객체의 좌표 설정
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}

	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point) p).ix) && (this.iy == ((Point) p).iy))
			return true;
		else
			return false;
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

	private List<Point> data; // 스택용 리스트
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		top = 0;
		this.capacity = capacity;
		try {
			data = new ArrayList<>();
		} catch (OutOfMemoryError e){
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if (isFull())
			throw new OverflowGenericStackException("push: Stack overflow");
		else {
			top++;
			data.add(x);
			return true;
		}
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("pop : Stack empty");
		else {
			--top;
			return data.remove(top);
		}
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (isEmpty()) {
			throw new EmptyGenericStackException("peek : Stack empty");
		} else {
			return data.get(top-1);
		}
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
	public void dump() throws EmptyGenericStackException{
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class Test_QueenEight_구현과제 {
	public static void EightQueen(int[][] d) {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0; //해?
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		ix++;
		st.push(p);// 스택에 현 위치 객체를 push
		while (true) {
			if (ix >= 8) {
				showQueens(d);
				break;
			}
			iy = nextMove(d, ix, iy);
			System.out.println("iy : " + iy);
			if (iy != -1) { //이동할 수 있어서 push
				//p = new Point(ix, iy);
				//st.push(p);
				st.push(new Point(ix, iy));
				d[ix][iy] = 1; //놓았다.
				ix++;//다음 행으로 이동해야 하니까 x++라고 생각
				iy=0;//0열부터 다시 시작
				count++;//놓을 수 있으니까 Q가 하나 생긴다고 생각
				continue;
			}
			
			if (count == 8) { //모든 경우의 수 출력... 1. 겹치지 않게 위치해서 출력하고자 한다.
				numberSolutions++; //해의 개수 세기
				System.out.println("["+numberSolutions+"]");
				System.out.println();
				showQueens(d);
				try {
					p = st.pop();
				} catch(Stack4.EmptyGenericStackException e) {
					e.getMessage();					
				}
				ix = p.getX(); //pop한 위치의 좌표를 갖고 오는 메서드
				iy = p.getY();
				d[ix][iy] = 0; //이전 위치의 퀸을 제거하고
				iy++;//다음 열 탐색
				count--;
				continue;
			} else {
				if (st.isEmpty()) {//2. 스택이 비어있는 경우 8개 위치 성공해서 비었거나
					break;
				} else {
					try {
						p = st.pop();
					} catch(Stack4.EmptyGenericStackException e) {
						e.getMessage();	
					}
				ix = p.getX(); //pop한 위치의 좌표를 갖고 오는 메서드
				iy = p.getY();
				d[ix][iy] = 0; //이전 위치의 퀸을 제거하고
				iy++;//다음 열 탐색
				count--;
			}
			}
		}
				//else {//이동할 수 없을 때 pop. push할 때 출력하는 코드를 왜 썼을까...
				//try {
				//		p = st.pop(); //pop한 위치를 p에
				//	} catch (Stack4.EmptyGenericStackException e) {
				//		e.getMessage();
				//	}
				//ix = p.getX(); //pop한 위치의 좌표를 갖고 오는 메서드
				//iy = p.getY();
				//d[ix][iy] = 0; //이전 위치의 퀸을 제거하고
				//iy++;//다음 열 탐색
				//count--;
				//continue;

			} 	


		//8 Queen 문제는 각 행에, 각 열에, 각 대각선에 모두 퀸이 하나씩 놓여야 해결 > 목표...
		public static boolean checkRow(int[][] d, int crow) {//배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
			for (int x = 0; x < d.length; x++) {//각 행을 반복해서 조사하고 싶다.
				if (d[crow][x] == 1) //그래서 어떤 행에 이미 퀸이 있다면 >> 어떤 열에 퀸이 있는지 조사 > 그래서 행은 고정 - 3/18
					return false; //못 놓는다.
			}
			return true; //놓을 수 있다.
		}

		public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
			for (int y = 0; y < d[0].length; y++) { //각 열을 반복해서 조사하고 싶다
				if (d[y][ccol] == 1) //그래서 어떤 열에 이미 퀸이 있다면 >> 어떤 행에 퀸이 있는지 조사 > 그래서 열은 고정 - 3/18
					return false; //못 놓는다
			}
			return true; //놓을 수 있다.
		}

		// 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
		public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
			int x = cx;
			int y = cy;
			while (0 <= x && x <= 7 && 0 <= y && y <= 7) {//배열을 넘으면 안 되니까
				if(d[x][y] == 1 ) {//남서 방향으로 Q이 있으면 못 둔다
					return false;				
				}
				x++; //아니라면 남서 방향으로.
				y--;
			}

			x = cx; //초기화
			y = cy;

			while (0 <= x && x <= 7 && 0 <= y && y <= 7) {//배열을 넘으면 안 되니까
				if(d[x][y] == 1 ) {//북동 방향으로 Q이 있으면 못 둔다
					return false;				
				}
				x--; //아니라면 북동 방향으로.
				y++;
			}
			return true;//둘 수 있다.
		}

		// 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
		public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
			int x = cx;
			int y = cy;
			while (0 <= x && x <= 7 && 0 <= y && y <= 7) {//배열을 넘으면 안 되니까
				if(d[x][y] == 1) { //남동 방향으로 Q 있으면 못 둔다.
					return false;
				}
				x++; //아니라면 남동 방향으로 둘 수 있다.
				y++;
			}
			x = cx;
			y = cy;
			while (0<= x && x <= 7 && 0 <= y && y <= 7) {
				if (d[x][y] == 1) { //북서 방향으로 Q 있으면 못 둔다
					return false;
				}
				x--; //아니라면 북서 방향으로 둘 수 있다.
				y--;
			}
			return true;
		}

		// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
		public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
			if (checkRow(d, x) & checkCol(d, y) & checkDiagSW(d, x, y) & checkDiagSE(d, x, y)) {
				return true;
			}
			return false;
		}

		// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
		public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
			for (int i = col+1; i < d[0].length; i++) {
				if (checkMove(d, row, i)) //놓을 수 있다 = 이동할 수 있다.
					return i; //놓을 수 있는 다음 열을 알아냈다.
			}
			return -1; //이동하지 못한다.
		}

		static void showQueens(int[][] data) {// 퀸이 배치된 결과값을 출력해주는 메서드. for문에서 무조건 괄호 써주기.
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[0].length; j++) {
					System.out.print(data[i][j] + " ");			
				}
				System.out.println();
			}
		}
		public static void main(String[] args)  {
			int row = 8, col = 8;
			int[][] data = new int[8][8];
			for (int i = 0; i < data.length; i++)
				for (int j = 0; j < data[0].length; j++)
					data[i][j] = 0;

			EightQueen(data);

		}
	}