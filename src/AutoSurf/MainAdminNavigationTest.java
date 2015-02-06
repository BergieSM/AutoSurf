package AutoSurf;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Class to test the navigation and interaction on the Main Admin page.
 * 
 * @author Bergie
 */
public class MainAdminNavigationTest {
	@Test
	private static void administratorsAddSurveyTest() {
		String option = "Bergie";
		String expectedTitle = "Survey Admin";
		Results.addTestResult(new TestResult("administratorsAddSurveyTest",
				false));

		try {
			MainAdminNavigation.administratorsAddSurvey(option);
			MainAdminNavigation.clickAdministratorsAddSurveyButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void administratorsCreateClientsTest() {
		String option = "Express Set Up";
		String expectedTitle = "Express Setup";
		Results.addTestResult(new TestResult("administratorsCreateClientsTest",
				false));

		try {
			MainAdminNavigation.administratorsCreateClient(option);
			MainAdminNavigation.clickAdministratorsCreateClientGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void administratorsCustomAdminFunctionsTest() {
		// String option = "Global Question Sets";
		WebDriver driver = Driver.getCurrentDriver();
		String expectedTitle = "Custom Admin Master - 2_qa";
		Results.addTestResult(new TestResult(
				"administratorsCustomAdminFunctionsTest", false));

		try {
			MainAdminNavigation.clickAdministratorsCustomAdminFunctionsButton();
			Debug.throwInDebugIfOn(driver.getTitle());
			if (driver.getTitle().equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void administratorsManageTest() {
		String option = "Manager Accounts";
		String expectedTitle = "My Manager Administration";
		Results.addTestResult(new TestResult("administratorsManageTest", false));

		try {
			MainAdminNavigation.administratorsManage(option);
			MainAdminNavigation.clickAdministratorsManageGoButton();
			System.out.println("administratorsManageTest Title: "
					+ Driver.getCurrentDriver().getTitle()
					+ ", versus expectedTitle: " + expectedTitle);
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void administratorsSurveyToolsTest() {
		String option = "Global Question Sets";
		String expectedTitle = "Global Question Sets";
		Results.addTestResult(new TestResult("administratorsSurveyToolsTest",
				false));

		try {
			MainAdminNavigation.administratorsSurveyTools(option);
			MainAdminNavigation.clickAdministratorsSurveyToolsGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void administratorsTrackerOptionsTest() {
		String option = "Classie";
		String expectedTitle = "SassieClassie";
		Results.addTestResult(new TestResult(
				"administratorsTrackerOptionsTest", false));
		WebDriver driver = Driver.getCurrentDriver();

		try {
			MainAdminNavigation.administratorsTrackerOptions(option);
			MainAdminNavigation.clickAdministratorsTrackerOptionsGoButton();
			ArrayList<String> windows = new ArrayList<String>(
					driver.getWindowHandles());
			driver.switchTo().window(windows.get(windows.size() - 1));

			if (driver.getTitle().equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
			driver.close();
			driver.switchTo().window(windows.get(windows.size() - 2));
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void clientsExportTest() {
		String option = "Locations";
		String expectedTitle = "Location Export";
		Results.addTestResult(new TestResult("clientsExportTest", false));

		try {
			MainAdminNavigation.clientsExport(option);
			MainAdminNavigation.clickClientsExportGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void clientsLoginAsClientTest() {
		String option = "Locations";
		String expectedTitle = "Client Location (1)s";
		Results.addTestResult(new TestResult("clientsLoginAsClientTest", false));

		try {
			MainAdminNavigation.clientsLoginAsClient(option);
			MainAdminNavigation.clickClientsLoginAsClientGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void clientsManageTest() {
		String option = "Locations";
		String expectedTitle = "Location Administration";
		Results.addTestResult(new TestResult("clientsManageTest", false));

		try {
			MainAdminNavigation.clientsManage(option);
			MainAdminNavigation.clickClientsManageGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	/**
	 * Use to call full test of all Navigation functions on MainAdmin Page
	 */
	public static void runlist() {
		WebDriver driver = Driver.getCurrentDriver();
		Parameters.setBoxSet(2);
		Parameters.setMSP("2_qa");
		Parameters.setClient("Bergie");
		Parameters.setSessionName("Automation Test");
		Parameters.setSurvey("Test1");

		Navigation.goToSuperGlobal();
		SuperGlobalAdmin.MSPAdminLinkSelect();

		try {
			Debug.throwInDebugIfOn("Selecting Survey"); // debugging
			MainAdminNavigation.selectSurvey();
			Debug.throwInDebugIfOn("Mapping Buttons"); // debugging
			MainAdminNavigation.mapButtons();
			Debug.throwInDebugIfOn("Un-mapping Buttons"); // debugging
			MainAdminNavigation.clearButtonMappings();
			// static WebElement clientsManageGoButton;
			Debug.throwInDebugIfOn("clientsManageTest"); // debugging
			clientsManageTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement clientsLoginAsClientGoButton;
			Debug.throwInDebugIfOn("clientsLoginAsClientTest"); // debugging
			clientsLoginAsClientTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement clientsExportGoButton;
			Debug.throwInDebugIfOn("clientsExportTest"); // debugging
			clientsExportTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement shopsShopToolsGoButton;
			Debug.throwInDebugIfOn("shopsShopToolsTest"); // debugging
			shopsShopToolsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement shopsReviewShopsGoButton;
			Debug.throwInDebugIfOn("shopsReviewShopsTest"); // debugging
			shopsReviewShopsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement shopsScheduleShopsGoButton;
			Debug.throwInDebugIfOn("shopsScheduleShopsTest"); // debugging
			shopsScheduleShopsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement shoppersShopperBillingButton;
			Debug.throwInDebugIfOn("shoppersShopperBillingTest"); // debugging
			shoppersShopperBillingTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement shoppersShopperSearchButton;
			Debug.throwInDebugIfOn("shoppersShopperSearchTest"); // debugging
			shoppersShopperSearchTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement shoppersShopperToolsGoButton;
			Debug.throwInDebugIfOn("shoppersShopperToolsTest"); // debugging
			shoppersShopperToolsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement administratorsTrackerOptionsGoButton;
			Debug.throwInDebugIfOn("administratorsTrackerOptionsTest"); // debugging
			administratorsTrackerOptionsTest();
			// static WebElement administratorsCreateClientGoButton;
			Debug.throwInDebugIfOn("administratorsCreateClientsTest"); // debugging
			administratorsCreateClientsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement administratorsAddSurveyButton;
			Debug.throwInDebugIfOn("administratorsAddSurveyTest"); // debugging
			administratorsAddSurveyTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement administratorsManageGoButton;
			Debug.throwInDebugIfOn("administratorsManageTest"); // debugging
			administratorsManageTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement administratorsSurveyToolsGoButton;
			Debug.throwInDebugIfOn("administratorsSurveyToolsTest");
			administratorsSurveyToolsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// static WebElement administratorsCustomAdminFunctionsButton;
			Debug.throwInDebugIfOn("administratorsCustomAdminFunctionsTest");
			administratorsCustomAdminFunctionsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void shoppersShopperBillingTest() {
		// String option = "Urgent Log";
		String expectedTitle = "BILLING";
		Results.addTestResult(new TestResult("shoppersShopperBillingTest",
				false));

		try {
			// MainAdmin.shopsScheduleShops(option);
			MainAdminNavigation.clickShoppersShopperBillingButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void shoppersShopperSearchTest() {
		String option = "test";
		String expectedTitle = "Shopper Administration";
		Results.addTestResult(new TestResult("shoppersShopperBillingTest",
				false));

		try {
			MainAdminNavigation.shopsShopperSearch(option, null);
			MainAdminNavigation.clickShoppersShopperSearchButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void shoppersShopperToolsTest() {
		String option = "Shopper Announcement";
		String expectedTitle = "Shopper Announcement Admin";
		Results.addTestResult(new TestResult("shoppersShopperToolsTest", false));

		try {
			MainAdminNavigation.shoppersShopperTools(option);
			MainAdminNavigation.clickShoppersShopperToolsGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void shopsReviewShopsTest() {
		String option = "Shop Status Changer";
		String expectedTitle = "Status Changer";
		Results.addTestResult(new TestResult("shopsReviewShopsTest", false));

		try {
			MainAdminNavigation.shopsReviewShops(option);
			MainAdminNavigation.clickShopsReviewShopsGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void shopsScheduleShopsTest() {
		String option = "Urgent Log";
		String expectedTitle = "Urgent Log";
		Results.addTestResult(new TestResult("shopsScheduleShopsTest", false));

		try {
			MainAdminNavigation.shopsScheduleShops(option);
			MainAdminNavigation.clickShopsScheduleShopsGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	private static void shopsShopToolsTest() {
		String option = "Status Viewer";
		String expectedTitle = "STATUS VIEWER";
		Results.addTestResult(new TestResult("shopsShopToolsTest", false));

		try {
			MainAdminNavigation.shopsShopTools(option);
			MainAdminNavigation.clickShopsShopToolsGoButton();
			if (Driver.getCurrentDriver().getTitle()
					.equalsIgnoreCase(expectedTitle))
				Results.replaceLastResult(true);
			else
				Results.replaceLastResult(false);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}
}
