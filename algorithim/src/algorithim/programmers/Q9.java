package algorithim.programmers;
import java.util.Arrays;
public class Q9 {
	/*
	 	https://programmers.co.kr/learn/courses/30/lessons/17676
	 */
	public static void main(String[] args) {
//		String[] test = {
//				"2016-09-15 20:59:57.421 0.351s",
//				"2016-09-15 20:59:58.233 1.181s",
//				"2016-09-15 20:59:58.299 0.8s",
//				"2016-09-15 20:59:58.688 1.041s",
//				"2016-09-15 20:59:59.591 1.412s",
//				"2016-09-15 21:00:00.464 1.466s",
//				"2016-09-15 21:00:00.741 1.581s",
//				"2016-09-15 21:00:00.748 2.31s",
//				"2016-09-15 21:00:00.966 0.381s",
//				"2016-09-15 21:00:02.066 2.62s"
//		};
		String[] test = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		System.out.println(solution(test));
	}
	public static int solution(String[] array) {
		int len = array.length;
		float[] times = new float[len];
		float[] terms = new float[len];
		String[] data;
		String[] time;
		int j;
		int max = 1;
		int count;
		float pivot;
		for(int i=0; i < len; i++) {
			data = array[i].split(" ");
			terms[i] = Float.parseFloat(data[2].substring(0,data[2].length()-1));
			time = data[1].split(":");
			times[i] = (Integer.parseInt(time[0]) * 3600) + (Integer.parseInt(time[1]) * 60) + (Float.parseFloat(time[2]));
		}
		for(int i=0; i < len - 1; i++) {
			pivot = (float) (times[i] + 0.999);
			j = i + 1;
			count = 1;
			while(j < len && times[j] - 3 <pivot) {
				if(times[j] - terms[j] < pivot) {
					count++;
				}
				j++;
			}
			if(count > max) {
				max = count;
			}
		}
		return max;
	}
}