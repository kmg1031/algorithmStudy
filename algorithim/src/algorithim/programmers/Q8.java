package algorithim.programmers;
import java.util.Arrays;
public class Q8 {
	/*	22-05-26
	 	https://programmers.co.kr/learn/courses/30/lessons/1829
	 	6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]
	 	[4, 5]
	 	- 원본 배열 훼손 금지
	 */
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}
    public static int[][] picture_;
    public static int[] solution(int m, int n, int[][] picture) {
        picture_ = new int[m][n];
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			picture_[i][j] = picture[i][j];
    		}
    	}
		System.out.println(Arrays.toString(picture_));
        int color;
        int color_count = 0;
        int max = 0;
        int tmp;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
        	    if(picture_[i][j] != -1 && picture_[i][j] != 0) {
        	    	color_count++;
            	    color = picture_[i][j];
              	   	tmp = Search(i, j, color);
              	   	if(max < tmp) {
              	   		max = tmp;
              	   	}
        	    }
            }
        }
        return new int[] {color_count, max};
    }
	public static int Search(int i, int j, int color){
    	int count = 0;
    	if(picture_[i][j] == color) {
    		count++;
    		picture_[i][j] = -1;
    		if(i > 0){
	        	count += Search(i - 1, j, color);
	        }
	        if(j > 0){
	        	count += Search(i, j - 1, color);
	        }
	        if(i < picture_.length - 1){
	        	count += Search(i + 1, j, color);
	        }
	        if(j < picture_[0].length - 1){
	        	count += Search(i, j + 1, color);
	        }
    	}
        return count;
    }
}