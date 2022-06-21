package algorithim.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Q13 {

	
	/*
	 	https://programmers.co.kr/learn/courses/30/lessons/43238
	 	level 3 입국심사
	 	이분 탐색
	 	
	 	https://programmers.co.kr/learn/courses/30/lessons/43236?language=java
	 	level 4 징검다리
	 	이분 탐색
	 */
	
	
	public static void main(String[] args) {
		
//		6	[6, 10]	24
//		int n = 6;
//		int[] times = {7, 10};
//		System.out.println(solution(n, times));
		
		
		
//		25	[2, 14, 11, 21, 17]	2	4
		int distance = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n2 = 4;
		
		System.out.println(solution2(distance, rocks, n2));
	}
	public static int solution2(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int start = 0;
       
        
        

        
        
        
        
        return answer;
    }
	
	public static long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        long end = (long)times[times.length - 1] * n;
        long mid;
        long sum;

        while(start <= end) {
	        mid = (start + end) / 2;
	        sum = 0;
	        for(int i=0; i < times.length; i++) {
	        	sum += mid / times[i];
	        }
	        
	        if(sum >= n) {
	        	end = mid - 1;
	        	answer = mid;
	        }else {
	        	start = mid + 1;
	        }
        }
      
        return answer;
    }
	
	
}
