// 완벽하진 않은 
public class Test4 {

	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0},
			{1, 0, 1, 1}};
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int cnt = 1;
		int i = 0;
		int j = 0;
		int direction = 0; // 0 = right, 1 = down, 2 = left, 3 = up
		while (true) {

			switch (direction % 4) {
				case 0:
					if (j + 1 < board[i].length) {
						j++;
					} else {
						direction++;
						i++;
					}
					break;
				case 1:
					if (i + 1 < board.length) {
						i++;
					} else {
						direction++;
						j--;
					}
					break;
				case 2:
					if (j - 1 >= 0) {
						j--;
					} else {
						direction++;
						i--;
					}
					break;
				case 3:
					if (i - 1 >= 0) {
						i--;
					} else {
						direction++;
						j++;
					}
					break;
			}

			if (board[i][j] == 1) {
					System.out.println("첫번째 direction(" + direction + ") : " + i + ", " + j);
				direction++;
			} else if (board[i][j] == 0) {
				board[i][j] = -1;
				System.out.println("두번째 direction(" + direction + ") : " + i + ", " + j);
				cnt++;
			} else {
				System.out.println("세번째 direction(" + direction + ") : " + i + ", " + j);
				break;
			}
		}

		return cnt;
	}
}
