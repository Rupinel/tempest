package kr.howmuch.tempest.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

public class ResultCount {

    public static int getLoopCount(String url) {

        WebDriver driver = PhantomDriver.getWebDriver();
        driver.get(url);

        String html = driver.getPageSource();

        Document document = Jsoup.parse(html);
        Elements elements = document.select(".col-md-4");

        String result = elements.text().split("of")[1];;
        int resultCount = Integer.parseInt(result.replaceAll("[^0-9]",""));
        int loopCnt = 0;

        if (resultCount % 60 > 0)
            loopCnt = (resultCount / 60) + 1;
        else
            loopCnt = resultCount / 60;

        driver.quit();

        return loopCnt;
    }
}
