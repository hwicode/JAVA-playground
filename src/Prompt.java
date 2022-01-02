import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner scan = new Scanner(System.in);
		HelloGit calandar = new HelloGit();

		while (true) {
			System.out.println("년을 입력하세요.");
			System.out.print("Year> ");
			int year = scan.nextInt();
			System.out.println("월을 입력하세요.");
			System.out.print("Month> ");
			int month = scan.nextInt();
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
			System.out.print("Day> ");
			String firstDay = scan.next();

			if (month == -1) {
				System.out.println("Have a nice day!");
				break;
			} else if (month > 12 || month < 1) {
				System.out.println("알맞은 값을 입력해주세요.");
			} else {
				calandar.printCalandar(year, month, firstDay);
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
