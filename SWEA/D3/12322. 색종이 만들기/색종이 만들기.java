import java.util.Scanner;
 
public class Solution {
 
    static int whitePaper;     // 흰색 색종이 개수
    static int bluePaper;      // 파란색 색종이 개수
    static int[][] paper;      // 전체 색종이 정보를 저장하는 배열
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int TC = sc.nextInt(); // 테스트 케이스 개수 입력
 
        // 테스트 케이스 반복
        for (int t = 1; t <= TC; t++) {
            int N = sc.nextInt();     // 색종이 한 변의 길이
            paper = new int[N][N];    // 전체 색종이 배열 생성
 
            whitePaper = 0; // 흰색 개수 초기화
            bluePaper = 0;  // 파란색 개수 초기화
 
            // 색종이 값 입력 (0: 흰색, 1: 파란색)
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    paper[r][c] = sc.nextInt();
                }
            }
             
            // (0,0)부터 전체 크기 N을 시작으로 분할
            paperCut(paper, 0, 0, N);
             
            // 결과 출력
            System.out.println("#" + t + " " + whitePaper + " " + bluePaper);
        }
    }
 
    // 색종이를 분할하는 재귀 함수
    public static void paperCut(int[][] newPaper, int row, int col, int size) {
         
        // 크기가 1이면 더 이상 나눌 수 없음 (기저 조건)
        if(size == 1) {
            if(paper[row][col] == 0) { // 흰색이면
                whitePaper++;
            } else {                   // 파란색이면
                bluePaper++;
            }
            return;
        }
         
        // 현재 영역을 복사할 새로운 배열 생성
        newPaper = new int [size][size]; 
     
        // 원본 paper 배열에서 해당 영역을 newPaper로 복사
        int row1 = row - 1;
        for(int r=0; r<size; r++) {
            row1++;
            int col1 = col;
            for(int c=0; c<size; c++) {
                newPaper[r][c] = paper[row1][col1++];
            }
        }
         
        // 현재 영역이 모두 같은 색인지 검사
        if(samePaper(newPaper, 0, 0, size)) {
            if(newPaper[0][0] == 0) { // 흰색이면
                whitePaper++;
            } else {                 // 파란색이면
                bluePaper++;
            }
            return; // 더 이상 분할하지 않음
        }
         
        // 서로 다른 색이 섞여 있다면 4등분
        size = size/2;
         
        // 좌상
        paperCut(newPaper, row, col, size);
        // 좌하
        paperCut(newPaper, row+size, col, size);
        // 우상
        paperCut(newPaper, row, col+size, size);
        // 우하
        paperCut(newPaper, row+size, col+size, size);
 
    }
 
    // 해당 영역이 모두 같은 색인지 확인하는 함수
    public static boolean samePaper(int[][] newPaper, int row, int col, int size) {
        int firstNum = newPaper[row][col]; // 첫 번째 값 기준
         
        for(int r=row; r<row+size; r++) {
            for(int c=col; c<col+size; c++) {
                if(firstNum != newPaper[r][c]) {
                    return false; // 하나라도 다르면 false
                }
            }
        }
        return true; // 모두 같으면 true
    }
}