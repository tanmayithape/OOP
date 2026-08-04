package fibonaccii;

public class series {
	public static void main(String[]args){ 
		int a=12;
		int b=1;
		int c=1;
		
		for(int i=1;i<=a;i++) {
			int d=b+c;
			b=c;
			c=d;
			System.out.println(d);
		}
	}
}
