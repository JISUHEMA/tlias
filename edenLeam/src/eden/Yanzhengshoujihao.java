package eden;

import java.util.Scanner;

public class  Yanzhengshoujihao{

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner Scanner=new Scanner(System.in);
		System.out.println("请输入手机号码");
		String Nanbe=Scanner.next();
		
		
		String regex="[1-9]\\d{10}";
		boolean march=Nanbe.matches(regex);
		
		if(march) {
			System.out.println("手机号码正确");
		}else {
			System.out.println("手机号码错误");
		}
		
		 
			
		

	
	}
}