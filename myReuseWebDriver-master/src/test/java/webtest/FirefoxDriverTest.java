package webtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.HttpCommandExecutor;

public class FirefoxDriverTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");

        // 鍒濆鍖栦竴涓猣irefox娴忚鍣ㄥ疄渚�1
        FirefoxDriver driver = new FirefoxDriver();
        // 鏈�澶у寲绐楀彛
        driver.manage().window().maximize();
        // 璁剧疆闅愭�х瓑寰呮椂闂�
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // get()鎵撳紑涓�涓珯鐐�
        driver.get("https://www.baidu.com");
        // getTitle()鑾峰彇褰撳墠椤甸潰title鐨勫��
        System.out.println("褰撳墠鎵撳紑椤甸潰鐨勬爣棰樻槸锛� " + driver.getTitle());

        System.out.println(driver.getSessionId());
        System.out.println(((HttpCommandExecutor) driver.getCommandExecutor()).getAddressOfRemoteServer());
        // 鍏抽棴骞堕��鍑烘祻瑙堝櫒
        // driver.quit();
    }
}
