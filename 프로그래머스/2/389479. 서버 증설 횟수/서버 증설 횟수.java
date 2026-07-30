class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0; // 지금까지 증설한 총 서버 수
        int server = 0; // 현재 운영 중인 서버 수

        // added[t]에는 t 시간에 반납할 서버 수
        int[] added = new int[players.length + k];

        for(int t=0; t<players.length; t++) {
            // 만료된 서버 반납
            server -= added[t];

            int player = players[t];

            // 필요한 서버 수
            int needServer = player / m;

            // 서버 부족한 경우
            if(server < needServer) {
                int addServer = needServer - server;

                server += addServer;
                cnt += addServer;

                // 현재 증설된 서버는 k 시간 뒤에 반납
                added[t+k] += addServer;
            }
        }
        return cnt;
    }
}