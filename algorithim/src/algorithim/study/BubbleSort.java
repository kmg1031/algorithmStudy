package algorithim.study;
import java.util.Arrays;
public class BubbleSort {
	/*	22-05-26
	 	https://www.zerocho.com/category/Algorithm/post/57f67519799d150015511c38
	 	버블 정렬
	 */
	public static void main(String[] args) {
		int[] test = {7,6,9,1,0,2,4,3,8,5};
		System.out.println(Arrays.toString(bubbleSort(test)));
	}
	public static int[] bubbleSort(int[] array) {
		int len = array.length;
		int tmp;
		for(int i=0; i < len - 1; i++) {
			for(int j=0; j < len - 1 - i; j++) {
				if(array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
		return array;
	}
}