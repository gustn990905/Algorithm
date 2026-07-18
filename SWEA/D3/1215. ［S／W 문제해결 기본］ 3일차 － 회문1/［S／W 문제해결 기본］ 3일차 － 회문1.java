import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t=1; t<=10; t++) {
            int length = sc.nextInt(); // 찾아야 하는 회문 길이

            char[][] board = new char[8][8];

            for(int i=0; i<8; i++) {
                String line = sc.next();
                for(int j=0; j<8; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            int answer = 0;

            // 가로 회문 확인
            for(int row = 0; row < 8; row++) {
                
                // 길이가 length인 문자열의 시작 위치
                for (int start = 0; start<=8-length; start++) {
                    boolean possible = true;
                    
                    // 앞 문자와 뒤쪽 문자 비교
                    for(int k=0; k<length/2; k++) {
                        char left = board[row][start+k];
                        char right = board[row][start + length - 1 -k];
                        
                        if(left != right) {
                            possible = false;
                            break;
                        }
                    }
                    
                    if(possible) answer++;
                }
            }
            
            // 세로 회문 확인
            for(int col = 0; col<8; col++) {
                
                // 시작 위치
                for(int start=0; start<=8-length; start++) {
                    boolean possible = true;
                    
                    // 문자 비교
                    for(int k=0; k<length/2; k++) {
                        char top = board[start+k][col];
                        char bottom = board[start + length - 1 -k][col];
                        
                        if(top != bottom) {
                            possible = false;
                            break;
                        }
                    }
                    
                    if(possible) answer++;
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}