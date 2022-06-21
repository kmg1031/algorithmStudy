package algorithim.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Q15 {

	/*	22-06-21
	 	https://programmers.co.kr/learn/courses/30/lessons/42628
	 	priorityQueue 쓰면 쉬웠다...
	 	
	 */
	
	public static void main(String[] args) {
		
		
//		["I 16","D 1"]	[0,0]
//		["I 7","I 5","I -5","D -1"]	[7,5]
//		"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" [333, -45]
		
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		System.out.println(Arrays.toString(solution(operations)));
		
	}
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        ArrayList<Integer> heap_max = new ArrayList<Integer>();
        ArrayList<Integer> heap_min = new ArrayList<Integer>();
        int idx;
        int len;
        int num = 0;
        int del_max = 0;
        int del_min = 0;

        for(int i=0; i < operations.length; i++) {
        	if(operations[i].charAt(0) == 'I') {
        		// 삽입
        		num = Integer.parseInt(operations[i].substring(2));

        		idx = heap_max.size();
        		heap_max.add(num);
        		while(heap_max.get(idx) > heap_max.get((idx-1)/2)) {
        			swap(heap_max, idx, (idx-1)/2);
        			idx = (idx-1)/2;
        		}

        		idx = heap_min.size();
        		heap_min.add(num);
        		while(heap_min.get(idx) < heap_min.get((idx-1)/2)) {
    				swap(heap_min, idx, (idx-1)/2);
    				idx = (idx-1)/2;
        		}

        	}else{
        		// 삭제
        		if(operations[i].charAt(2) == '1') {
        			// 최댓값 삭제
        			if(heap_max.isEmpty()) {
        			}else if(heap_max.size() - del_min - 1 <= 0) {
        				heap_max.clear();
        				heap_min.clear();
        				del_min = 0;
        				del_max = 0;
        			}else{
	        			num = heap_max.remove(heap_max.size()-1);
	        			del_max++;
	        			heap_max.set(0, num);
	        			idx = 0;
	        			len = heap_max.size()-1;
	            		while(len >= idx*2+1) {
	            			if(len == idx*2+1) {
	            				if(heap_max.get(idx*2+1) > heap_max.get(idx)) { swap(heap_max, idx, idx*2+1); }
	            				break;
	            			}else{
	            				if(heap_max.get(idx*2+1) > heap_max.get(idx*2+2)) {
	                				swap(heap_max, idx, idx*2+1);            				
	                				idx = idx*2+1;
	                			}else{
	                				swap(heap_max, idx, idx*2+2);
	                				idx = idx*2+2;
	                			}
	            			}
	            		}
        			}
        		}else{
        			// 최솟값 삭제
        			if(heap_min.isEmpty()) {
        			}else if(heap_min.size() - del_max - 1 <= 0) {
        				heap_max.clear();
        				heap_min.clear();
        				del_min = 0;
        				del_max = 0;
        			}else{
        				num = heap_min.remove(heap_min.size()-1);
        				del_min++;
        				heap_min.set(0, num);
        				idx = 0;
        				len = heap_min.size()-1;
        				while(len >= idx*2+1) {
        					if(len == idx*2+1) {
        						if(heap_min.get(idx*2+1) < heap_min.get(idx)) { swap(heap_min, idx, idx*2+1); }
        						break;
        					}else{
        						if(heap_min.get(idx*2+1) < heap_min.get(idx*2+2)) {
        							swap(heap_min, idx, idx*2+1);
        							idx = idx*2+1;
        						}else{
        							swap(heap_min, idx, idx*2+2);
        							idx = idx*2+2;
        						}
        					}
        				}
        			}
        		}
        	}
        }

        if(!heap_max.isEmpty()) {
        	answer[0] = heap_max.get(0);
        }
        if(!heap_min.isEmpty()) {
        	answer[1] = heap_min.get(0);
        }
        return answer;
    }
	public static void swap(ArrayList<Integer> heap, int i, int j) {
		int temp;
		temp = heap.get(i) ;
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
}
