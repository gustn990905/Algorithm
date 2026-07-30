class Solution {
    public String solution(
            String video_len,
            String pos,
            String op_start,
            String op_end,
            String[] commands
    ) {
        int videoLen = toSeconds(video_len);
        int current = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        // 최초 위치가 오프닝 구간이면 오프닝 끝으로 이동
        current = skipOpening(current, opStart, opEnd);

        for (String command : commands) {

            if (command.equals("next")) {
                current += 10;

                // 영상 길이를 넘어갈 수 없음
                if (current > videoLen) {
                    current = videoLen;
                }
            } else if (command.equals("prev")) {
                current -= 10;

                // 0초보다 앞으로 갈 수 없음
                if (current < 0) {
                    current = 0;
                }
            }

            // 명령 실행 후 오프닝 구간인지 확인
            current = skipOpening(current, opStart, opEnd);
        }

        int minute = current / 60;
        int second = current % 60;

        return String.format("%02d:%02d", minute, second);
    }

    // "mm:ss"를 전체 초로 변환
    private int toSeconds(String time) {
        int minute = Integer.parseInt(time.substring(0, 2));
        int second = Integer.parseInt(time.substring(3, 5));

        return minute * 60 + second;
    }

    // 현재 위치가 오프닝 구간이면 오프닝 끝으로 이동
    private int skipOpening(int current, int opStart, int opEnd) {
        if (current >= opStart && current <= opEnd) {
            return opEnd;
        }

        return current;
    }
}