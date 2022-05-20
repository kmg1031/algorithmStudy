package algorithim.programmers;
import java.util.Arrays;
import java.util.HashSet;
public class Q2 {
	/*	22-05-12
	 	https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
	 	[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]		[3, 5]
		[0, 0, 0, 0, 0, 0]		[38, 19, 20, 40, 15, 25]	[1, 6]
		[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]		[1, 1]
	 */
	public static void main(String[] args) {
		int[] lottos = {44, 3, 2, 4, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Integer[] win_nums_ = Arrays.stream(win_nums).boxed().toArray(Integer[]::new);
        int binCount = 0;
        int winCount = 0;
        HashSet<Integer> win_nums_set = new HashSet<Integer>(Arrays.asList(win_nums_));
        for(int num : lottos) {
        	if(num == 0) {
        		binCount++;
        	}else if(win_nums_set.contains(num)) {
        		winCount++;
        	}
        }
        if(winCount == 0) {
        	winCount = 1;
        }
        if(binCount == 6) {
        	binCount = 5;
    	}
        answer[1] += 7 - winCount;
        answer[0] = answer[1] - binCount;
        return answer;
    }
}