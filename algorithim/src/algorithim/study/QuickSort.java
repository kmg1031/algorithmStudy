package algorithim.study;
import java.util.Arrays;
public class QuickSort {
	/*	22-05-27
	 	https://www.zerocho.com/category/Algorithm/post/57f72d415141fc5fe4f4ca8b
	 	합병 정렬 보다 평균적으로 빠름
	 	시간복잡도 O(n log n) ~ O(n^2)
	 	신경써야 할 조건문이 몇 개있음 (1개 이하 처리, 정렬된 상태 처리)
	 */
	public static void main(String[] args) {
		int[] test = {7,6,9,1,0,2,4,3,8,5};
		quickSort(test);
		System.out.println(Arrays.toString(test));
	}
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	public static void quickSort(int[] array, int left, int right) {
		// 빈 배열 처리
		if(left > right) {
			return;
		}
		int pivotIndex = right;
		pivotIndex = partition(array, left, right - 1, pivotIndex);
		// 정렬 대상이 1개 이하라면 정렬된 상태
		if(left < pivotIndex - 1) {
			quickSort(array, left, pivotIndex - 1);
		}
		if(pivotIndex + 1 < right) {
			quickSort(array, pivotIndex + 1, right);
		}
	}
	public static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivot = array[pivotIndex];
		while(left <= right) {
			// 정렬된 상태일 경우 pivotIndex가됨
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot && right > left){
				right--;
			}
			if(left <= right) {
				swap(array, left, right);
				right--;
			}
		}
		swap(array, left, pivotIndex);
		return left;
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}