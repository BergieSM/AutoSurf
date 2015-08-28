package AutoSurf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.*;

/**
 * Main Driver class, launches webdrivers, stores open browser windows, and cleans up after itself.
 * @author Bergie
 */
public class Driver {
	static WebDriver currentDriver = null;
	static WebDriverWait currentWait = null;

	static WebDriver ffDriver = null;
	static WebDriver cDriver = null;
	static WebDriver htmlDriver = null;
	static WebDriver androidDriver = null;
	static WebDriver ie32Driver = null;
	static WebDriver ie64Driver = null;

	static WebDriverWait ffWait = null;
	static WebDriverWait cWait = null;
	static WebDriverWait htmlWait = null;
	static WebDriverWait androidWait = null;
	static WebDriverWait ie32Wait = null;
	static WebDriverWait ie64Wait = null;

	/**
	 * Launches the Android browser, without closing other browsers.
	 * TODO: Needs a lot of love.
	 */
	protected static void activateAndroid() {
		// cleanUp();
		// String userDirectory = System.getProperty("user.dir");
		// System.setProperty("webdriver.chrome.driver", userDirectory +
		// "/misc/chromedriver.exe");
		WebDriver driver = new RemoteWebDriver(DesiredCapabilities.android());
		driver.get("http://google.com");
	}

	/**
	 * Launches the Chrome browser, without closing other browsers.
	 */
	protected static void activateChrome() {
		// cleanUp();
		ChromeOptions cOptions = new ChromeOptions();
		String userDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userDirectory
				+ "/bin/chromedriver.exe");
		currentDriver = cDriver = new ChromeDriver(cOptions);
		currentWait = cWait = new WebDriverWait(cDriver, 20);
	}

	/**
	 * Launches the Firefox browser, without closing other browsers.
	 */
	protected static void activateFirefox() {
		// Debug.throwInDebugIfOn("Before cleanUp");
		// cleanUp();
		// Debug.throwInDebugIfOn("After cleanUp");
		Debug.throwInDebugIfOn("Before ffProfile");
		FirefoxProfile ffProfile = new FirefoxProfile();
		Debug.throwInDebugIfOn("After ffProfile");
		Debug.throwInDebugIfOn("Before ffDriver");
		currentDriver = ffDriver = new FirefoxDriver(ffProfile);
		Debug.throwInDebugIfOn("After ffDriver");
		Debug.throwInDebugIfOn("Before ffWait");
		currentWait = ffWait = new WebDriverWait(ffDriver, 20);
		Debug.throwInDebugIfOn("After ffWait");
	}

	/**
	 * Launches the HTMLUnit browser, without closing other browsers.</br>
	 * TODO: Needs a complete overhaul.
	 */
	protected static void activateHTMLUnit() {
		// cleanUp();
		currentDriver = htmlDriver = new HtmlUnitDriver();
		currentWait = htmlWait = new WebDriverWait(htmlDriver, 20);
	}

	/**
	 * Launches the Internet Explorer 32 Bit browser, without closing other browsers.</br> 
	 * For issues launching the IE driver, see here:</br> 
	 * https://code.google.com/p/selenium/wiki/InternetExplorerDriver</br>
	 * TODO: Needs serious work.
	 */
	protected static void activateIE32() {
		// cleanUp();
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		String userDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", userDirectory
				+ "/misc/IEDriverServer_Win32_2.44.0/IEDriverServer.exe");
		currentDriver = ie32Driver = new InternetExplorerDriver(capabilities);
		currentWait = ie32Wait = new WebDriverWait(ie32Driver, 20);
	}

	/**
	 * Launches the Internet Explorer 64 Bit browser, without closing other browsers.</br> 
	 * For issues launching the IE driver, see here:</br> 
	 * https://code.google.com/p/selenium/wiki/InternetExplorerDriver</br>
	 * TODO: Needs serious work.
	 */
	protected static void activateIE64() {
		// cleanUp();
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		String userDirectory = System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", userDirectory
				+ "/misc/IEDriverServer_x64_2.44.0/IEDriverServer.exe");
		currentDriver = ie64Driver = new InternetExplorerDriver();
		currentWait = ie64Wait = new WebDriverWait(ie64Driver, 20);

	}

	/**
	 * Closes other browsers and launches the Android browser.</br>
	 * TODO: Needs a lot of love.
	 */
	protected static void switchToAndroid() {
		cleanUp();
		activateAndroid();
	}

	/**
	 * Closes other browsers and launches the Chrome browser.
	 */
	protected static void switchToChrome() {
		cleanUp();
		activateChrome();
	}

	/**
	 * Closes other browsers and launches the Firefox browser.
	 */
	protected static void switchToFirefox() {
		cleanUp();
		activateFirefox();
	}

	/**
	 * Closes other browsers and launches the HTMLUnit browser.</br>
	 * TODO: Needs a complete overhaul.
	 */
	protected static void switchToHTMLUnit() {
		cleanUp();
		activateHTMLUnit();
	}

	/**
	 * Closes other browsers and launches the 32-Bit Internet Explorer browser.</br> 
	 * For issues launching the IE driver, see here:</br> 
	 * https://code.google.com/p/selenium/wiki/InternetExplorerDriver</br>
	 * TODO: Needs serious work.
	 */
	protected static void switchToIE32() {
		cleanUp();
		activateIE32();
	}

	/**
	 * Closes other browsers and launches the 64-Bit Internet Explorer browser.</br> 
	 * For issues launching the IE driver, see here:</br> 
	 * https://code.google.com/p/selenium/wiki/InternetExplorerDriver</br>
	 * TODO: Needs serious work.
	 */
	protected static void switchToIE64() {
		cleanUp();
		activateIE64();
	}

	/**
	 * Check the state of each driver to make sure everything is properly closed
	 * out and shut down, prevent major memory leaking.
	 */
	protected static void cleanUp() {
		Debug.throwInDebugIfOn("cleanUp starting now.");

		try {
			Debug.throwInDebugIfOn("ffDriver == null: " + (ffDriver == null));
			if (ffDriver != null)
				ffDriver.quit();
		} catch (Exception e) {
			Debug.throwInDebugIfOn("ffDriver.quit exception");
		}
		try {
			Debug.throwInDebugIfOn("cDriver == null: " + (cDriver == null));
			if (cDriver != null)
				cDriver.quit();
		} catch (Exception f) {
			Debug.throwInDebugIfOn("cDriver.quit exception");
		}
		try {
			Debug.throwInDebugIfOn("htmlDriver == null: "
					+ (htmlDriver == null));
			if (htmlDriver != null)
				htmlDriver.quit();
		} catch (Exception g) {
			Debug.throwInDebugIfOn("htmlDriver.quit exception");
		}
		try {
			Debug.throwInDebugIfOn("ie32Driver == null: "
					+ (ie32Driver == null));
			if (ie32Driver != null)
				ie32Driver.quit();
		} catch (Exception e) {
			Debug.throwInDebugIfOn("ie32Driver.quit exception");
		}
		try {
			Debug.throwInDebugIfOn("ie64Driver == null: "
					+ (ie64Driver == null));
			if (ie64Driver != null)
				ie64Driver.quit();
		} catch (Exception e) {
			Debug.throwInDebugIfOn("ie64Driver.quit exception");
		}
		try {
			Debug.throwInDebugIfOn("androidDriver == null: "
					+ (androidDriver == null));
			if (androidDriver != null)
				androidDriver.quit();
		} catch (Exception e) {
			Debug.throwInDebugIfOn("androidDriver.quit exception");
		}

	}

	/**
	 * Return the currently active/ main driver.
	 * @return WebDriver that is currently active
	 */
	protected static WebDriver getCurrentDriver() {
		return currentDriver;
	}

	/**
	 * Return the currently active/ main driver's wait period.
	 * @return WebDriverWait The current wait
	 */
	protected static WebDriverWait getCurrentWait() {
		return currentWait;
	}

	/**
	 * Sets the currently active/ main driver to a passed WebDriver.
	 * @param WebDriver to be set as main 
	 */
	protected static void setDriver(WebDriver driver) {
		Driver.currentDriver = driver;
	}

	/**
	 * Sets the currently active/ main driver wait to a passed WebDriverWait.
	 * @param WebDriverWait to be set as main wait
	 */
	protected static void setWait(WebDriverWait wait) {
		Driver.currentWait = wait;
	}

	/**
	 * Called with no other parameters, Driver will launch Firefox and set it as main.
	 */
	protected Driver() {
		activateFirefox();
	}

	/**
	 * TODO: IN PROGRESS Need to make this class more useful for recovering from
	 * a random browser close.
	 */
	protected static void reactivate() {
		if (currentDriver == ffDriver) {
			cleanUp();
			activateFirefox();
		} else if (currentDriver == cDriver) {
			cleanUp();
			activateChrome();
		} else if (currentDriver == ie32Driver) {
			cleanUp();
			activateIE32();
		} else if (currentDriver == ie64Driver) {
			cleanUp();
			activateIE64();
		} else if (currentDriver == htmlDriver) {
			cleanUp();
			activateHTMLUnit();
		} else if (currentDriver == androidDriver) {
			cleanUp();
			activateAndroid();
		}
	}
}
