package day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 구간합 구하기 5
문제: N * N 크기의 2차원 행렬에서 원하는 부분 행렬을 구하는 문제이다.

아이디어: 
	예를 들어 4 * 4 행렬에서 
	인덱스 시작을 1로 하면, (2,2) ~ (3,3)의 합은 arr[2][2] + arr[2][3] + arr[2][4]
	+ arr[3][2] + arr[3][3] + arr[3][4] 이다.
	최악 시간 복잡도는 N=1024 M=100000 => N * M = 1억을 넘기 때문에 (시간 제한 1초) 시간 제한안에 해결 할 수 없다.
	따라서 누적 합을 관리하는 2차원 배열을 통해서 해결했다. (memoization)
 */
public class Main_B_11660 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		// 데이터를 담는 2차원 배열
		int[][] arr = new int[N][N];
		// 가로,세로 누적합을 저장 시킬 2차원 배열
		int[][] dp = new int[N+1][N+1];
		for (int i=0; i<N; i++) {
			String[] a = br.readLine().split(" ");
			for (int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(a[j]);
			}
		}
		
		// 가로 방향 누적합
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				dp[i][j+1] = dp[i][j] + arr[i][j];
			}
		}

		// 세로 방향 누적합
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<N+1; j++) {
				dp[i+1][j] += dp[i][j];
			}
		}
		
		// 데이터가 잘 저장 됐는지 확인 용도.
//		for (int[] datas : dp) {
//			for (int data: datas) {
//				System.out.print(data + " ");
//			}
//			System.out.println();
//		}
		
		for (int i=0; i<M; i++) {
			
			// 원하는 좌표 범위를 입력 받는다.
			String[] k = br.readLine().split(" ");
			int x = Integer.parseInt(k[0]);
			int y = Integer.parseInt(k[1]);
			int x2 = Integer.parseInt(k[2]);
			int y2 = Integer.parseInt(k[3]);
			
			// dp 배열에 인덱스를 접근하기 위해서 좌표 위치 가공.
			x = x-1;
			x2 = x2-1;

			int diff = 0;
			// dp 배열에서 인덱스 0일때 패딩처리를 안해서 조건문을 통해서 인덱스 에러 방지.
			if (x == 0) {
				diff = dp[x2][y2] - dp[x2][y-1];
			} else {
				// 격자 모양에서 부분합을 구하려면 = 전체 누적 합 - 좌표 값에 해당하지 않는 부분 합 => 원하는 구간 누적합 
				diff = dp[x2][y2] + dp[x-1][y-1] - dp[x-1][y2] - dp[x2][y-1];
			}
			
			sb.append(diff+"\n");
		}
		// 스트링 빌더를 통한 출력
		System.out.print(sb.toString());
		
	}

}
