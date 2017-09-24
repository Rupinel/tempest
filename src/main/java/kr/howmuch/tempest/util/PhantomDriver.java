package kr.howmuch.tempest.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomDriver {

    public static WebDriver getWebDriver() {

       DesiredCapabilities DesireCaps = new DesiredCapabilities();
       DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C://phantomjs.exe");

       WebDriver driver = new PhantomJSDriver(DesireCaps);
       //WebDriver driver = new PhantomJSDriver();

        return driver;
    }
}
