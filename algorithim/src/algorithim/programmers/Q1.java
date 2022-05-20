package algorithim.programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class Q1 {
	/*	22-05-10
	  	https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
	*/
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}
	 public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<String> id_list_ = new ArrayList<String>(Arrays.asList(id_list));
        HashMap<String, HashSet<String>> h = new HashMap<>();
        for(String s : report) {
          	String[] ss = s.split(" ");
          	if(h.containsKey(ss[1])) {
          		h.get(ss[1]).add(ss[0]);
          	}else {
          		h.put(ss[1], new HashSet<String>());
          		h.get(ss[1]).add(ss[0]);
          	}
        }
  		h.forEach((key, arr)->{
  			if( arr.size() >= k ) {
  				for(String id : arr) {
  					answer[id_list_.indexOf(id)]++;
  				}
  			}
  		});
        return answer;
    }
}