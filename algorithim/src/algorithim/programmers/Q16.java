package algorithim.programmers;

public class Q16 {

	/*	22-07-15
		https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=java
		l2 - k진수에서 소수 개수 구하기
	*/
	
	public static void main(String[] args) {
		
//		437674	3	3	110101020112
//		110011	10	2

		int n = 524287; 
		int k = 2;
		
		System.out.println(solution(n, k));

	}
	public static int solution(int n, int k) {
        int answer = 0;
        int r;
        String num = "";
        String[] nums;

        while(n > 0){
            r = n % k;
            n = n / k; 
            num = Integer.toString(r) + num;
        }
        nums = num.split("0");
        for(int i=0; i < nums.length; i++) {
        	if(!nums[i].equals("")) {
        		answer += check(Long.parseLong(nums[i]));            		
        	}	
        }

        return answer;
    }
    public static int check(Long num){
    	if(num == 1){
    		return 0;
        }else if(num == 1){
        	return 1;
        }
    	for(long i=2; i * i <= num; i++) {
    		if(num % i == 0){
    			return 0;
            }
    	}
        return 1;
    }
}
