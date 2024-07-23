import com.kotan4ik.pages.MainPage;
import com.kotan4ik.pages.OrderPage;
import com.kotan4ik.utils.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class OrderTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void testOrderSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputName("Иван");
        orderPage.inputLastName("Кравцов");
        orderPage.inputAddress("Примерный адрес");
        orderPage.chooseSubwayStation(5);
        orderPage.inputPhoneNumber("89991234567");
        orderPage.clickButtonNext();
        orderPage.chooseFirstAvailableDate();
        orderPage.chooseDaysForRent(7);
        orderPage.chooseGreyColor();
        orderPage.orderScooter();
        orderPage.confirmOrder();
        Assert.assertTrue(orderPage.checkOrderConfirmed());
        System.out.println("wait");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
