package D2;

import java.util.Scanner;
import java.util.Arrays;
//1974.스도쿠 검증
public class SudokuVerification {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		
		for (int tc=1; tc<=TestCase; tc++) {
			//스도쿠 2차원 배열 생성
			int[][] array = new int[9][9];
			
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			//---------------------------------
			boolean flag = true;
			
			//1) 가로, 세로 검사하기.
			for (int i=0; i<9; i++) {
				// 행
				boolean[] row = new boolean[9];
				// 열
				boolean[] col = new boolean[9];
				Arrays.fill(row, false);
				Arrays.fill(col, false);
				for (int j=0; j<9; j++) {
					row[array[i][j] - 1] = true;
					col[array[j][i] - 1] = true;
				}
				
				for (int p=0; p<9; p++) {
					if (row[p] == false) {
						flag = false;
						break;
					}
				}
				for (int p=0; p<9; p++) {
					if (col[p] == false) {
						flag = false;
						break;
					}
				}
			}
			
			//2) 3x3 검사하기.
			for (int i=0; i<9; i=i+3) {
				for (int j=0; j<9; j=j+3) {
					boolean[] visited = new boolean[9];
					Arrays.fill(visited, false);
					for (int p=0; p<3; p++) {
						for (int q=0; q<3; q++) {
							visited[array[i+p][j+q] - 1] = true;
						}
					}
					
					for (int v=0; v<9; v++) {
						if (visited[v] == false) {
							flag = false;
							break;
						}
					}
				}
			}
			
			if (flag) {
				System.out.printf("#%d %d\n", tc, 1);
			} else {
				System.out.printf("#%d %d\n", tc, 0);
			}
		}
	}

}
