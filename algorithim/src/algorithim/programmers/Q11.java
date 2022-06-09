package algorithim.programmers;
import java.util.Arrays;
public class Q11 {
	/*	22-06-08
	 	https://programmers.co.kr/learn/courses/30/lessons/17678
	 	3 level 셔틀버스
	 */
	public static void main(String[] args) {
		//	10	25	1	{ "09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50", "10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50" }	"10:29"
		//	1	1	5	["08:00", "08:01", "08:02", "08:03"]	"09:00"
		//	2	10	2	["09:10", "09:09", "08:00"]				"09:09"
		int n = 10;
		int t = 25;
		int m = 1;
		String[] timetable = { "09:00", "09:10" ,"09:20" ,"09:30" ,"09:40" ,"09:50", "10:00", "10:10" ,"10:20" ,"10:30" ,"10:40" ,"10:50" };
		System.out.println(solution(n, t, m, timetable));
	}
	public static String solution(int n, int t, int m, String[] timetable) {
		// 버스 시간마다 탈 수 있는지 확인해야함
		// 해당 시간마다 탈 수 있는 시간을 확인하고 맨 마지막의 숫자로 대체
		// 각 버스 시간이 기준이고 태울 수 있는 사람 수 -1 자리의 사람 보다 1분 빨리
		// 널널하면 버스 시간 그리고 다음 버스 시간 계산
		// 그럼 버스 시간 확인 + 대기인원 확인 + 남아서 넘어가는 인원도 확인
		int[] bus_schedule = new int[n];
		int[] people_schedule = new int[timetable.length];
		int[] result = new int[n];
		String[] time = null;
		int max = 0;
		int waiting = 0;
		bus_schedule[0] = 540;
		// 버스 시간표
		for(int i=1; i < n; i++) {
			bus_schedule[i] = bus_schedule[i-1] + t;
		}
		// 사람 시간표
		for(int i=0; i < people_schedule.length; i++) {
			time = timetable[i].split(":");
			people_schedule[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
		}
		Arrays.sort(people_schedule);
		int j = 0;
		for(int i=0; i < bus_schedule.length; i++) {
			while(j < people_schedule.length && i < bus_schedule.length &&  people_schedule[j] <= bus_schedule[i] && result[i] < m) {
				result[i]++;
				j++;
			}
		}
		int idx = 0;
		for(int i=0; i < result.length; i++) {
			waiting = waiting + result[i] - m;
			idx += result[i];
			if(waiting < 0) {
				max = bus_schedule[i];
				waiting = 0;
			}else {
				max = people_schedule[idx-1] - 1;
			}
		}
		time[0] = Integer.toString(max / 60);
		time[0] = time[0].length() < 2 ? "0" + time[0]: time[0];
		time[1] = Integer.toString(max % 60);
		time[1] = time[1].length() < 2 ? "0" + time[1]: time[1];
		return String.join(":", time);
	}
	public static int take(int[] times, Integer sTime, Integer t) {
		int cnt = 0;
		sTime = sTime != null ? sTime : 0;
		t = t != 0? t : 1440;
		for(int i=0; i <times.length; i++) {
			if(times[i] > sTime && times[i] < sTime + t) { cnt++; }
		}
		return cnt;
	}
}