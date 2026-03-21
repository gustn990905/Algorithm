import java.util.Scanner;
public class Main {
		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 0 0이 들어올 때까지 입력 받기
        while(true) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	// a와 b가 모두 0이면 입력 받지 않기
        	if(a == 0 && b == 0) break;
        	
        	// a가 b보다 크고 a를 b로 나눈 나머지가 0인 경우 -> 배수
        	if(a>b && a % b==0) System.out.println("multiple");
        	
        	// b가 a보다 더 크고 b를 a로 나눈 나머지가 0인 경우 -> 약수
        	else if(a<b && b%a == 0) System.out.println("factor");
        	
        	else System.out.println("neither");
        }
    }
}