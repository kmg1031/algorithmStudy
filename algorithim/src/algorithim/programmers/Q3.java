package algorithim.programmers;
public class Q3 {
	/*	22-05-12
	  	https://programmers.co.kr/learn/courses/30/lessons/86051?language=java
	  	[1,2,3,4,6,7,8,0]	14
		[5,8,4,0,6,7,9]		6
	 */
	public static void main(String[] args) {
		int[] numbers = {5,8,4,0,6,7,9};
		System.out.println(solution(numbers));
	}
	 public static int solution(int[] numbers) {
        int answer = 45;
        for(int n : numbers) {
        	answer -= n;
        }
        return answer;
    }
}