package D2;

import java.util.Scanner;

//1961.숫자 배열 회전
public class RotateAnArrayOfNumbers {
	
	//2차원 배열을 90도 회전하는 함수
	static int[][] rotateArray(int[][] a, int n){
		//회전 후 데이터를 담을 2차원 배열
		int[][] result = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				result[i][j] = a[n-1-j][i];
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		
		for (int tc=1; tc<=TestCase; tc++) {
			int N = sc.nextInt();
			int[][] array = new int[N][N];
			
			// 배열에 값 입력받기
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			
			int[][] array_90 = new int[N][N];
			array_90 = rotateArray(array, N);
			
			int[][] array_180 = new int[N][N];
			array_180 = rotateArray(array_90, N);
			
			int[][] array_270 = new int[N][N];
			array_270 = rotateArray(array_180, N);
			
			System.out.printf("#%d\n", tc);
			for (int w=0; w<N; w++) {
				String st = "";
				for (int i=0; i<N; i++) {
					st += Integer.toString(array_90[w][i]);
				}
				st += " ";
				for (int i=0; i<N; i++) {
					st += Integer.toString(array_180[w][i]);
				}
				st += " ";
				for (int i=0; i<N; i++) {
					st += Integer.toString(array_270[w][i]);
				}
				
				System.out.println(st);
				
			}

			
			
			
			
			
			
		}
	}

}
