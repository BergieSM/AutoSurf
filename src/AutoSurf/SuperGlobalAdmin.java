package AutoSurf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Collection of Super Global Admin page navigation functions.<br>
 * More options in the future, such as custom domain vs. sassie domain, as priorities shift.
 * @author Bergie
 *
 */
public class SuperGlobalAdmin extends Navigation {
	/**
	 * Used to select an MSP's Admin page from the SuperGlobalAdmin page
	 */
	protected static void MSPAdminLinkSelect() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			WebDriverWait wait = Driver.getCurrentWait();
			// if (Debug.getDebugState() ==
			// true)FileOutput.throwInDebug("Current URL: " +
			// driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("SuperGlobalAdmin.php/")) {
				throw new IllegalStateException(
						"Class MSPAdminLinkSelect called from a page other than a Super Global Admin: "
								+ driver.getCurrentUrl());
			}
			String MSP = Parameters.getMSP();
			if (MSP != null) {
				// Determine the boxSet
				int boxSet = Parameters.getBoxSet().getBoxSetAsInt();
				List<WebElement> MSPList = driver
						.findElements(By.tagName("tr"));
				for (WebElement MSPListing : MSPList) {
					if (MSPListing != MSPList.get(0)) {
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListing.getText()); //
						// debugging
						List<WebElement> MSPListingColumns = MSPListing
								.findElements(By.tagName("td"));
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListingColumns.get(1).getText()
						// + ", " + MSP); // debugging
						int columnNumber = 1;
						if (boxSet == 1) {
							columnNumber = 2;
						}
						if (MSPListingColumns.get(columnNumber).getText()
								.equalsIgnoreCase(MSP)) {
							Debug.throwInDebugIfOn("Found MSP!"); // debugging
							MSPListingColumns.get(columnNumber + 4)
									.findElement(By.tagName("a")).click();
							break;
						} else if (MSPListing == MSPList
								.get(MSPList.size() - 1)) {
							// Failed to locate MSP
							System.out
									.println("Failed to locate MSP, defaulting to 2_qa");
							WebElement twoQAAdminLink = driver
									.findElement(By
											.cssSelector("a[href*='expressadminlogin.php?dirname=2_qa']"));
							twoQAAdminLink.click();
						}
					}
				}
			} else {
				System.out.println("No MSP defined, defaulting to 2_qa");
				WebElement adminLink = driver
						.findElement(By
								.cssSelector("a[href*='expressadminlogin.php?dirname=2_qa']"));// Go
																								// to
																								// Admin
																								// link
																								// of
																								// 2_qa
																								// if
																								// none
																								// defined?
				adminLink.click();
			}
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.name("surveyTools")));
			wait.until(ExpectedConditions.elementToBeClickable(driver
					.findElement(By.name("surveyTools"))));
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by MSPAdminLinkSelect: "
					+ e.getLocalizedMessage());
			return;
		}
	}

	/**
	 * Used to select an MSP's DB page from the SuperGlobalAdmin page
	 */
	protected static void MSPDBLinkSelect() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();
			// if (Debug.getDebugState() ==
			// true)FileOutput.throwInDebug("Current URL: " +
			// driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("SuperGlobalAdmin.php/")) {
				throw new IllegalStateException(
						"Class MSPDBLinkSelect called from a page other than a Super Global Admin: "
								+ driver.getCurrentUrl());
			}
			String MSP = Parameters.getMSP();
			if (MSP != null) {
				// Determine the boxSet
				int boxSet = Parameters.getBoxSet().getBoxSetAsInt();
				List<WebElement> MSPList = driver
						.findElements(By.tagName("tr"));
				for (WebElement MSPListing : MSPList) {
					if (MSPListing != MSPList.get(0)) {
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListing.getText()); //
						// debugging
						List<WebElement> MSPListingColumns = MSPListing
								.findElements(By.tagName("td"));
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListingColumns.get(1).getText()
						// + ", " + MSP); // debugging
						int columnNumber = 1;
						if (boxSet == 1) {
							columnNumber = 2;
						}
						if (MSPListingColumns.get(columnNumber).getText()
								.equalsIgnoreCase(MSP)) {
							Debug.throwInDebugIfOn("Found MSP!"); // debugging
							MSPListingColumns.get(columnNumber + 3)
									.findElement(By.tagName("a")).click();
							break;
						} else if (MSPListing == MSPList
								.get(MSPList.size() - 1)) {
							// Failed to locate MSP
							System.out
									.println("Failed to locate MSP, defaulting to 2_qa");
							WebElement twoQADBLink = driver
									.findElement(By
											.cssSelector("a[href*='phpMyAdmin/index.php?db=2qa']"));
							twoQADBLink.click();
						}
					}
				}
			} else {
				System.out.println("No MSP defined, defaulting to 2_qa");
				WebElement dbLink = driver.findElement(By
						.cssSelector("a[href*='phpMyAdmin/index.php?db=2qa']"));// Go
																				// to
																				// DB
																				// link
																				// of
																				// 2_qa
																				// if
																				// none
																				// defined?
				dbLink.click();
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by MSPDBLinkSelect: "
					+ e.getLocalizedMessage());
			return;
		}
	}

	/**
	 * Used to select an MSP's Global page from the SuperGlobalAdmin page
	 */
	protected static void MSPGlobalLinkSelect() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// if (Debug.getDebugState() ==
			// true)FileOutput.throwInDebug("Current URL: " +
			// driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("SuperGlobalAdmin.php/")) {
				throw new IllegalStateException(
						"Class MSPGlobalLinkSelect called from a page other than a Super Global Admin: "
								+ driver.getCurrentUrl());
			}
			String MSP = Parameters.getMSP();
			if (MSP != null) {
				// Determine the boxSet
				int boxSet = Parameters.getBoxSet().getBoxSetAsInt();
				List<WebElement> MSPList = driver
						.findElements(By.tagName("tr"));
				for (WebElement MSPListing : MSPList) {
					if (MSPListing != MSPList.get(0)) {
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListing.getText()); //
						// debugging
						List<WebElement> MSPListingColumns = MSPListing
								.findElements(By.tagName("td"));
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListingColumns.get(1).getText()
						// + ", " + MSP); // debugging
						int columnNumber = 1;
						if (boxSet == 1) {
							columnNumber = 2;
						}
						if (MSPListingColumns.get(columnNumber).getText()
								.equalsIgnoreCase(MSP)) {
							Debug.throwInDebugIfOn("Found MSP!"); // debugging
							MSPListingColumns.get(columnNumber + 2)
									.findElement(By.tagName("a")).click();
							break;
						} else if (MSPListing == MSPList
								.get(MSPList.size() - 1)) {
							// Failed to locate MSP
							System.out
									.println("Failed to locate MSP, defaulting to 2_qa");
							WebElement twoQAGlobalLink = driver
									.findElement(By
											.cssSelector("a[href*='2_qa/admin/superadmin/GlobalAdmin']"));
							twoQAGlobalLink.click();
						}
					}
				}
			} else {
				System.out.println("No MSP defined, defaulting to 2_qa");
				WebElement globalLink = driver
						.findElement(By
								.cssSelector("a[href*='2_qa/admin/superadmin/GlobalAdmin']"));// Go
																								// to
																								// Global
																								// link
																								// of
																								// 2_qa
																								// if
																								// none
																								// defined?
				globalLink.click();
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by MSPGlobalLinkSelect: "
					+ e.getLocalizedMessage());
			return;
		}
	}

	/**
	 * Used to select an MSP's Home page from the SuperGlobalAdmin page
	 */
	protected static void MSPHomeLinkSelect() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// if (Debug.getDebugState() ==
			// true)FileOutput.throwInDebug("Current URL: " +
			// driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("SuperGlobalAdmin.php/")) {
				throw new IllegalStateException(
						"Class MSPHomeLinkSelect called from a page other than a Super Global Admin: "
								+ driver.getCurrentUrl());
			}
			String MSP = Parameters.getMSP();
			if (MSP != null) {
				// Determine the boxSet
				int boxSet = Parameters.getBoxSet().getBoxSetAsInt();
				List<WebElement> MSPList = driver
						.findElements(By.tagName("tr"));
				for (WebElement MSPListing : MSPList) {
					if (MSPListing != MSPList.get(0)) {
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListing.getText()); //
						// debugging
						List<WebElement> MSPListingColumns = MSPListing
								.findElements(By.tagName("td"));
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListingColumns.get(1).getText()
						// + ", " + MSP); // debugging
						int columnNumber = 1;
						if (boxSet == 1) {
							columnNumber = 2;
						}
						if (MSPListingColumns.get(columnNumber).getText()
								.equalsIgnoreCase(MSP)) {
							Debug.throwInDebugIfOn("Found MSP!"); // debugging
							MSPListingColumns.get(columnNumber + 5)
									.findElement(By.tagName("a")).click();
							break;
						} else if (MSPListing == MSPList
								.get(MSPList.size() - 1)) {
							// Failed to locate MSP
							System.out
									.println("Failed to locate MSP, defaulting to 2_qa");
							WebElement twoQAHomeLink = driver
									.findElement(By
											.cssSelector("a[href*='sassiedev.com/2_qa/']"));
							twoQAHomeLink.click();
						}
					}
				}
			} else {
				System.out.println("No MSP defined, defaulting to 2_qa");
				WebElement homeLink = driver.findElement(By
						.cssSelector("a[href*='sassiedev.com/2_qa/']"));// Go to
																		// Home
																		// link
																		// of
																		// 2_qa
																		// if
																		// none
																		// defined?
				homeLink.click();
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by MSPHomeLinkSelect: "
					+ e.getLocalizedMessage());
			return;
		}
	}

	/**
	 * Used to select an MSP's MSAdmin page from the SuperGlobalAdmin page
	 */
	protected static void MSPMSAdminLinkSelect() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// if (Debug.getDebugState() ==
			// true)FileOutput.throwInDebug("Current URL: " +
			// driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("SuperGlobalAdmin.php/")) {
				throw new IllegalStateException(
						"Class MSPMSAdminLinkSelect called from a page other than a Super Global Admin: "
								+ driver.getCurrentUrl());
			}
			String MSP = Parameters.getMSP();
			if (MSP != null) {
				// Determine the boxSet
				int boxSet = Parameters.getBoxSet().getBoxSetAsInt();
				List<WebElement> MSPList = driver
						.findElements(By.tagName("tr"));
				for (WebElement MSPListing : MSPList) {
					if (MSPListing != MSPList.get(0)) {
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListing.getText()); //
						// debugging
						List<WebElement> MSPListingColumns = MSPListing
								.findElements(By.tagName("td"));
						// if (Debug.getDebugState() ==
						// true)System.out.println(MSPListingColumns.get(1).getText()
						// + ", " + MSP); // debugging
						int columnNumber = 1;
						if (boxSet == 1) {
							columnNumber = 2;
						}
						if (MSPListingColumns.get(columnNumber).getText()
								.equalsIgnoreCase(MSP)) {
							Debug.throwInDebugIfOn("Found MSP!"); // debugging
							MSPListingColumns.get(columnNumber + 1)
									.findElement(By.tagName("a")).click();
							break;
						} else if (MSPListing == MSPList
								.get(MSPList.size() - 1)) {
							// Failed to locate MSP
							System.out
									.println("Failed to locate MSP, defaulting to 2_qa");
							WebElement twoQAMSAdminLink = driver
									.findElement(By
											.cssSelector("a[href*='admin/MSAdmin.php?mode=view&msID=122']"));
							twoQAMSAdminLink.click();
						}
					}
				}
			} else {
				System.out.println("No MSP defined, defaulting to 2_qa");
				WebElement msAdminLink = driver
						.findElement(By
								.cssSelector("a[href*='admin/MSAdmin.php?mode=view&msID=122']"));// Go
																									// to
																									// MSAdmin
																									// link
																									// of
																									// 2_qa
																									// if
																									// none
																									// defined?
				msAdminLink.click();
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by MSPMSAdminLinkSelect: "
					+ e.getLocalizedMessage());
			return;
		}
	}
}
