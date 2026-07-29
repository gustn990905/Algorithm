import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int testCase = Integer.parseInt(br.readLine());
            String target = br.readLine();
            char targetFirst = target.charAt(0); // 검색하는 문자열의 첫 문자
            String sentence = br.readLine();

            int cnt = 0; // 일치하는 문자 수
            for(int i=0; i<=sentence.length()-target.length(); i++) {
                // 첫 문자가 target이랑 같으면 확인
                if(sentence.charAt(i) == targetFirst) {
                    boolean possible = true;
                    for(int j=1; j<target.length(); j++) {
                        if(sentence.charAt(i+j) != target.charAt(j)) {
                            possible = false;
                            break;
                        }
                    }

                    if(possible) cnt++;
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}