/**
 * 
 */
/*
 * package AutoSurf;
 * 
 * import org.junit.After; import org.junit.Before; import org.junit.Test;
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement;
 * 
 * 
 * 
 * public class MobileWebTest {
 * 
 * private SelendroidLauncher selendroidServer = null; private WebDriver driver
 * = null;
 * 
 * @Test public void shouldSearchWithEbay() { // And now use this to visit ebay
 * driver.get("http://m.ebay.com");
 * 
 * // Find the text input element by its id WebElement element =
 * driver.findElement(By.id("kw"));
 * 
 * // Enter something to search for element.sendKeys("Nexus 5");
 * 
 * // Now submit the form. WebDriver will find the form for us from the element
 * element.submit();
 * 
 * // Check the title of the page System.out.println("Page title is: " +
 * driver.getTitle()); driver.quit(); }
 * 
 * @Before public void startSelendroidServer() throws Exception {
 * //System.setProperty("sdk.dir","/home/user/Android/adt/sdk"); if
 * (selendroidServer != null) { selendroidServer.stopSelendroid(); }
 * SelendroidConfiguration config = new SelendroidConfiguration();
 * 
 * selendroidServer = new SelendroidLauncher(config);
 * selendroidServer.launchSelendroid();
 * 
 * DesiredCapabilities caps = SelendroidCapabilities.android();
 * 
 * driver = new SelendroidDriver(caps); }
 * 
 * @After public void stopSelendroidServer() { if (driver != null) {
 * driver.quit(); } if (selendroidServer != null) {
 * selendroidServer.stopSelendroid(); } } }
 */