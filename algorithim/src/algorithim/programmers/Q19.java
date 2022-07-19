package algorithim.programmers;

import java.util.Arrays;

public class Q19 {

	/* 22-07-19
	 	https://school.programmers.co.kr/learn/courses/30/lessons/60059
	 	l3 자물쇠와 열쇠
	 */
	
	public static void main(String[] args) {
		
//		[[0, 0, 0], [1, 0, 0], [0, 1, 1]]	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]	true
		
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1,1},{1,1,0,1},{1,0,1,1},{1,0,1,1}};
		
		System.out.println(solution(key, lock));
		
	}
	
	public static boolean solution(int[][] key, int[][] lock) {               

		for(int i=0; i < 4; i++) {			
			if(check(key, lock)) {
				return true;
			}

//        	 키돌리기 * 3
            key = keyRotate(key);
        }

        return false;
    }
	
	public static int[][] keyRotate(int[][] key){
		
		int keyLen = key.length;
		int[][] key2 = new int[keyLen][keyLen];

		for(int i=0; i < keyLen; i++) {
			for(int j=0; j < keyLen; j++) {
				key2[i][j] = key[j][keyLen - i - 1];
			}	
		}
		return key2;
	}

	public static boolean check(int[][] key, int[][] lock) {
		int keyLen = key.length;
		int lockLen = lock.length;
		int[][] checkLock = new int[lockLen][lockLen];
		
		// 두 좌표계 차이
		int min = 1 - keyLen;
		int max = lockLen;
        
		// 검사
		for(int dx=min; dx < max; dx++) {
			loop : 
			for(int dy=min; dy < max; dy++) {
				for(int i=0; i < lockLen; i++) {
					for(int j=0; j < lockLen; j++) {
						checkLock[i][j] = lock[i][j];
					}
				}
				for(int x=0;x < lockLen; x++) {
					if(x - dx >= 0 && x - dx < keyLen) {
						for(int y=0;y < lockLen; y++) {
							if(y - dy >= 0 && y - dy < keyLen) {
								if(key[y - dy][x - dx] + lock[y][x] != 1) {
									continue loop;
								}else {
									checkLock[y][x] = 1;
								}
							}
						}
					}
				}
//				System.out.println(dx + "  " + dy);
//				for(int i=0; i < lockLen; i++) {
//					for(int j=0; j < lockLen; j++) {
//						System.out.print(checkLock[i][j] + " ");
//					}	
//					System.out.println();	
//				}
				// 정답 확인
				for(int i=0; i < lockLen; i++) {
					for(int j=0; j < lockLen; j++) {
						if(checkLock[i][j] != 1) {
							continue loop;
						}
					}
				}
				return true;
			}
		}
		return false; 
	}
	
}
