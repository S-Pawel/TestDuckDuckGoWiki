import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestCase {
    public static void testCaseWithDataBase(String[] TestCaseTable) {
        String[] testResults = new String[TestCaseTable.length];

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
                    testResults[i] = "Odnaleziona nazwa zgadza się bazową";
                    System.out.println(testResults[i]);
                } else {
                    testResults[i] = "Bazowa nazwa różni się od nazwy odnalezionej";
                    System.out.println(testResults[i]);
                }
            }catch (NoSuchElementException e) {
                testResults[i] = "Nie znaleziono elementu o klasie mw-page-title-main";
                System.out.println(testResults[i]);
            }
            driver.close();
        }


        SaveToExel.saveToXlsx(TestCaseTable, testResults, "wyniki.xlsx");
    }

}




