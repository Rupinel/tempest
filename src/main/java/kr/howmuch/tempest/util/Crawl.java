package kr.howmuch.tempest.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crawl {

    public void collectCardInfo() throws Exception {

        String url = "http://www.cardkingdom.com/catalog/view?filter%5Bipp%5D=60&filter%5Bsort%5D=name&filter%5Bsearch%5D=mtg_advanced&filter%5Bcategory_id%5D=0&filter%5Bmulti%5D%5B0%5D=1&filter%5Btype_mode%5D=any&filter%5Bmanaprod_select%5D=anypage=1";

        int loopCnt = ResultCount.getLoopCount(url);

        WebDriver driver = PhantomDriver.getWebDriver();
        driver.get(url);

        String html = driver.getPageSource();
        Document document = Jsoup.parse(html);

        Elements elements = document.getElementsByClass("productItemWrapper productCardWrapper ");

        List cardList = new ArrayList<HashMap<String, String>>();
        Map<String, String> cardInfo;

        try {
            for (Element item : elements) {

                cardInfo = new HashMap<String, String>();

                cardInfo.put("name", item.getElementsByClass("productDetailTitle").text());
                cardInfo.put("set", item.getElementsByClass("productDetailSet").text());
                cardInfo.put("type", item.getElementsByClass("productDetailType").text());
                cardInfo.put("flavorText", item.getElementsByClass("detailFlavortext").text());
                cardInfo.put("price", item.getElementsByClass("stylePrice").text());

                cardList.add(cardInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("loopCnt : " + loopCnt);

        System.out.println("===========================================================================");


        for (int i = 0; i < cardList.size(); i++) {
            HashMap<String, String> map = (HashMap<String, String>) cardList.get(i);
            System.out.println(map.get("name"));
            System.out.println(map.get("set"));
            System.out.println(map.get("type"));
            System.out.println(map.get("flavorText"));
            System.out.println(map.get("price"));
            System.out.println("===========================================================================");
        }

        driver.quit();

    }
}
