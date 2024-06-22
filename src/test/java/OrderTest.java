import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObjects.HomePage;
import pageObjects.OrderAboutRentPage;
import pageObjects.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest extends CoreTest{
    private final boolean isInHeaderButton;
    private final String name;
    private final String secondName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String rentDate;
    private final int rentTermID;
    private final int colorID;
    private final String courierComment;

    public OrderTest(boolean isInHeaderButton, String name, String secondName, String address, String metro, String phone,
                     String rentDate, int rentTermID, int colorID, String courierComment) {
        this.isInHeaderButton = isInHeaderButton;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.rentDate = rentDate;
        this.rentTermID = rentTermID;
        this.colorID = colorID;
        this.courierComment = courierComment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {true, "Дмитрий","Волков","ул. Ленина, д. 12, кв. 7","Сокольники","89115553535","27.05.2024", 0, 0, "Тестовый комментарий"},
                {false, "Евгений","Тестов","ул. Солнечная 44","Курская","89279166111","25.12.2024", 1, 1, "Проверка комментария"},

        };
    }

    @Test
    public void scooterOrderTest(){
        HomePage mainPage = new HomePage(driver);
        OrderPage orderPage = mainPage.clickOnOrderButton(isInHeaderButton);
        OrderAboutRentPage orderAboutRentPage = orderPage.fillOrderDetails(name, secondName,address,metro,phone);
        orderAboutRentPage.order(rentDate, rentTermID,colorID,courierComment);
        Assert.assertTrue("Ожидалось оформление заказа", orderAboutRentPage.isOrderProcessed());

    }
}
