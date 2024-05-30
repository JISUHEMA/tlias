package eden;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RrgrcEmail {

	public static void main(String[] args) {
	// 验证邮箱
	//3246566@qq.com   zhangsa3@gmail.com delih9889@pci.com.cn
		String email = "test@example.com";
		if (checkEmail(email)) {
		    System.out.println("邮箱格式正确");
		} else {
		    System.out.println("邮箱格式错误");
		}
	}
		public static boolean checkEmail(String email) {
		    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
		                   "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		    Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(email);
		    return matcher.matches();
	}

}
