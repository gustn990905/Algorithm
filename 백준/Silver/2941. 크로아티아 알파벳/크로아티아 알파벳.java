import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 크로아티아 알파벳 패턴을 배열에 저장
		// 문제에서 주어진 특정 문자열들은 하나의 알파벳으로 취급
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String line = sc.next();
		
		// 입력 문자열(line)에서 croatia 배열에 있는 패턴을 찾아
		// "*" 한 문자로 치환
		for(int i=0; i<croatia.length; i++) {
			line = line.replace(croatia[i], "*");
		}
		
		// 각 크로아티아 알파벳이 '*' 하나로 바뀌었기 때문에
		// 문자열 길이가 곧 알파벳 개수
		System.out.println(line.length());
	}
}