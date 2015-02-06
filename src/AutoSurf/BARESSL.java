package AutoSurf;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a test bed for a run that iterates through every page of an MSP, checking for any SSL breaks in coverage.<br>
 * TODO: Continue work when priorities shift.
 * @author Bergie
 *
 */
public class BARESSL extends TestCases {
	static List<String> potentialProblems = new ArrayList<String>();

	/**
	 * Called on each page, checks for the SSL / untrusted connection page,
	 * reports it if it's broken.
	 */
	protected static void checkSSL() {
		// Check for not trusted connection
		// report URL into potentialProblems
		// TODO Expand this to cover the other, odd issues. The yellow triangle,
		// the untrusted script, etc.

		if (Driver.getCurrentDriver().getTitle().equals("Untrusted Connection")) {
			potentialProblems.add(Driver.getCurrentDriver().getCurrentUrl());
		}
		;
	}

	/**
	 * Use this class to build a Firefox test of BARE SSL cert issues.</br> Idea
	 * here is to go through the whole of accessible BARE pages, see if ANY
	 * return an insecure connection issue.</br> Report any links where there is
	 * an issue.
	 */
	public static void main() {
		// WebDriver driver = Master.getDriver();

		Parameters.setBoxSet(2); // Dev = 2, UAT = 4
		Parameters.setMSP("2bareusa");
		// TODO Make the above the debug default, but without the debug set
		// allow it to go to any MSP/boxSet and check for SSL issues.

		// Navigation.goToSuperGlobal();
		// SuperGlobalAdmin.MSPAdminLinkSelect();

		/*
		 * WebElement selectSurveyDropdown = driver.findElement(By
		 * .name("selectSurvey")); Select surveySelect = new
		 * Select(selectSurveyDropdown); List<WebElement> surveyList = new
		 * ArrayList<WebElement>(); surveyList = surveySelect.getOptions();
		 * 
		 * for(int i = 0;i<surveyList.size();i++){
		 * 
		 * }
		 */

		// Gain control of every page from the Main Admin, reports, etc. Full
		// control.
		// Call checkSSL for each page.
		// Output list of potentially problematic pages

	}

	/**
	 * Output the list of Potential Problem URLs to a file.
	 */
	protected static void outputPotentialProblems() {
		FileOutput.printTextFile(potentialProblems, "BARESSL Results");
	}

}
