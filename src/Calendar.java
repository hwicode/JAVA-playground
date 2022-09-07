import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final Map<LocalDate, List<String>> plans = new HashMap<>();

	public boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
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

		int sumMonthDays = 0;
		if (isLeapYear(year)) {
			for(int i = 0; i < previousMonth; i++) {
				sumMonthDays += LEAP_MAX_DAYS[i];
			}
		} else {
			for(int i = 0; i < previousMonth; i++) {
				sumMonthDays += MAX_DAYS[i];
			}
		}

		int allDays = zeroToPreviousYear + sumMonthDays + 1;
		return allDays % 7;
	}

	public void registerPlan(String strDate, String plan) {
		LocalDate date = LocalDate.parse(strDate);
		if (plans.containsKey(date)) {
			List<String> datePlans = plans.get(date);
			datePlans.add(plan);
		} else {
			List<String> datePlans = new ArrayList<>();
			datePlans.add(plan);
			plans.put(date, datePlans);
		}
	}

	public List<String> getDatePlans(String strDate) {
		LocalDate date = LocalDate.parse(strDate);
		List<String> datePlans = new ArrayList<>();

		if (plans.containsKey(date)) {
			List<String> original = plans.get(date);
			datePlans.addAll(original);
		}

		return datePlans;
	}
}
