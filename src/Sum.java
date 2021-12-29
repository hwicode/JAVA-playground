import java.util.Scanner;

public class Sum {
	
	public static void main(String [] args) {
		int a, b;
//		String str;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("두 수를 입력하세요");
		a = scan.nextInt();
		b = scan.nextInt();
//		str = Integer.toString(a + b);
//		System.out.println("두 수의 합은 " + str + "입니다." );
		System.out.printf("%d와 %d의 합은 %d입니다", a, b, a + b);
		
		scan.close();
		
	}

}
