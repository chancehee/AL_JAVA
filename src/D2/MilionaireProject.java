package D2;

import java.util.Scanner;
// int형은 약 20억 보관 가능.
// N=100만, 매매가=1만 => 1만 * 100만 => 10,000,000,000 => 100억 => long형으로 정답 도출

/*
 * 1. 아이디어:
 * 	숫자들을 배열로 입력받는다. 
 * 	배열 뒤부터 탐색 시작해서 최대 값일 경우를 기록하고, 최대 값보다 앞의 배열 값이 작거나 같을 경우 차이 값을 더해서 누적합 시킨다.
 * 	만약 앞의 배열 값이 최대 값보다 더 크다면 최대 값을 갱신한다.
 */

public class MilionaireProject {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		for (int tc=1; tc<=TestCase; tc++)
		{
			// 입력 숫자의 개수
			int n = sc.nextInt();
			// 정답 값
			long diff = 0;
			
			int[] arr = new int[n];
			for (int j=0; j<n; j++) 
			{
				arr[j] = sc.nextInt();
			}
			
			int temp = 0;
			for (int j=n-1; j>=0; j--) 
			{
				if (temp < arr[j]) temp = arr[j];
				diff = diff + temp - arr[j];
			}
			
			
			System.out.printf("#%d %d%n", tc, diff);
		}
		sc.close();
		
	}

}
