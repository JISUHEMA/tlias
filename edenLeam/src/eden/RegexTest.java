package eden;

import java.util.Scanner;

public class RegexTest {

	public static void main(String[] args) {
		// 规则 qq 6到20  0开始不行 只有数字
		//String qq="012345678";
		@SuppressWarnings("resource")
		Scanner Scanner=new Scanner(System.in);
		System.out.println("请输入QQ号码");
		String QQ=Scanner.next();
		
		/*char ch='￥r';
		int in=ch;
		System.out.println(in);*/
		
		//System.out.println(qq.length());
		
		//System.out.println(checkqq(qq));
		//正规表现验证
		String regex="[1-9]\\d{5,19}";
		boolean march=QQ.matches(regex);
		//System.out.println(QQ.matches(regex));
		
		if(checkqq(QQ)) {
			System.out.println("QQ号码正确");
		}else {
			System.out.println("QQ号码错误");
		}}
		
	/*// 邮箱验证
	String email = "test@example.com";
	if (checkEmail(email)) {
	    System.out.println("邮箱格式正确");
	} else {
	    System.out.println("邮箱格式错误");
	}
	}*/
		
	public static boolean checkqq(String qq) {
		int len=qq.length();
		if(len<6||len>20) {
			return false;
	}
		if(qq.startsWith("0")) {
		
	}
		for(int i=0;i<qq.length();i++) {
			char c=qq.charAt(i);
			if(c<'0'||c>'9') {
				return false;
}
		}
	return true;
	}
	
	/*public static boolean checkEmail(String email) {
	    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
	                   "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	  Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}*/
}
