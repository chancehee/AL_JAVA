import java.util.Scanner;

/*
 * 재귀 함수의 동작 방식에 대해서 공부할 수 있는 좋은 예제라고 생각한다.
 * 메모리 스택 영역에 쌓이고 리턴하면 다시 이전 스택으로 돌아가는 형태이다. (Last In First Out)
 */

public class Main_B_17478 {

	public static String chat(int n, StringBuilder sb, int cnt) {
		String temp = "";
		for (int i=0; i<cnt; i++) {
			temp += "____";
			
		}
		
		
		if (n == 0) { // 기저 케이스
			sb.append(temp);
			sb.append("\"재귀함수가 뭔가요?\"\n");
			sb.append(temp);
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(temp);
			sb.append("라고 답변하였지.\n");
			return sb.toString();
		}
		
		
		
		sb.append(temp);
		sb.append("\"재귀함수가 뭔가요?\"\n");
		sb.append(temp);
		sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(temp);
		sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(temp);
		sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		chat(n-1, sb, cnt+1);
		sb.append(temp);
		sb.append("라고 답변하였지.\n");
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 반복 횟수
		int cnt = 0; // 언더바 반복 횟수 
		StringBuilder sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		
		String result = chat(N, sb, cnt);
		System.out.println(result);
		
	}

}
