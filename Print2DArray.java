
public class Print2DArray {
	static int  min;
	static int  max;
	public static int min (int previousRow,int previousColumn,int adjecentNumber) {
		
		int l = Math.min( previousRow, previousColumn);
		return Math.min(l,adjecentNumber);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int[][] matrix = { {1,1,1,1,1},{1,1,1,1,0},{1,1,1,1,0},{1,1,1,1,1} };
		int result[][] = new int[4][5];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// reverse matrix
//	    		  result[i][j]=matrix[j][i];
//	    		  System.out.print(result[i][j]+" ");

				result[i][j] = matrix[i][j];
				System.out.print(result[i][j] + " ");

			}
			System.out.println();
		}

		for (int i = 0; i < matrix.length; i++) {
			result[i][0] = matrix[i][0];
			//System.out.print(result[i][0] + " ");
		}
		for (int j = 0; j < matrix[0].length; j++) {
			result[0][j] = matrix[0][j];
			//System.out.print(result[0][j] + " ");
		}
		System.out.println();
		
	
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
	                if(matrix[i][j] == 0){
	                    continue;
	                }
	                int t = min(result[i-1][j],result[i-1][j-1],result[i][j-1]);
	                result[i][j] =  t +1;
	                if(result[i][j] > max){
	                    max = result[i][j];
	                }
	            	System.out.print(result[i][j] + " ");
	            }
			System.out.println();
			}
			System.out.println("max"+max);
		}
	}


