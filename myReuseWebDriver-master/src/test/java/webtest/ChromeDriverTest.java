package webtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.HttpCommandExecutor;

public class ChromeDriverTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
      
        ChromeDriverService chromeDrService = ChromeDriverService.createDefaultService();

        ChromeDriver driver = new ChromeDriver(chromeDrService);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.get("https://www.baidu.com");
        System.out.println("打开浏览器页签名为： " + driver.getTitle());

        System.out.println("获取session为： " +driver.getSessionId());
        System.out.println("Webdriver地址为："+((HttpCommandExecutor) driver.getCommandExecutor()).getAddressOfRemoteServer());
//         driver.quit();
    }
}
