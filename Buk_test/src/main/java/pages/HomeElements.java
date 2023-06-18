package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class HomeElements {

    private static final Map<String, By> selectors = new HashMap<>();

    static {
        selectors.put("email_input", By.cssSelector("#recipient-email"));
        selectors.put("name_input", By.cssSelector("#recipient-name"));
        selectors.put("message_input", By.cssSelector("#message-text"));
        selectors.put("send_button", By.cssSelector("button[onclick='send()']"));
        selectors.put("product_id", By.xpath("//*[@id='tbodyid']/div[3]/div/div/h4/a"));
        selectors.put("add_button", By.xpath("//*[@id='tbodyid']/div[2]/div/a"));
        selectors.put("name_order_input", By.cssSelector("#name"));
        selectors.put("country_input", By.cssSelector("#country"));
        selectors.put("city_input", By.cssSelector("#city"));
        selectors.put("credit_card_input", By.cssSelector("#card"));
        selectors.put("month_input", By.cssSelector("#month"));
        selectors.put("year_input", By.cssSelector("#year"));
        selectors.put("purchase_button", By.cssSelector("button[onclick='purchaseOrder()']"));
        selectors.put("order_button", By.xpath("//*[@id='page-wrapper']/div/div[2]/button"));
    }

    public By getSelector(String selector)   {
            return selectors.get(selector);
    }
}






