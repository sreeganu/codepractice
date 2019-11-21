
public class MaxProduct {
	int temp[] = new int[10];
	int max = 0;
	int position = 0;

	public void findMaxProduct(int arr[]) {
		temp = new int[10];
		max = 0;
		position = 0;
		  //max product of 2 consecutive integers in an array 
		//for (int i = 0; i < arr.length; i++) { 
			//for (int j = 0; j < arr.length; j++) { 
				//if (i != j) { 
					//if(arr[i] * arr[j] > max) { 
						//max = arr[i] * arr[j]; 
						//} 
					//} 
				//} 
			//}
		 // System.out.println("max product of 2 consecutive integers in an array:" + max);
		 
//Max product sub array
		for (int i = 1; i < arr.length; i++) {

			if (i - 1 == 0) {
				max = arr[i] * arr[i - 1];
				position = i;
			} else if (arr[i] * arr[i - 1] > max) {
				if (position == i - 1) {
					max = max * arr[i];
					position = i;	
					for (int j = 0; j <= i; j++) {
						temp[j] = arr[j];
					}
				} else {
					position = i;
					max = arr[i] * arr[i - 1];					
						temp[0] = arr[i-1];
						temp[1] = arr[i];
				}
				
			}
		}
		System.out.println("Max Product subarray:");
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0)
				System.out.print(temp[i]);
		}
		System.out.println();
		System.out.println("Max Product:" + max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -2, -3, 0, -2, -40 };
		int arr1[] = { 6, -3, -10, 0, 2 };
		int arr2[] = { 1, 2, -2, 3, 5};
		MaxProduct maxProduct = new MaxProduct();
		maxProduct.findMaxProduct(arr);
		maxProduct.findMaxProduct(arr1);
		maxProduct.findMaxProduct(arr2);

	}

}
