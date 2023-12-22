package basic.code.design;

import java.util.*;

/*
Design a Leaderboard class, which has 3 functions:
    1. addScore(playerId, score): Update the leaderboard by adding score to the given player's score.
    If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.

    2. top(K): Return the score sum of the top K players.

    3. reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard).
    It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.
*/
public class LeaderBoard {

    private Map<Integer, Integer> scoreCount;
    private Map<Integer, Integer> sortedScore;

    public LeaderBoard(){
        this.scoreCount = new HashMap<>();
        this.sortedScore = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score){
        int preScore = this.scoreCount.getOrDefault(playerId, 0);
        if (preScore == 0){
            this.sortedScore.put(score, this.sortedScore.getOrDefault(score, 0)+1);
            this.scoreCount.put(playerId, score);
        } else {
            this.sortedScore.put(preScore, this.sortedScore.get(preScore) -1);
            int newScore = preScore+score;
            this.sortedScore.put(newScore, this.sortedScore.getOrDefault(newScore, 0)+1);
            this.scoreCount.put(playerId, newScore);
        }
    }

    public int top(int k){
        int total =0;
        int count =k;
        for (Map.Entry<Integer, Integer> entry:this.sortedScore.entrySet()) {
            int times = entry.getValue()>count? count: entry.getValue();;
            total = total+entry.getKey()*times;
            count = count-times;
            if(count <0){
                break;
            }
        }

        return total;
    }

    public void reset(int playerId){
        int preScore = this.scoreCount.get(playerId);
        int count = this.sortedScore.get(preScore);
        if(count>0){
            this.sortedScore.put(preScore, this.sortedScore.get(preScore)-1);
        }

        this.scoreCount.remove(playerId);
    }
}
