package algorithim.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Q17 {
	/*	22-07-15
	 	https://school.programmers.co.kr/learn/courses/30/lessons/92341
	 	l2 주차 요금 계산
	 */
	
	public static void main(String[] args) {
	
//		[180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
//		[120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
//		[1, 461, 1, 10]	["00:00 1234 IN"]	[14841]
		
		int[] fees = {120, 0, 60, 591};
		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		
		System.out.println(Arrays.toString(solution(fees, records)));
	}
	
	public static int[] solution(int[] fees, String[] records) {
        int[] answer;
		int carNum;
		int time;
		String[] timeStr;
		String[] rec;
		int lastTime = 1439; // 23:59
		int fee;
		int j = 0;
		int overFee;
        HashMap<Integer, Integer> info = new HashMap<>();
        
        for(int i=0; i < records.length; i++) {
        	rec = records[i].split(" ");
        	carNum = Integer.parseInt(rec[1]);
        	timeStr = rec[0].split(":");
        	time = (Integer.parseInt(timeStr[0]) * 60) + Integer.parseInt(timeStr[1]); 
        	
        	if(rec[2].equals("IN")) {
        		if(info.containsKey(carNum)) {
        			info.replace(carNum, info.get(carNum) - time);
        		} else {
        			info.put(carNum, -time);
        		}
        	} else {
        		info.put(carNum, info.get(carNum) + time);
        	}
        }
        
        Object[] carNums = info.keySet().toArray();
        Arrays.sort(carNums);
        answer = new int[carNums.length];
        
        for(Object key : carNums ) {
        	
        	time = info.get(key);
        	if(time <= 0) {
        		time += lastTime;
        	}
        	overFee = (int) Math.ceil((double) (time - fees[0]) / (double) fees[2]) * fees[3];
        	if(overFee < 0) {
        		overFee = 0;
        	}
        	fee = fees[1] + overFee;
        	// 정산
        	answer[j] = fee;
        	j++;
        }
        
        
        return answer;
    }
}
