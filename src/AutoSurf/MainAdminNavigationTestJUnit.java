package AutoSurf;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


/**
 * Class to test the navigation and interaction on the Main Admin page.<br>
 * JUnit Variant.<br>
 * Each test will click one option, verify the resulting page title, then return to the Main Admin page.
 * @author Bergie
 */
public class MainAdminNavigationTestJUnit {
	@Test
	public void administratorsAddSurveyTest() {
		String option = "Bergie";
		String expectedTitle = "Survey Admin";
		try {
			MainAdminNavigation.administratorsAddSurvey(option);
			MainAdminNavigation.clickAdministratorsAddSurveyButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}
	
	@Test
	public void administratorsCreateClientsTest() {
		String option = "Express Set Up";
		String expectedTitle = "Express Setup";
		try {
			MainAdminNavigation.administratorsCreateClient(option);
			MainAdminNavigation.clickAdministratorsCreateClientGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void administratorsCustomAdminFunctionsTest() {
		String expectedTitle = "Custom Admin Master - 2_qa";
		try {
			MainAdminNavigation.clickAdministratorsCustomAdminFunctionsButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void administratorsManageTest() {
		String option = "Manager Accounts";
		String expectedTitle = "My Manager Administration";
		try {
			MainAdminNavigation.administratorsManage(option);
			MainAdminNavigation.clickAdministratorsManageGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
			Debug.throwInDebugIfOn("administratorsManageTest Title: "
					+ Driver.getCurrentDriver().getTitle()
					+ ", versus expectedTitle: " + expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void administratorsSurveyToolsTest() {
		String option = "Global Question Sets";
		String expectedTitle = "Global Question Sets";
		try {
			MainAdminNavigation.administratorsSurveyTools(option);
			MainAdminNavigation.clickAdministratorsSurveyToolsGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void administratorsTrackerOptionsTest() {
		String option = "Classie";
		String expectedTitle = "SassieClassie";
		WebDriver driver = Driver.getCurrentDriver();
		try {
			MainAdminNavigation.administratorsTrackerOptions(option);
			MainAdminNavigation.clickAdministratorsTrackerOptionsGoButton();
			ArrayList<String> windows = new ArrayList<String>(
					driver.getWindowHandles());
			driver.switchTo().window(windows.get(windows.size() - 1));
			assertEquals(driver.getTitle(),expectedTitle);
			driver.close();
			driver.switchTo().window(windows.get(windows.size() - 2));
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void clientsExportTest() {
		MainAdminNavigation.selectSurvey();
		String option = "Locations";
		String expectedTitle = "Location Export";
		try {
			MainAdminNavigation.clientsExport(option);
			MainAdminNavigation.clickClientsExportGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void clientsLoginAsClientTest() {
		MainAdminNavigation.selectSurvey();
		String option = "Locations";
		String expectedTitle = "Client Location (1)s";
		try {
			MainAdminNavigation.clientsLoginAsClient(option);
			MainAdminNavigation.clickClientsLoginAsClientGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void clientsManageTest() {
		MainAdminNavigation.selectSurvey();
		String option = "Locations";
		String expectedTitle = "Location Administration";
		try {
			MainAdminNavigation.clientsManage(option);
			MainAdminNavigation.clickClientsManageGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	/**
	 * This function runs before any tests run in this class.<br>
	 * Initializes basic variables and navigates to the Main Admin Page.
	 */
	@BeforeClass
	public static void beforeAll(){
		TestCases.initializeParameters();
		Parameters.setBoxSet(2);
		Parameters.setMSP("2_qa");
		Parameters.setClient("Bergie");
		Parameters.setSessionName("Automation Test");
		Parameters.setSurvey("Test1");
		TestCases.promptForSQLPassword();
		/*if(args.length != 0){
			Parameters.setSqlPassword(args[0]);
			FileOutput.setStartTime(Instant.now());
		}
		else {TestCases.promptForSQLPassword();}*/

		//Driver.activateFirefox();
		Driver.activateChrome();
		Navigation.goToSuperGlobal();
		SuperGlobalAdmin.MSPAdminLinkSelect();
	}

	@AfterClass
	public static void afterALL(){
		Results.printResults();
		Driver.cleanUp();
	}
	
	/**
	 * Use to call full test of all Navigation functions on MainAdmin Page
	 */
	/*public void runlist() {
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
			// WebElement clientsManageGoButton;
			Debug.throwInDebugIfOn("clientsManageTest"); // debugging
			clientsManageTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement clientsLoginAsClientGoButton;
			Debug.throwInDebugIfOn("clientsLoginAsClientTest"); // debugging
			clientsLoginAsClientTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement clientsExportGoButton;
			Debug.throwInDebugIfOn("clientsExportTest"); // debugging
			clientsExportTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement shopsShopToolsGoButton;
			Debug.throwInDebugIfOn("shopsShopToolsTest"); // debugging
			shopsShopToolsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement shopsReviewShopsGoButton;
			Debug.throwInDebugIfOn("shopsReviewShopsTest"); // debugging
			shopsReviewShopsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement shopsScheduleShopsGoButton;
			Debug.throwInDebugIfOn("shopsScheduleShopsTest"); // debugging
			shopsScheduleShopsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement shoppersShopperBillingButton;
			Debug.throwInDebugIfOn("shoppersShopperBillingTest"); // debugging
			shoppersShopperBillingTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement shoppersShopperSearchButton;
			Debug.throwInDebugIfOn("shoppersShopperSearchTest"); // debugging
			shoppersShopperSearchTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement shoppersShopperToolsGoButton;
			Debug.throwInDebugIfOn("shoppersShopperToolsTest"); // debugging
			shoppersShopperToolsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement administratorsTrackerOptionsGoButton;
			Debug.throwInDebugIfOn("administratorsTrackerOptionsTest"); // debugging
			administratorsTrackerOptionsTest();
			// WebElement administratorsCreateClientGoButton;
			Debug.throwInDebugIfOn("administratorsCreateClientsTest"); // debugging
			administratorsCreateClientsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement administratorsAddSurveyButton;
			Debug.throwInDebugIfOn("administratorsAddSurveyTest"); // debugging
			administratorsAddSurveyTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement administratorsManageGoButton;
			Debug.throwInDebugIfOn("administratorsManageTest"); // debugging
			administratorsManageTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement administratorsSurveyToolsGoButton;
			Debug.throwInDebugIfOn("administratorsSurveyToolsTest");
			administratorsSurveyToolsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
			// WebElement administratorsCustomAdminFunctionsButton;
			Debug.throwInDebugIfOn("administratorsCustomAdminFunctionsTest");
			administratorsCustomAdminFunctionsTest();
			if (!driver.getTitle().endsWith("AdminMaster.php"))
				driver.navigate().back();
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}*/

	@Test
	public void shoppersShopperBillingTest() {
		String expectedTitle = "BILLING";
		try {
			MainAdminNavigation.clickShoppersShopperBillingButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void shoppersShopperSearchTest() {
		String option = "test";
		String expectedTitle = "Shopper Administration";
		try {
			MainAdminNavigation.shopsShopperSearch(option, null);
			MainAdminNavigation.clickShoppersShopperSearchButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void shoppersShopperToolsTest() {
		String option = "Shopper Announcement";
		String expectedTitle = "Shopper Announcement Admin";
		try {
			MainAdminNavigation.shoppersShopperTools(option);
			MainAdminNavigation.clickShoppersShopperToolsGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void shopsReviewShopsTest() {
		MainAdminNavigation.selectSurvey();
		String option = "Shop Status Changer";
		String expectedTitle = "Status Changer";
		try {
			MainAdminNavigation.shopsReviewShops(option);
			MainAdminNavigation.clickShopsReviewShopsGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void shopsScheduleShopsTest() {
		String option = "Urgent Log";
		String expectedTitle = "Urgent Log";
		try {
			MainAdminNavigation.shopsScheduleShops(option);
			MainAdminNavigation.clickShopsScheduleShopsGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	@Test
	public void shopsShopToolsTest() {
		String option = "Status Viewer";
		String expectedTitle = "STATUS VIEWER";
		try {
			MainAdminNavigation.shopsShopTools(option);
			MainAdminNavigation.clickShopsShopToolsGoButton();
			assertEquals(Driver.getCurrentDriver().getTitle(),expectedTitle);
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	/**
	 * This check is to make sure the next test begins on the Main Admin page.<br>
	 * Checks for the correct page, otherwise goes back once, and if that fails, navigates to the Main Admin again.
	 */
	@After
	public void afterEach(){
		if (!Driver.getCurrentDriver().getTitle().endsWith("AdminMaster.php")){
			Driver.getCurrentDriver().navigate().back();
			if(!Driver.getCurrentDriver().getTitle().endsWith("AdminMaster.php")){
				Navigation.goToSuperGlobal();
				SuperGlobalAdmin.MSPAdminLinkSelect();
			}
		}
	}
}
