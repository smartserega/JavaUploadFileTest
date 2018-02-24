import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class UploadFileTest {

    private static WebDriver driver;

    @Test
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ПК\\IdeaProjects\\AutomatingTestingJavaMaven\\src\\recourses\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.rambler.ru/");
        System.out.println("Открылся сайт почты mail.ru");
    }
    @Test
            public void userLogin() throws InterruptedException {


                WebElement loginField = driver.findElement(By.xpath(".//*[@id=\"app\"]//form/div[1]//input"));
                loginField.sendKeys("smarseregatest");
                System.out.println("Пользователь ввёл логин");

                WebElement passwordField = driver.findElement(By.xpath(".//*[@id=\"app\"]//form/div[2]//input"));
                passwordField.sendKeys("12345678");
                System.out.println("Пользователь ввёл пароль");

                WebElement loginButton = driver.findElement(By.xpath(".//*[@id=\"app\"]//button"));
                loginButton.click();
                System.out.println("Пользователь вошёл в почту");

                WebElement writeButton = driver.findElement(By.className("_Button-label-3x"));
                writeButton.click();
                System.out.println("Пользователь начал писать новое письмо");

                //нужно выибрать селектор с тегом input
                driver.findElement(By.className("Compose-fileInput-dl")).sendKeys("C:\\Users\\ПК\\IdeaProjects\\AutomatingTestingJavaMaven\\src\\recourses\\chromedriver.exe");


                WebElement check = driver.findElement(By.className("Uploads-name-2k"));
                System.out.println("Пользователь загружает файл");




    }
            @AfterClass
            public static void tearDown() {
                //driver.quit();
                System.out.println("Тест завершён");
    }
}

