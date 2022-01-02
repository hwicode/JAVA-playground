
public class HelloGit {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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
	
	public int getWeekDay(int year, int month) {
		int previousYear = year - 1;
		int previousMonth = month - 1;
		int zeroToPreviousYear = (previousYear * 365) + (previousYear / 4) - (previousYear / 100) + (previousYear / 400);
		if (isLeapYear(year)) {
			int sumMonthDays = 0;
			for(int i = 0; i < previousMonth; i++) {
				sumMonthDays += LEAP_MAX_DAYS[i];
			}
			int allDays = zeroToPreviousYear + sumMonthDays + 1;
			int weekDay = allDays % 7;
			return weekDay;
		} else {
			int sumMonthDays = 0;
			for(int i = 0; i < previousMonth; i++) {
				sumMonthDays += MAX_DAYS[i];
			}
			int allDays = zeroToPreviousYear + sumMonthDays + 1;
			int weekDay = allDays % 7;
			return weekDay;
		}
	}

	public void printCalandar(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int maxDay = getMaxDaysOfMonth(year, month);
		int emptyDay = getWeekDay(year, month);

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

}
