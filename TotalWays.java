/**
 * 
 */

/**
 * @author 12069
 *
 */
public class TotalWays {

	/**
	 * @param args
	 */
	public void totalWays(int arr[][]) {
		int result[][] = new int[arr.length][arr[0].length];
		// to insert first row 
		for (int i = 0; i < arr.length; i++) {
			result[i][0] = 1;
		}
		// to insert first column 
		for (int j = 0; j < arr[0].length; j++) {
			result[0][j] = 1;
		}

		//to insert remaining cells
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}
		//printing array
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 13 }, { 13, 14, 15, 16 } };
		TotalWays totalWays = new TotalWays();
		totalWays.totalWays(arr);
	}

}
