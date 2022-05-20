package algorithim.study;
import java.util.Arrays;
public class MergeSort {
	/*	22-05-20
	 	https://www.zerocho.com/category/Algorithm/post/57ee1fc107c0b40015045cb4
	 	합병 정렬(머지 정렬)
	 	- 특징
	 		쪼개고 합치기
	 		재귀
	 	- 높은 공간 복잡도
	 */
	public static void main(String[] args) {
		int[] test = {7,6,9,1,0,2,4,3,8,5};
		System.out.println(Arrays.toString(mergeSort(test)));
	}
	public static int[] mergeSort(int[] array){
		if( array.length < 2 ) { return array; }
		int pivot = array.length / 2;
		int[] left = new int[pivot];
		int[] right = new int[array.length - pivot];
		for(int i=0; i < array.length;i++) {
			if( i < pivot ) {
				left[i] = array[i];
			}else {
				right[i - pivot] = array[i];
			}
		}
		return merge(mergeSort(left), mergeSort(right));
	}
	public static int[] merge(int[] left, int[] right){
		int[] result = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while( i < left.length && j < right.length ) {
			if( left[i] < right[j] ) {
				result[k++] = left[i++];
			}else {
				result[k++] = right[j++];
			}
		}
		while( i < left.length ) { result[k++] = left[i++]; }
		while( j < right.length ) { result[k++] = right[j++]; }
		return result;
	}
}