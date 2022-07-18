package D2;

import java.util.Scanner;
// 1979. 어디에 단어가 들어갈 수 있을까
public class WhereCanTheWordsGo {

	// k가 몇개 들어갈 수 있는지 리턴해주는 함수
	static int check(int[][] arr,int n, int k) {
		int result = 0;
		for (int i=0; i<n; i++) {
			int cnt = 0;
			for (int j=0; j<n; j++) {
				// 현재 위치가 검은색인 경우 (이전에 칸 수가 k랑 일치한다면 놓을 수 있는 경우다.)
				if(arr[i][j] == 0) {
					if (cnt == k) {
						result++;
					}
					cnt = 0;
				} else {
					cnt += 1;
				}
			}
			// 반복을 끝냈을 때, 칸 수가 k랑 일치하는지 비교.
			if (cnt == k) {
				result++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		
		for (int tc=1; tc<=TestCase; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int answer = 0;
			
			//2차원 배열 선언
			int[][] array;
			array = new int[N][N];
			
			//N번 입력 값을 2차원 배열에 할당
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					array[i][j] = sc.nextInt();
				}
			}
		
			//K가 들어갈 수 있는지 판단하기(함수로 만들기)
			answer += check(array, N, K);
			
			
			//90도 회천 배열 만들기(함수로 만들기)
			int[][] changeArray = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					changeArray[i][j] = array[N-1-j][i];
				}
			}
			
			answer += check(changeArray, N, K);
			System.out.printf("#%d %d\n", tc, answer);
			
			
		}
	}

}
