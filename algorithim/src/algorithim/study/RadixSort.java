package algorithim.study;
import java.util.Arrays;
public class RadixSort {
	/*	22-05-30
	 	https://www.zerocho.com/category/Algorithm/post/58007c338475ed00152d6c4c
	 	https://herong.tistory.com/entry/%EA%B8%B0%EC%88%98%EC%A0%95%EB%A0%ACRidix-Sort?category=818669
	 	기수정렬
	 	LSD
	 	MSD도 있음
	 */
	public static void main(String[] args) {
		int[] test = {9,42,11,5502,34,63,555,1,1000,4};
		System.out.println(Arrays.toString(radixSort(test)));
		String[] test2 = {"tesdfaew","wer","aaac","dsf","zsd","aaab","ettw","wead","z","etes","as"};
		System.out.println(Arrays.toString(radixSort(test2)));
	}
	public static int[] radixSort(int[] array) {
		int max = 0;
		for(int i=0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		for(int digit=1; digit < max; digit *= 10) {
			array = countingSort(array, digit);
		}
		return array;
	}
	// [a-z] String 정렬
	public static int[] countingSort(int[] array, int digit) {
		int[] counting = new int[10];
		int[] result = new int[array.length];
		for(int i=0; i < array.length; i++) {
			counting[(array[i] / digit ) % 10]++;
		}
		for(int i=1; i < 10; i++) {
			counting[i] += counting[i-1];
		}
		for(int i=array.length - 1; i >= 0; i--){
			result[counting[(array[i] / digit ) % 10] - 1] = array[i];
			counting[(array[i] / digit ) % 10]--;
		}
		return result;
	}
	public static String[] radixSort(String[] array) {
		int max = 0;
		for(int i=0; i < array.length; i++) {
			if(array[i].length() > max) {
				max = array[i].length();
			}
		}
		for(int digit = max - 1; digit >= 0; digit--) {
			array = countingSort(array,digit);
		}
		return array;
	}
	public static String[] countingSort(String[] array, int digit) {
		String[] result = new String[array.length];
		int[] counting = new int['z' - 'a' + 2];
		int idx;
		for(int i=0; i < array.length; i++) {
			if(array[i].length() > digit) {
				idx = array[i].charAt(digit) - 'a' + 1;
			}else {
				idx = 0;
			}
			counting[idx]++;
		}
		for(int i=1; i < 'z' - 'a' + 2; i++) {
			counting[i] += counting[i-1];
		}
		for(int i = array.length - 1; i >= 0; i--) {
			if(array[i].length() > digit) {
				idx = array[i].charAt(digit) - 'a' + 1;
			}else {
				idx = 0;
			}
			result[counting[idx] - 1] = array[i];
			counting[idx]--;
		}
		return result;
	}
}