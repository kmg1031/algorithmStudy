package algorithim.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q18 {

	
	/* 22-07-18
	 	https://school.programmers.co.kr/learn/courses/30/lessons/43163
	 */

	
	public static void main(String[] args) {
//		"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
		
	}
	
	 public static int solution(String begin, String target, String[] words) {        
        int matchCnt;
        int wordLen = begin.length();
        int lastIdx = words.length;
        int targetIdx = -1;
        int idx;
        
        boolean[][] map = new boolean[lastIdx+1][lastIdx+1];
        Queue<Integer> que = new LinkedList<Integer>();
        int[] val = new int[lastIdx+1];

        for(int i=0; i < val.length; i++) {
        	val[i] = 9999;
        }

        // 그래프화
        	// 글자를 어떻게 맵핑할까
        	// 각 글자를 판별해서 하나만 다른것을 찾고 그것끼리 붙여야함
        for(int i=0; i < lastIdx; i++) {
        	if(words[i].equals(target)) {
        		targetIdx = i;
        	}
        	for(int j=i+1; j < lastIdx; j++) {
        		// 유사성 확인
        		matchCnt = 0;
        		for(int k=0; k < wordLen; k++) {
        			if(words[i].charAt(k) != words[j].charAt(k)) {
        				matchCnt++;
        			}
        		}
        		if(matchCnt == 1) {
        			// 매칭
        			map[i][j] = true;
        			map[j][i] = true;
        		}
        	}
        	matchCnt = 0;
    		for(int k=0; k < wordLen; k++) {
    			if(words[i].charAt(k) != begin.charAt(k)) {
    				matchCnt++;
    			}
    		}
    		if(matchCnt == 1) {
    			// 매칭
    			map[i][lastIdx] = true;
    			map[lastIdx][i] = true;
    		}
        }
        if(targetIdx == -1) {
        	return 0;
        }

        
//        for(int i=0; i < lastIdx+1; i++) {
//        	System.out.println(Arrays.toString(map[i]));
//        }
        
        // 탐색

        val[lastIdx] = 0;
        que.add(lastIdx);
        while(!que.isEmpty()) {
        	idx = que.poll();
        	
        	for(int i=0; i < lastIdx+1; i++) {
        		if(map[idx][i]) {
        			que.add(i);
        			map[idx][i] = false;
        			map[i][idx] = false;
        			val[i] = Math.min(val[idx] + 1 , val[i]);
        		}
        	}
        }
        
//        System.out.println(Arrays.toString(val));
        
        return val[targetIdx];
    }
	
	 
	 
}
