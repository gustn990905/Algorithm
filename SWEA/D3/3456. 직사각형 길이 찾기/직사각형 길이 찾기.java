import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            int[] arr = new int[101];

            for(int i=0; i<3; i++) {
                arr[sc.nextInt()]++;
            }

            int result = 0;
            for(int i=0; i<102; i++) {
                // 값이 없으면 넘어가기
                if(arr[i] == 0) continue;

                else if(arr[i] % 2 == 0) continue;

                else {
                    result = i;
                    break;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}