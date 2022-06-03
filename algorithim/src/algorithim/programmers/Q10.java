package algorithim.programmers;
import java.util.LinkedList;
import java.util.Queue;
public class Q10 {
	/*	22-06-03
	 	https://programmers.co.kr/learn/courses/30/lessons/49189
	  	테스트 케이스는 다 맞는데
	  	메모리 때문인가
	  	linkedList 써야하나
	 */
	public static void main(String[] args) {
		int[][] test = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int n = 6; // 3
//		int[][] test = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 5}, {3, 6}, {4, 8}, {4, 9}, {5, 9}, {5, 10}, {6, 10}, {6, 11}};
//		int n = 11; // 4
//		int[][] test = {{1, 2}, {2, 3}, {3, 4}};
//		int n = 4; // 1
//		int[][] test = {{1, 2}};
//		int n = 2; // 1
//		int[][] test = {{4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
//		int n = 5; //2
//		int[][] test = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}};
//		int n = 4; // 1
//		int[][] test = {};
//		int n = 4; // 0
		System.out.println(solution2(n, test));
	}
	// 메모리 초과
	public static int solution(int n, int[][] edge) {
		if(edge.length == 0) return 0;
		int[] nodeCnt = new int[n];
		int[] que = new int[n];
		que[0] = 1;
		nodeCnt[0] = 1;
		int queIdx = 1;
		int max = 1;
		int maxCnt = 1;
		boolean[][] loot = new boolean[n][n];
		for(int i=0; i < edge.length; i++) {
			loot[edge[i][0] - 1][edge[i][1] - 1] = true;
			loot[edge[i][1] - 1][edge[i][0] - 1] = true;
		}
		for(int i=0; i < n; i++) {
			for(int j=0; j < n; j++) {
				if(nodeCnt[j] != 0 || j == i) { continue; }
				if(loot[i][j]) {
					nodeCnt[j] = nodeCnt[i] + 1;
					que[queIdx - 1] = j + 1;
					queIdx++;
				}
			}
		}
		for(int i=0; i < n; i++) {
			if( max < nodeCnt[i]) {
				max = nodeCnt[i];
				maxCnt = 1;
			}else if(max == nodeCnt[i]){
				maxCnt++;
			}
		}
		return maxCnt;
	}
	public static int solution2(int n, int[][] edge) {
		if(edge.length == 0) return 0;
		int[] nodeCnt = new int[n];
		Queue<Integer> que = new LinkedList<>();
		int max = 1;
		int maxCnt = 1;
		int node;
		que.add(0);
		nodeCnt[0] = 1;
		boolean[][] loot = new boolean[n][n];
		for(int i=0; i < edge.length; i++) {
			loot[edge[i][0] - 1][edge[i][1] - 1] = true;
			loot[edge[i][1] - 1][edge[i][0] - 1] = true;
		}
		while(!que.isEmpty()) {
			node = que.poll();
			for(int j=0; j < n; j++) {
				if(j == node) { continue; }
				if(loot[node][j] && nodeCnt[j] == 0) {
					nodeCnt[j] = nodeCnt[node] + 1;
					que.offer(j);
				}
			}
		}
		for(int i=0; i < n; i++) {
			if( max < nodeCnt[i]) {
				max = nodeCnt[i];
				maxCnt = 1;
			}else if(max == nodeCnt[i]){
				maxCnt++;
			}
		}
		return maxCnt;
	}
}