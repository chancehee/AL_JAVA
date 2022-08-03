package day_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 구간 합 구하기 4
문제: 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
N: 배열의 길이 , M: 테스트 케이스 개수
arr[]: 숫자 배열
1 3: 1~3까지의 합
2 4: 2~4까지의 합
5 5: 5~5까지의 합

아이디어:
	Java -> 1억번 연산 => 1초
	N과 M의 범위가 최악일 경우 10만 * 10만 = 100억
	반복문을 통해서 배열에서 누적 값을 구할 경우 최악 -> O(N^2) -> 시간 초과 (시간 제한 1초이므로)
	따라서 O(N)의 시간 복잡도로 구해야한다.
	memoization을 통해서 부분 합의 값을 기록 하고 사용하는 방법 사용.
*/
public class Main_B_11659 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int[] arr = new int[N];

		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		// int로도 범위내에 해결 가능하지만 혹시 몰라서 long형으로 선언했다..
		long[] dp = new long[N+1];
		for (int i=1; i<=N; i++) {
			// 기존 합 + 현재 위치의 값 => 누적
			dp[i] =  dp[i-1] + arr[i-1];
		}
	
		for (int i=0; i<M; i++) {
			String[] temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			// 예를 들어 2~3의 합을 구하고 싶다면 -> 1~3의 합 - 1의 합 
			long diff = dp[end] - dp[start-1];
			sb.append(diff+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
