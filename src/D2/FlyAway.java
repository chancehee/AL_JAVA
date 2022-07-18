package D2;

import java.util.Scanner;
//2001.파리 퇴치
public class FlyAway {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		
		for (int tc=1; tc<=TestCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] array = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			// ---------------------------------
			// 데이터 준비 완료
			int max = 0;
			
			for (int i=0; i<N-M+1; i++) {
				for (int j=0; j<N-M+1; j++) {
					int temp = 0;
					for (int p=0; p<M; p++) {
						for (int q=0; q<M; q++) {
							temp += array[i+p][j+q];
						}
					}
					max = Math.max(max, temp);
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);

		}
	}

}
