package algorithim.programmers;
public class Q12 {
	/*	22-06-09
	 	https://programmers.co.kr/learn/courses/30/lessons/43105
	 */
	public static void main(String[] args) {
		int[][] test = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(test));
	}
    public static int solution(int[][] triangle) {
    	int answer = 0;
    	int len = triangle.length;
        
        for(int i=1; i < len; i++) {
        	for(int j=0; j < triangle[i].length;j++) {
        		
        		if(j == 0) {
        			// 왼쪽 끝자리
        			triangle[i][j] += triangle[i-1][0];
        		}else if(j == i){
        			// 오른쪽 끝자리
        			triangle[i][j] += triangle[i-1][j - 1];
        		}else{
        			triangle[i][j] += Math.max(triangle[i-1][j - 1], triangle[i-1][j]);
        		}
        	}
        }
        for(int i=0; i < triangle[len - 1].length; i++) {
        	if(answer < triangle[len - 1][i]) {
        		answer = triangle[len - 1][i];
        	}
        }
        
        return answer;
    }

	
	
	
}
