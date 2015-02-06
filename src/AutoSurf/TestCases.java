package AutoSurf;

import java.time.Instant;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.junit.*;

public class TestCases {
	/**
	 * Main method that initializes variables, prompts the user for the SQL password or takes it from passed args, then passes to TestCases.runList().
	 * After they run, prints results and cleans up.
	 * @param args Expects only the sql password being passed in at this point.
	 */
	public static void main(String[] args) {
		try {
			initializeParameters();
			if(args.length != 0){
				Parameters.setSqlPassword(args[0]);
				FileOutput.setStartTime(Instant.now());
			}
			else {promptForSQLPassword();}
			runList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FileOutput.throwInDebug(e.getMessage());
		} finally {
			Results.printResults();
			Driver.cleanUp();
			RemoteDriver.remoteCleanUp();
		}
	}

	/**
	 * Call this to run AutoSchedulerTest main
	 */
	protected static void autoSchedulerTest() {
		try {
			// Master.setHandle(Master.getDriver().getWindowHandle());
			// System.out.println("Starting autoSchedulerTest main.  1 Test.");
			AutoSchedulerTest.main();
		} catch (Exception e) {
			Navigation.recovery(e);
			return;
		}
		return;
	}

	/**
	 * Runs through every currently available page of 2bareusa to check for
	 * correct SSL implementation
	 */
	protected static void BARESSLTest() {
		try {
			// System.out.println("Starting BARESSL main.");
			BARESSL.main();
		} catch (Exception e) {
			Navigation.recovery(e);
			return;
		}
		return;
	}

	/**
	 * This call the main method in ExperimentHere
	 */
	protected static void ExperimentHereRun() {
		try {
			Results.addTestResult(new TestResult("ExperimentHere", false));
			ExperimentHere.main();
			Results.replaceLastResult(true);
		} catch (Exception e) {
			Results.replaceLastResult(false);
			Navigation.recovery(e);
		}
	}

	/**
	 * Runs autoSchedulerTest on the five boxSets to check that access to each
	 * is functional.
	 */
	protected static void fiveBoxCheck() {
		Parameters.setMSP("2_qa");
		Parameters.setClient("Bergie");
		Parameters.setSessionName("Automation Test");
		// System.out.println("Starting fiveBoxCheck.  5 autoSchedulerTest Tests.");

		try {
			for (int i = 1; i < 6; i++) {
				switch (i) {
				case 1:
					Parameters.setBoxSet(i);
					autoSchedulerTest();
					break;
				case 2:
					Parameters.setBoxSet(i);
					autoSchedulerTest();
					break;
				case 3:
					Parameters.setBoxSet(i);
					autoSchedulerTest();
					break;
				case 4:
					Parameters.setBoxSet(i);
					autoSchedulerTest();
					break;
				case 5:
					Parameters.setBoxSet(i);
					autoSchedulerTest();
					break;
				}
			}
			return;
		} catch (Exception e) {
			Navigation.recovery(e);
			return;
		}
	}

	/**
	 * Tests the button mapping on the Main Admin page
	 */
	protected static void mainAdminNavigationCheck() {
		try {
			// Master.setHandle(Master.getDriver().getWindowHandle());
			// System.out.println("Starting MainAdminTest main.  15 Tests");
			MainAdminNavigationTest.runlist();
		} catch (Exception e) {
			Navigation.recovery(e);
			return;
		}
		return;
	}

	/**
	 * Tests the mapping of the Admin NavBar.
	 */
	protected static void adminNavBarCheck() {
		try {
			NavBarNavigationTest.runList();
		} catch (Exception e) {
			Navigation.recovery(e);
		}
	}

	/**
	 * Edit this to change what tests will run when you run Master.Main.
	 */
	public static void runList() {
		Debug.setDebugOff();
		// Master.setDebugOn(); //I do not recommend using this yet, still being
		// fully implemented.

		Driver.activateFirefox();
		 fiveBoxCheck();
		 superGlobalAdminExceptionsCheck();
		 mainAdminNavigationCheck();
		// BARESSLTest();
		// ExperimentHereRun();
		// adminNavBarCheck();
		// Driver.activateChrome();
		// fiveBoxCheck();
		// superGlobalAdminExceptionsCheck();
		// mainAdminNavigationCheck();
		// Driver.activateHTMLUnit();
		// fiveBoxCheck();
		// superGlobalAdminExceptionsCheck();
		// mainAdminNavigationCheck();
		// Driver.activateAndroid();
		// fiveBoxCheck();
		// superGlobalAdminExceptionsCheck();
		// mainAdminNavigationCheck();
		// Driver.activateIE32();
		// superGlobalAdminExceptionsCheck();
		// mainAdminNavigationCheck();
		// Driver.activateIE64();
		// superGlobalAdminExceptionsCheck();
		// mainAdminNavigationCheck();
		// jsonExperimentCheck();
		// Server.launchHub();
		// Server.launchNode();

		/*
		 * Debug.throwInDebug(System.getProperties().toString()); //debugging,
		 * looking for any property that would auto-launch a hub or node, like
		 * the webdriver.chrome.driver property for the chromeDriver.
		 * RemoteDriver.activateRemoteAndroidDriver(); fiveBoxCheck();
		 * superGlobalAdminExceptionsCheck(); RemoteDriver.remoteCleanUp();
		 * Server.cleanUp();
		 */
	}

	/**
	 * Run the superglobaladmin navigation methods versus google.com to check
	 * exception handling
	 */
	protected static void superGlobalAdminExceptionsCheck() {
		WebDriver driver = Driver.getCurrentDriver();
		Parameters.setMSP("2_qa");
		Parameters.setClient("Bergie");
		Parameters.setSessionName("Automation Test");
		// System.out.println("Starting superGlobalAdminExceptionsTest. 5 SuperGlobalAdmin Tests.");

		try {
			Results.addTestResult(new TestResult(
					"Testing MSPMSAdminLinkSelect throwing exception", false));
			driver.get("https://www.google.com");
			SuperGlobalAdmin.MSPMSAdminLinkSelect();
			Results.replaceLastResult(true);
		} catch (Exception e) {
			Navigation.recovery(e);
			Results.replaceLastResult(false);
		}

		try {
			Results.addTestResult(new TestResult(
					"Testing MSPGlobalLinkSelect throwing exception", false));
			driver.get("https://www.google.com");
			SuperGlobalAdmin.MSPGlobalLinkSelect();
			Results.replaceLastResult(true);
		} catch (Exception e) {
			Navigation.recovery(e);
			Results.replaceLastResult(false);
		}

		try {
			Results.addTestResult(new TestResult(
					"Testing MSPDBLinkSelect throwing exception", false));
			driver.get("https://www.google.com");
			SuperGlobalAdmin.MSPDBLinkSelect();
			Results.replaceLastResult(true);
		} catch (Exception e) {
			Navigation.recovery(e);
			Results.replaceLastResult(false);
		}

		try {
			Results.addTestResult(new TestResult(
					"Testing MSPAdminLinkSelect throwing exception", false));
			driver.get("https://www.google.com");
			SuperGlobalAdmin.MSPAdminLinkSelect();
			Results.replaceLastResult(true);
		} catch (Exception e) {
			Navigation.recovery(e);
			Results.replaceLastResult(false);
		}

		try {
			Results.addTestResult(new TestResult(
					"Testing MSPHomeLinkSelect throwing exception", false));
			driver.get("https://www.google.com");
			SuperGlobalAdmin.MSPHomeLinkSelect();
			Results.replaceLastResult(true);
		} catch (Exception e) {
			Navigation.recovery(e);
			Results.replaceLastResult(false);
		}
		return;
	}

	@BeforeClass
	public static void setUpTestCases() {
		initializeParameters();
		promptForSQLPassword();
	}

	/**
	 * Basic initialization of defaults, run before TestCases.runList()
	 */
	protected static void initializeParameters() {
		Results r = new Results();
		Results.setResults(r);
		Parameters p = new Parameters();
		Parameters.setParameters(p);
		Debug.setDebugOff();
	}

	/**
	 * Prompts the user to enter the sql password, to prevent the need to
	 * hardcode it.</br> Sets the sql password in Parameters.
	 */
	protected static void promptForSQLPassword() {
		String pass = JOptionPane.showInputDialog(JOptionPane.getRootFrame(),
				"Enter the sql password", null, JOptionPane.PLAIN_MESSAGE);
		Parameters.setSqlPassword(pass);
		FileOutput.setStartTime(Instant.now()); // Putting this here, it belongs
												// in initializeParameters, but
												// this way it is called After
												// the human factor is
												// eliminated. Should make it a
												// more useful metric.
	}

	@AfterClass
	public static void afterTestCases() {
		Results.printResults();
		Driver.cleanUp();
		RemoteDriver.remoteCleanUp();
	}
}
