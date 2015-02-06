package AutoSurf;

import java.util.List;

//import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Functions to interact with the Admin page of an MSP
 * @author Bergie
 */
public class MainAdminNavigation extends Navigation {
	private static WebElement clientsManageGoButton;
	private static WebElement clientsLoginAsClientGoButton;
	private static WebElement clientsExportGoButton;
	private static WebElement shopsShopToolsGoButton;
	private static WebElement shopsReviewShopsGoButton;
	private static WebElement shopsScheduleShopsGoButton;
	private static WebElement shoppersShopperBillingButton;
	private static WebElement shoppersShopperSearchButton;
	private static WebElement shoppersShopperToolsGoButton;
	private static WebElement administratorsTrackerOptionsGoButton;
	private static WebElement administratorsCreateClientGoButton;
	private static WebElement administratorsAddSurveyButton;
	private static WebElement administratorsManageGoButton;
	private static WebElement administratorsSurveyToolsGoButton;
	private static WebElement administratorsCustomAdminFunctionsButton;

	/**
	 * Chooses an option from the main Admin page Administrators > Add Survey
	 * dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from administrators add survey dropdown
	 *            options
	 */
	public static void administratorsAddSurvey(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class administratorsAddSurvey called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement administratorsAddSurveyDropdown = driver
						.findElement(By.name("changeClientID"));
				Select administratorsAddSurveySelect = new Select(
						administratorsAddSurveyDropdown);
				try {
					administratorsAddSurveySelect
							.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("administratorsAddSurvey HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class administratorsAddSurvey missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by administratorsAddSurvey: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Administrators > Create Client
	 * dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from administrators survey toolscreate
	 *            client dropdown options
	 */
	public static void administratorsCreateClient(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class administratorsCreateClient called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement administratorsCreateClientDropdown = driver
						.findElement(By.name("createClient"));
				Select administratorsCreateClientSelect = new Select(
						administratorsCreateClientDropdown);
				try {
					administratorsCreateClientSelect
							.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("administratorsCreatClient HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class administratorsCreateClient missing selection");
			}
			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by administratorsCreateClient: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Administrators > Manage
	 * dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from administrators manage dropdown
	 *            options
	 */
	public static void administratorsManage(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class administratorsManage called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement administratorsManageDropdown = driver.findElement(By
						.name("adminManageOptions"));
				Select administratorsManageSelect = new Select(
						administratorsManageDropdown);
				try {
					administratorsManageSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("administratorsManage HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class administratorsManage missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by administratorsManage: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Administrators > Survey Tools
	 * dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from administrators survey tools
	 *            dropdown options
	 */
	public static void administratorsSurveyTools(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class administratorsSurveyTools called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement administratorsSurveyToolsDropdown = driver
						.findElement(By.name("surveyTools"));
				Select administratorsSurveyToolsSelect = new Select(
						administratorsSurveyToolsDropdown);
				try {
					administratorsSurveyToolsSelect
							.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("administratorsSurveyTools HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class administratorsSurveyTools missing selection");
			}
			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by administratorsSurveyTools: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Administrators > Tracker
	 * Options dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from administrators tracker options
	 *            dropdown options
	 */
	public static void administratorsTrackerOptions(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class administratorsTrackerOptions called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement administratorsTrackerOptionsDropdown = driver
						.findElement(By.name("trackerOptions"));
				Select administratorsTrackerOptionsSelect = new Select(
						administratorsTrackerOptionsDropdown);
				try {
					administratorsTrackerOptionsSelect
							.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("administratorsTrackerOptions HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class administratorsTrackerOptions missing selection");
			}
			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by administratorsTrackerOptions: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Sets all the WebElements for the go buttons to null
	 */
	public static void clearButtonMappings() {
		clientsManageGoButton = null;
		clientsLoginAsClientGoButton = null;
		clientsExportGoButton = null;
		shopsShopToolsGoButton = null;
		shopsReviewShopsGoButton = null;
		shopsScheduleShopsGoButton = null;
		shoppersShopperBillingButton = null;
		shoppersShopperSearchButton = null;
		shoppersShopperToolsGoButton = null;
		administratorsTrackerOptionsGoButton = null;
		administratorsCreateClientGoButton = null;
		administratorsAddSurveyButton = null;
		administratorsManageGoButton = null;
		administratorsSurveyToolsGoButton = null;
		administratorsCustomAdminFunctionsButton = null;
	}

	/**
	 * Attempts to click the Administrators > Add Survey go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickAdministratorsAddSurveyButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsAddSurveyButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				administratorsAddSurveyButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Administrators > Add Survey go button, retrying with fresh go button mapping");
				clickAdministratorsAddSurveyButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsAddSurveyButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Administrators > Add Survey
	 * go button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickAdministratorsAddSurveyButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsAddSurveyButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					administratorsAddSurveyButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Administrators > Add Survey go button, retrying go button mapping");
					clickAdministratorsAddSurveyButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Administrators > Add Survey go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsAddSurveyButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Administrators > Create Client go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickAdministratorsCreateClientGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsCreateClientGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				administratorsCreateClientGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Administrators > Create Client go button, retrying with fresh go button mapping");
				clickAdministratorsCreateClientGoButton(1); // 1 map attempt
															// only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsCreateClientGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Administrators > Create
	 * Client go button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickAdministratorsCreateClientGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsCreateClientGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					administratorsCreateClientGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Administrators > Create Client go button, retrying go button mapping");
					clickAdministratorsCreateClientGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Administrators > Create Client go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsCreateClientGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Administrators > Custom Admin Functions button,
	 * will call overloaded method for a mapping if necessary
	 */
	public static void clickAdministratorsCustomAdminFunctionsButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsCustomAdminFunctionsButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				administratorsCustomAdminFunctionsButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Administrators > Custom Admin Functions button, retrying with fresh go button mapping");
				clickAdministratorsCustomAdminFunctionsButton(1); // 1 map
																	// attempt
																	// only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsCustomAdminFunctionsButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Administrators > Custom
	 * Admin Functions button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickAdministratorsCustomAdminFunctionsButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsCustomAdminFunctionsButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					administratorsCustomAdminFunctionsButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Administrators > Custom Admin Functions button, retrying go button mapping");
					clickAdministratorsCustomAdminFunctionsButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Administrators > Custom Admin Functions button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsCustomAdminFunctionsButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Administrators > Manage go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickAdministratorsManageGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsManageGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				administratorsManageGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Administrators > Manage go button, retrying with fresh go button mapping");
				clickAdministratorsManageGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsManageGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Administrators > Manage go
	 * button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickAdministratorsManageGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsManageGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					administratorsManageGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Administrators > Manage go button, retrying go button mapping");
					clickAdministratorsManageGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Administrators > Manage go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsManageGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Administrators > Survey Tools go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickAdministratorsSurveyToolsGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsSurveyToolsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				administratorsSurveyToolsGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Administrators > Survey Tools go button, retrying with fresh go button mapping");
				clickAdministratorsSurveyToolsGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsSurveyToolsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Administrators > Survey
	 * Tools go button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickAdministratorsSurveyToolsGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsSurveyToolsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					administratorsSurveyToolsGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Administrators > Survey Tools go button, retrying go button mapping");
					clickAdministratorsSurveyToolsGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Administrators > Survey Tools go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsSurveyToolsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Administrators > Tracker Options go button, will
	 * call overloaded method for a mapping if necessary
	 */
	public static void clickAdministratorsTrackerOptionsGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsTrackerOptionsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				administratorsTrackerOptionsGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Administrators > Tracker Options go button, retrying with fresh go button mapping");
				clickAdministratorsTrackerOptionsGoButton(1); // 1 map attempt
																// only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsTrackerOptionsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Administrators > Tracker
	 * Options go button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickAdministratorsTrackerOptionsGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickAdministratorsTrackerOptionsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					administratorsTrackerOptionsGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Administrators > Tracker Options go button, retrying go button mapping");
					clickAdministratorsTrackerOptionsGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Administrators > Tracker Options go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickAdministratorsTrackerOptionsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Clients > Export go button, will call overloaded
	 * method for a mapping if necessary
	 */
	public static void clickClientsExportGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickClientsExportGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				clientsExportGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Clients > Export go button, retrying with fresh go button mapping");
				clickClientsExportGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickClientsExportGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Clients > Export go button,
	 * will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickClientsExportGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickClientsExportGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					clientsExportGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Clients > Export go button, retrying go button mapping");
					clickClientsExportGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Clients > Export go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickClientsExportGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Clients > Login As Client go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickClientsLoginAsClientGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickClientsLoginAsClientGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				clientsLoginAsClientGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Clients > Login As Client go button, retrying with fresh go button mapping");
				clickClientsLoginAsClientGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickClientsLoginAsClientGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Clients > Login As Client
	 * go button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickClientsLoginAsClientGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickClientsLoginAsClientGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					clientsLoginAsClientGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Clients > Login As Client go button, retrying go button mapping");
					clickClientsLoginAsClientGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Clients > Login As Client go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickClientsLoginAsClientGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Clients > Manage go button, will call overloaded
	 * method for a mapping if necessary
	 */
	public static void clickClientsManageGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickClientsManageGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				clientsManageGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Clients > Manage go button, retrying with fresh go button mapping");
				clickClientsManageGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickClientsManageGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Clients > Manage go button,
	 * will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickClientsManageGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickClientsManageGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					clientsManageGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Clients > Manage go button, retrying go button mapping");
					clickClientsManageGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Clients > Manage go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickClientsManageGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Shoppers > Shopper Billing button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickShoppersShopperBillingButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShoppersShopperBillingButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				shoppersShopperBillingButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Shoppers > Shopper Billing button, retrying with fresh go button mapping");
				clickShoppersShopperBillingButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShoppersShopperBillingButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Shoppers > Shopper Billing
	 * button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickShoppersShopperBillingButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShoppersShopperBillingButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					shoppersShopperBillingButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Shoppers > Shopper Billing button, retrying go button mapping");
					clickShoppersShopperBillingButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Shoppers > Shopper Billing button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShoppersShopperBillingButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Shoppers > Shopper Search button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickShoppersShopperSearchButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShoppersShopperSearchButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				shoppersShopperSearchButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Shoppers > Shopper Search button, retrying with fresh go button mapping");
				clickShoppersShopperSearchButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShoppersShopperSearchButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Shoppers > Shopper Search
	 * button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickShoppersShopperSearchButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShoppersShopperSearchButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					shoppersShopperSearchButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Shoppers > Shopper Search button, retrying go button mapping");
					clickShoppersShopperSearchButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Shoppers > Shopper Search button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShoppersShopperSearchButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Shoppers > Shopper Tools go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickShoppersShopperToolsGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShoppersShopperToolsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				shoppersShopperToolsGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Shoppers > Shopper Tools go button, retrying with fresh go button mapping");
				clickShoppersShopperToolsGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShoppersShopperToolsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Shoppers > Shopper Tools go
	 * button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickShoppersShopperToolsGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShoppersShopperToolsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					shoppersShopperToolsGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Shoppers > Shopper Tools go button, retrying go button mapping");
					clickShoppersShopperToolsGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Shoppers > Shopper Tools go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShoppersShopperToolsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Shops > Review Shops go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickShopsReviewShopsGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShopsReviewShopsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				shopsReviewShopsGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Shops > Review Shops go button, retrying with fresh go button mapping");
				clickShopsReviewShopsGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShopsReviewShopsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Shops > Review Shops go
	 * button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickShopsReviewShopsGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShopsReviewShopsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					shopsReviewShopsGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Shops > Review Shops go button, retrying go button mapping");
					clickShopsReviewShopsGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Shops > Review Shops go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShopsReviewShopsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Shops > Schedule Shops go button, will call
	 * overloaded method for a mapping if necessary
	 */
	public static void clickShopsScheduleShopsGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShopsScheduleShopsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				shopsScheduleShopsGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Shops > Schedule Shops go button, retrying with fresh go button mapping");
				clickShopsScheduleShopsGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShopsScheduleShopsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Shops > Schedule Shops go
	 * button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickShopsScheduleShopsGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShopsScheduleShopsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					shopsScheduleShopsGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Shops > Schedule Shops go button, retrying go button mapping");
					clickShopsScheduleShopsGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Shops > Schedule Shops go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShopsScheduleShopsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Attempts to click the Shops > Shop Tools go button, will call overloaded
	 * method for a mapping if necessary
	 */
	public static void clickShopsShopToolsGoButton() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShopsShopToolsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}

			try {
				shopsShopToolsGoButton.click();
			} catch (Exception e) {
				Debug.throwInDebugIfOn("Failed to click Shops > Shop Tools go button, retrying with fresh go button mapping");
				clickShopsShopToolsGoButton(1); // 1 map attempt only
			}

			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by shopsShopToolsGoButton: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Calls mapButtons() before trying to click the Shops > Shop Tools go
	 * button, will retry
	 * 
	 * @param tries
	 *            Number of mapping retries allowed
	 */
	public static void clickShopsShopToolsGoButton(int tries) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clickShopsShopToolsGoButton called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (tries > 0) {
				mapButtons();
				tries--;
				try {
					shopsShopToolsGoButton.click();
				} catch (Exception e) {
					System.out
							.println("Failed to click Shops > Shop Tools go button, retrying go button mapping");
					clickShopsShopToolsGoButton(tries);
				}
			} else {
				System.out
						.println("Failed to click the Shops > Shop Tools go button");
			}

			return;
		} catch (Exception e) {
			System.out
					.println("Exception thrown by clickShopsShopToolsGoButton: "
							+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Clients > Export dropdown
	 * (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from clients export dropdown options
	 */
	public static void clientsExport(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clientsExport called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement clientsExportDropdown = driver.findElement(By
						.name("exportOptions"));
				Select clientsExportSelect = new Select(clientsExportDropdown);
				try {
					clientsExportSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("clientsExport HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class clientsExport missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by clientsExport: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Clients > Login as Client
	 * dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from clients login as client dropdown
	 *            options
	 */
	public static void clientsLoginAsClient(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clientsLoginAsClient called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement clientsLoginAsClientDropdown = driver.findElement(By
						.name("clientOptions"));
				Select clientsLoginAsClientSelect = new Select(
						clientsLoginAsClientDropdown);
				try {
					clientsLoginAsClientSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("clientsLoginAsClient HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class clientsLoginAsClient missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by clientsLoginAsClient: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Clients > Manage dropdown
	 * (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from clients manage dropdown options
	 */
	public static void clientsManage(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class clientsManage called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement clientsManageDropdown = driver.findElement(By
						.name("adminOptions"));
				Select clientsManageSelect = new Select(clientsManageDropdown);
				try {
					clientsManageSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("clientsManage HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class clientsManage missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by clientsManage: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * This should be called to map the buttons on the Main Admin page before
	 * the button clickers are used.</br>
	 */
	public static void mapButtons() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class mapButtons called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			List<WebElement> buttons = driver.findElements(By.tagName("a"));
			String buttonLinkHolder;
			for (WebElement goButton : buttons) {
				// List all of the Admin page buttons, map each
				// If/Else if so when one is mapped, it goes just a bit quicker
				// by not checking any of the rest
				// 16 buttons to start with
				Debug.throwInDebugIfOn(goButton.getAttribute("href")); // debugging
				buttonLinkHolder = goButton.getAttribute("href");
				if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='admin';")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='admin';")) {
					clientsManageGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='shoptools'")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='shoptools'")) {
					shopsShopToolsGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='client'")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='client'")) {
					clientsLoginAsClientGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='review'")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='review'")) {
					shopsReviewShopsGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='';%20window.document.forms[0].action='../scheduler/ShopperAdmin.php?mode='")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value=''; window.document.forms[0].action='../scheduler/ShopperAdmin.php?mode='")) {
					shoppersShopperSearchButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='export'")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='export'")) {
					clientsExportGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='scheduler'")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='scheduler'")) {
					shopsScheduleShopsGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20processShopperSelection()")
						|| buttonLinkHolder
								.contains("javascript: processShopperSelection()")) {
					shoppersShopperToolsGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='adminManage'")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='adminManage'")) {
					administratorsManageGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='surveyTools'")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='surveyTools'")) {
					administratorsSurveyToolsGoButton = goButton;
				} else if (buttonLinkHolder
						.contains("http://www.sassiedev.com/2_qa/admin/BillingAdmin.php")) {
					shoppersShopperBillingButton = goButton;
				} else if (buttonLinkHolder
						.contains("custom/admin/customAdminMaster.php")) {
					administratorsCustomAdminFunctionsButton = goButton;
				} else if (buttonLinkHolder.contains("/admin/AdminMaster.php#")) {
					// This could be one of two # links on the page
					Debug.throwInDebugIfOn("onclick: "
							+ goButton.getAttribute("onclick")); // debugging
					if (goButton.getAttribute("onclick") != null) {
						administratorsTrackerOptionsGoButton = goButton;
					}
				} else if (buttonLinkHolder
						.contains("javascript:%20window.document.forms[0].mode.value='clientAdd';%20window.document.forms[0].submit();")
						|| buttonLinkHolder
								.contains("javascript: window.document.forms[0].mode.value='clientAdd'; window.document.forms[0].submit();")) {
					administratorsCreateClientGoButton = goButton;
				} else if (buttonLinkHolder.contains("method")) {
					administratorsAddSurveyButton = goButton;
				}
			}
			return;
		} catch (Exception e) {
			System.out.println(e.getMessage());

			return;
		}
	}

	/**
	 * Selects the client: survey from the main Admin page dropdown.</br> Uses
	 * the Master.getClientSurvey function, so set the Master Client and Survey
	 * first.
	 * 
	 * @param clientSurvey
	 *            Exact string to select from the survey dropdown
	 */
	public static void selectSurvey() {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class selectSurvey called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (Parameters.getClientSurvey() != null) {
				// Actually choose the desired survey
				WebElement selectSurveyDropdown = driver.findElement(By
						.name("selectSurvey"));
				Select surveySelect = new Select(selectSurveyDropdown);
				try {
					surveySelect.selectByVisibleText(Parameters
							.getClientSurvey());
					Debug.throwInDebugIfOn("selectSurvey HERE"); // debugging
				} catch (Exception e) {
					// If here, the surveyName could not be found. default to
					// first survey
					System.out
							.println("Survey not found, defaulting to first available survey");
					surveySelect.selectByIndex(1);// 1 should be the second
													// option, which should be
													// the first Actual survey
				}
			} else {
				System.out
						.println("No client and/or survey defined, defaulting to first available survey");
				WebElement selectSurveyDropdown = driver.findElement(By
						.name("selectSurvey"));
				Select surveySelect = new Select(selectSurveyDropdown);
				surveySelect.selectByIndex(1);// 1 should be the second option,
												// which should be the first
												// Actual survey
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by selectSurvey: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Shoppers > Shopper Tools
	 * dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from shoppers shopper tools dropdown
	 *            options
	 */
	public static void shoppersShopperTools(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class shoppersShopperTools called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement shoppersShopperToolsDropdown = driver.findElement(By
						.name("shopperOptions"));
				Select shoppersShopperToolsSelect = new Select(
						shoppersShopperToolsDropdown);
				try {
					shoppersShopperToolsSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("shoppersShopperTools HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class shoppersShopperTools missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by shoppersShopperTools: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Shops > Review Shops dropdown
	 * (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from shops review shops dropdown
	 *            options
	 */
	public static void shopsReviewShops(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class shopsReviewShops called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement shopsReviewShopsDropdown = driver.findElement(By
						.name("reviewerOptions"));
				Select shopsReviewShopsSelect = new Select(
						shopsReviewShopsDropdown);
				try {
					shopsReviewShopsSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("shopsReviewShops HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class shopsReviewShops missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by shopsReviewShops: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Shops > Schedule Shops
	 * dropdown (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from shops schedule shops dropdown
	 *            options
	 */
	public static void shopsScheduleShops(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class shopsScheduleShops called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement shopsScheduleShopsDropdown = driver.findElement(By
						.name("schedulerOptions"));
				Select shopsScheduleShopsSelect = new Select(
						shopsScheduleShopsDropdown);
				try {
					shopsScheduleShopsSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("shopsScheduleShops HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class shopsScheduleShops missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by shopsScheduleShops: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Throws text into the Last Name or Email (or both) text fields on the Main
	 * Admin page.
	 * 
	 * @param lastName
	 *            The String to be input into the Last Name field.
	 * @param email
	 *            The String to be input into the Email field.
	 */
	public static void shopsShopperSearch(String lastName, String email) {
		try {
			WebDriver driver = Driver.getCurrentDriver();
			// WebDriverWait wait = Master.getWait();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class shopsShopperSearch called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (lastName != null || email != null) {
				// Actually choose the desired selection
				WebElement shopsShopperSearchLastName = driver.findElement(By
						.name("searchShopperLName"));
				WebElement shopsShopperSearchEmail = driver.findElement(By
						.name("searchShopperEmailH"));
				if (lastName != null)
					shopsShopperSearchLastName.sendKeys(lastName);
				if (email != null)
					shopsShopperSearchEmail.sendKeys(email);
				Debug.throwInDebugIfOn("shopsShopperSearch HERE"); // debugging
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class shopsShopperSearch missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by shopsShopperSearch: "
					+ e.getLocalizedMessage());

			return;
		}
	}

	/**
	 * Chooses an option from the main Admin page Shops > Shop Tools dropdown
	 * (must pass the exact selection text)
	 * 
	 * @param selection
	 *            Exact string to select from shops shop tools dropdown options
	 */
	public static void shopsShopTools(String selection) {
		try {
			WebDriver driver = Driver.getCurrentDriver();

			Debug.throwInDebugIfOn("Current URL: " + driver.getCurrentUrl()); // debugging
			if (!driver.getCurrentUrl().endsWith("AdminMaster.php")) {
				throw new IllegalStateException(
						"Class shopsShopTools called from a page other than a Main Admin: "
								+ driver.getCurrentUrl());
			}
			if (selection != null) {
				// Actually choose the desired selection
				WebElement shopsShopToolsDropdown = driver.findElement(By
						.name("shoptools"));
				Select shopsShopToolsSelect = new Select(shopsShopToolsDropdown);
				try {
					shopsShopToolsSelect.selectByVisibleText(selection);
					Debug.throwInDebugIfOn("shopsShopTools HERE"); // debugging
				} catch (Exception e) {
					// If here, the option could not be found.
					System.out.println("Option not found");

				}
			} else {
				System.out.println("No option defined");
				throw new IllegalStateException(
						"Class shopsShopTools missing selection");
			}
			return;
		} catch (Exception e) {
			System.out.println("Exception thrown by shopsShopTools: "
					+ e.getLocalizedMessage());

			return;
		}
	}

}