/**
 * 
 */
package AutoSurf;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Tests the NavBarNavigation tools.
 * @author Bergie
 * 
 */
public class NavBarNavigationTest {
	@Test
	private static void adminShopLogTest() {
		String expectedTitle = "Admin Shop Log";
		Boolean success = false;
		String title = "";
		try {
			NavBarNavigation.goToAdminShopLog();
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			title = Driver.getCurrentDriver().getTitle();
			Debug.throwInDebugIfOn("adminShopLogTest Title:"
					+ Driver.getCurrentDriver().getTitle());
			// Driver.getWait().until(ExpectedConditions.presenceOfElementLocated(By.name("adminnavbarb8bed8de")));
			if (title.equalsIgnoreCase(expectedTitle)) {
				success = true;
			}
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Results.addTestResult(new TestResult("adminShopLogTest", success));
		}
	}

	@Test
	private static void mainAdminHomeTest(String eT) {
		String expectedTitle = eT;
		Boolean success = false;
		String title = "";
		try {
			NavBarNavigation.goToMainAdminHome();
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			title = Driver.getCurrentDriver().getTitle();
			Debug.throwInDebugIfOn("mainAdminHomeTest Title:"
					+ Driver.getCurrentDriver().getTitle());
			if (title.equalsIgnoreCase(expectedTitle)) {
				success = true;
			}
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Results.addTestResult(new TestResult("mainAdminHomeTest", success));
		}
	}

	@Test
	private static void shopReviewTest(String eT) {

		String expectedTitle = eT;
		Boolean success = false;
		String title = "";
		try {
			NavBarNavigation.goToShopReview();
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			title = Driver.getCurrentDriver().getTitle();
			Debug.throwInDebugIfOn("shopReviewTest Title:"
					+ Driver.getCurrentDriver().getTitle());
			if (title.equalsIgnoreCase(expectedTitle)) {
				success = true;
			}
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Results.addTestResult(new TestResult("shopReviewTest", success));
		}
	}

	@Test
	private static void schedulerMasterTest() {
		String expectedTitle = "Scheduler Main Page";
		Boolean success = false;
		String title = "";
		try {
			NavBarNavigation.goToSchedulerMaster();
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			title = Driver.getCurrentDriver().getTitle();
			Debug.throwInDebugIfOn("schedulerMasterTest Title:"
					+ Driver.getCurrentDriver().getTitle());
			if (title.equalsIgnoreCase(expectedTitle)) {
				success = true;
			}
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Results.addTestResult(new TestResult("schedulerMasterTest", success));
		}
	}

	@Test
	private static void helpTest() {
		String expectedTitle = "HELP:";
		Boolean success = false;
		String title = "";
		try {
			NavBarNavigation.goToHelp();
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			title = Driver.getCurrentDriver().getTitle();
			ArrayList<String> windows = new ArrayList<String>(Driver
					.getCurrentDriver().getWindowHandles());
			Driver.getCurrentDriver().switchTo()
					.window(windows.get(windows.size() - 1));
			Debug.throwInDebugIfOn("helpTest Title:"
					+ Driver.getCurrentDriver().getTitle());
			if (title.equalsIgnoreCase(expectedTitle)) {
				success = true;
			}
			Driver.getCurrentDriver().close();
			Driver.getCurrentDriver().switchTo()
					.window(windows.get(windows.size() - 2));
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Results.addTestResult(new TestResult("helpTest", success));
		}
	}

	@Test
	private static void sessionsTest(String eT) {

		String expectedTitle = eT;
		Boolean success = false;
		String title = "";
		try {
			NavBarNavigation.goToSessions();
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			title = Driver.getCurrentDriver().getTitle();
			Debug.throwInDebugIfOn("sessionsTest Title:"
					+ Driver.getCurrentDriver().getTitle());
			if (title.equalsIgnoreCase(expectedTitle)) {
				success = true;
			}
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Results.addTestResult(new TestResult("sessionsTest", success));
		}
	}

	@Test
	private static void schedulerLogTest() {

		String expectedTitle = "Scheduler Log";
		Boolean success = false;
		String title = "";
		try {
			NavBarNavigation.goToSchedulerLogs();
			Driver.getCurrentWait().until(
					ExpectedConditions.presenceOfElementLocated(By
							.name("adminnavbarb8bed8de")));
			title = Driver.getCurrentDriver().getTitle();
			Debug.throwInDebugIfOn("schedulerLogTest Title:"
					+ Driver.getCurrentDriver().getTitle());
			if (title.equalsIgnoreCase(expectedTitle)) {
				success = true;
			}
		} catch (Exception e) {
			Navigation.recovery(e);
		} finally {
			Results.addTestResult(new TestResult("schedulerLogTest", success));
		}
	}

	protected static void runList() {
		// Testing on 2_qa
		Debug.throwInDebugIfOn("Testing on 2bareusa"); // debugging
		Parameters.setBoxSet(2);
		Parameters.setMSP("2bareusa");
		Navigation.goToSuperGlobal();
		SuperGlobalAdmin.MSPAdminLinkSelect();
		try {
			NavBarNavigation.mapNavBar();
			adminShopLogTest();
			mainAdminHomeTest("Admin MASTER - BARE");
			shopReviewTest("APOLLO Shop Review !");
			helpTest();
			schedulerMasterTest();
			sessionsTest("Shopper Administration");
			schedulerLogTest();
			NavBarNavigation.clearNavBarMap();
		} catch (Exception e) {
			Navigation.recovery(e);
		}

		// Testing on 2bareusa
		Debug.throwInDebugIfOn("Testing on 2_qa"); // debugging
		Parameters.setBoxSet(2);
		Parameters.setMSP("2_qa");
		Navigation.goToSuperGlobal();
		SuperGlobalAdmin.MSPAdminLinkSelect();
		try {
			adminShopLogTest();
			mainAdminHomeTest("Admin MASTER - 2_qa");
			shopReviewTest("QA_rebranded Shop Review !");
			helpTest();
			schedulerMasterTest();
			sessionsTest("AutoScheduler : View Sessions");
			schedulerLogTest();
			NavBarNavigation.clearNavBarMap();
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}
}
