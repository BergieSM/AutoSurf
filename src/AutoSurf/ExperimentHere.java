package AutoSurf;

import org.openqa.selenium.WebDriver;

/**
 * This class is strictly to help anyone new to WebDriver (or coding in general) acclimate quickly.<br>
 * Feel free to modify anything here, nothing else depends on this code!<br>
 * If you have a question, get stuck, break everything horrifically, whatever- you have options.<br><br>
 * Either pull fresh from the git repo to reset things,<br> 
 * check reference sites such as http://docs.seleniumhq.org/ or http://stackoverflow.com/questions/tagged/selenium-webdriver,<br>
 * or contact Bergie.
 * @author Bergie
 */
public class ExperimentHere extends TestCases {
	/**
	 * This function goes to the 2qa Main Admin page on Dev, and prints the title to the console and Results file.
	 */
	protected static void goTo2QAMainAdmin() {
		WebDriver driver = Driver.getCurrentDriver();
		Parameters.setBoxSet(2);	//Sets the main Parameter's boxSet to 2, Dev. 
		Navigation.goToSuperGlobal(); // Goes to the superglobaladmin site based on the Parameter's BoxSet setting, set just above.
		Parameters.setMSP("2_qa"); // Set the MSP to navigate to.
		SuperGlobalAdmin.MSPAdminLinkSelect(); // Select the Admin Link on the SuperGlobalAdmin page for the selected MSP.
		System.out.println("Expecting to see something about 2qa: "	+ driver.getTitle()); // This will output to the console the first line in double quotes, appended with the title of the webpage, provided by the driver.
		FileOutput.throwInResults("Expecting to see something about 2qa: " + driver.getTitle()); // Sending the same to the Results file.
	}

	/**
	 * The main function, this is called by the TestCases class.
	 */
	public static void main() {
		// Write whatever you like into this space to have it run.
		Driver.switchToFirefox(); //This launches a Firefox window under WebDriver control.
		WebDriver driver = Driver.getCurrentDriver();	//This loads the current WenDriver (firefox window) as 'driver' for easier control.
		driver.get("https://www.google.com/"); //Load the google home page.
		FileOutput.throwInResults(driver.getTitle()); // Have the driver get the title of the google homepage, and send that to the Results file.
		System.out.println(driver.getTitle()); //Output the page title to the console. (shows up in Eclipse, useful for easy debugging)

		// goTo2QAMainAdmin(); //Remove the '//' from the front of a line of code to make it active again.
	}
}
