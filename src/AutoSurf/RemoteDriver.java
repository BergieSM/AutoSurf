package AutoSurf;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * TODO: IN PROGRESS 
 * 
 * @author Bergie
 * 
 */
public class RemoteDriver {
	static WebDriver currentDriver = null;
	static WebDriverWait currentWait = null;

	static WebDriver remoteFirefoxDriver = null;
	static WebDriver remoteAndroidDriver = null;

	// RemoteWebDriver d = new RemoteWebDriver();

	/**
	 * Only currently functional by manually running the Hub and Node.</br>
	 * Server class will hopefully be able to run these functions automatically
	 * in the future?
	 */
	public static void activateRemoteFirefoxDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		// Parameters.setRemoteURL("http://bsg.surfmerchants.com:3389");
		// Parameters.setRemoteURL("http://bsg.surfmerchants.com:4444/wd/hub");
		// Parameters.setRemoteURL("http://127.0.0.1:4444/wd/hub");
		// Parameters.setRemoteURL("http://10.1.2.230:4444/wd/hub");
		// Parameters.setRemoteURL("http://localhost:4444/wd/hub");
		// String url = "http://192.168.1.174/wd/hub"; //stand alone in download
		// folder, need to create node shortcut by finding java path and
		// registering hub IP. Remarkably slow and annoying to interact with, no
		// other options however.
		// String url = "http://localhost:4444/wd/hub";
		// String url = "http://10.1.2.230:4444/wd/hub";
		// String url =
		String url = "http://localhost:6000/wd/hub";
		String encodedUrl = Navigation.encodeURL(url);
		System.out.println("url = " + url);
		System.out.println("encoded url = " + encodedUrl);
		Parameters.setRemoteURL(encodedUrl);
		// Proxy proxy = new Proxy();
		// proxy.setProxyAutoconfigUrl(Parameters.getRemoteURL());
		// capabilities.setCapability(CapabilityType.PROXY, proxy);
		System.out.println("Activate1");
		try {
			remoteFirefoxDriver = new RemoteWebDriver(new URL(
					Parameters.getRemoteURL()), capabilities);
			System.out.println("Activate2");
			Capabilities actualCapabilities = ((RemoteWebDriver) remoteFirefoxDriver)
					.getCapabilities();
			System.out.println("Activate3");
			FileOutput.throwInDebug(actualCapabilities.toString());
			System.out.println("Activate4");
			remoteFirefoxDriver.get("http://www.google.com");
			System.out.println("Activate5");
			System.out.println(remoteFirefoxDriver.getTitle());
			System.out.println("Activate6");
			System.out.println(System.getProperties());
			FileOutput.throwInDebug(System.getProperties().toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			Throwable cause = e.getCause();
			if (cause instanceof ScreenshotException) {
				FileOutput.throwInDebug(((ScreenshotException) cause)
						.getBase64EncodedScreenshot());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// selenium = new WebDriverBackedSelenium(driver,
		// Parameters.getRemoteURL());
	}

	public static void remoteCleanUp() {
		if (remoteFirefoxDriver != null)
			try {
				remoteFirefoxDriver.quit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (remoteAndroidDriver != null) {
			try {
				remoteAndroidDriver.quit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void activateRemoteAndroidDriver() {
		// 0f699ad5
		// adb -s 0f699ad5 shell am start -a android.intent.action.MAIN -n
		// org.openqa.selenium.android.app/.MainActivity
		// adb -s 0f699ad5 forward tcp:6000 tcp:8080
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		String url = "http://localhost:6000/wd/hub";
		String encodedUrl = Navigation.encodeURL(url);
		System.out.println("url = " + url);
		System.out.println("encoded url = " + encodedUrl);
		Parameters.setRemoteURL(encodedUrl);
		try {
			remoteAndroidDriver = new RemoteWebDriver(new URL(
					Parameters.getRemoteURL()), capabilities);
			// Capabilities actualCapabilities = ((RemoteWebDriver)
			// remoteFirefoxDriver).getCapabilities();
			// FileOutput.throwInDebug(actualCapabilities.toString());
			Driver.setDriver(remoteAndroidDriver);
			currentDriver = remoteAndroidDriver;
			// remoteAndroidDriver.get("http://www.google.com"); //debugging
			// System.out.println(remoteFirefoxDriver.getTitle()); //debugging
			// System.out.println(System.getProperties()); //debugging
			// FileOutput.throwInDebug(System.getProperties().toString());
			// //debugging
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			Throwable cause = e.getCause();
			if (cause instanceof ScreenshotException) {
				FileOutput.throwInDebug(((ScreenshotException) cause)
						.getBase64EncodedScreenshot());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
