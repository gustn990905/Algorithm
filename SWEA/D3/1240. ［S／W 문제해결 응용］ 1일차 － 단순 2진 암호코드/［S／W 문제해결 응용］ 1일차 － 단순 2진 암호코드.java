import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    // 숫자 0~9에 해당하는 7비트 암호
    static String[] patterns = {
            "0001101", // 0
            "0011001", // 1
            "0010011", // 2
            "0111101", // 3
            "0100011", // 4
            "0110001", // 5
            "0101111", // 6
            "0111011", // 7
            "0110111", // 8
            "0001011"  // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 세로의 크기
            int m = Integer.parseInt(st.nextToken()); // 가로의 크기

            String codeLine = null;
            int end = -1;

            // n개의 줄 입력 받기
            for(int r=0; r<n; r++) {
                String line = br.readLine();

                // 현재 줄에서 가장 오른쪽 1을 찾음
                for(int c=m-1; c>=0; c--) {
                    if(line.charAt(c) == '1') {
                        codeLine = line;
                        end = c;
                        break;
                    }
                }
            }

            // 시작 위치는 끝 위치에서 왼쪽으로 56칸 이동
            int start = end - 55;

            int[] numbers = new int[8];

            // 암호는 숫자 8개, 숫자 하나당 7비트
            for (int i = 0; i < 8; i++) {
                int partStart = start + i * 7;
                int partEnd = partStart + 7;

                String part = codeLine.substring(partStart, partEnd);

                numbers[i] = decode(part);
            }

            int oddSum = 0;
            int evenSum = 0;
            int totalSum = 0;

            for(int i=0; i<8; i++) {
                totalSum += numbers[i];

                if(i%2 == 0) oddSum += numbers[i];
                else evenSum += numbers[i];
            }
            int check = oddSum*3 + evenSum;

            if(check % 10 == 0) System.out.println("#" + t + " " + totalSum);
            else System.out.println("#" + t + " " + 0);
        }
    }

    static int decode(String part) {
        for(int i=0; i<10; i++) {
            if(patterns[i].equals(part)) {
                return i;
            }
        }
        return -1;
    }
}