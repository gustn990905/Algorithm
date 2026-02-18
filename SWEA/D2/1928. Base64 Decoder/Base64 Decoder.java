import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	// Base64 문자 하나를 0~63 사이 숫자로 변환하는 함수
    // Base64는 6비트 단위이므로 0~63 값을 가짐
	public static int base64Value(char c) {
        if (c >= 'A' && c <= 'Z') return c - 'A';
        if (c >= 'a' && c <= 'z') return c - 'a' + 26;
        if (c >= '0' && c <= '9') return c - '0' + 52;
        if (c == '+') return 62;
        if (c == '/') return 63;
        return 0;
    }
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			// Base64로 인코딩된 문자열 입력
			String line = br.readLine();
			// 6비트 이진수들을 이어붙일 버퍼
			StringBuilder sb = new StringBuilder();
			
			// Base64 문자 -> 6비트 이진수로 변환
			for(int l=0; l<line.length(); l++) {
				int A = base64Value(line.charAt(l));
				// 숫자를 2진수 문자열로 변환
				String A2 = Integer.toBinaryString(A);
				// 항상 6자리로 맞추기 위해 앞에 0 채움
				A2 = String.format("%6s", A2).replace(' ', '0');
				// 6비트 문자열을 계속 이어붙임
				sb.append(A2);
			}
			System.out.print("#" + t + " ");
			// 6비트들이 모인 큰 이진수 문자열을 8비트씩 자름
			for(int s=0; s<sb.length(); s+=8) {
				StringBuilder sb2 = new StringBuilder();
				
				// 현재 위치부터 8비트 추출
				for(int s1=s; s1<s+8; s1++) {
					sb2.append(sb.charAt(s1));
				}
				
				 // 8비트 이진수 -> 10진수 변환
				int num = Integer.parseInt(sb2.toString(), 2);
				// 10진수 -> ASCII 문자 변환 후 출력
				System.out.print((char)num);
			}
			System.out.println();
		}
	}
}