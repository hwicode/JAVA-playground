
public class HelloGit {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] dayOfTheWeek = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}

	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	// SU는 빈공간 0개, MO는 빈공간 1개, ~~~, SA는 빈공간 6개
	public int getEmptySpace(String firstDay) {
		for (int i = 0; i < dayOfTheWeek.length; i++) {
			if (dayOfTheWeek[i].equals(firstDay)) {
				return i;
			}
		}
		return 0;
	}

	public void printCalandar(int year, int month, String firstDay) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int maxDay = getMaxDaysOfMonth(year, month);
		int emptyDay = getEmptySpace(firstDay);

		for (int i = 0; i < emptyDay; i++) {
			System.out.print("   ");
		}

		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			//빈 공간을 i에 더해서 빈 공간 + i가 7에 나눠질 때마다 줄바꿈하게 만듦
			if ((i + emptyDay) % 7 == 0) {
				System.out.println();
			}
		}

		System.out.println();

	}

}
