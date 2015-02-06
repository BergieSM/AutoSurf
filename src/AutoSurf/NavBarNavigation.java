package AutoSurf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class that controls navigation via the NavBar.
 * @author Bergie
 */
public class NavBarNavigation extends Navigation {
	private static WebElement MainAdminHome = null;
	private static WebElement AdminShopLog = null;
	private static WebElement ShopReview = null;
	private static WebElement SchedulerMaster = null;
	private static WebElement Help = null;
	private static WebElement SchedulerLogs = null;
	private static WebElement Sessions = null;
	private static WebElement AdminNavBarMap = null;
	private static String MainAdminHomeLink = null;
	private static String AdminShopLogLink = null;
	private static String ShopReviewLink = null;
	private static String SchedulerMasterLink = null;
	private static String HelpLink = null;
	private static String SchedulerLogsLink = null;
	private static String SessionsLink = null;

	/**
	 * Attempts to map the controls on the NavBar.
	 * TODO: IN PROGRESS
	 */
	protected static void mapNavBar() {
		try {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			AdminNavBarMap = Driver.getCurrentDriver().findElement(
					By.name("adminnavbarb8bed8de"));
			List<WebElement> areas;
			areas = AdminNavBarMap.findElements(By.tagName("area"));
			for (WebElement a : areas) {
				String alt = a.getAttribute("alt");
				String link = a.getAttribute("href");
				Debug.throwInDebugIfOn(alt); // Debug
				Debug.throwInDebugIfOn("href? " + a.getAttribute("href"));
				switch (alt) {
				case "Help":
					Help = a;
					HelpLink = link;
					break;
				case "Scheduling":
					SchedulerMaster = a;
					SchedulerMasterLink = link;
					break;
				case "Scheduler":
					SchedulerMaster = a;
					SchedulerMasterLink = link;
					break;
				case "Shop Review":
					ShopReview = a;
					ShopReviewLink = link;
					break;
				case "Admin Shop Log":
					AdminShopLog = a;
					AdminShopLogLink = link;
					break;
				case "Admin":
					MainAdminHome = a;
					MainAdminHomeLink = link;
					break;
				case "Main Admin page":
					MainAdminHome = a;
					MainAdminHomeLink = link;
					break;
				case "Sessions":
					Sessions = a;
					SessionsLink = link;
					break;
				case "Logs":
					SchedulerLogs = a;
					SchedulerLogsLink = link;
					break;
				default:
					System.out
							.println("Something other than an expected alt text: "
									+ alt);
				}
			}
			if (Debug.getDebugState() == true)
				printNavBar();
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	/**
	 * Resets all NavBar mappings to null.
	 */
	protected static void clearNavBarMap() {
		MainAdminHome = null;
		AdminShopLog = null;
		ShopReview = null;
		SchedulerMaster = null;
		Help = null;
		SchedulerLogs = null;
		Sessions = null;
		AdminNavBarMap = null;
		MainAdminHomeLink = null;
		AdminShopLogLink = null;
		ShopReviewLink = null;
		SchedulerMasterLink = null;
		HelpLink = null;
		SchedulerLogsLink = null;
		SessionsLink = null;
	}

	protected static void goToAdminShopLog() {
		try {
			// AdminShopLog.click();
			Driver.getCurrentDriver().get(AdminShopLogLink);
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			mapNavBar();
		}
	}

	protected static void goToMainAdminHome() {
		try {
			// MainAdminHome.click();
			Driver.getCurrentDriver().get(MainAdminHomeLink);
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			mapNavBar();
		}
	}

	protected static void goToShopReview() {
		try {
			// ShopReview.click();
			Driver.getCurrentDriver().get(ShopReviewLink);
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			mapNavBar();
		}
	}

	protected static void goToSchedulerMaster() {
		try {
			// SchedulerMaster.click();
			Driver.getCurrentDriver().get(SchedulerMasterLink);
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			mapNavBar();
		}
	}

	protected static void goToHelp() {
		try {
			// Help.click();
			Driver.getCurrentDriver().get(HelpLink);
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			mapNavBar();
		}
	}

	protected static void goToSessions() {
		try {
			// Sessions.click();
			Driver.getCurrentDriver().get(SessionsLink);
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			mapNavBar();
		}
	}

	protected static void goToSchedulerLogs() {
		try {
			// SchedulerLogs.click();
			Driver.getCurrentDriver().get(SchedulerLogsLink);
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			mapNavBar();
		}
	}

	/**
	 * Strictly a debugging tool.
	 */
	protected static void printNavBar() {
		FileOutput.throwInDebug("MainAdminHome: " + MainAdminHome);
		FileOutput.throwInDebug("AdminShopLog: " + AdminShopLog);
		FileOutput.throwInDebug("ShopReview: " + ShopReview);
		FileOutput.throwInDebug("SchedulerMaster: " + SchedulerMaster);
		FileOutput.throwInDebug("Help: " + Help);
		FileOutput.throwInDebug("SchedulerLogs: " + SchedulerLogs);
		FileOutput.throwInDebug("Sessions: " + Sessions);
		FileOutput.throwInDebug("AdminNavBarMap: " + AdminNavBarMap);
	}
}
