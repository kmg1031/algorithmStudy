package algorithim.programmers;
public class Q6 {
	/*	22-05-17
		https://programmers.co.kr/learn/courses/30/lessons/12899
		1	1
		2	2
		3	4
		4	11
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(10));
	}
	public static String solution(int n) {
        String answer = "";
        int f = 0;
        do{
        	n--;
        	f = n % 3;
        	n = n / 3;
        	if(f == 2) {
        		answer = "4" + answer;
        	}else if(f == 1){
        		answer = "2" + answer;
        	}else if(f == 0){
        		answer = "1" + answer;
        	}
        }while(n>0);
        return answer;
    }
}