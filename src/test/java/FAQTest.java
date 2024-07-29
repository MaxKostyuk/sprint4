import com.kotan4ik.pages.MainPage;
import com.kotan4ik.utils.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class FAQTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void testFaqExpandsAnswerOnQuestionClickSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.acceptCookies();
        int numberOfButtons = mainPage.getNumberOfFaqButtons();
        boolean[] isDisplayed = new boolean[numberOfButtons];
        for (int i = 1; i <= numberOfButtons; i++) {
            mainPage.clickFaqButton(i);
            isDisplayed[i -1] = mainPage.isDisplayedFaqAnswer(i);
        }
        int j = 1;
        boolean allDisplayed = true;
        for (boolean displayed : isDisplayed) {
            if (!displayed) {
                allDisplayed = false;
                break;
            }
            j++;
        }
        Assert.assertTrue("FAQ answer[" + j + "] is not displayed", allDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
