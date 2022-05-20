package algorithim.study;
import java.util.Arrays;
public class InsertionSort {
	/*	22-05-17
	 	https://www.zerocho.com/category/Algorithm/post/57e39fca76a7850015e6944a
	 	삽입 정렬 알고리즘
	 	- 특징
	 		한 쪽의 숫자를 뽑아서 뽑는 곳부터 벽으로가면서 끼워 주는 방식
	 	- 시간 복잡도
	 		O(N^2)
	 	- 공간 복잡도
	 	{7,6,9,1,0,2,4,3,8,5}
	 */
	public static void main(String[] args) {
		int[] test = {7,6,9,1,0,2,4,3,8,5};
		int i, j, tmp;
		for(i=1;i<test.length;i++) {
			tmp = test[i];
			for(j=i-1; j>=0 && test[j] > tmp;j--) {
				test[j+1] = test[j];
			}
			test[j+1] = tmp;
		}
		System.out.println(Arrays.toString(test));
	}
}