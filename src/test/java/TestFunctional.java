import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestFunctional {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/Mac/Downloads/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMdpincorrect() throws Exception {
    driver.get("http://localhost:7979/AGL_war_exploded/login");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("hamza");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("hamza");
    driver.findElement(By.xpath("//input[@value='Connexion']")).click();
  }

  @Test
  public void testCnxok() throws Exception {
    driver.get("http://localhost:7979/AGL_war_exploded/login");
    driver.findElement(By.xpath("//table")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("salama");
    driver.findElement(By.xpath("//input[@value='Connexion']")).click();
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://localhost:7979/AGL_war_exploded/login");
    driver.findElement(By.linkText("Guest Page")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }



  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
