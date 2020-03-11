package CTC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//for backtracking questions
//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
//https://www.geeksforgeeks.org/permute-string-changing-case/



/*import java.util.Arrays;
import java.util.Collections;

class Solution {
    String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char) (best_res!=occurrences[i]?((char)((int)'a' + i)):Math.min(best_char, (char)((int)'a' + i)));
                best_res  = occurrences[i];
            }
        }
        
        String s= "1010";
        
        
        return Character.toString(best_char);
    }
    
    public static int findMaxTasks(int[] cpus, int[] tasks) {
    	Arrays.sort(cpus);
    	Arrays.sort(tasks);
    	
    	int i = 0, j = 0, res = 0;
    	
    	while(i<cpus.length && j<tasks.length) {
    		if(cpus[i] < tasks[j]) {
    			i++;
    		}else {
    			res++;
    			cpus[i] = cpus[i] - tasks[j];
    			j++;
    		}
    	}
    	return res;
    }
    
    public static void main(String[] ar) {
    	int[] cpus = new int[] {3,5,7,10};
    	int[] tasks = new int[] {1,2,2,5,8,10};
    	
    	int maxTasks = findMaxTasks(cpus, tasks);
    	System.out.println(maxTasks);
    }
}*/


import java.io.*;
import java.util.*;

/*
Exercise Goals:

    - The goal of this exercise is to show us how you apply software engineering 
    principles to create a maintainable software solution.

    How to approach this:

            - Don't worry about persistence. It would make sense here, but for this
            exercise only use in-memory data structures.
            - Don't worry about tricks or "gotchyas", as there aren't any.
            - Just focus on writing clean maintainable code.



Specification:

    Create a class LeaderBoard whose interface includes the following methods:

    Method Name: add_score

        - Add a new score to the player's average. If a player doesn't exist in the 
        LeaderBoard, they will be automatically added.

        Args:

                player_id (Integer): The player's ID.
                score (Integer): The score to record for the player

        Returns:

                Double: The new average score for the given player

    Method Name: top

        - Get the top player_ids on the leaderboard ordered by their average scores
        from highest to lowest

        Args:

                num_players (Integer): The maximum number of player_ids to return

        Returns:

                List<Integer>: a list of player_ids

    Method Name: reset

        - Removes any scoring information for a player, effectively 
        resetting them to 0

        Args:

                player_id (Integer): The player's ID.

Example Usage:


    // Create a new LeaderBoard Instance
    LeaderBoard leader_board = new LeaderBoard();

    // Add scores for players to the LeaderBoard
    leader_board.add_score(1, 50); // 50.0
    leader_board.add_score(2, 80); // 80.0
    leader_board.add_score(2, 70); // 75.0
    leader_board.add_score(2, 60); // 70.0
    leader_board.add_score(3, 90); // 90.0
    leader_board.add_score(3, 85); // 87.5

    // Get top positions for the leaderboard
    leader_board.top(3); // [3, 2, 1]
    leader_board.top(2); // [3, 2]
    leader_board.top(1); // [3]

    // Reset a player 3's scores
    leader_board.reset(3); // void

    // Player 3 is now at the bottom of the leaderboard
    leader_board.top(3); // [2, 1, 3]

Expected values

    - Player IDs will always be positive integers small enough to be 
    stored as a signed 32-bit integer Scores are integers ranging from 0-100


We have provided stubbed out code and tests for you below. Please note that these tests are not exhaustive and do not cover all corner cases. We recommend extending the given tests to ensure your code is correct.
*/



// Your code goes here. Feel free to make helper classes if needed
class LeaderBoard {
  
  HashMap<Integer, Player> playerScoreCard;
  List<Integer> topPlayers;
  boolean isTopPlayersUpdated;
  
  
  public LeaderBoard(){
      playerScoreCard = new HashMap<>();
      topPlayers = new LinkedList<>();
      isTopPlayersUpdated = false;
  }
  
  public Double add_score(Integer player_id, Integer score) {
      double avScore=  (double)score;
      Player player;
      
      if(this.playerScoreCard.containsKey(player_id)){
          player = playerScoreCard.get(player_id);
          avScore = ((player.avScore*player.scoreNum)+avScore)/(player.scoreNum+1);
      }else{
          player = new Player(player_id);
      }
    
      player.scoreNum += 1;
      player.avScore = avScore;
      this.isTopPlayersUpdated = false;
      
      this.playerScoreCard.put(player_id, player);
    return avScore;
  }
  
  public List<Integer> top(Integer max) {
    //no need to sort exisiting topPlayers if there hasn't been any additions or resets
    if(!this.isTopPlayersUpdated){
      this.getTopPlayers();
      this.isTopPlayersUpdated = true;
    }
    
    return this.topPlayers.subList(0, max);
  }
  
  
  public void reset(Integer player_id) {
    
    //reset only for existing players
      if(this.playerScoreCard.containsKey(player_id)){
          this.playerScoreCard.put(player_id, new Player(player_id));
          this.isTopPlayersUpdated = false;
      }
    return;
  }
  
  public void getTopPlayers(){
      List<Map.Entry<Integer, Player>> topPlayerList = new ArrayList<Map.Entry<Integer, Player>>(this.playerScoreCard.entrySet());
      
      PriorityQueue<List<Integer>> locByDistance 
      = new PriorityQueue<>((a,b) -> (int)((Math.pow(a.get(0), 2) + Math.pow(a.get(1),2)) -  (Math.pow(b.get(0), 2) + Math.pow(b.get(1),2))));
      
      Comparator<List<Integer>> cmp = new Comparator<List<Integer>>(){
          public int compare(List<Integer> a, List<Integer> b){
              return a.get(1) - b.get(1);
          }
      };
     
      
      List<List<Integer>> list= new ArrayList<>();
      
      locByDistance.addAll(list);
    
      Collections.sort(topPlayerList, new Comparator<Map.Entry<Integer, Player>>(){
          public int compare(Map.Entry<Integer, Player> a, Map.Entry<Integer, Player> b){
            return (int)(b.getValue().avScore - a.getValue().avScore);
          } 
      });
      
      this.topPlayers = new ArrayList<>();
      
      for(Map.Entry<Integer, Player> player: topPlayerList){
          this.topPlayers.add(player.getKey());
      }
  }

}


// Test code here
class Solution {
  public static void main(String[] args) {
    LeaderBoard leaderBoard = new LeaderBoard();
    System.out.println(leaderBoard.add_score(1, 50));
    System.out.println(leaderBoard.add_score(2, 80)==80);
    System.out.println(leaderBoard.add_score(2, 70)==75);
    System.out.println(leaderBoard.add_score(2, 60)==70);
    System.out.println(leaderBoard.add_score(3, 90) == 90);
    System.out.println(leaderBoard.add_score(3, 85) == 87.5);
    
    
    
    System.out.println(leaderBoard.top(3).equals(Arrays.asList(3, 2, 1)));  
    System.out.println(leaderBoard.top(2).equals(Arrays.asList(3, 2)));
    

    leaderBoard.reset(3);

    System.out.println(leaderBoard.top(3).equals(Arrays.asList(2, 1, 3)));
  }
}


class Player{
  
  int playerId;
  double avScore;
  int scoreNum;
  
  public Player(){
    playerId = 0;
    avScore = 0.0;
    scoreNum = 0;
  }
  
  public Player(int player_id){
    playerId = player_id;
  }
 
}
