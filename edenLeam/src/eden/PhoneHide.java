package eden;

public class PhoneHide {

	public static void main(String[] args) {
		// TODO 139 5177 6623
		String phoneNum1="133 5117 6623";
		String phoneNum2="1335117";
		String phoneNum3="1335116623a";
	
	//String substring = cha.substring(0, 3)+"****"+cha.substring(8,11);
	//alt+/ 命令快捷键
	//substring=substring+"****";
	
	//System.out.println(substring);
		String plusMark="+";
		String starMark="*";
		
		String numchek = phoneNumcheck(phoneNum3,starMark);
			
		System.out.println(numchek);
			
			
		}
	public static String phoneNumcheck(String p,String m) {
		p=p.trim();
		
		if (p.isEmpty()||p.isBlank()) {
			return "电话号码不能为空";
		}
		if(p.length()!=11) {
			return"电话位数错误，请重新输入";
					
		}
		if(!p.matches("\\d+")) {
			return "电话号码只能输入数字";
		}
	
		String firstNum=p.substring(0,3);
		
		firstNum=firstNum+"****";
		
		String scronNum=p.substring(7);
		
		String PhoneHide3=firstNum+scronNum;
		
		return PhoneHide3;
}

	
}
