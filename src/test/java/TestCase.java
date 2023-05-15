import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCase {
    public static void testCaseWithDataBase(String[] TestCaseTable) {

        for(int i = 0; i < TestCaseTable.length; i++) {
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://duckduckgo.com");

            String[] basicVariable = TestCaseTable;
            driver.findElement(By.id("search_form_input_homepage")).sendKeys(TestCaseTable[i]);
            driver.findElement(By.id("search_button_homepage")).click();
            driver.findElement(By.xpath("//article/div/h2/a")).click();
            try {
                WebElement userNameInput = driver.findElement(By.className("mw-page-title-main"));

                String derivativeVariable = userNameInput.getText();

                boolean comparisonVariable = derivativeVariable.equals(basicVariable[i]);

                if (comparisonVariable) {
                    System.out.println("Odnaleziona nazwa zgadza się bazową");
                } else {
                    System.out.println("Bazowa nazwa różni się od nazwy odnalezionej");
                }
            }catch (NoSuchElementException e) {
                System.out.println("Nie znaleziono elementu o klasie mw-page-title-main");
            }
            driver.close();

        }}

}




