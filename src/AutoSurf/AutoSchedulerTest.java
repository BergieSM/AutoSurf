package AutoSurf;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

/**
 * This was the first class created for this project and as such, though functional, is very rough and filled with old code.<br>
 * @author Bergie
 *
 */
public class AutoSchedulerTest {
	/**
	 * Runs the autocheduler test versus the current MSP, client, and session
	 * defined globally.<br>
	 * This opens the Super Global Admin, navigates to the MSP's Admin page,
	 * then session viewer, selects the client, opens the session, and selects
	 * the first location.<br>
	 * Next it navigates the autoscheduler to the desired month and year,
	 * determines what dates are selectable, randomly picks one and clicks that
	 * date.<br>
	 */
	static void main() {
		Results.addTestResult(new TestResult("AutoSchedulerTest on "
				+ Parameters.getBoxSet().getBoxSetName(), false));
		// String[] args = Master.getParameters();
		WebDriver driver = Driver.getCurrentDriver();
		WebDriverWait wait = Driver.getCurrentWait();
		// String sqlUserName = args[0];
		// String sqlPassword = args[1];
		// String MSP = args[4];
		// String client = args[5];
		// String sandboxUserName = args[2];
		// String companyValueString = "";
		// String sessionName = args[6];
		// String boxSetAsString = args[3];
		// int boxSet = Integer.valueOf(boxSetAsString);
		// int companyValue = 0;
		Boolean success = false;

		// sandboxUserName = "jbergstrom"; //debugging
		// MSP = "2mercsurveys"; //debugging
		// client = "Bergie's Tacos"; //debugging
		// sessionName = "Bergie Automation Test Session"; //debugging

		// String DEVSuperGlobal =
		// "http://www.sassiedev.com/admin/SuperGlobalAdmin.php";
		// String SuperGlobalWPass = "http://" + sqlUserName + ":" + sqlPassword
		// + "@" + Navigation.boxSet(boxSet,sandboxUserName) +
		// "/admin/SuperGlobalAdmin.php/";
		// String DEVAdmin2MercSurveysLoginURL =
		// String DEVAdmin2MercSurveysLoginURLWPass =

		// WebDriver driver = new FirefoxDriver();//Start Firefox //debugging
		// WebDriverWait wait = new WebDriverWait(driver, 20); //debugging

		// System.out.println(SuperGlobalWPass);
		// driver.get(SuperGlobalWPass); //Go to Super Global
		// System.out.println(driver.getTitle());//Report title //debugging

		// String[] parameters = new String[]{sqlUserName, sqlPassword,
		// sandboxUserName, boxSetAsString};
		Navigation.goToSuperGlobal();
		SuperGlobalAdmin.MSPAdminLinkSelect();

		// Alert showing up at this point for the Android Browser
		checkAlert();

		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.name("schedulerOptions")));
		WebElement scheduleShopsBox = driver.findElement(By
				.name("schedulerOptions"));
		Select scheduleShopsSelect = new Select(scheduleShopsBox);
		scheduleShopsSelect.selectByValue("applications");

		List<WebElement> goButtons = driver.findElements(By.tagName("a"));
		for (WebElement goButton : goButtons) {
			Debug.throwInDebugIfOn(goButton.getAttribute("href")); // debugging
			// if(goButton.getAttribute("href").contains("javascript:%20window.document.forms[0].mode.value='scheduler'")){
			if (goButton.getAttribute("href").matches("(.*)'scheduler'(.*)")) {
				goButton.click();
				break;
			}
		}

		WebElement companyBox = driver.findElement(By.name("searchClientID"));
		Select companySelect = new Select(companyBox);

		if (Parameters.getClient() != null) {
			// Both work
			// clickThis.selectByValue("357");//works
			companySelect.selectByVisibleText(Parameters.getClient());// works
		} else {
			System.out
					.println("No company defined for AutoSchedulerTest, defaulting to first available company");
			companySelect.selectByIndex(1);
		}

		WebElement showSessionsButton = driver.findElement(By
				.name("submitButtonName"));
		showSessionsButton.click();

		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("body > div:nth-child(4) > table > tbody")));
		WebElement sessionList = driver.findElement(By
				.cssSelector("body > div:nth-child(4) > table > tbody"));
		List<WebElement> sessions = sessionList.findElements(By.tagName("tr"));
		List<WebElement> sessionInfo = null;
		WebElement processLink = null;
		// if(Debug.getDebugState()==true)System.out.println("sessionName: "+sessionName);
		// //debugging //deprecated
		if (Parameters.getSessionName() == null) {
			System.out
					.println("No session defined for AutoSchedulerTest, defaulting to first available session");
			sessionInfo = sessions.get(1).findElements(By.tagName("td"));
			wait.until(ExpectedConditions.elementToBeClickable(By
					.linkText("Process")));
			Debug.throwInDebugIfOn(sessionInfo.get(5).getText()); // debugging
			processLink = sessionInfo.get(5)
					.findElement(By.linkText("Process"));
		} else {
			for (WebElement sessionB : sessions) {
				sessionInfo = sessionB.findElements(By.tagName("td"));
				Debug.throwInDebugIfOn("sessionInfo size" + sessionInfo.size()); // debugging
				Debug.throwInDebugIfOn(sessionInfo.get(1).getText()); // debugging
				if (sessionInfo.get(1).getText()
						.contains(Parameters.getSessionName())) {
					Debug.throwInDebugIfOn("woohoo!"); // debugging
					processLink = sessionInfo.get(5).findElement(
							By.linkText("Process"));
					break;
				}
			}
		}
		if (processLink == null) {
			System.out.println("Could not find session, quitting");
			// driver.quit();
			Results.replaceLastResult(success);
			// results.add(success);

			return;
		}

		// WebElement processLink =
		// driver.findElement(By.cssSelector("body > div:nth-child(4) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(6) > a:nth-child(1)"));
		processLink.click();

		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector(".maroonbold > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > a:nth-child(1)")));
		WebElement firstLocationSelect = driver
				.findElement(By
						.cssSelector(".maroonbold > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > a:nth-child(1)"));
		firstLocationSelect.click();

		Debug.throwInDebugIfOn("Dumb Testing Here"); // debugging
		for (int j = 0; j < 2; j++) {
			nextMonth();
			prevMonth();
		}
		monthSelect(12);
		yearSelect(2015);
		yearSelect(2014);

		// Array variable- 28 or 35 or 42 possible date locations (4, 5, or 6
		// weeks displayed)
		WebElement calendarBody = driver
				.findElement(By
						.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(2)"));

		int numberOfWeeks = calendarBody.findElements(By.tagName("tr")).size();
		Debug.throwInDebugIfOn("Weeks: " + numberOfWeeks); // debugging

		Debug.throwInDebugIfOn("Calendar start"); // debugging
		String[] calendar = new String[numberOfWeeks * 7];
		int day = 1;
		int week = 1;
		for (int i = 0; i < numberOfWeeks * 7; i++) {
			if (day == 8) {
				day = 1;
				week++;
			}
			calendar[i] = driver
					.findElement(
							By.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child("
									+ week + ") > td:nth-child(" + day + ")"))
					.getAttribute("data-handler");
			day++;
		}

		// print the array, debugging
		if (Debug.getDebugState() == true) {
			for (int j = 0; j < numberOfWeeks * 7; j++) {
				Debug.throwInDebugIfOn(calendar[j]);
			}
		}

		// determine the number of select-able days
		int selectableDays = 0;
		int[] selectableDates = new int[31]; // 31 only because there cannot be
												// more days in a month than 31
		for (int k = 0; k < numberOfWeeks * 7; k++) {
			if (calendar[k] != null) {
				selectableDates[selectableDays] = k;
				selectableDays++;
			}
		}
		Debug.throwInDebugIfOn("Number of selectable days: " + selectableDays); // debugging
		if (selectableDays == 0) {
			Debug.throwInDebugIfOn("No selectable days for this month.");
			success = true;
		} else {
			// Print the select-able days //Debugging
			if (Debug.getDebugState() == true) {
				System.out.println("Selectable Days:");
				for (int l = 0; l < selectableDays; l++) {
					Debug.throwInDebugIfOn(String.valueOf(selectableDates[l]));
				}
			}

			// Pick a random day from the select-able
			Random r = new Random();
			int selectedDay = selectableDates[r.nextInt(selectableDays)];
			Debug.throwInDebugIfOn("Selected day: " + selectedDay); // debugging

			// Click on selected day
			int selectedWeekDay = (selectedDay % 7) + 1;
			int selectedWeek = (int) (selectedDay / 7) + 1;
			WebElement selectedDayClick = driver
					.findElement(By
							.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child("
									+ selectedWeek
									+ ") > td:nth-child("
									+ selectedWeekDay + ")"));
			Debug.throwInDebugIfOn("selectedDayClick (ACTUAL date chosen): "
					+ selectedDayClick.getText()); // debugging
			selectedDayClick.click();
			success = true;
		}

		Debug.throwInDebugIfOn("Title is: " + driver.getTitle()); // Just to
																	// know that
																	// it got to
																	// the end
																	// basically,
																	// debugging
		Debug.throwInDebugIfOn("URL is: " + driver.getCurrentUrl()); // debugging
		// driver.close(); //Closes the currently active window, quits the run
		// only if it is the only/last window.
		// driver.quit(); //Closes all windows associated with this run, and
		// then quits the run- does not quit other Firefox windows, just
		// associated windows.
		Results.replaceLastResult(success);

		return;
	}

	/**
	 * Used to select a specific month in the autoscheduler calendar, takes the
	 * month as an int (1-12 for ease of use)
	 * 
	 * @param monthChoice
	 *            1-12 as January to December
	 */
	private static void monthSelect(int monthChoice) {
		WebDriver driver = Driver.getCurrentDriver();
		WebDriverWait wait = Driver.getCurrentWait();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > select:nth-child(1)")));
		WebElement monthSelect = driver
				.findElement(By
						.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > select:nth-child(1)"));
		Select monthClick = new Select(monthSelect);
		// Check that it is valid input between 1 and 12, then case into select
		// by visible text
		if (0 < monthChoice && monthChoice < 13) {
			switch (monthChoice) {
			case 1:
				monthClick.selectByVisibleText("Jan");
				break;
			case 2:
				monthClick.selectByVisibleText("Feb");
				break;
			case 3:
				monthClick.selectByVisibleText("Mar");
				break;
			case 4:
				monthClick.selectByVisibleText("Apr");
				break;
			case 5:
				monthClick.selectByVisibleText("May");
				break;
			case 6:
				monthClick.selectByVisibleText("Jun");
				break;
			case 7:
				monthClick.selectByVisibleText("Jul");
				break;
			case 8:
				monthClick.selectByVisibleText("Aug");
				break;
			case 9:
				monthClick.selectByVisibleText("Sep");
				break;
			case 10:
				monthClick.selectByVisibleText("Oct");
				break;
			case 11:
				monthClick.selectByVisibleText("Nov");
				break;
			case 12:
				monthClick.selectByVisibleText("Dec");
				break;
			}
		} else {
			System.out.println("Error on input to monthSelect function");
		}

		return;
	}

	/**
	 * Used to select the following month in the autoscheduler calendar
	 */
	private static void nextMonth() {
		WebDriver driver = Driver.getCurrentDriver();
		WebDriverWait wait = Driver.getCurrentWait();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > a:nth-child(2) > span:nth-child(1)")));
		// WebElement nextMonthClick =
		// driver.findElement(By.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > a:nth-child(2) > span:nth-child(1)"));
		// nextMonthClick.click(); //Multiple in a row fails, use monthSelect
		// (Future: function call with findelement preceding click always)
		driver.findElement(
				By.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > a:nth-child(2) > span:nth-child(1)"))
				.click();

		return;
	}

	/**
	 * Used to select the previous month in the autoscheduler calendar
	 */
	private static void prevMonth() {
		WebDriver driver = Driver.getCurrentDriver();
		WebDriverWait wait = Driver.getCurrentWait();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")));
		// WebElement priorMonthClick =
		// driver.findElement(By.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
		// priorMonthClick.click(); //Multiple in a row fails, use monthSelect
		// (Future: function call with findelement preceding click always)
		driver.findElement(
				By.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"))
				.click();

		return;
	}

	/**
	 * Used to select a specific year in the autoscheduler calendar, takes the
	 * year as an int
	 * 
	 * @param yearChoice
	 *            The year to select as an integer
	 */
	private static void yearSelect(int yearChoice) {
		WebDriver driver = Driver.getCurrentDriver();
		WebDriverWait wait = Driver.getCurrentWait();
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")));
		WebElement yearSelect = driver
				.findElement(By
						.cssSelector("#selfAssignInfoCalendar > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > select:nth-child(2)"));
		Select yearClick = new Select(yearSelect);
		if (yearChoice > 0 && yearChoice < 10000) {
			String yearChoiceAsString = String.valueOf(yearChoice);
			yearClick.selectByValue(yearChoiceAsString); // value just = the
															// year, ie, 2015 =
															// 2015
		} else {
			System.out.println("Error on input to yearSelect function");
		}

		return;
	}
	
	/**
	 * TODO: This class will hopefully be able to automatically dismiss the pop-up alert warning that flash is not installed when viewing SuperGlobalAdmin on an Android device.
	 */
	private static void checkAlert() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			String handle = driver.getWindowHandle();
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			driver.switchTo().window(handle);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// exception handling
		}
		/*
		 * private static void checkAlert2() { try{ WebDriver driver =
		 * Driver.getCurrentDriver(); //WebDriverWait wait = new
		 * WebDriverWait(driver, 2); String parentWindowHandle =
		 * driver.getWindowHandle(); String childWindowHandle = null;
		 * if(driver.getWindowHandles().iterator().hasNext()){ childWindowHandle =
		 * driver.getWindowHandles().iterator().next(); }
		 * driver.switchTo().window(childWindowHandle); driver.close();
		 * driver.switchTo().window(parentWindowHandle); } catch (Exception e) {
		 * 
		 * } }
		 */
	}
}