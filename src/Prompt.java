import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		HelloGit calandar = new HelloGit();

		while (true) {
			System.out.println("년을 입력하세요.");
			System.out.print("Year> ");
			int year = scan.nextInt();
			if (year == -1) {
				System.out.println("Have a nice day!");
				break;
			}
			
			System.out.println("월을 입력하세요.");
			System.out.print("Month> ");
			int month = scan.nextInt();

			if (month == -1) {
				System.out.println("Have a nice day!");
				break;
			} else if (month > 12 || month < 1) {
				System.out.println("알맞은 값을 입력해주세요.");
			} else {
				calandar.printCalandar(year, month);
			}
		}

		scan.close();
	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
