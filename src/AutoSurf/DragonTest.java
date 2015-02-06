package AutoSurf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.Select;

/**
 * Deprecated, made during the Dragon hands-on preview.<br>  
 * TODO: When time is available, make main navigation and other arguments for traversing and testing Dragon.
 * @author Bergie
 */
public class DragonTest {
	public static void main(String[] args) {

		// String MSP = "";
		// String client = "";
		// String sandboxUserName = "";

		// sandboxUserName = "dragon";
		// MSP = "2_qa";
		// client = "";

		// String DEVSuperGlobal =
		// "http://www.sassiedev.com/admin/SuperGlobalAdmin.php";
		// String DEVAdmin2MercSurveysLoginURL =
		// String DEVAdmin2MercSurveysLoginURLWPass =

		WebDriver driver = new FirefoxDriver();

		// driver.get(DEVSuperGlobalWPass);
		System.out.println(driver.getTitle());

		// WebElement mercSurveysAdmin =
		// driver.findElement(By.cssSelector("body > div:nth-child(1) > font:nth-child(2) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(113) > td:nth-child(6) > a:nth-child(1)"));
		WebElement twoDevAdmin = driver.findElement(By
				.cssSelector("a[href*='expressadminlogin.php?dirname=2_dev']"));
		twoDevAdmin.click();

		WebElement surveySelectBox = driver
				.findElement(By.name("selectSurvey"));
		Select surveySelectClick = new Select(surveySelectBox);
		surveySelectClick.selectByValue("48^1134");

		WebElement reportGoButton = driver
				.findElement(By
						.cssSelector("body > div:nth-child(4) > form > table > tbody > tr:nth-child(5) > td:nth-child(1) > a > img"));
		reportGoButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("table.reports > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)")));
		WebElement reportTable = driver.findElement(By.tagName("table"));
		List<WebElement> buttonLinks = reportTable
				.findElements(By.tagName("a"));
		// System.out.println("Button #: "+buttonLinks.size());
		for (WebElement button : buttonLinks) {
			// System.out.println(button.getAttribute("href"));
			if (button.getAttribute("href").matches("(.*)Cat66(.*)")) {
				// System.out.println("Found the Cat66 button!");
				button.click();
				break;
			}
		}

		// driver.get("http://dragon.sassiedev.com/dragon/dashboard");

		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("Page URL: " + driver.getCurrentUrl());

		// WebElement dragonHeader =
		// driver.findElement(By.cssSelector("#main > div.dragon > header"));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("a.icon-cog")));
		WebElement layoutSelector = driver.findElement(By.tagName("select"));
		Select layoutSelectorSelect = new Select(layoutSelector);
		layoutSelectorSelect.selectByValue("33");

		/*
		 * WebElement newLayout = driver.findElement(By.id("new_layout"));
		 * newLayout
		 * .findElement(By.id("layout_name")).sendKeys("Automation Test");
		 * WebElement newLayoutRadios =
		 * newLayout.findElement(By.className("create_layout_radios")); Select
		 * newLayoutRadiosSelect = new Select(newLayoutRadios);
		 * newLayoutRadiosSelect.selectByValue("empty");
		 */

		System.out.println("Current URL, with layout number? : "
				+ driver.getCurrentUrl());

		System.out.println("Title is: " + driver.getTitle()); // Just to know
																// that it got
																// to the end
																// basically
		driver.close(); // Closes the currently active window, quits the run
						// only if it is the only/last window.
		driver.quit(); // Closes all windows associated with this run, and then
						// quits the run- does not quit other Firefox windows,
						// just associated windows.
	}
}