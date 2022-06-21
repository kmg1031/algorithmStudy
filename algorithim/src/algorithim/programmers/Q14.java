package algorithim.programmers;
import java.util.Stack;
public class Q14 {
	/*	22-06-16
	 	https://programmers.co.kr/learn/courses/30/lessons/81303
	 	level 3 표편집
	 */
	public static void main(String[] args) {
//		8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]	"OOOOXOOO"
//		8	2	["D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"]	"OOXOXOOO"
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(n, k, cmd));
	}
	static class Node{
		int pre;
		int cur;
		int next;
		Node(int pre, int cur, int next){
			this.pre = pre;
			this.cur = cur;
			this.next = next;
		}
	}
	public static String solution(int n, int k, String[] cmd) {
		int temp;
		StringBuilder sb = new StringBuilder("O".repeat(n));
		
		int[] pre = new int[n];
		int[] next = new int[n];
        Stack<Node> del = new Stack<>();
        Node node;
    	for(int i=0; i < n; i++) {
    		pre[i] = i-1;
    		next[i] = i+1;
    	}
    	next[n - 1] = -1;

        for(int i=0; i < cmd.length; i++) {
        	switch(cmd[i].charAt(0)) {
	        	case 'D':
	        		temp = Integer.parseInt(cmd[i].split(" ")[1]);
	        		for(int j=0; j < temp; j++) {
	        			k = next[k];
	        		}
					break;
	        	case 'U':
	        		temp = Integer.parseInt(cmd[i].split(" ")[1]);
	        		for(int j=0; j < temp; j++) {
	        			k = pre[k];
	        		}
					break;
	        	case 'Z':
	        		node = del.pop();
	        		sb.setCharAt(node.cur, 'O');
	        		if(node.pre != -1) { next[node.pre] = node.cur; }
	        		if(node.next != -1) { pre[node.next] = node.cur; }

					break;
	        	case 'C':
	        		del.push(new Node(pre[k], k, next[k]));
	        		sb.setCharAt(k, 'X');
	        		if(pre[k] != -1) { next[pre[k]] = next[k]; }
	        		if(next[k] != -1) { pre[next[k]] = pre[k]; }

	        		if(next[k] == -1) { k = pre[k]; }
	        		else { k = next[k]; }

	        		break;
        	}
        }

        return sb.toString();
    }
}