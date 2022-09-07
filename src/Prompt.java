import java.util.*;

public class Prompt {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar calendar = new Calendar();

		printMenu();

		boolean key = true;
		while (key) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("> ");

			String cmd = scanner.next();
			switch(cmd) {
				case "1":
					cmdRegister(scanner, calendar);
					break;
				case "2":
					cmdSearch(scanner, calendar);
					break;
				case "3":
					cmdCalendar(scanner, calendar);
					break;
				case "h":
					printMenu();
					break;
				case "q":
					key = false;
			}
		}

		System.out.println("Thank you, Bye~");
		scanner.close();
	}

	private void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록 ");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println(ANSI_RED + "| h. 도움말 q. 종료" + ANSI_RESET);
		System.out.println(ANSI_RED + "+----------------------+" + ANSI_RESET);
	}

	private void cmdSearch(Scanner scanner, Calendar calendar) {
		System.out.println("[일정 검색] 날짜를 입력하세요.");
		System.out.print("> ");
		String strDate = scanner.next();

		printDatePlans(calendar, strDate);
	}

	private void printDatePlans(Calendar calendar, String strDate) {
		List<String> datePlans = calendar.getDatePlans(strDate);
		if (datePlans.size() == 0) {
			System.out.println("해당 날짜에는 일정이 없습니다.");
		} else {
			System.out.printf("%d의 일정이 있습니다\n", datePlans.size());
			for (int i = 0; i < datePlans.size(); i++) {
				System.out.printf("%d. " + datePlans.get(i) + "\n", i + 1);
			}
		}
	}

	private void cmdRegister(Scanner scanner, Calendar calendar) {
		System.out.println("[일정 등록] 날짜를 입력하세요.");
		System.out.print("> ");
		String strDate = scanner.next();

		System.out.println("일정을 입력하세요.");
		System.out.print("> ");
		String plan = scanner.next();

		calendar.registerPlan(strDate, plan);
	}

	private void cmdCalendar(Scanner scanner, Calendar calendar) {
		System.out.println("년을 입력하세요.");
		System.out.print("Year> ");
		int year = scanner.nextInt();

		System.out.println("월을 입력하세요.");
		System.out.print("Month> ");
		int month = scanner.nextInt();

		if (month > 12 || month < 1) {
			return;
		}

		printCalendar(calendar, year, month);
	}

	private void printCalendar(Calendar calendar, int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int maxDay = calendar.getMaxDaysOfMonth(year, month);
		int emptyDay = calendar.getWeekDay(year, month);

		for (int i = 0; i < emptyDay; i++) {
			System.out.print("   ");
		}

		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			// 빈 공간을 i에 더해서 빈 공간 + i가 7에 나눠질 때마다 줄바꿈하게 만듦
			int delim = i + emptyDay;
			if (delim % 7 == 0) {
				System.out.println();
			}
		}

		System.out.println();
		System.out.println();

	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
