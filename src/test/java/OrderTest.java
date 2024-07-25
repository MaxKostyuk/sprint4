import com.kotan4ik.pages.MainPage;
import com.kotan4ik.pages.OrderPage;
import com.kotan4ik.utils.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final int stationNumber;
    private final String phoneNumber;
    private final String date;
    private final int daysForRent;

    public OrderTest(String name, String lastName, String address, int stationNumber, String phoneNumber, String date, int daysForRent) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.stationNumber = stationNumber;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.daysForRent = daysForRent;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Иван", "Кравцов", "Адрес", 5, "81234567890", "01.01.1991",7},
                {"Михаил", "Иванов", "Адрес2", 3, "80987654321", "22.02.2022", 1},
        };
    }

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void testOrderSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.acceptCookies();
        mainPage.clickOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputName(name);
        orderPage.inputLastName(lastName);
        orderPage.inputAddress(address);
        orderPage.chooseSubwayStation(stationNumber);
        orderPage.inputPhoneNumber(phoneNumber);
        orderPage.clickButtonNext();
        orderPage.setRentDate(date);
        orderPage.chooseDaysForRent(daysForRent);
        orderPage.chooseGreyColor();
        orderPage.orderScooter();
        orderPage.confirmOrder();
        Assert.assertTrue(orderPage.checkOrderConfirmed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
