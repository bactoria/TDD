import test.AccountTest;

public class Main {

    public static void main(String[] args) {

        AccountTest test = new AccountTest();

        try {
            test.testAccount(); //테스트 실행
        } catch (Exception e) {
            System.out.println("실패"); //예외가 발생하면 실패
            return;
        }
        System.out.println("성공");
    }
}
