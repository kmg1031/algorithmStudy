package algorithim.programmers;
import java.util.Arrays;
public class Q5 {
	/* 22-05-16
	 	https://programmers.co.kr/learn/courses/30/lessons/77485?language=java
		6		6	{{2,2,5,4},{3,3,6,6},{5,1,6,3}}					{8, 10, 25}
		3		3	{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}		{1, 1, 5, 3}
		100		97	{{1,1,100,97}}									{1}
	 */
	public static int[][] board;
    public static int tmp;
	public static void main(String[] args) {
		int r = 3;
		int c = 3;
		int[][] b = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		System.out.println(Arrays.toString(solution(r,c,b)));
	}
    public static void swap(int y, int x) {
    	int t = tmp;
    	tmp = board[y][x];
    	board[y][x] = t;
    }
	 /**
	 * @param rows
	 * @param columns
	 * @param queries
	 * @return
	 */
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        board = new int[rows+1][columns+1];
        int min = 0;
        int x1=0, x2=0, y1=0 , y2=0;
        tmp = 1;
        for(int i=1;i<=rows;i++) {
        	for(int j=1;j<=columns;j++) {
        		board[i][j] = tmp++;
        	}
        }
        for(int i=0;i<queries.length;i++) {
        	y1 = queries[i][0];
        	x1 = queries[i][1];
        	y2 = queries[i][2];
        	x2 = queries[i][3];
        	tmp = board[y1][x1];
        	min = tmp;
        	for(int j=x1+1;j<=x2;j++) {
        		swap(y1, j);
        		if(tmp < min) min = tmp;
        	}
        	for(int j=y1+1;j<=y2;j++) {
        		swap(j, x2);
        		if(tmp < min) min = tmp;
        	}
        	for(int j=x2-1;j>=x1;j--) {
        		swap(y2, j);
        		if(tmp < min) min = tmp;
        	}
        	for(int j=y2-1;j>=y1;j--) {
        		swap(j, x1);
        		if(tmp < min) min = tmp;
        	}
        	answer[i] = min;
        }
        return answer;
    }
}