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
    public void testFaqExpandsAnswerOnQuestionClick_success() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickFaqButton(1);
        boolean isDisplayed = mainPage.isDisplayedFaqAnswer(1);
        Assert.assertTrue("FAQ answer is not displayed", isDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
