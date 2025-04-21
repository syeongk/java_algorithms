import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int answer = 0;
        
        if (pq.peek() >= K){
            return 0;
        }
        
        while (pq.size() >= 2) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int newNum = num1 + (num2 * 2);
            pq.offer(newNum);
            answer++;
            
            if (pq.peek() >= K){
                return answer;
            }
            
        }
        
        return -1;
    }
}