import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 파리 퇴치
public class solution_2001_부분합배열_연습 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TestCase = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 숫자 만큼 반복
		for (int tc=1; tc<=TestCase; tc++) {
			// 스트링 빌더 선언
			StringBuilder sb = new StringBuilder();
			// n(배열 크기), m(윈도우 크기)
			String[] ab = br.readLine().split(" ");
			int n = Integer.parseInt(ab[0]);
			int m = Integer.parseInt(ab[1]);
			// 맵 정보 입력받기
			int[][] arr = new int[n][n];
			for (int i=0; i<n; i++) {
				String[] datas = br.readLine().split(" ");
				for (int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(datas[j]);
				}
			}
			
			// 부분 합을 담을 2차원 배열 선언.
			int[][] dp = new int[n+1][n+1];
			
			// 부분 누적합을 통해서 가로, 세로로 누적되는 합을 담는다.
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					dp[i+1][j+1] = arr[i][j] + dp[i+1][j] - dp[i][j] + dp[i][j+1];
				}
			}
			
			// 부분 누적 합 배열 출력 (데이터 잘 들어갔나 확인 용도)
//			for (int[] datas : dp) {
//				for(int data : datas) {
//					System.out.print(data+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			
			int ans = 0;
			
			// 윈도우를 이동 시키면서 그리드 크기 만큼의 누적합과 기존 최대 값과 비교하여 업데이트.
			for(int i=1; i<=n-m+1; i++) {
				for (int j=1; j<=n-m+1; j++) {
					int x=i;
					int y=j;
					int x2 = i+m-1;
					int y2 = j+m-1;
					
					int diff = dp[x2][y2] + dp[x-1][y-1] - dp[x-1][y2] - dp[x2][y-1];
					ans = Math.max(ans, diff);

				}
			}
			sb.append("#"+tc+" ");
			sb.append(ans+"\n");
			System.out.print(sb.toString());
		}
	}
}
