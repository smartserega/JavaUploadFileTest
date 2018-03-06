import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class UploadFileTest {

    private static WebDriver driver;

    @BeforeClass
    public static void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ПК\\IdeaProjects\\AutomatingTestingJavaMaven\\src\\recourses\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.rambler.ru/");
        System.out.println("Открылся сайт почты mail.ru");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.name("login"));
        loginField.sendKeys("smarseregatest");
        System.out.println("Пользователь ввёл логин");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("12345678");
        System.out.println("Пользователь ввёл пароль");

        WebElement loginButton = driver.findElement(By.cssSelector(".form-button.form-button_submit"));
        loginButton.click();
        System.out.println("Пользователь вошёл в почту");

        WebElement writeButton = driver.findElement(By.className("rui-Button-content"));
        writeButton.click();
        System.out.println("Пользователь начал писать новое письмо");

        //нужно выибрать селектор с тегом input
        driver.findElement(By.className("Compose-fileInput-dl")).sendKeys("C:\\Program Files\\Java\\chromedriver.exe");
        System.out.println("Пользователь загружает файл");


        assertTrue(driver.findElement(By.className("Uploads-name-2k")).getText().contains("chromedriver.exe"));
        System.out.println("Тест пройден файл успешно загрузился");
        }
    }
    @AfterClass
        public static void tearDown() {
        driver.quit();
        System.out.println("Тест завершён");
    }
}

