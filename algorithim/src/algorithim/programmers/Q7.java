package algorithim.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Q7 {

	
	/*
	 	https://programmers.co.kr/learn/courses/30/lessons/42888
	 	
	 	["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
	 	["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
	 */
	public static HashMap<String, String> id_list = new HashMap<>();
	
	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
		
	}
	
	 public static String[] solution(String[] record) {
        String[] answer = {};
        
        int log_count = 0;
        String[] record_one;
        
        for(int i = 0; i< record.length; i++) {
        	record_one = record[i].split(" ");
        	if(record_one[0].equals("Change")) {
        		
        		id_list.put(record_one[1], record_one[2]);
        	}else if(record_one[0].equals("Enter")) {
        		log_count++;
        		id_list.put(record_one[1], record_one[2]);	
        	}else {
        		log_count++;
        	}
        }
        answer = new String[log_count];
        
        for(int i = 0,j = 0; i< record.length; i++) {
        	record_one = record[i].split(" ");
        	if(!record_one[0].equals("Change")) {
        		answer[j++] = changeLanguage(record_one[1], record_one[0]);
        	}
        }
        
        return answer;
    }

	
	public static String changeLanguage(String id, String type) {
		String result = "";
		
		if(type.equals("Enter")) {
			result = id_list.get(id) + "님이 들어왔습니다.";
		}else if(type.equals("Leave")) {
			result = id_list.get(id) + "님이 나갔습니다.";
		}
		
		return result;
	}
	
	 
	 
}
