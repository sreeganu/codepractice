
public class CountSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sampleSpace = 3;
		int n = 2;
		int count = 0;
		if(sampleSpace > 0 && n>0) {
		for(int i =sampleSpace;i>0;sampleSpace--) {
			if(n<=0) {
				count = count+1;
				System.out.println("count:"+count);				
				break;
			}else {
				count =  (sampleSpace * n) + count;
				System.out.println("sampleSpace : "+sampleSpace+" "+"N :"+" "+n);
				System.out.println("count:"+count);
				n--;
			}
			
		}
		}else {
			
			System.out.println("Invalid number");
		}

	}

}
