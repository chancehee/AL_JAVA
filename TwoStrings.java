package task;

import java.util.Scanner;

public class TwoStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		
		for (int tc=1; tc<=TestCase; tc++) {
			// 크기를 통해서 로직을 사용하기 위한 변수
			int small = 0;
			int big = 0;
			int[] A; // 적은 숫자 배열
			int[] B; // 큰 숫자 배열
			int max = 0;
			
			// N과 M입력 받기 (숫자열의 개수이다.)
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 크기 비교, 배열에 데이터 입력받기
			if (N >= M) {
				small = M;
				big = N;
				A = new int[M];
				B = new int[N];
				for (int i=0; i<big; i++) {
					int num = sc.nextInt();
					B[i] = num;
				}
				for (int i=0; i<small; i++) {
					int num = sc.nextInt();
					A[i] = num;
				}
				
			} else {
				small = N;
				big = M;
				A = new int[N];
				B = new int[M];
				for (int i=0; i<small; i++) {
					int num = sc.nextInt();
					A[i] = num;
				}
				for (int i=0; i<big; i++) {
					int num = sc.nextInt();
					B[i] = num;
				}
			}
			
			// 비교 횟수
			int circle = big - small + 1;
			
			// 비교 하기
			for (int i=0; i<circle; i++) {
				int temp = 0;
				for (int j=0; j<small; j++) {
					// i=0  j=0 1 2
					// i=1  j=0 1 2
					// i=0 -> (j,j) 0,0 1,1 2,2
					// i=1 -> (j, i+j) 0,1 1,2 2,3
					// i=2 -> (j, i+j) 0,2 1,3 2,4
					temp += A[j] * B[i+j];
				}
				// 최댓값 갱신
				max = Math.max(max, temp);
			}
			
			System.out.printf("#%d %d\n", tc,max);
			
		}
	}

}
