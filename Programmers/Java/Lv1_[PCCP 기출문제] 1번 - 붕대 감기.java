import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int max_health = health; 
        int end_time = attacks[attacks.length-1][0];
        
        int idx = 0; // attacks 배열 idx
        int cnt = 0; // 연속 성공
        
        for(int i=1; i<=end_time; i++){
            if(health <= 0) return -1;
            
            if(i == attacks[idx][0]){ // 몬스터 공격 time
                health-=attacks[idx][1];
                cnt = 0;
                idx++;
            } else { // 체력 회복 time 
                if(max_health <= health + bandage[1]) health = max_health; // 현재 체력이 최대 체력보다 커지는 것은 X
                else health+=bandage[1];
                
                cnt++;
                if(cnt == bandage[0]) {
                    health+=bandage[2];
                    cnt=0;
                }
            }
        }
        
        if(health<=0) answer = -1;
        else answer = health;
        
        return answer;
    }
}