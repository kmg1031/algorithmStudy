package algorithim.study;
import java.util.Arrays;
public class CountingSort {
	/*	22-05-30
	 	https://www.zerocho.com/category/Algorithm/post/58006da88475ed00152d6c4b
	 	계수정렬
	 */
	public static void main(String[] args) {
		int[] test = {1,5,4,2,2,3,4,1,2,3,5,6,1,0,0,2,8};
		System.out.println(Arrays.toString(countingSort(test, 9)));
	}
	public static int[] countingSort(int[] array, int k) {
		int[] counting = new int[k];
		int[] result = new int[array.length];
		for(int i=0; i < array.length; i++) {
			counting[array[i]]++;
		}
		for(int i=0; i < k - 1 ; i++) {
			counting[i+1] += counting[i];
		}
		System.out.println(Arrays.toString(counting));
		for(int i=0; i < array.length; i++) {
			result[counting[array[i]] - 1] = array[i];
			counting[array[i]]--;
		}
		return result;
	}
}