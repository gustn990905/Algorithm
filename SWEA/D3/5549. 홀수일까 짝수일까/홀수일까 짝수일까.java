import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            String num = sc.next();

            int check = num.charAt(num.length()-1);
            
            if(check % 2 == 0) {
                System.out.println("#" + t + " Even");
            }
            else {
                System.out.println("#" + t + " Odd");
            }
        }
    }
}