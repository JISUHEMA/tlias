package eden;

import java.util.Scanner;

public class Aagdggdg {

    public static void main(String[] args) {
        // 输入7位数以内的金额，位数不够的话追加成0，用中国的大文字表示
        //0~9999999以内
        //[壹,贰,叁,肆，伍，陆，柒，捌，玖]

        int money = 235;
        String moneyStr = "";
        while (true) {
            int remain = money % 10;

            String capital = getCapital(remain);
            moneyStr = capital + moneyStr;

            money = money / 10;
            if (money == 0) {
                break;
            }
        }
        System.out.println("金额大写表示：" + moneyStr);

    }

    static String getCapital(int n) {
        String[] arrString = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

        return arrString[n];
    }

    static int checkMoney() {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入金额:");

        while (!scanner.hasNextInt()) {
            System.out.println("金额只能输入数字，请再次输入");
            scanner.next();
        }

        while (true) {
            long num = scanner.nextInt();

            if (num >= 00 && num < 9999999) {
                //输入金额正确的时候
                return (int) num;
            } else {
                //输入金额错误的时候
                System.out.println("金额只能输入0~9999999");
                scanner.next();


            }

        }
    }
}
