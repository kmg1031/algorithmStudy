package algorithim.study;
import java.util.Arrays;
public class SelectionSort {
	/*	22-05-26
	 	https://www.zerocho.com/category/Algorithm/post/57f728c85141fc5fe4f4ca89
	 	선택 정렬
	 */
	public static void main(String[] args) {
		int[] test = {7,6,9,1,0,2,4,3,8,5};
		System.out.println(Arrays.toString(selectionSort(test)));
	}
	public static int[] selectionSort(int[] array) {
		int len = array.length;
		int minIdx, tmp;
		for(int i=0; i < len - 1;i++) {
			minIdx = i;
			for(int j=i; j < len; j++) {
				if(array[j] < array[minIdx]) {
					minIdx = j;
				}
			}
			if(i != minIdx) {
				tmp = array[i];
				array[i] = array[minIdx];
				array[minIdx] = tmp;
			}
		}
		return array;
	}
}