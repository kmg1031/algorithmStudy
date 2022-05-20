package algorithim.programmers;
public class Q4 {
	/*	22-05-13
	 	https://programmers.co.kr/learn/courses/30/lessons/60057
	 	"aabbaccc"					7
		"ababcdcdababcdcd"			9
		"abcabcdede"				8
		"abcabcabcabcdededededede"	14
		"xababcdcdababcdcd"			17
	 */
	public static void main(String[] args) {
		String data = "aabbaccc";
		System.out.println(solution(data));
	}
	public static int solution(String data) {
        int data_len = data.length();
        int loop_len = data.length()/2;
        int min = data_len;
        int cnt;
        int term;
    	int j=0;
        String a;
        String b;
        String s = "";
        for(int i=1;i<=loop_len;i++) {
        	a = "";
        	b = "";
        	cnt = 1;
        	term = i;
        	s = "";
        	j = -i;
        	do {
        		j += i;
        		if(data_len < j+term) {
        			term = data_len - j;
        		}
        		;
        		if(j > data_len) {
        			b = "";
        		}else {
        			b = data.substring(j, Math.min(data_len, j+term));
        		}
        		if(a.equals(b) && j+i <= data_len) {
        			cnt++;
        		}else {
        			a = b;
        				System.out.println(cnt);
        			if(cnt>=100) {
        				s += cnt + b;
        			}else if(cnt >= 10){
        				s += cnt + b;
        			}else if(cnt > 1) {
        				s += cnt + b;
        			}else {
        				s += b;
        			}
        			cnt = 1;
        		}
			} while (j<data_len);
        	if(min > s.length()) {
        		min = s.length();
        	}
        }
        return min;
    }
}