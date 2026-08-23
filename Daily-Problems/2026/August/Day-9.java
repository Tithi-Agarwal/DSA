//1510. Stone Game IV

class Solution {
    int[][] memo;
    public boolean winnerSquareGame(int n) {
        memo = new int[n+1][2];
        return game(n, true);
    }

    public boolean game(int n, boolean isAlice) {
        int isAliceIdx = isAlice ? 1 : 0;
        if(memo[n][isAliceIdx] != 0) return memo[n][isAliceIdx] == 1;
        int c = 1;
        boolean best = !isAlice;
        int i = 1;
        while(c <= n) {
            if(!isAlice) {
                if(!game(n-c,true)) {
                    best = false;
                    break;
                }
            } else {
                if(game(n-c,false)) {
                    best = true;
                    break;
                }
            }
            i++;
            c = i*i;
        }
        memo[n][isAliceIdx] = best ? 1 : 2;
        return best;
    }
}